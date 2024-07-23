/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conex.conexion;
public class EjemploSencillo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Obtener la conexión a la base de datos
            connection = conexion.getConnection();
            System.out.println("Conexión establecida.");

            // Crear un statement
            statement = connection.createStatement();

            // Insertar un nuevo administrador
            String insertQuery = "INSERT INTO Administrador (Nombre, Apellido, Telefono) VALUES ('Juan', 'Pérez', '1234567890')";
            statement.executeUpdate(insertQuery);
            System.out.println("Administrador creado.");

            // Leer administradores de la base de datos
            String selectQuery = "SELECT * FROM Administrador";
            resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("apellido");
                String numeroTelefono = resultSet.getString("Telefono");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Número de Teléfono: " + numeroTelefono);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}