package com.example.gestiondepedidos.model.usuario;

import Utils.HibernateUtils;
import bbdd.properties.AmazenConnection;

import java.sql.Array;
import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UsuarioDAO{
    protected static final Connection con = AmazenConnection.getConnection();

    static public  ArrayList<Usuario> getAll () {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "SELECT usuario from Usuario usuario";
            var query = session.createQuery(sql_query, Usuario.class);
            usuarios = (ArrayList<Usuario>) query.list();

        } catch (HibernateException e) {
            System.err.println(e);
        }
        return usuarios;
    }

    static public ArrayList<Usuario> getT (Integer identificador) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            usuarios = session.get(usuarios.getClass(), identificador);
        } catch (HibernateException e) {
            System.err.println(e);
        }
        return usuarios;
    }


    public Optional<Usuario> loginUsuario(String name, String password){
        Optional<Usuario> usuario = Optional.empty();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String sql_query = "FROM Usuario usuario WHERE name=:name AND password=:pass";
            Query query = session.createQuery(sql_query, Usuario.class);
            query.setParameter("name", name);
            query.setParameter("pass", password);
            usuario = query.uniqueResultOptional();
        } catch (HibernateException e) {
            System.err.println(e);
        }
        return usuario;
    }
}
