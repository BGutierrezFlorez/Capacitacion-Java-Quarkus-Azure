package org.example;

public class Persona {
    public static void main(String[] args) {
        System.out.println("nombre es : " + nombre);
        System.out.println("edad es : " + edad);
    }
    private static String nombre;
    private static int edad;
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }



}


