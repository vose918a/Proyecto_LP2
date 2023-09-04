package org.fcyt.model.DAO;

import org.fcyt.model.Empresa;

import java.util.List;

public interface DAO<T> {
    public void insertar(T t);
    public void actualizar(T t);
    public void eliminar(T t);
    public List<Empresa> listar();
}
