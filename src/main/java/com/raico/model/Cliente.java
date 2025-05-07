// Esta clase es un modelo simple que representa un cliente con su código, nombre y email
package com.raico.model;

public class Cliente {
    private String codigo;
    private String nombre;
    private String email;

    // Constructor que recibe todos los datos como String
    public Cliente(String codigo, String nombre, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters (opcionalmente podrías agregarlos si los necesitás luego)
    public String getCodigo() {
        return codigo; // Devuelve el código del cliente
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del cliente
    }

    public String getEmail() {
        return email; // Devuelve el email del cliente
    }

    // toString para imprimir el cliente fácilmente
    @Override
    public String toString() {
        // Retorna una cadena con los datos del cliente en formato amigable
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


