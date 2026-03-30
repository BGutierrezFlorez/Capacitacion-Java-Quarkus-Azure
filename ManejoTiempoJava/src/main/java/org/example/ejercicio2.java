package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ejercicio2 {
    public static void main(String[] args) {
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm.ss");
        String formattedDate = fechaActual.format(formatter);
        System.out.println("fecha formateada = " + formattedDate);
    }
}
