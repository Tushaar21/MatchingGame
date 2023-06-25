package com.ccs.Beroeps_product;

import java.sql.*;
import java.util.Scanner;

public class Login {
    static final String URL = "jdbc:mysql://localhost/memory_game";
    static final String USER = "root";
    static final String PASS = "root";
    static Scanner src = new Scanner(System.in);

    public static String exit(){
        return ("Exit!");
    }
    
    public static void insertData(){
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            System.out.println("Connected database successfully..." + "\n");
            System.out.println("Inserting records into the table...");
            String input_name;
            int user_pass;
            Scanner src = new Scanner(System.in);

            System.out.print("insert username: ");
            input_name = src.nextLine();
            System.out.print("Insert your password: ");
            user_pass = src.nextInt();

            // insert data into table(Mysql)
            String sql = "INSERT INTO User_info ( user_name, user_code) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, input_name);
            pstmt.setInt(2, user_pass);
            pstmt.executeUpdate();

            System.out.println("\n" + "Inserted records into the table...");
            System.out.println("\n" + "user_name: " + input_name + "\n" + "user_pass:" + user_pass);
            System.out.println(" Username and Password successfully added!");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loginData(){
        try (Connection conn = DriverManager.getConnection(URL,USER, PASS)
        ) {
            System.out.println("Connected database successfully..." + "\n");
            System.out.println("insert username: ");
            String input_name = src.nextLine();
            System.out.println("Insert your password: ");
            int input_pass = src.nextInt();
            // insert data into table(Mysql)
            String sql = "Select * FROM User_info " +
                    "WHERE user_name = ? " +
                    "AND user_code = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_name);
            pstmt.setInt(2, input_pass);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("exLogin Successful!");
                TheGame.startMenu();
            }else{
                System.out.println("invalid username or password");
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}