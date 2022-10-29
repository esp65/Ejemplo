/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.ClienteDaoJDBC;
import datos.Conexion;
import domain.ClienteDTO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class ClientesSQLite {
    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            ClienteDaoJDBC clienteJdbc = new ClienteDaoJDBC(conexion);
            
            ClienteDTO cambioClientes = new ClienteDTO();
            cambioClientes.setId_cliente(2);
            cambioClientes.setNombre("Mario");
            cambioClientes.setApellido("Ramirez");
            cambioClientes.setEmail("Ramirez@mail.com");
            cambioClientes.setTelefono("12345678910");
            clienteJdbc.update(cambioClientes);
            
            ClienteDTO nuevocliente = new ClienteDTO();
            nuevocliente.setNombre("Marcos");
            nuevocliente.setApellido("Lemus");
            clienteJdbc.insert(nuevocliente);
            
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
