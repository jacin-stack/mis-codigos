package dao;

import database.DBConnection;
import database.SchemaDB;
import model.Pedido;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PedidoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

   public boolean agregarPedido (Scanner sc, ArrayList<Producto> listaProductos) throws SQLException {
       connection = new DBConnection().getConnection();
       boolean exito = true;
       Pedido pedido = null;
       System.out.println("Introduce el id del producto que quieres añadir al pedido");
       String id = sc.next();
       for (Producto p : listaProductos){
           if(p.getId().equals(id) && p.getStock() != 0){
               pedido = new Pedido(id, p.getTitle(), p.getPrice());
           }
       }
       String query = String.format("INSERT INTO %s (%s, %s, %s) VALUE (?, ?, ?)", SchemaDB.TB_PEDIDOS, SchemaDB.COL_IDPRODUCTO,
               SchemaDB.COL_DESCRIPCIONPEDIDO, SchemaDB.COL_PRECIOPEDIDO);
       preparedStatement = connection.prepareStatement(query);
       assert pedido != null;
       preparedStatement.setString(1, pedido.getIdProducto());
       preparedStatement.setString(2, pedido.getDescripcion());
       preparedStatement.setDouble(3, pedido.getPrecioTotal());
       int resultado = preparedStatement.executeUpdate();
       if (resultado <= 0){
           exito = false;
       }
       return exito;
   }

   public void mostrarPedidos() throws SQLException {
       connection = new DBConnection().getConnection();
       String query = String.format("SELECT * FROM %s", SchemaDB.TB_PEDIDOS);
       preparedStatement = connection.prepareStatement(query);
       resultSet = preparedStatement.executeQuery();

       while(resultSet.next()){
           String idPedido = String.valueOf(resultSet.getInt(SchemaDB.COL_IDPEDIDOS));
           String idProducto = resultSet.getString(SchemaDB.COL_IDPRODUCTO);
           String descripcion = resultSet.getString(SchemaDB.COL_DESCRIPCIONPEDIDO);
           String precioTotal = resultSet.getString(SchemaDB.COL_PRECIOPEDIDO);

           System.out.println(idPedido);
           System.out.println(idProducto);
           System.out.println(descripcion);
           System.out.println(precioTotal);
           System.out.println("---------------");
       }
   }
}
