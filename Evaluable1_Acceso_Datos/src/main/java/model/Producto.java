package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto implements Serializable {

    private int stock;
    private double price;
    private String id, title, description;

    @Override
    public String toString() {
        return "id = " + id + ", nombre = " + title + ", cantidad = " + stock + ", precio = " + price + ", descripcion = " + description;
    }
}
