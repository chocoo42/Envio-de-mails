package com.raico.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfScanner {

    // Ruta de la carpeta donde están los archivos PDF (ajustala a tu caso real)
    private static final String PDF_FOLDER_PATH = "D:\\BORRAR\\Facturas Raico\\Facturas PDF";

    /**
     * Este método escanea la carpeta y agrupa los archivos PDF por código de cliente.
     * Devuelve un Map donde:
     * - clave: código del cliente (ej: 10444)
     * - valor: lista de archivos PDF correspondientes a ese cliente
     */
    public static Map<String, List<File>> getPdfFilesGroupedByClientCode() {
        Map<String, List<File>> groupedFiles = new HashMap<>();

        File folder = new File(PDF_FOLDER_PATH);

        // Verificamos que la carpeta exista y sea una carpeta
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

            if (files != null) {
                for (File file : files) {
                    // Extraemos los primeros 8 dígitos del nombre del archivo
                    String filename = file.getName();
                    String codePart = filename.substring(0, 8); // ej: "00010444"

                    // Eliminamos ceros a la izquierda (ej: "00010444" → "10444")
                    String clientCode = codePart.replaceFirst("^0+(?!$)", "");

                    // Agrupamos los archivos según el código de cliente
                    groupedFiles.computeIfAbsent(clientCode, k -> new ArrayList<>()).add(file);
                }
            }

        } else {
            System.out.println("❌ La carpeta especificada no existe o no es válida: " + PDF_FOLDER_PATH);
        }

        return groupedFiles;
    }
}

