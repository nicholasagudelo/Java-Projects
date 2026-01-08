import java.util.Scanner;
import java.lang.Math;

/*
Name: Nicholas Agudelo
Date: March 17, 2023
Description: This program assists you with mathematical equations with a user-friendly interface.
*/

public class MathAgudelo
{
   
}
class Expression
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner (System.in);
      System.out.println("How many times do you want to run the program? ");
      int count = kb.nextInt();
      
      for (int i = 1; i <= count; i++){
         menu();
      }
   }
   
   public static void conversion(){ //This module will switch the characters to their operator counterparts
   
   Scanner kb = new Scanner (System.in);
   System.out.println("Please type: * , / , + , - , ^ , or % ");
   char character = kb.next().charAt(0);
   int operator = 0;
   
   switch (character) //"operator" is given a number to find what process will be done!
   {
      case '+' : operator = 1;
               break;
      case '-' : operator = 2;
               break;
      case '*' : operator = 3;
               break;
      case '/' : operator = 4;
               break;
      case '^' : operator = 5;
               break;
      case '%' : operator = 6;
               break;
      
      default : operator = -1;
   }
   
   operation(operator, character);
   
   }
   
   public static void menu(){
   
      System.out.println("What do you want to do? \nMultiply? \nDivide? \nAdd? \nSubtract?\n");
      System.out.println("//////////////////////////////////////////////////////////////////\n");
      conversion();
   
   }
   
   public static void operation(int operator, char character){ //"Operation" grabs the desired equation using the operator number
   
      Scanner kb = new Scanner (System.in);
   
      System.out.println("Choose your first number: ");
      int num1 = kb.nextInt();
      System.out.println("Choose your second number: ");
      int num2 = kb.nextInt();
      int result = 0;
      
      switch (operator){
      
         case 1 : result = num1 + num2;
                  break;
         case 2 : result = num1 - num2;
                  break;
         case 3 : result = num1 * num2;
                  break;
         case 4 : result = num1 / num2;
                  break;
         case 5 : result = (int)Math.pow(num1, num2);
                  break;
         case 6 : result = num1 % num2;
                  break;
         default : result = -1;
      
      }
      
      System.out.println("The result of " + num1 + " " + character + " " + num2 + " is: " + result + "\n");
   
   }
}