package com.projek.service;

import com.projek.model.Role;
import com.projek.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplemen implements RoleService{

    @Autowired
    RoleRepo roleRepo;

    @Override
    public Role create(Role role) {
        return roleRepo.save(role);
    }
}
