package com.raico;

import com.raico.utils.DatabaseConnection;
import com.raico.utils.PdfScanner;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Conexión a la base de datos establecida correctamente.\n");
        } else {
            System.out.println("❌ Error al conectar a la base de datos.");
            return; // Si no hay conexión, no seguimos
        }

        // Probamos el escaneo de archivos PDF
        Map<String, List<File>> archivosPorCliente = PdfScanner.getPdfFilesGroupedByClientCode();

        // Mostramos qué archivos se encontraron por cada cliente
        for (String clientCode : archivosPorCliente.keySet()) {
            System.out.println("📦 Cliente " + clientCode + " tiene los siguientes archivos:");
            for (File archivo : archivosPorCliente.get(clientCode)) {
                System.out.println("   - " + archivo.getName());
            }
        }
    }
}


