package database;

public interface SchemaDB {

    String HOST = "127.0.0.1";
    String DB_NAME = "almacen";
    String TB_EMPLEADOS = "empleados";
    String COL_ID = "ID";
    String COL_NAME = "Nombre";
    String COL_SURNAME = "Apellidos";
    String COL_EMAIL = "Correo";
    String TB_PRODUCTOS = "productos";
    String COL_IDP = "ID";
    String COL_NOMBRE = "Nombre";
    String COL_DESCRIPCION = "Descripcion";
    String COL_CANTIDAD = "Cantidad";
    String COL_PRECIO = "Precio";
    String TB_PEDIDOS = "pedidos";
    String COL_IDPEDIDOS = "ID";
    String COL_IDPRODUCTO = "ID_Producto";
    String COL_DESCRIPCIONPEDIDO = "Descripcion";
    String COL_PRECIOPEDIDO = "Precio_Total";
    String TB_PRODUCTOFAV = "productos_fav";
    String COL_IDPRODUCTOFAV = "ID_producto";
}
