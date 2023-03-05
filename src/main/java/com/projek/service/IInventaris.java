package com.projek.service;

import com.projek.model.Inventaris;

import java.util.List;
import java.util.Optional;

public interface IInventaris {

    List<Inventaris> lists() throws Exception ;
    Inventaris insert(Inventaris inv);

    Optional<Inventaris> get(String id);

    void update(Inventaris data, String id);

    void delete(String id);


}
