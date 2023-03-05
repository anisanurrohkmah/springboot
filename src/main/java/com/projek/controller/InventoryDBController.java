package com.projek.controller;


import com.projek.model.InventoryDB;
import com.projek.model.Request.NewInventaris;
import com.projek.model.Request.NewInventoryDb;
import com.projek.model.Response.PagingResponse;
import com.projek.model.Response.SuccessResp;
import com.projek.service.IInventoryDBService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventoryDb")
@Validated
public class InventoryDBController {

    @Autowired
    IInventoryDBService iInventoryDBService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllData() throws Exception {
        List<InventoryDB> list = iInventoryDBService.getAll() ;
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/page")
    public ResponseEntity getPagination(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "DESC") String direction,
            @RequestParam(defaultValue = "courseId") String sortBy
    ) throws Exception {
        Page<InventoryDB> courses = iInventoryDBService.list(page, size, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Success get course list", courses));
    }


    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable String id){
        try{
            Optional<InventoryDB> result = iInventoryDBService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity createNew(@Valid @RequestBody NewInventoryDb dataSender){
        InventoryDB newData = modelMapper.map(dataSender, InventoryDB.class);
        InventoryDB result = iInventoryDBService.save(newData);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResp<>("Success create a new inventory",result));

    }

    @PutMapping("/{id}")
    public ResponseEntity updateBy(@Valid @RequestBody NewInventaris dataSender, @PathVariable String id) throws Exception{
        InventoryDB inv = modelMapper.map(dataSender, InventoryDB.class);
        iInventoryDBService.updateBy(inv,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResp<>(" Success Update Data", inv));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteBy(@PathVariable String id){
        iInventoryDBService.deleteBy(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseEntity<>("Data Success Deleted", null));
    }



}
