package com.Beroeps_product_groep6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Names: Binsrie T     (SE/1122/012)
        *         Djojopawiro A (SE/1122/020)
        *         Elshot T      (SE/1122/023)
        *         Haricharan R  (SE/1122/030)
        *         Goeptar S     (SE/1122/029)
        * Groep: 6
        * Docenten: Bhoendie A
        *           Ramcharan R
        * Datum: 26-06-2023*/

        // main menu
        System.out.println("""
                Pres 0 to exit
                Pres 1 to Login
                Pres 2 to open game info / the top 10 players""");
        Scanner src = new Scanner(System.in);
        System.out.print("=> ");
        int UI = src.nextInt();

        switch (UI) {
            case 0 -> System.out.println("EXIT");
            case 1 ->
                myn();
            case 2 -> {
                System.out.println("""
                  Welcome to the Memory Game!
                  Before playing the game please make a profile and choose a game mode and have fun!!!
                  
                  The game rules are:
                  1. The deck consists of a 4x5 grid with 10 duplicates
                  2. Choose to open 2 cards by selecting the row and column
                  3. Try to guess all the matching cards as fast as you can
                  4. After 10 unmatched cards the game will end
                  5. For every matched card 2 points wil be added to your final score""");

                ScoreSystem.ScoreBoard();
                System.out.println();
                System.out.println("pres 1 to exit");
                System.out.println("pres 2 to go back");
                int oi = src.nextInt();
                if (oi == 1) {
                    System.out.println("EXIT!!!");
                } else if (oi ==2) {
                    myn();
                }
            }
        }
    }
    //Login menu
    public static void myn(){
        System.out.println("""
                Pres 0 to exit
                Pres 1 to create new user
                Pres 2 to login
                Pres 3 to change user data""");
        Scanner src = new Scanner(System.in);
        System.out.print("=>");
        int UI = src.nextInt();

        switch (UI) {
            case 0 -> System.out.println("EXIT!!!");
            case 1 -> Login.insertData();
            case 2 -> Login.loginData();
            case 3 -> Login.settings();
        }
    }
}
