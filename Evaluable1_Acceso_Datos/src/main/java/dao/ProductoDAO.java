package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean agregarProductos (ArrayList<Producto> listaProductos) throws SQLException {
        connection = new DBConnection().getConnection();
        boolean exito = true;
        for (Producto p: listaProductos) {
            String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUE (?, ?, ?, ?, ?)", SchemaDB.TB_PRODUCTOS,
                    SchemaDB.COL_IDP, SchemaDB.COL_NOMBRE, SchemaDB.COL_DESCRIPCION, SchemaDB.COL_CANTIDAD, SchemaDB.COL_PRECIO);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, p.getId());
            preparedStatement.setString(2, p.getTitle());
            preparedStatement.setString(3, p.getDescription());
            preparedStatement.setInt(4, p.getStock());
            preparedStatement.setDouble(5, p.getPrice());
            int resultado = preparedStatement.executeUpdate();
            if (resultado <= 0){
                exito = false;
            }
        }
        return exito;
    }

    public void menosSeiscientos() throws SQLException {
        connection = new DBConnection().getConnection();
        String query = String.format("SELECT * FROM %s WHERE %s < 600", SchemaDB.TB_PRODUCTOS, SchemaDB.COL_PRECIO);
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String id = resultSet.getString(SchemaDB.COL_IDP);
            String nombre = resultSet.getString(SchemaDB.COL_NOMBRE);
            String descripcion = resultSet.getString(SchemaDB.COL_DESCRIPCION);
            String cantidad = resultSet.getString(SchemaDB.COL_CANTIDAD);
            String precio = resultSet.getString(SchemaDB.COL_PRECIO);

            System.out.println(id);
            System.out.println(nombre);
            System.out.println(descripcion);
            System.out.println(cantidad);
            System.out.println(precio);
            System.out.println("--------------");
        }
    }
}
