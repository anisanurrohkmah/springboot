package com.projek.repository;

import com.projek.model.InventoryDB;
import org.springframework.data.jpa.repository.JpaRepository;



public interface InventoryDBRepo extends JpaRepository<InventoryDB, String> {
}
