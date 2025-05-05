package com.raico.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de conexión al servidor SQL Server
    // - localhost\SQLEXPRESS → es tu instancia local de SQL Server
    // - databaseName=RAICO → nombre de la base de datos
    // - encrypt=true;trustServerCertificate=true → esto permite conexiones seguras incluso si el certificado no es válido
    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=RAICO;encrypt=true;trustServerCertificate=true";

    // Usuario de la base de datos
    private static final String USER = "sa";

    // Contraseña de la base de datos
    private static final String PASSWORD = "asterix";

    // Método que devuelve una conexión activa a la base de datos
    public static Connection getConnection() {
        try {
            // Intenta conectarse con los datos especificados
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Si hay error al conectar, se imprime el error
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
            return null; // Si falla la conexión, devuelve null
        }
    }
}


