// primero tengo que importar el .jar

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        /*// pongo las variables de mi bdd
        // localhost significa que estamos trabajando de manera local
        String url="jdbc:mysql://localhost:3306/esfotventas";
        String user="root";
        String password="123456"; //es el pass de mi bdd
        //try si no hay errores se va al try , si hay qrrores me muestra el catch
        //creo una instancai con el try
        // Conecta va a recibir mi base de datos
        // DriverManager me ayuda a hacer la conexion de la base de datos
        //
        try(Connection conecta= DriverManager.getConnection(url,user,password)) {

            if (conecta!= null){
                System.out.println("CONEXION EXITOSA A LA BASE DE DATOS");
            }
            else {
                System.out.println("NOOOOOOOO CONEXION A LA BASE DE DATO NO CORRECTA");
            }
        }
        //eL CATCH ASOMA CUANDO HALFGO ESTA MAL EN LA BASE DE DATOS
        catch (SQLException e){
            // printStrackTrace imprime el error quye tenga e es un nombre cualquiera
            e.printStackTrace();
        }*/
        diseño venta=new diseño();
        venta.setVisible(true);
    }
}