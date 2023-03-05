package com.projek.service;

import com.projek.exception.DataNotFoundException;
import com.projek.model.Inventaris;
import com.projek.repository.IInventarisRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InventarisImplemenService implements IInventaris {

    private IInventarisRepo inventarisrepo;

    public InventarisImplemenService(IInventarisRepo inventarisrepo) {
        this.inventarisrepo = inventarisrepo;
        System.out.println("Counter repository object Id: " + this.inventarisrepo.hashCode());
    }



    @Override
    public List<Inventaris> lists() throws Exception {

        List<Inventaris> result = inventarisrepo.getAllData();
        if(result.isEmpty()){
           throw  new DataNotFoundException("Data is empty");
        }
        return result;

    }


    @Override
    public Inventaris insert(Inventaris inv) {

        try {
            return inventarisrepo.insertData(inv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Inventaris data, String id) {

        try {
            inventarisrepo.updateData(data, id);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(String id) {
        try{
            inventarisrepo.deleteBy(id);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Inventaris> get(String id) {

        return inventarisrepo.getBy(id);
    }





}
