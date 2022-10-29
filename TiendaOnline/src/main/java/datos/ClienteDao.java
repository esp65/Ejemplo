/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.ClienteDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ClienteDao {
    
    public List<ClienteDTO> select() throws SQLException;
    
    public int insert(ClienteDTO cliente) throws SQLException;
    
    public int update(ClienteDTO cliente) throws SQLException;
    
    public int delete(ClienteDTO cliente) throws SQLException;
    
}
