/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class ZoologicoCrud {
    public class estudiantesDAO {




    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion acceso = new Conexion();

    public void listar() {

        String sql = "select * from estudiante";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void crear(Animales animales) {

        String sql = "insert into animales(id_animal,nombre,edad,especie) values (?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, animales.getIdAnimal());
            ps.setString(2, animales.getNombreAnimal());
            ps.setString(3, animales.getFechaNacimientoAni());
             ps.setString(4, animales.getEspecie());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modificar(Animales animales) {

        String sql = "update animales set  nombre=?, edad=?, especie=? where id_animal=?  ;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
          
            ps.setString(1, animales.getNombreAnimal());
            ps.setString(2, animales.getFechaNacimientoAni());
            ps.setString(3, animales.getEspecie());
            ps.setString(4, animales.getIdAnimal());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(Animales elim) {
        String sql = "delete from animales where id_animal=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, elim.getIdAnimal());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
    
}
