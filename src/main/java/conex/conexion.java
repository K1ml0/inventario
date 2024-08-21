/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class conexion {
    public static String username_gmail = "dagisoftwarej4@gmail.com"; // Gmail de la empresa
    public static String password_gmail = "xjmg fzza wnzq kgjb"; // contraseña de Gmail de la empresa
    
    
    public static final String URL = "jdbc:mysql://localhost:3306/inventario?serverTimezone=America/Bogota&zeroDateTimeBehavior=CONVERT_TO_NULL";
    public static final String USER = "root"; // Tu usuario MySQL
    public static final String PASSWORD = ""; // Tu contraseña MySQL
    
    
    //tabla administrador
    public static String tablaAdministrador ="administrador";
    public static String ColubnaNombreEmpresa = "Nombre_empresa";
    public static String ColubnaNitEmpresa = "Nit_empresa";
    public static String ColubnaTelefonoEmpresa = "Telefono_empresa";
    public static String ColubnaDireccionEmpresa = "Direccion_empresa";
    public static String ColubnaCorreoElectronicoEmpresa = "correo_electronico";
    
    public static String ColubnaNombreAdministrador = "Nombre_administrador";
    public static String ColubnaDocumentoIdentificacionAdministrador = "Documento_identificacion_administrador";
    public static String ColubnaTelefonoAdministrador = "Telefono";
    public static String ColubnaDireccionAdministrador = "Direccion";
    public static String ColubnaCorreoAdministrador = "correo_administrador";
    public static String ColubnaRotAdministrador = "rot";
    public static String ColubnaContraseñaAdministrador = "contraseña";
    
    //tabla producto
    public static String nombreTablaProducto ="producto";
    public static String isProducto = "idProducto";
    public static String fechaEntradaProducto = "fechaentrada";
    public static String fechaFabricacion = "fechaFabricacion";
    public static String fechaVencimiento = "fechaVencimiento";
    public static String nombreProducto = "nombre";
    public static String precioProducto = "precio";
    public static String categoriaProducto = "categoria";
    public static String cantidadProducto = "cantidad";
    public static String proveedorProducto = "proveedor";
    public static String numeroLoteProducto = "numeroLote";
    public static String descripcionProducto ="descripcion";
    public static String codigoProducto = "codigoProducto";
    
    //tabla proveedor
    public static String nombreTablaProveedor = "proveedor";
    public static String idProveedor = "id_proveedor";
    public static String nombreEmpresaProveedor ="nombreEmpresa";
    public static String numeroTelefonoEmpresaProveedor ="Numero_telefono_empresa";
    public static String numeroTelefonoProveedor ="Numero_telefono";
    public static String direccioProveedor ="Direccion";
    public static String correoProveedor = "Correo electronico";
    
    //tabla categoria
    public static String tablaCategoria = "categoria";
    public static String idcategoria ="idcategoria";
    public static String nombreCategoria="nombre";
    public static String descripcionCategoria="descripcion";
    public static String estadoCategoria="estado";
    

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Cargar el driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Conectar a la base de datos y retornar la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
