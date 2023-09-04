package org.fcyt.model.DAO;

import org.fcyt.model.Conexion;
import org.fcyt.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpresarDAOImplementacion implements DAO<Empresa>{
    Connection con;
    PreparedStatement sentencia;

    public EmpresarDAOImplementacion(){//Constructor
        Conexion conectar = new Conexion();
        con = conectar.getConexion();
    }

    @Override
    public void insertar(Empresa empresa) {

    }

    @Override
    public void actualizar(Empresa empresa) {

    }

    @Override
    public void eliminar(Empresa empresa) {

    }

    @Override
    public List<Empresa> listar() {
        ArrayList<Empresa> ListaEmpresa = new ArrayList<>();
        try {
            sentencia = con.prepareStatement("SELECT * FROM empresa");
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("id"));
                empresa.setRuc(rs.getString("ruc"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setDireccion(rs.getString("direccion"));
                ListaEmpresa.add(empresa);
            }
        } catch (Exception e){
            System.out.println("Error al listar" + e);
        }
        return null;
    }
}
