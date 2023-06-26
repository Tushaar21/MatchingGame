package com.Beroeps_product_groep6;

import java.sql.*;
import java.util.Scanner;

public class Login {
    static final String URL = "jdbc:mysql://localhost/memory_game";
    static final String USER = "root";
    static final String PASS = "root";
    static Scanner src = new Scanner(System.in);

    public static void insertData(){
        // connecting to database
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            System.out.println("Connected database successfully..." + "\n");
            System.out.println("Inserting records into the table...");
            String input_name;
            String user_pass;
            Scanner src = new Scanner(System.in);

            System.out.print("insert username: ");
            input_name = src.nextLine();
            System.out.print("Insert your password: ");
            user_pass = src.nextLine();

            // insert user data into table(Mysql)
            String sql = "INSERT INTO User_info ( user_name, user_code) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, input_name);
            pstmt.setString(2, user_pass);
            pstmt.executeUpdate();

            System.out.println("\n" + "Inserted records into the table...");
            System.out.println("\n" + "user_name: " + input_name + "\n" + "user_pass:" + user_pass);
            System.out.println(" Username and Password successfully added!");
            //if successful this will bring you to the game mode menu
            TheGameHard.gameMode();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loginData(){
        // connecting to database
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            System.out.println("Connected database successfully..." + "\n");
            System.out.print("insert username: ");
            String input_name = src.nextLine();
            System.out.print("Insert your password: ");
            String input_pass = src.nextLine();
            // checking user data in table(Mysql)
            String sql = "Select * FROM User_info " +
                    "WHERE user_name = ? " +
                    "AND user_code = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_name);
            pstmt.setString(2, input_pass);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("Login Successful!");
                System.out.println();
                //if successful this will bring you to the game mode menu
                TheGameHard.gameMode();
            }else{
                System.out.println("invalid username or password");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void settings() {
        System.out.println("pres 1 to change password");
        System.out.println("pres 2 to change user name");
        System.out.println("=> ");
        int ui = src.nextInt();
        switch (ui) {
            case 1 -> {
                // connecting to database
                try (Connection conn = DriverManager.getConnection(URL, USER, PASS)
                ) {
                    System.out.println("Connected database successfully..." + "\n");
                    System.out.println("Change Password");
                    String input_name;
                    String user_pass;
                    Scanner src = new Scanner(System.in);
                    System.out.print("insert username: ");
                    input_name = src.nextLine();
                    System.out.print("Insert your password: ");
                    user_pass = src.nextLine();

                    // updating user data into table(Mysql)
                    String sql = "UPDATE User_info SET user_code = ? WHERE user_name = ? ";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, user_pass);
                    pstmt.setString(2, input_name);
                    pstmt.executeUpdate();
                    System.out.println("Password changed successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {
                // connecting to databas
                try (Connection conn = DriverManager.getConnection(URL, USER, PASS)
                ) {
                    System.out.println("Connected database successfully..." + "\n");
                    System.out.println("Change user name");
                    String input_name;
                    String user_pass;
                    Scanner src = new Scanner(System.in);
                    System.out.print("insert username: ");
                    input_name = src.nextLine();
                    System.out.print("Insert your password: ");
                    user_pass = src.nextLine();

                    // updating user data into table(Mysql)
                    String sql = "UPDATE User_info SET user_name = ? WHERE user_code = ? ";
                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    pstmt.setString(1, input_name);
                    pstmt.setString(2, user_pass);
                    pstmt.executeUpdate();
                    System.out.println("Password changed successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}