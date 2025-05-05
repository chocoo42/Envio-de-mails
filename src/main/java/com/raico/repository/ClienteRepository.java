// Esta clase se encarga de conectarse a la base y traer los datos del cliente
package com.raico.repository;

import com.raico.model.Cliente;
import com.raico.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteRepository {

    // Este método recibe un código de cliente, consulta la base y devuelve un objeto Cliente
    public static Cliente buscarClientePorCodigo(int codigoCliente) {
        Cliente cliente = null;

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT Clientes_Codigo, Clientes_Nombre, Clientes_EMail " +
                    "FROM Clientes WHERE Clientes_Codigo = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, codigoCliente);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int codigo = rs.getInt("Clientes_Codigo");
                String nombre = rs.getString("Clientes_Nombre");
                String email = rs.getString("Clientes_EMail");

                // Creamos el objeto Cliente
                cliente = new Cliente(codigo, nombre, email);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Para depurar si hay error de conexión o SQL
        }

        return cliente; // Puede devolver null si no encontró el cliente
    }
}

