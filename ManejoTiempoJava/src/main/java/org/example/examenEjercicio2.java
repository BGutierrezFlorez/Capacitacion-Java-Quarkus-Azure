package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class examenEjercicio2 {
    public static void main(String[] args) {
        String fechaActual = " 2025-12-03 ";
        System.out.println("fechaActual" + fechaActual);
        LocalDate fechaParaConvertir = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formateString = fechaActual.format(String.valueOf(formatter));
        System.out.println("fecha formateada" + formateString);
    }
}
