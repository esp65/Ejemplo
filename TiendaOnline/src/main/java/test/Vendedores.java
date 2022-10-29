/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.Conexion;
import datos.VendedorDao;
import datos.VendedorDaoJDBC;
import domain.VendedorDTO;
import java.sql.*;
import java.util.List;


/**
 *
 * @author USUARIO
 */
public class Vendedores {
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            VendedorDao vendedorDao = new VendedorDaoJDBC(conexion);
            
            List<VendedorDTO> vendedores = vendedorDao.select();
            
//            for(PersonaDTO persona: personas){
//                System.out.println("Persona DTO:" + persona);
//            }
vendedores.forEach(vendedor -> {
    System.out.println("Vendedor DTO:" + vendedor);
            });
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

 }
    

