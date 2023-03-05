package com.projek.controller;


import com.projek.config.jwt.JWTUtils;
import com.projek.model.Request.Login;
import com.projek.model.Request.SignUp;
import com.projek.model.Response.Message;
import com.projek.model.Response.ResponJWT;
import com.projek.model.Role;
import com.projek.model.RoleType;
import com.projek.model.User;
import com.projek.model.UserDetailModel;
import com.projek.repository.RoleRepo;
import com.projek.repository.UserRepo;
import com.projek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins ="*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleService roleService;

    @Autowired
    JWTUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@Valid @RequestBody Login loginReq){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);

        UserDetailModel userDetail = (UserDetailModel) authentication.getPrincipal();

        List<String> roles = userDetail.getAuthorities().stream().map(item->item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new ResponJWT(jwt, userDetail.getUserId(), userDetail.getUsername(), userDetail.getEmail(), roles));
    }

    @PostMapping("/createRole")
    public Role createRole(@RequestBody Role roleNew){
        return roleService.create(roleNew);
    }

    @PostMapping("/signup")
    public ResponseEntity<?>  userRegist(@Valid @RequestBody SignUp signUpReq) throws Exception{
        if(userRepo.existsByUsername(signUpReq.getUsername())){
            return ResponseEntity.badRequest().body(new Message(" Username is already taken"));
        }
        if(userRepo.existsByEmail(signUpReq.getEmail())){
            return ResponseEntity.badRequest().body(new Message(" Email is already use"));
        }

        User user = new User(signUpReq.getUsername(), signUpReq.getEmail(), passwordEncoder.encode(signUpReq.getPassword()));

        Set<String> roles = signUpReq.getRole();
        Set<Role> newRoles = new HashSet<>();

        if(roles == null){

            Role userRole = roleRepo.findByName(RoleType.USER).orElseThrow(()->new RuntimeException(" role not found"));
            newRoles.add(userRole);

        }
        else{
            roles.forEach(role->{
                switch (role){

                    case "admin":
                        Role adminRole = roleRepo.findByName(RoleType.ADMIN).orElseThrow(()->new RuntimeException(" role not found"));
                        newRoles.add(adminRole);
                        break;
                    case "viewer":
                        Role vRole = roleRepo.findByName(RoleType.VIEWER).orElseThrow(()->new RuntimeException(" role not found"));
                        newRoles.add(vRole);
                        break;
                    default:
                        Role userRole = roleRepo.findByName(RoleType.USER).orElseThrow(()->new RuntimeException(" role not found"));
                        newRoles.add(userRole);
                        break;
                }
            });
        }
        user.setRoles(newRoles);
        userRepo.save(user);

        return ResponseEntity.ok(new Message("user success registered :)"));
    }






















}
