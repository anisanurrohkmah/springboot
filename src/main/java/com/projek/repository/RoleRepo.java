package com.projek.repository;

import com.projek.model.Role;
import com.projek.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {

   Optional<Role> findByName(RoleType name);


}
