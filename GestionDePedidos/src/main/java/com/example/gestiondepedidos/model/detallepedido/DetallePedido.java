package com.example.gestiondepedidos.model.detallepedido;

import com.example.gestiondepedidos.model.producto.ProductoDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "detallepedido", schema = "gestorpedidos")
public class DetallePedido {


    @Getter @Setter
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter @Setter
    @Column(name = "id_pedido", nullable = false)
    private Integer id_pedido;

    @Getter @Setter
    private String nombre_producto;

    @Getter @Setter
    private Integer total_dinero;

    @Getter @Setter
    @Column(name = "id_producto", nullable = false)
    private Integer id_producto;

    @Getter @Setter
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;


    public void configurar() {
        ProductoDAO productoDAO = new ProductoDAO();
        nombre_producto = productoDAO.getNameById(id_producto.toString());
        total_dinero = productoDAO.getPriceById(id_producto.toString()) * cantidad;
    }

}
