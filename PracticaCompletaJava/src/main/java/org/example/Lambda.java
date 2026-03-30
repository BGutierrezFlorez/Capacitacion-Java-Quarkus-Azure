package org.example;

import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

        // 🔹 1. Mostrar números pares
        System.out.println("Números pares:");
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // 🔹 2. Multiplicar cada número por 2
        System.out.println("\nNúmeros multiplicados por 2:");
        numeros.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);

        // 🔹 3. Sumar todos los números
        int suma = numeros.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("\nSuma total: " + suma);

    }
}
