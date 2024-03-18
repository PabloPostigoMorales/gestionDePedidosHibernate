package com.example.gestiondepedidos.model.producto;

import Utils.HibernateUtils;
import bbdd.properties.AmazenConnection;
import com.example.gestiondepedidos.model.detallepedido.DetallePedido;
import com.example.gestiondepedidos.model.pedido.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.gestiondepedidos.model.usuario.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class ProductoDAO {
    Connection con = AmazenConnection.getConnection();

    public String getNameById (String id) {
        Producto producto = new Producto();
        String nombre = "";

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            producto = session.get(Producto.class, id);
            nombre = producto.getProd_Name();
        } catch (HibernateException e) {
            System.err.println(e);
        }
        return nombre;
    }

    public Integer getPriceById (String id) {
        Producto producto = new Producto();
        Integer precio = 0;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            producto = session.get(Producto.class, id);
            precio = producto.getPrice();
        } catch (HibernateException e) {
            System.err.println(e);
        }
        return precio;
    }

    public ArrayList<Producto> getAll() {
        ArrayList<Producto> productosArr = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "SELECT producto from Producto producto";
            var query = session.createQuery(sql_query, Producto.class);
            productosArr = (ArrayList<Producto>) query.list();

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return productosArr;
    }
}
