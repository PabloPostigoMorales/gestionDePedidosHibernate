package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.App;
import com.example.gestiondepedidos.DataSaver;
import com.example.gestiondepedidos.model.detallepedido.DetallePedido;
import com.example.gestiondepedidos.model.detallepedido.DetallePedidoDAO;
import com.example.gestiondepedidos.model.pedido.Pedido;
import com.example.gestiondepedidos.model.pedido.PedidoDAO;
import com.example.gestiondepedidos.model.producto.Producto;
import com.example.gestiondepedidos.model.producto.ProductoDAO;
import com.example.gestiondepedidos.model.usuario.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CrearPedidoController implements Initializable {

    @javafx.fxml.FXML
    private DatePicker dpFechaPedido;
    @javafx.fxml.FXML
    private TextField lbCodigoPedido;
    @javafx.fxml.FXML
    private Button btnAgregar;
    @javafx.fxml.FXML
    private Button btnCancelar;
    @javafx.fxml.FXML
    private Spinner spProd1;
    @javafx.fxml.FXML
    private Spinner spProd2;
    @javafx.fxml.FXML
    private Spinner spProd3;
    @javafx.fxml.FXML
    private Spinner spProd4;
    @javafx.fxml.FXML
    private Spinner spProd5;
    @javafx.fxml.FXML
    private Spinner spProd6;
    @javafx.fxml.FXML
    private Spinner spProd7;
    @javafx.fxml.FXML
    private Spinner spProd8;
    @javafx.fxml.FXML
    private Spinner spProd9;
    @javafx.fxml.FXML
    private Spinner spProd10;
    private Integer totalPedido;
    private ProductoDAO productoDAO = new ProductoDAO();
    private ArrayList<Producto> productos = new ArrayList<>();
    private HashMap<Integer, Integer> precios = new HashMap<>();

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        productos = productoDAO.getAll();
        for (Producto producto : productos) {
            precios.put(producto.getPrice(), 0);
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        dpFechaPedido.setValue(date.toLocalDate());


        spProd1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd7.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd8.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd9.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        spProd10.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));


        spProd1.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(800, (Integer) newValue);
            actualizarTotal();
        });
        spProd2.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(1000, (Integer) newValue);
            actualizarTotal();
        });
        spProd3.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(80, (Integer) newValue);
            actualizarTotal();
        });
        spProd4.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(50, (Integer) newValue);
            actualizarTotal();
        });
        spProd5.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(300, (Integer) newValue);
            actualizarTotal();
        });
        spProd6.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(130, (Integer) newValue);
            actualizarTotal();
        });
        spProd7.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(200, (Integer) newValue);
            actualizarTotal();
        });
        spProd8.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(70, (Integer) newValue);
            actualizarTotal();
        });
        spProd9.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(90, (Integer) newValue);
            actualizarTotal();
        });
        spProd10.valueProperty().addListener((obs, oldValue, newValue) -> {
            precios.put(60, (Integer) newValue);
            actualizarTotal();
        });
    }


    private void actualizarTotal () {
        totalPedido = 0;
        for(Map.Entry<Integer, Integer> entry : precios.entrySet()) {
            Integer precio = entry.getKey();
            Integer cantidad = entry.getValue();
            Integer total = precio * cantidad;
            totalPedido += total;
        }
    }

    @javafx.fxml.FXML
    public void agregar (ActionEvent actionEvent) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
        Pedido pedido = new Pedido();
        pedido.setOrder_date(Date.valueOf(dpFechaPedido.getValue()));
        pedido.setUser_id(Session.getUsuario().getId());
        pedido.setCod_pedido(lbCodigoPedido.getText());
        pedido.setTotal(totalPedido);
        pedido.setId(pedidoDAO.getLastId());
        pedidoDAO.savePedido(pedido);
        if ((Integer) spProd1.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(800);
            int dinero = 800;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Ordenador Portátil");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(1);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd2.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(1000);
            int dinero = 1000;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("PC de Escritorio");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(2);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd3.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(80);
            int dinero = 80;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Teclado Mecánico");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(3);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd4.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(50);
            int dinero = 50;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Ratón Gaming");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(4);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd5.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(300);
            int dinero = 300;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Monitor 27\"");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(5);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd6.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(130);
            int dinero = 130;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Disco Duro SSD 1TB");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(6);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd7.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(200);
            int dinero = 200;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Impresora Multifunción");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(7);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd8.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(70);
            int dinero = 70;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Router WiFi AC");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(8);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd9.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(90);
            int dinero = 90;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Auriculares Inalámbricos");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(9);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }
        if ((Integer) spProd10.getValue() > 0) {
            DetallePedido detallePedido = new DetallePedido();
            int cantidad = precios.get(60);
            int dinero = 60;
            detallePedido.setId_pedido(pedido.getId());
            detallePedido.setNombre_producto("Cámara Web HD");
            detallePedido.setCantidad(cantidad);
            detallePedido.setTotal_dinero(cantidad * dinero);
            detallePedido.setId_producto(10);
            detallePedido.setId(detallePedidoDAO.getLastId());
            detallePedidoDAO.save(detallePedido);
        }


        btnCancelar.fire();
    }

    @javafx.fxml.FXML
    public void cancelar (ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/mainView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataSaver.getStage().setScene(scene);
    }
}
