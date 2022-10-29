/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author USUARIO
 */
public class VendedorDTO {
     private int id_usuario;
    private String username;
    private String password;

    public VendedorDTO() {
    }

    public VendedorDTO(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public VendedorDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public VendedorDTO(int id_usuario, String username, String password) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
    }
    

    public int getId_vendedor() {
        return id_usuario;
    }

    public void setId_vendedor(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", username=" + username + ", password=" + password + '}';
    }
    
}
