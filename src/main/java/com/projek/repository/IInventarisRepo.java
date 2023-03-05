package com.projek.repository;

import com.projek.model.Inventaris;

import java.util.List;
import java.util.Optional;

public interface IInventarisRepo {
    List<Inventaris> getAllData () throws Exception;
    Inventaris insertData(Inventaris inv)  throws Exception;

    Optional<Inventaris> getBy(String id); List<Inventaris> lists ()  throws Exception;

    void updateData(Inventaris data, String id) throws Exception;
    void deleteBy(String id) throws Exception;



}
