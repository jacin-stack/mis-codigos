package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoFavDAO {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public boolean insertarMayorMil(ArrayList<Producto> listaProductos) throws SQLException {
        connection = new DBConnection().getConnection();
        boolean exito = true;
        for (Producto p : listaProductos){
            if (p.getPrice() > 1000){
                String query = String.format("INSERT INTO %s (%s) VALUE (?)", SchemaDB.TB_PRODUCTOFAV, SchemaDB.COL_IDPRODUCTOFAV);
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, p.getId());
                int resultado = preparedStatement.executeUpdate();
                if (resultado <= 0){
                    exito = false;
                }
            }
        }
        return exito;
    }
}
