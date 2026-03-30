package org.example;

import java.util.Scanner;

public class excepcionDivisionPorCero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero");
        int num1 = sc.nextInt();
        System.out.println("Digite outro numero");
        int num2 = sc.nextInt();
        try {

            int resultado = num1 / num2;
            System.out.println(resultado);
        } catch(ArithmeticException e) {}
        System.out.println("division por cero no es valida");
    }


    }

