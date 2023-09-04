package org.fcyt.model.DAO;

import org.fcyt.model.Conexion;
import org.fcyt.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAOImplementacion implements DAO<Empresa>{
    Connection con;
    PreparedStatement sentencia;

    public EmpresaDAOImplementacion(){//Constructor
        Conexion conectar = new Conexion();
        con = conectar.getConexion();
    }

    @Override
    public void insertar(Empresa empresa) {
        String csql = "INSERT INTO empresa(ruc,nombre,direccion,telefono) VALUES (?,?,?,?)";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setString(1,empresa.getRuc());
            sentencia.setString(2,empresa.getNombre());
            sentencia.setString(3,empresa.getDireccion());
            sentencia.setString(4,empresa.getTelefono());
            int rs = sentencia.executeUpdate();
            if(rs > 0){
                System.out.println("Exito al crear la emoresar");
            }
        } catch (SQLException e) {
            System.out.println("Error al Insertar la Empresa:  " + e);
        }
    }

    @Override
    public void actualizar(Empresa empresa) {
        String sql = "UPDATE empresa SET ruc = ?, nombre = ?, direccion = ?, telefono = ? WHERE id = ? ";
        try {
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1,empresa.getRuc());
            sentencia.setString(2,empresa.getNombre());
            sentencia.setString(3,empresa.getDireccion());
            sentencia.setString(4,empresa.getTelefono());
            sentencia.setInt(5,empresa.getId());
            int rs = sentencia.executeUpdate();
            if(rs > 0){
                System.out.println("Exito al crear la empresar");
            }
        } catch (SQLException e) {
            System.out.println("Error al Actualizar la Empresa:  " + e);
        }
    }

    @Override
    public void eliminar(Empresa empresa) {
        String sql = "DELETE FROM empresa WHERE id = " + empresa.getId();
        try {
            sentencia = con.prepareStatement(sql);
            int rs = sentencia.executeUpdate();
            if(rs > 0){
                System.out.println("Exito al Eliminar la empresar");
            }
        }catch (SQLException e){
            System.out.println("Error al eliminar la empresa");
        }


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
            System.out.println("Error al listar la Empresa:  " + e);
        }
        return ListaEmpresa;
    }
}
