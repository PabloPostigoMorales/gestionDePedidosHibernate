package com.example.gestiondepedidos.controllers;

import com.example.gestiondepedidos.App;
import com.example.gestiondepedidos.DataSaver;
import com.example.gestiondepedidos.model.usuario.Session;
import com.example.gestiondepedidos.model.usuario.Usuario;
import com.example.gestiondepedidos.model.usuario.UsuarioDAO;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Log
public class LoginController implements Initializable {

    @FXML
    @Getter @Setter
    private TextField userlbl;
    @FXML
    @Getter @Setter
    private TextField passlbl;
    @FXML
    @Getter @Setter
    private Button loginBtn;
    @FXML
    @Getter @Setter
    private Label infolbl;


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void loggin (Event event) {
        UsuarioDAO user = new UsuarioDAO();
        Optional<Usuario> userIniciado = user.loginUsuario(userlbl.getText(),passlbl.getText());

        if (userIniciado.isPresent()) {
            infolbl.setText("Usuario correcto");
            log.info("Se ha iniciado sesion con los datos: "+userIniciado.get());
            Session.setUsuario(userIniciado.get());

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/mainView.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 800);
                DataSaver.getStage().setScene(scene);
            }catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else {
            infolbl.setText("El usuario o la contraseña no son correctos");
        }

    }


}