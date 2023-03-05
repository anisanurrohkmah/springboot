package com.projek.repository;

import com.projek.model.Inventaris;
import com.projek.utils.IRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class InventarisRepoImplemen implements IInventarisRepo{


    @Autowired
    IRandom irandomGenerator;
    private List<Inventaris> objeks = new ArrayList<>();

    @Override
    public List<Inventaris> getAllData() throws Exception {
        return objeks;
    }

    @Override
    public List<Inventaris> lists() throws Exception {
        return null;
    }

    @Override
    public Inventaris insertData(Inventaris inv) throws Exception {
//        Random rand = new Random();
//        int upperbound = 1000000;
//        int int_random = rand.nextInt(upperbound);
        inv.setIdInventory(String.valueOf(irandomGenerator.Random()));
        objeks.add(inv);
        return  inv;
    }

    @Override
    public void updateData(Inventaris dataUpdatean, String id) throws Exception {
        for(Inventaris dataStay : objeks){
            if(dataStay.getIdInventory().equals(id)){
                dataStay.setMerk(dataUpdatean.getMerk());
                dataStay.setName(dataUpdatean.getName());
                dataStay.setPrice(dataUpdatean.getPrice());
            }
        }

    }

    @Override
    public void deleteBy(String id) throws Exception {
        for(Inventaris x : objeks){
            if(x.getIdInventory().equals(id)){
                objeks.remove(id);
            }
        }

    }

    @Override
    public Optional<Inventaris> getBy(String id) {
        for(Inventaris x : objeks){
            if(x.getIdInventory().equals(id)){
                return Optional.of(x);
            }
        }
        return Optional.empty();
    }


}
