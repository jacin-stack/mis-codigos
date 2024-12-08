import api.ProductoAPI;
import dao.EmpleadoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.ProductoFavDAO;
import database.DBConnection;
import model.Empleado;
import model.Producto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        EmpleadoDAO edao = new EmpleadoDAO();
        ProductoAPI papi = new ProductoAPI();
        ProductoDAO pdao = new ProductoDAO();
        PedidoDAO pedao = new PedidoDAO();
        ProductoFavDAO prodao = new ProductoFavDAO();
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        Scanner sc = new Scanner(System.in);

        papi.obtenerProductos(listaProductos);

        try {
            prodao.insertarMayorMil(listaProductos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*try {
            pdao.menosSeiscientos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pedao.mostrarPedidos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pedao.agregarPedido(sc, listaProductos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            pdao.agregarProductos(listaProductos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       System.out.println("¿Cuantos usuarios desea usted insertar?");
        int numero = sc.nextInt();

        for (int i = 1 ; i <= numero; i++){
            edao.insertarEmpleados(sc, edao);
        }
        */
        try {
            edao.mostrarEmpleados();
        } catch (SQLException e) {
            System.out.println("Error en la ejecucion");
        }

    }
}
