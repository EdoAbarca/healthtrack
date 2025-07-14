package com.weight.healthtrack.model;

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void actualizarPeso(double nuevoPeso) {
        // ERROR: En lugar de asignar el nuevo peso, se está restando 1kg.
        //this.peso -= 1;
        // Corrige el error: asigna el nuevo peso en vez de restar 1kg
        this.peso = nuevoPeso;
    }

    // Método en desuso, debería ser visible en SonarQube como código muerto
    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
    }
}