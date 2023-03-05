package com.projek.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_detail_inventory")
public class Detail {

    @Id
    @GeneratedValue(generator = "system-uuid2")
    @GenericGenerator(name = "system-uuid2", strategy ="uuid2")
    @Column(name = "id_detail")
    private String idDetail;

    private String generation;
    private String assurance;

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "idDetail='" + idDetail + '\'' +
                ", generation='" + generation + '\'' +
                ", assurance='" + assurance + '\'' +
                '}';
    }
}
