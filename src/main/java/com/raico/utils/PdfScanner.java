package com.raico.utils;

import com.raico.model.Cliente;
import com.raico.repository.ClienteRepository;

import java.io.File;

public class PdfScanner {

    // Ruta de la carpeta donde están los archivos PDF
    private static final String CARPETA_PDF = "D:\\BORRAR\\Facturas Raico\\Facturas PDF"; // Cambia esta ruta si es necesario

    // Este método recorre los archivos PDF y busca clientes
    public static void escanearYBuscarClientes() {
        File carpeta = new File(CARPETA_PDF); // Creamos un objeto File para acceder a la carpeta

        // Obtenemos solo los archivos que terminan en .pdf
        File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.toLowerCase().endsWith(".pdf"));

        // Si no hay archivos PDF, mostramos un mensaje y salimos del método
        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos PDF en: " + CARPETA_PDF);
            return; // Salimos si no hay archivos PDF
        }

        // Recorremos cada archivo PDF
        for (File archivo : archivos) {
            String nombreArchivo = archivo.getName(); // Obtenemos el nombre del archivo
            System.out.println("Procesando archivo: " + nombreArchivo);

            // Extraemos el código del cliente desde el nombre del archivo
            String codigoCliente = extraerCodigoCliente(nombreArchivo);

            if (codigoCliente != null) {
                // Si conseguimos un código de cliente, buscamos al cliente en la base de datos
                Cliente cliente = ClienteRepository.buscarPorCodigo(codigoCliente);

                if (cliente != null) {
                    // Si encontramos al cliente, lo mostramos
                    System.out.println("Cliente encontrado: " + cliente);
                } else {
                    // Si no encontramos al cliente, mostramos una advertencia
                    System.out.println("⚠️ No se encontró cliente con código: " + codigoCliente);
                }
            } else {
                // Si no se pudo extraer el código, mostramos un mensaje de error
                System.out.println("⚠️ No se pudo extraer código del archivo: " + nombreArchivo);
            }
        }
    }

    // Este método separa el nombre del archivo para obtener el código del cliente
    private static String extraerCodigoCliente(String nombreArchivo) {
        // Suponemos que el nombre del archivo es algo como "10444_Factura_RAICO.pdf"
        try {
            return nombreArchivo.split("_")[0]; // Tomamos la parte antes del primer "_"
        } catch (Exception e) {
            return null; // Si falla algo, devolvemos null
        }
    }
}


