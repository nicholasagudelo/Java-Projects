/*
 Name: Nicholas Agudelo
 Date: April 2, 2023
 Description: This program encrypts and decrypts messages using ASCII.
 */
 

import java.util.*;
import java.lang.Math;

public class  EncryptAgudelo // <-----change the name to include your last name
{
   
}  
class TextMessage
{
   public static void main(String[] args) {
       
         menu();
   }
   
   //*************************************************************************************
   public static void Choose( ) //Use the switch and cases to choose between encrypting or decrypting
   {
      Scanner kb = new Scanner (System.in);
      
      System.out.println("Press E to encrypt, or D to decrypt");
      int path = (int)kb.next().charAt(0); 
      
      do { 
         if (path == 'E'|| path == 'e')
         {
            System.out.println("Choose a number as the password!");
            int key = Math.abs(kb.nextInt());
            System.out.println("Write the message you want to be encrypted!");
            String s = kb.next();
            encrypt(s, key);
            break;
         }
         else if (path == 'D' || path == 'd')
         {
            System.out.println("What's the message's key?");
            int key = Math.abs(kb.nextInt());
            System.out.println("Write the message you want decrypted");
            String s = kb.next();
            decrypt(s, key);
            break;
         }
         else
         {
            System.out.println("Choose a valid option this time...");
            System.out.println("Press E to encrypt, or D to decrypt");
            path = (int)kb.next().charAt(0);
         }
         
      } while (path != 'E' || path != 'D');
      
   }
   
	/*
	 * Returns a new string with the letters of the given string shifted
	 * forward or backward by the amount equal to the given key.
	 * For example, shift("hello", 3) returns "khoor".
	 */
   public static String encrypt(String message, int key)  
   {
      message = message.toUpperCase();
      String encryption = "";
      
      for (int i = 0; i < message.length(); i++)
      {
         char letter = message.charAt(i);
         
         if (letter == ' ')
         {
            letter = '#';
         }
         else if (letter >= 'A' && letter <= 'Z')
            {
               letter = (char)(letter + key);
            }
            if (letter > 'Z')
            {
               letter = (char)(letter - 26);
            }
            else if (letter < 'A')
            {
               letter = (char)(letter + 26);
            } 
         
      encryption += letter;
         
      }
      
      System.out.println("This is your encrypted message: \n" + encryption);
   	
      return encryption; 
   }
   //*********************************************************************
   
   /*
	 * decrypts the encrypted string using the same key value. 
	 * For example, decrypt("khoor", 3) returns "hello".
	 */

   public static String decrypt(String message, int key) 
   {
      message = message.toUpperCase();
      String decryption = "";
      
      for (int i = 0; i < message.length(); i++)
      {
         char letter = message.charAt(i);
         
         if (letter == '#')
         {
            letter = ' ';
         }
         if (letter >= 'A' && letter <= 'Z')
         {
            letter = (char)(letter - key);
         }
         if (letter < 'A')
         {
            int diff = 'A' - letter;
            letter = (char)('Z' - diff + 1);
         }
         else if (letter > 'Z')
         {
            int diff = 'Z' - letter;
            letter = (char)('A' + diff + 1);
         }
      
      decryption += letter;
      
      }

      System.out.println(decryption);
                      	
      return decryption; 
   }
   
   //**********************************************************************
   
   /*This method displays a menu for the user to choose the option.
   refer to the provided output to see the menu*/
   public static void menu()   
   {
     Scanner kb = new Scanner (System.in);
   
     System.out.println("*******************************************"); 
     System.out.println("     Welcome to the encryptor machine!");
     System.out.println("How many times do you want to run the code?"); 
     System.out.println("*******************************************");
     
     int count = kb.nextInt();
     
     for (int i = 1; i <= count; i++)
     {
      Choose();
     }
   }
   //**********************************************************************************

}