package com.example.gestiondepedidos;

import com.example.gestiondepedidos.model.pedido.Pedido;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class DataSaver {
    @Getter
    @Setter
    private static Stage stage;
    @Getter
    @Setter
    private static Pedido pedido;
}
