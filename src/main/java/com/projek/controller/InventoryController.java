package com.projek.controller;

import com.projek.model.Inventaris;
import com.projek.model.Request.NewInventaris;
import com.projek.model.Response.SuccessResp;
import com.projek.service.IInventaris;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
@Validated
public class InventoryController {
    @Autowired
    IInventaris inventoriService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllData() throws Exception {
        // List<Inventaris> list = inventoriService.lists() ;
        List<Inventaris> list = new ArrayList<>();

        list.add(new Inventaris("1","ansia",900, "abc"));
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable String id){
        try{
            Optional<Inventaris> result = inventoriService.get(id);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity createNew(@Valid @RequestBody NewInventaris dataSender){
        Inventaris newData = modelMapper.map(dataSender, Inventaris.class);
        Inventaris result = inventoriService.insert(newData);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResp<>("Success create a new inventory",result));

    }

    @PutMapping("/{id}")
    public ResponseEntity updateBy(@Valid @RequestBody NewInventaris dataSender, @PathVariable String id) throws Exception{
        Inventaris inv = modelMapper.map(dataSender, Inventaris.class);
        inventoriService.update(inv,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResp<>(" Success Update Data", inv));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteBy(@PathVariable String id){
        inventoriService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseEntity<>("Data Success Deleted", null));
    }






}
