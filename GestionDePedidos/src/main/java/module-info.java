module com.example.gestiondepedidos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;


    opens com.example.gestiondepedidos to javafx.fxml, org.hibernate.orm.core;
    exports com.example.gestiondepedidos;
    exports com.example.gestiondepedidos.controllers;
    opens com.example.gestiondepedidos.controllers to javafx.fxml, org.hibernate.orm.core;
    exports com.example.gestiondepedidos.model.producto;
    opens com.example.gestiondepedidos.model.producto to javafx.fxml, org.hibernate.orm.core;
    exports com.example.gestiondepedidos.model.pedido;
    opens com.example.gestiondepedidos.model.pedido to javafx.fxml, org.hibernate.orm.core;
    exports com.example.gestiondepedidos.model.usuario;
    opens com.example.gestiondepedidos.model.usuario to javafx.fxml, org.hibernate.orm.core;
    exports com.example.gestiondepedidos.model.detallepedido;
    opens com.example.gestiondepedidos.model.detallepedido to javafx.fxml, org.hibernate.orm.core;
}