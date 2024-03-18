package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.App;
import com.example.gestiondepedidos.DataSaver;
import com.example.gestiondepedidos.model.pedido.Pedido;
import com.example.gestiondepedidos.model.pedido.PedidoDAO;
import com.example.gestiondepedidos.model.usuario.Session;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @javafx.fxml.FXML
    private ToolBar toolBarra;
    @javafx.fxml.FXML
    private Button btnLogOut;
    @javafx.fxml.FXML
    private Text fechaText;
    @javafx.fxml.FXML
    private TabPane tabPane;
    @javafx.fxml.FXML
    private Tab pedidosTab;
    @javafx.fxml.FXML
    private TableColumn idColumn;
    @javafx.fxml.FXML
    private TableColumn fechaColumn;
    @javafx.fxml.FXML
    private TableColumn totalColumn;
    @javafx.fxml.FXML
    private TableColumn idUserColumn;
    @javafx.fxml.FXML
    private TableColumn codPedidoColumn;
    @javafx.fxml.FXML
    private TableView tablaView;
    @javafx.fxml.FXML
    private Button btnEntrarPedido;
    @javafx.fxml.FXML
    private Button btnEliminarPedido;
    @javafx.fxml.FXML
    private Button btnCrearPedido;
    @javafx.fxml.FXML
    private Button btnEditarPedido;

    @javafx.fxml.FXML
    public void logOut (ActionEvent actionEvent) {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/login.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 320, 240);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataSaver.getStage().setScene(scene);
        Session.setUsuario(null);
    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        ArrayList<Pedido> pedidos = pedidoDAO.getAllByUserID(Session.getUsuario().getId());
        ObservableList<Pedido> pedido = FXCollections.observableArrayList(pedidos);

        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        idUserColumn.setCellValueFactory(new PropertyValueFactory("user_id"));
        codPedidoColumn.setCellValueFactory(new PropertyValueFactory("cod_pedido"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory("order_date"));
        totalColumn.setCellValueFactory(new PropertyValueFactory("total"));

        tablaView.setItems(pedido);
        tablaView.getSelectionModel().clearAndSelect(0);
    }

    @javafx.fxml.FXML
    public void verPedido (ActionEvent actionEvent) {
        Pedido pedido = (Pedido) tablaView.getSelectionModel().getSelectedItem();
        if (pedido!=null) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/productos.fxml"));
            DataSaver.setPedido(pedido);
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 800, 400);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            DataSaver.getStage().setScene(scene);
        }
    }

    @javafx.fxml.FXML
    public void eliminarPedido (ActionEvent actionEvent) {
        Pedido pedido = (Pedido) tablaView.getSelectionModel().getSelectedItem();
        PedidoDAO pedidoDAO = new PedidoDAO();
        if (pedido!=null) {
            pedidoDAO.deleteByID(pedido.getId());
            tablaView.getItems().remove(tablaView.getSelectionModel().getSelectedItem());
        }
    }

    @javafx.fxml.FXML
    public void crearPedido (ActionEvent actionEvent) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/crearPedido.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 800, 400);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            DataSaver.getStage().setScene(scene);
    }

    @javafx.fxml.FXML
    public void editarPedido (ActionEvent actionEvent) {
    }
}
