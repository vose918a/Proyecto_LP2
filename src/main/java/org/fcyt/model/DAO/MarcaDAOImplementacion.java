package org.fcyt.model.DAO;

import org.fcyt.model.Conexion;
import org.fcyt.model.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAOImplementacion implements DAO<Marca>{

    Connection con;
    PreparedStatement sentencia;

    public MarcaDAOImplementacion(){//Constructor
        Conexion conectar = new Conexion();
        con = conectar.getConexion();
    }

    @Override
    public void insertar(Marca marca) {
        String csql = "INSERT INTO marca(descripcion) VALUES(?)";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setString(1, marca.getDescripcion());
            int rs = sentencia.executeUpdate();
            if (rs > 0){
                System.out.println("Marca insertada");
            }else{
                System.out.println("Error al insertar Marca");
            }
        } catch (SQLException e) {
            System.out.println("Error al Insertar la Marca:  " + e);
        }
    }

    @Override
    public void actualizar(Marca marca) {
        String csql = "UPDATE marca SET descripcion =? WHERE id =?";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setString(1, marca.getDescripcion());
            sentencia.setInt(2, marca.getId());
            int rs = sentencia.executeUpdate();
            if (rs > 0){
                System.out.println("Marca actualizada");
            }else{
                System.out.println("Error al actualizar Marca");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Marca:  " + e);
        }
    }

    @Override
    public void eliminar(Marca marca) {
        String csql = "DELETE FROM marca WHERE id =?";
        try {
            sentencia = con.prepareStatement(csql);
            sentencia.setInt(1, marca.getId());
            int rs = sentencia.executeUpdate();
            if (rs > 0){
                System.out.println("Marca eliminada");
            }else{
                System.out.println("Error al eliminar Marca");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Marca:  " + e);
        }
    }

    @Override
    public List<Marca> listar() {
        ArrayList<Marca> listaMarcas = new ArrayList<>();
        try {
            sentencia = con.prepareStatement("SELECT * FROM marca");
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setDescripcion(rs.getString("descripcion"));
                listaMarcas.add(marca);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las Marcas:  " + e);
        }
        return listaMarcas;
    }
}
