// Esta clase se encarga de conectarse a la base y traer los datos del cliente
package com.raico.repository;

import com.raico.model.Cliente;
import com.raico.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteRepository {

    // Método que busca un cliente por su código en la base de datos
    public static Cliente buscarPorCodigo(String codigo) {
        Cliente cliente = null;

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Actualizamos los nombres de las columnas a los correctos: Clientes_Codigo, Clientes_Nombre, Clientes_EMail
            String sql = "SELECT Clientes_Codigo, Clientes_Nombre, Clientes_EMail FROM Clientes WHERE Clientes_Codigo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigo); // Reemplazamos el "?" por el código del cliente

            ResultSet rs = stmt.executeQuery(); // Ejecutamos la consulta

            // Si encontramos un cliente, creamos un objeto Cliente
            if (rs.next()) {
                cliente = new Cliente(
                        rs.getString("Clientes_Codigo"), // Tomamos la columna 'Clientes_Codigo'
                        rs.getString("Clientes_Nombre"), // Tomamos la columna 'Clientes_Nombre'
                        rs.getString("Clientes_EMail") // Tomamos la columna 'Clientes_EMail'
                );
            }

        } catch (Exception e) {
            e.printStackTrace(); // Mostramos el error si algo falla
        }

        return cliente; // Devolvemos el cliente encontrado (o null si no se encontró)
    }
}


