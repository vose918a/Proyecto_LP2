package org.fcyt.model;

public class Marca {
    static Integer  id;
    static String   descripcion;
    public Marca(){}

    public static Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
