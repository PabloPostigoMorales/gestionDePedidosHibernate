package com.example.gestiondepedidos.model.usuario;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
@Table(name = "usuario", schema = "gestorpedidos")
public class Usuario {

    @Getter @Setter
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter @Setter
    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Override
    public String toString () {
        return "Usuario{" +
                "id:" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '\n';
    }
}

