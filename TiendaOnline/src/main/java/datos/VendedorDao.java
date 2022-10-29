/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.VendedorDTO;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author USUARIO
 */
public interface VendedorDao{
    
    public List<VendedorDTO> select() throws SQLException;
    
    public int insert(VendedorDTO vendedor) throws SQLException;
    
    public int update(VendedorDTO vendedor) throws SQLException;
    
    public int delete(VendedorDTO vendedor) throws SQLException;
    
    
}
