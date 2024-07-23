/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import Login.Diseño_login;
import Login.crearCuenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ventanaPrincipal.VentanaPrincipal;
import java.sql.*;

/**
 *
 * @author juand
 */
public class main {
    public static boolean usuario_registrado = true;//aun no hay un administrador registrado
    public static void main(String[] args) throws SQLException {
        if(usuario_registrado){
            VentanaPrincipal.main(args);//iniciar ventana principal
        }else{
            crearCuenta.main(args);//Crear cuenta
        }   
       
    }
}
