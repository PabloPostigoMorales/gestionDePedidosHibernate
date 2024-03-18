package bbdd.properties;
import lombok.Getter;

import java.sql.*;
public class AmazenConnection {
        @Getter
        private static final Connection connection;
        private static final String DB_URL = "jdbc:mysql://localhost:3306/";
        private static final String USER = "root";
        private static final String PASS = "";
        private static final String QUERY = "SELECT id, first, last, age FROM Employees";

        static  {
            String table ="gestorpedidos";
            // Open a connection
           try{
               connection = DriverManager.getConnection(DB_URL+table,USER,PASS);
               System.out.println("Se ha iniciado la base de datos correctamente");
           }catch (Exception e){
               System.out.println("No se ha podido iniciar conexion con la base de datos");
               throw new RuntimeException(e);
           }finally {
               System.out.println("Proceso de conexion finalizado");
           }

        }
}
