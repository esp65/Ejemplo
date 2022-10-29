/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;




import domain.UsuarioDTO;
import domain.VendedorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author USUARIO
 */
public class VendedorDaoJDBC implements VendedorDao{

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_vendedor, username, password FROM vendedor";
    private static final String SQL_INSERT = "INSERT INTO vendedor(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE vendedor SET username=?, password=? WHERE id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE id_usuario=?";

   public VendedorDaoJDBC() {

    }
   
   public VendedorDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<VendedorDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VendedorDTO vendedor = null;
        List<VendedorDTO> vendedores = new ArrayList<VendedorDTO>();
        
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");

                vendedor = new VendedorDTO();
                vendedor.setId_vendedor(id_usuario);
                vendedor.setUsername(username);
                vendedor.setPassword(password);

                vendedores.add(vendedor);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return vendedores;
        
        
        
    }

    @Override
    public int insert(VendedorDTO vendedor) throws SQLException {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getUsername());
            stmt.setString(2, vendedor.getPassword());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows; 
    }

    @Override
    public int update(VendedorDTO vendedor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getUsername());
            stmt.setString(2, vendedor.getPassword());
            stmt.setInt(3, vendedor.getId_vendedor());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int delete(VendedorDTO vendedor) throws SQLException {
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getId_vendedor());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
             if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

   
}