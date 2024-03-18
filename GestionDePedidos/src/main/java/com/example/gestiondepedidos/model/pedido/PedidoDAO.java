package com.example.gestiondepedidos.model.pedido;

import bbdd.properties.AmazenConnection;
import Utils.HibernateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.gestiondepedidos.model.producto.Producto;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PedidoDAO {

    protected static final Connection con = AmazenConnection.getConnection();


    public ArrayList<Pedido> getAllByUserID(Integer id){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "SELECT pedido FROM Pedido pedido WHERE user_id=:id";
            var query = session.createQuery(sql_query, Pedido.class);
            query.setParameter("id", id);
            pedidos = (ArrayList<Pedido>) query.list();

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return pedidos;
    }

    public Boolean deleteByID(Integer id) {
        boolean eliminado = false;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tst = session.beginTransaction();
            String sql_query = "DELETE Pedido WHERE id=:id";
            Query query = session.createQuery(sql_query, null);
            query.setParameter("id", id);
            int i = query.executeUpdate();


            if (i != 0) {
                eliminado = true;
            }
            tst.commit();

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return eliminado;
    }

    public void savePedido(Pedido pedido) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tst = session.beginTransaction();
            session.persist(pedido);
            tst.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getLastId() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Integer id = 0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "SELECT pedido FROM Pedido pedido";
            var query = session.createQuery(sql_query, Pedido.class);
            pedidos = (ArrayList<Pedido>) query.list();

            for (Pedido pedido : pedidos) {
                if (pedido.getId() > id) {
                    id = pedido.getId();
                }
            }

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return id+1;
    }
}
