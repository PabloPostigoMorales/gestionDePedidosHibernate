package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.App;
import com.example.gestiondepedidos.DataSaver;
import com.example.gestiondepedidos.model.pedido.Pedido;
import com.example.gestiondepedidos.model.usuario.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Date;

public class EditarPedidoController {
    @javafx.fxml.FXML
    private DatePicker dpFechaPedido;
    @javafx.fxml.FXML
    private TextField lbTotal;
    @javafx.fxml.FXML
    private TextField lbCodigoPedido;
    @javafx.fxml.FXML
    private Button btnAgregar;
    @javafx.fxml.FXML
    private Button btnCancelar;

    @javafx.fxml.FXML
    public void agregar (ActionEvent actionEvent) {
        Pedido pedido = new Pedido();
        pedido.setOrder_date(Date.valueOf(dpFechaPedido.getValue()));
        pedido.setCod_pedido(String.valueOf(lbCodigoPedido));
        pedido.setUser_id(Session.getUsuario().getId());
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
