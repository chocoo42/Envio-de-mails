package com.raico;

import com.raico.model.Cliente;
import com.raico.repository.ClienteRepository;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia del repositorio que maneja los clientes
        ClienteRepository clienteRepo = new ClienteRepository();

        // Supongamos que queremos buscar el cliente con código "123"
        String codigoCliente = "123";

        // Usamos el repositorio para buscarlo en la base de datos
        Cliente cliente = clienteRepo.buscarPorCodigo(codigoCliente); // Llamamos al método actualizado

        // Verificamos si lo encontró o no
        if (cliente != null) {
            // Mostramos los datos del cliente
            System.out.println("Cliente encontrado:");
            System.out.println("Código: " + cliente.getCodigo()); // Mostramos el código del cliente
            System.out.println("Nombre: " + cliente.getNombre()); // Mostramos el nombre del cliente
            System.out.println("Email: " + cliente.getEmail()); // Mostramos el email del cliente
        } else {
            System.out.println("No se encontró un cliente con el código " + codigoCliente); // Mensaje si no se encuentra
        }
    }
}




