// Esta clase es un modelo simple que representa un cliente con su código, nombre y email
package com.raico.model;

public class Cliente {
    private int codigo;
    private String nombre;
    private String email;

    // Constructor
    public Cliente(int codigo, String nombre, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    // Para imprimir al cliente (útil para debug)
    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
