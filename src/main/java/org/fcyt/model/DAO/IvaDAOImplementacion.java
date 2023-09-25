package org.fcyt.model.DAO;

import org.fcyt.model.Conexion;
import org.fcyt.model.Iva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IvaDAOImplementacion implements DAO<Iva>{

    Connection con;

    PreparedStatement sentencia;

    public IvaDAOImplementacion() {
        Conexion conectar = new Conexion();
        con = conectar.getConexion();
    }

    @Override
    public void insertar(Iva iva) {
        String csql = "INSERT INTO iva(descripcion) VALUES(?)";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setString(1, iva.getDescripcion());
            int rs = sentencia.executeUpdate();
            if (rs > 0){
                System.out.println("Iva insertada");
            }else{
                System.out.println("Error al insertar Iva");
            }
        } catch (SQLException e) {
            System.out.println("Error al Insertar la Iva:  " + e);
        }
    }

    @Override
    public void actualizar(Iva iva) {
        String csql = "UPDATE iva SET descripcion =? WHERE id =?";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setString(1, iva.getDescripcion());
            sentencia.setInt(2, iva.getId());
            int rs = sentencia.executeUpdate();
            if (rs > 0){
                System.out.println("Iva actualizada");
            }else{
                System.out.println("Error al actualizar Iva");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Iva:  " + e);
        }
    }

    @Override
    public void eliminar(Iva iva) {
        String csql = "DELETE FROM iva WHERE id =?";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setInt(1, iva.getId());
            int rs = sentencia.executeUpdate();
            if (rs > 0){
                System.out.println("Iva eliminada");
            }else{
                System.out.println("Error al eliminar Iva");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Iva:  " + e);
        }
    }

    @Override
    public List<Iva> listar() {
        ArrayList<Iva> listaIva = new ArrayList<>();
        try {
            sentencia = con.prepareStatement("SELECT * FROM iva");
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
                Iva iva = new Iva();
                iva.setId(rs.getInt("id"));
                iva.setDescripcion(rs.getString("descripcion"));
                listaIva.add(iva);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Iva: " + e);
        }
        return listaIva;
    }
}
