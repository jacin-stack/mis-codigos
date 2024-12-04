package api;

import com.google.gson.Gson;
import model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ProductoAPI {

    private static final String API_URL = "https://dummyjson.com/products?select=id,title,description,stock,price";

    public ArrayList<Producto> obtenerProductos(ArrayList<Producto> listaProductos) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = bufferedReader.readLine();

            JSONObject response = new JSONObject(linea);
            JSONArray products = response.getJSONArray("products");

            for (Object product : products) {
                if (product instanceof JSONObject) {
                    Gson gson = new Gson();
                    Producto producto = gson.fromJson(((JSONObject) product).toString(), Producto.class);
                    listaProductos.add(producto);
                    System.out.println(producto);
                }
            }

        } catch (MalformedURLException e) {
            System.err.println("La URL está mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error en la conexión o lectura: " + e.getMessage());
        }
        return listaProductos;
    }
}
