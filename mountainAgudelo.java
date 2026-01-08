/*
Name: Nicholas Agudelo
Date: April 15, 2023
Description: Random function chooses how much a player will climb or fall.
*/

import java.util.*;

public class mountainAgudelo
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner (System.in);
      menu(kb);
   }
   
   public static void menu(Scanner kb) //Description of program
   {
      System.out.println("**************************\n\n" + "How tall is your mountain?\n\n" + "**************************");
      
      int height = 0; //Validating height input
      
      do
      {
         while (!kb.hasNextInt())
         {
            kb.nextLine();
            System.out.println("Enter a valid value!");
         }
         height = kb.nextInt();
         height = java.lang.Math.abs(height - 0);
         
      }while (height <= 0);
      
      climb(kb, height);
   }
   public static void climb(Scanner kb, int height)
   {
      int count = 0;
      int steps = 0;
      int fate = coinFlip();
      
      while (steps <= height)
      {
         if (fate == 2)
         {
            do
            {
               int climb = climbRand();
               steps = steps + climb;
               fate = coinFlip();
               System.out.println("Your player climbed " + climb + " steps!");
               
            }while (fate == 2 && steps <= height);
         }
         
         else if (fate == 1)
         {
            do
            {
               int fall = fallRand();
               steps = steps - fall;
               fate = coinFlip();
               System.out.println("Your player fell " + fall + " steps!");
               
            }while (fate == 1 && steps <= height);
         }
         count = count + 1;
      }
      
   System.out.println("**************************************************************\n\n" + 
                      "It took the player " + count + " iterations to climb the mountain!\n\n" +
                      "**************************************************************");
   }
   
   public static int climbRand() //This method chooses how many steps the player climbs up.
   {
      Random rand = new Random();
      
      int climb = rand.nextInt(30 - 20 + 1) + 20; 
      
      return climb;
   }
   
   public static int fallRand() //This method chooses how many steps the player falls.
   {
      Random rand = new Random();
      
      int fall = rand.nextInt(5 - 1 + 1) + 1;
      
      return fall;
   }
   
   public static int coinFlip() //This method chooses fate. 
   {
      Random rand = new Random();
      
      int halfHalf = rand.nextInt(2 - 1 + 1) + 1;
      
      return halfHalf;
   }
}
