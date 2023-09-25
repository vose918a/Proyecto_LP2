package org.fcyt.model;

public class Marca {
    Integer  id;
    String   descripcion;
    public Marca(){}

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
