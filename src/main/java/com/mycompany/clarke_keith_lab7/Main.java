/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clarke_keith_lab7;

import edu.tarleton.caesarcipher.Caesar;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author 000728303
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command: 'encrypt' or 'decrypt");
        String userInput = sc.nextLine();

        Path sPath = Paths.get("encryptme.txt");
        Charset cs = Charset.forName("UTF-8");
        String input = Files.readString(sPath,cs);
        Caesar caesar = new Caesar(5); 

        switch(userInput){
            case "encrypt":
                  
                String encryptedMessage = caesar.encrypt(input);
                try (FileWriter textWriter = new FileWriter("encryptme.txt")) {
                    textWriter.write(encryptedMessage);
                }catch(IOException e){
                    System.out.println("Failed to write");
                }
                break;
            case "decrypt":
                String dencryptedMessage = caesar.decrypt(input);
                try (FileWriter textWriter = new FileWriter("encryptme.txt")) {
                    textWriter.write(dencryptedMessage);
                }catch(IOException e){
                    System.out.println("Failed to write");
                }
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
}
