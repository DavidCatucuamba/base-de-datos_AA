import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//No olvidarse del extends JFrame
public class diseño extends JFrame{
    private JButton button1;
    private JPanel panel1;
    private JTextField nom;
    private JTextField eda;
    private JTextField n1;
    private JTextField n2;
    private JButton verInf;

    //siemrpe lo primero que hago es crear el metodo constructor
    public diseño(){
        setTitle("Lo que pidio la ing");
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //nunca olvidarse poner esto
        setContentPane(panel1);




        //creo un listener desde la interfaz grafica
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    IngresarDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        verInf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    //Creo una funcion
    public void IngresarDatos() throws SQLException {
        //llamo a la funcion para que venga
        //primero se hace la conexion antes de realizar cualquier consulta
        Connection conecta=conexion();
        String nombre=nom.getText();
        String edad=eda.getText();

        //Lo que pidio
        String nota1=n1.getText();
        String nota2=n2.getText();

        //Lo que la ing pidio
        String sql="insert into estudiante(nombre,edad,nota1,nota2) values (?,?,?,?)";





        // iMP
        // PreparedStatement SIRVE PARA enviar sentrencias SQl a la base de datos
        //Guardamos la informacion que se agrega en el JTexfiel en la base de datos
        //Creo una instancia pstmt para conectar a la bdd
        //                                        sql = "la consulta que hago"

        PreparedStatement pstmt=conecta.prepareStatement(sql);

        // siempre con un set(String - Int depende de que tipo de datos es en mi bdd) ,
        // el numero cambia de acuerdo a la cantidad de datos que tengo
        pstmt.setString(1,nombre);
        //pstmt.setString(2,edad); ahi no esta converitdo
        //como necesitamos convertirlo a entero usamos;
        pstmt.setInt(2,Integer.parseInt(edad));

        //LO QUE LA ING PIDIO
        pstmt.setDouble(3,Double.parseDouble(nota1));
        pstmt.setDouble(4,Double.parseDouble(nota2));

        //Explicacion de esto
        // Ir fila por fila y agregarlo a la bdd
        //Me pone un registro debajo de otro
        int rowsAffect=pstmt.executeUpdate();
        //Este hace que se valla bajando
        if (rowsAffect>0){
            JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
        }
        //cerramos la base de datos
        pstmt.close();
        //cerramos la conexion
        conecta.close();
    }

    //Hacemos la conexion
    public Connection conexion() throws SQLException{
        String url="jdbc:mysql://localhost:3306/esfotventas";
        String user="root";
        String password="123456";
        //return
        return DriverManager.getConnection(url,user,password);

    }

    //metodo cisualizar informacion

    public void MostrarInformacion() throws SQLException {
        //llamo a la funcion para que venga
        //primero se hace la conexion antes de realizar cualquier consulta
        Connection conecta=conexion();
        String nombre=nom.getText();
        String edad=eda.getText();

        //Lo que pidio
        String nota1=n1.getText();
        String nota2=n2.getText();

        //Lo que la ing pidio
        String sql="insert into estudiante(nombre,edad,nota1,nota2) values (?,?,?,?)";





        // iMP
        // PreparedStatement SIRVE PARA enviar sentrencias SQl a la base de datos
        //Guardamos la informacion que se agrega en el JTexfiel en la base de datos
        //Creo una instancia pstmt para conectar a la bdd
        //                                        sql = "la consulta que hago"

        PreparedStatement pstmt=conecta.prepareStatement(sql);

        // siempre con un set(String - Int depende de que tipo de datos es en mi bdd) ,
        // el numero cambia de acuerdo a la cantidad de datos que tengo
        pstmt.setString(1,nombre);
        //pstmt.setString(2,edad); ahi no esta converitdo
        //como necesitamos convertirlo a entero usamos;
        pstmt.setInt(2,Integer.parseInt(edad));

        //LO QUE LA ING PIDIO
        pstmt.setDouble(3,Double.parseDouble(nota1));
        pstmt.setDouble(4,Double.parseDouble(nota2));

        //Explicacion de esto
        // Ir fila por fila y agregarlo a la bdd
        //Me pone un registro debajo de otro
        int rowsAffect=pstmt.executeUpdate();
        //Este hace que se valla bajando
        if (rowsAffect>0){
            JOptionPane.showMessageDialog(null,"Registro insertado correctamente");
        }
        //cerramos la base de datos
        pstmt.close();
        //cerramos la conexion
        conecta.close();


    }


}
