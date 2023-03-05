package com.projek.service;

import com.projek.exception.DataExistException;
import com.projek.exception.DataNotFoundException;
import com.projek.model.InventoryDB;
import com.projek.model.Room;
import com.projek.repository.InventoryDBRepo;
import com.projek.repository.RoomRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryDBServiceImplemen implements IInventoryDBService {


    @Autowired
    InventoryDBRepo inventoryDBRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<InventoryDB> getAll() throws Exception {
      List<InventoryDB> result =  inventoryDBRepo.findAll();
      return  result;
    }

    @Override
    public Optional<InventoryDB> getById(String id)  {
        try{
        Optional<InventoryDB> result = inventoryDBRepo.findById(id);
        return result;
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("Update failed because ID is not found");
        }
    }

    @Override
    public InventoryDB save(InventoryDB data) {
        try{
            Optional<Room> roomChoise = roomRepo.findById(data.getRoom().getRoomId());
            if(roomChoise.isEmpty()){
                throw new DataNotFoundException(" Room not match and not found");
            }
            data.setDetail(data.getDetail());
            data.setRoom(roomChoise.get());
            InventoryDB newInventoryDB = inventoryDBRepo.save(data);
            return  newInventoryDB;
        } catch (DataIntegrityViolationException e) {
            throw new DataExistException();
        }
    }

    @Override
    public void deleteBy(String id) {
        inventoryDBRepo.deleteById(id);
    }

    public InventoryDB get(String id) {
        Optional<InventoryDB> course = inventoryDBRepo.findById(id);
        if (course.isEmpty()) {
            throw new DataNotFoundException("Course not found");
        }
        return course.get();
    }

    @Override
    public void updateBy(InventoryDB data, String id)  {
        try {
        InventoryDB existingInv = get(id);
        modelMapper.map(data, existingInv);
        inventoryDBRepo.save(existingInv);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("Update failed because ID is not found");
        }

    }


    @Override
    public Page<InventoryDB> list(Integer page, Integer size, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        Page<InventoryDB> courses = inventoryDBRepo.findAll(pageable);
        return courses;
    }
}
