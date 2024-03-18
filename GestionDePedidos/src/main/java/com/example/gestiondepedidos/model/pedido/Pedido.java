package com.example.gestiondepedidos.model.pedido;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class Pedido {

    @Setter @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter @Setter
    @Basic
    @Column(name = "cod_pedido", nullable = false)
    private String cod_pedido;

    @Getter @Setter
    @Basic
    @Column(name = "order_date", nullable = false)
    private java.sql.Date order_date;

    @Getter @Setter
    @Basic
    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Getter @Setter
    @Basic
    @Column(name = "total", nullable = false)
    private Integer total;

}
