package com.example.gestiondepedidos.model.producto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class Producto {

    @Getter @Setter
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private String id;

    @Getter @Setter
    @Basic
    @Column(name = "prod_name", nullable = false)
    private String prod_Name;

    @Getter @Setter
    @Basic
    @Column(name = "price", nullable = false)
    private Integer price;

    @Getter @Setter
    @Basic
    @Column(name = "avail_quantity", nullable = false)
    private Integer avail_Quantity;
}
