package com.projek.model.Request;

import javax.validation.constraints.NotBlank;

public class NewDetail {

    @NotBlank
    private String generation;
    private String assurance;

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
        return "NewDetail{" +
                "generation='" + generation + '\'' +
                ", assurance='" + assurance + '\'' +
                '}';
    }
}
