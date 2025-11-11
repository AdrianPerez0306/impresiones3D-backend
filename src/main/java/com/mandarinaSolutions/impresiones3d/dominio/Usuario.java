package com.mandarinaSolutions.impresiones3d.dominio;

import com.mandarinaSolutions.impresiones3d.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Description")
    private String descripcion;

    public Integer getId(){return Id;}

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UserDTO toDTO(Usuario usuario){
        return new UserDTO(
                username = usuario.getUsername(),
                password = usuario.getPassword(),
                Id = usuario.Id);
    }
}
