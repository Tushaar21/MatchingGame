package com.ccs.Beroeps_product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Pres 0 to exit
                Pres 1 to new user
                Pres 2 to login""");
        Scanner src = new Scanner(System.in);
        System.out.println("Insert number: ");
        int UI = src.nextInt();

        switch (UI) {

            case 0 ->
                Login.exit();

            case 1 ->
                Login.insertData();

            case 2 -> {
                Login.loginData();

            }
        }
    }
}
