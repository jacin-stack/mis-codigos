package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpleadoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean agregarEmpleado(Empleado empleado) throws SQLException {
        connection = new DBConnection().getConnection();
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUE (?, ?, ?, ?)", SchemaDB.TB_EMPLEADOS, SchemaDB.COL_ID, SchemaDB.COL_NAME,
                SchemaDB.COL_SURNAME, SchemaDB.COL_EMAIL);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,empleado.getId());
        preparedStatement.setString(2,empleado.getNombre());
        preparedStatement.setString(3,empleado.getApellidos());
        preparedStatement.setString(4,empleado.getCorreo());
        return preparedStatement.execute();
    }

    public void mostrarEmpleados() throws SQLException {
        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s", SchemaDB.TB_EMPLEADOS);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String id = resultSet.getString("id");
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String correo = resultSet.getString("correo");

            System.out.println(id);
            System.out.println(nombre);
            System.out.println(apellidos);
            System.out.println(correo);
            System.out.println("---------------");
        }
    }

    public void insertarEmpleados(Scanner sc, EmpleadoDAO edao){
        System.out.println("Inserte el ID del empleado");
        String id = sc.next();
        System.out.println("Inserte el nombre del empleado");
        String nombre = sc.next();
        System.out.println("Inserte el primer apellido del empleado");
        String apellidos = sc.next();
        System.out.println("Inserte el correo del empleado");
        String correo = sc.next();
        Empleado e = new Empleado(id, nombre, apellidos, correo);
        try {
            edao.agregarEmpleado(e);
        } catch (SQLException ex) {
            System.out.println("Hay un error en la ejecucion");
            System.out.println(ex.getMessage());
        }
    }
}
