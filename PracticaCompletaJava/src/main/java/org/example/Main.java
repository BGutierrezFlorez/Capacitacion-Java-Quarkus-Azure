package org.example;

import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            int[] arr = new int[2];
            System.out.println(arr[5]);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("X");
        }

    }
    }
