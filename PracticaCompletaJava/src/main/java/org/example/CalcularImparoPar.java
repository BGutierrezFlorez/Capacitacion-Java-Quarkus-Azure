package org.example;

import java.util.Scanner;

public class CalcularImparoPar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hola buenos dias por favor dame un numero");
        int numero = scanner.nextInt();
        if(numero%2==0){
            System.out.println("El numero es par");
        } else if(numero%2==1){
            System.out.println("El numero es impar");
        }
    }
}
