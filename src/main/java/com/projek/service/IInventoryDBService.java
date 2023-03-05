package com.projek.service;

import com.projek.model.InventoryDB;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IInventoryDBService {

   List<InventoryDB> getAll() throws Exception;

   Optional<InventoryDB> getById(String id) ;

   InventoryDB save(InventoryDB data);

   void deleteBy(String id);

   void updateBy(InventoryDB data, String id) ;

    Page<InventoryDB> list(Integer page, Integer size, String direction, String sortBy);
}
