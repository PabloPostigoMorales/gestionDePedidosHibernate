package com.example.gestiondepedidos.model.detallepedido;

import Utils.HibernateUtils;
import bbdd.properties.AmazenConnection;
import com.example.gestiondepedidos.controllers.DetallePedidoController;
import com.example.gestiondepedidos.model.pedido.Pedido;
import com.example.gestiondepedidos.model.producto.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetallePedidoDAO {

    protected static final Connection con = AmazenConnection.getConnection();


    public ArrayList<DetallePedido> getAllById (Integer id) {
        ArrayList<DetallePedido> detallePedidos = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "SELECT detallePedido FROM DetallePedido detallePedido WHERE id_pedido=:idp";
            var query = session.createQuery(sql_query, DetallePedido.class);
            query.setParameter("idp", id);
            detallePedidos = (ArrayList<DetallePedido>) query.list();

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return detallePedidos;
    }


    public void save (DetallePedido detallePedido) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tst = session.beginTransaction();
            session.persist(detallePedido);
            tst.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getLastId() {
        ArrayList<DetallePedido> detallePedidos = new ArrayList<>();
        Integer id = 0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "SELECT detallePedido FROM DetallePedido detallePedido";
            var query = session.createQuery(sql_query, DetallePedido.class);
            detallePedidos = (ArrayList<DetallePedido>) query.list();

            for (DetallePedido detallePedido : detallePedidos) {
                if (detallePedido.getId() > id) {
                    id = detallePedido.getId();
                }
            }

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return id+1;
    }
}
