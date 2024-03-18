package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.App;
import com.example.gestiondepedidos.DataSaver;
import com.example.gestiondepedidos.model.detallepedido.DetallePedido;
import com.example.gestiondepedidos.model.detallepedido.DetallePedidoDAO;
import com.example.gestiondepedidos.model.pedido.Pedido;
import com.example.gestiondepedidos.model.pedido.PedidoDAO;
import com.example.gestiondepedidos.model.usuario.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetallePedidoController implements Initializable {

    @Setter
    private Pedido pedido;
    @javafx.fxml.FXML
    private TableView tablaView;
    @javafx.fxml.FXML
    private TableColumn prodColumn;
    @javafx.fxml.FXML
    private TableColumn cantidadColumn;
    @javafx.fxml.FXML
    private TableColumn totalColumn;
    @javafx.fxml.FXML
    private Label lblCodPedido;
    @javafx.fxml.FXML
    private Label lblCodUsuario;
    @javafx.fxml.FXML
    private Label lblFecPedido;
    @javafx.fxml.FXML
    private Label lblTotPedido;
    @javafx.fxml.FXML
    private Button btnVolver;

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        pedido = DataSaver.getPedido();
        DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
        ArrayList<DetallePedido> detallePedidos = detallePedidoDAO.getAllById(pedido.getId());
        for (DetallePedido detalle : detallePedidos) {
            detalle.configurar();
        }
        ObservableList<DetallePedido> detallePedidosObv = FXCollections.observableArrayList(detallePedidos);

        lblCodPedido.setText(pedido.getCod_pedido());
        lblCodUsuario.setText(String.valueOf(pedido.getUser_id()));
        lblFecPedido.setText(String.valueOf(pedido.getOrder_date()));
        lblTotPedido.setText(String.valueOf(pedido.getTotal()));

        prodColumn.setCellValueFactory(new PropertyValueFactory("nombre_producto"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory("cantidad"));
        totalColumn.setCellValueFactory(new PropertyValueFactory("total_dinero"));

        tablaView.setItems(detallePedidosObv);
        tablaView.getSelectionModel().clearAndSelect(0);
    }

    @javafx.fxml.FXML
    public void volverAtras (ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/mainView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 800, 800);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataSaver.getStage().setScene(scene);
    }
}
