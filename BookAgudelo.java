/*
Name:Nicholas Agudelo
Date: March 10, 2023
*/


import java.util.Scanner;
import static java.lang.Math.pow;

public class BookAgudelo{

   public static void main(String []args){
   
      Scanner kb = new Scanner(System.in);
      System.out.print("How many stories are you making: ");
      int count = kb.nextInt();
      kb.nextLine();
      
         for(int i = 1; i <= count ; i++){
            System.out.println("Answer a few questions and I will make up a story for you\n");
            //call the method that you created below, make sure to pass the Scanner object to it
            puppeter();
         }

   
   }
   
   public static void puppeter(){
   
      Scanner kb = new Scanner (System.in);
   
      System.out.println("What is your full legal name? ");
      String fullName = kb.nextLine();
      System.out.println("Where do you live? ");
      String address = kb.nextLine();
      System.out.println("What's your zipcode? ");
      int zipcode = kb.nextInt();
      System.out.println("At what time do you leave the house? \nMake sure to be exact by writing the hour like this \"6.30\"");
      double time = kb.nextDouble();
      System.out.println("Do you live with someone else? \nAnswer with true or false");
      boolean roommates = kb.nextBoolean();
      
      if (roommates == true){ //first ending
         System.out.println("How many roommates do you have? ");
         int roommateAmount = kb.nextInt();
         Story(fullName, address, zipcode, time, roommates, roommateAmount);
      } else {
      
         System.out.println("What is your profession? ");
         String job = kb.next();
         System.out.println("Where do you work? ");
         String jobPlace = kb.next();
         System.out.println("How many colleagues do you have? ");
         int jobFriends = kb.nextInt();
         System.out.println("Do any of your colleagues have a reason to hate you? ");
         boolean jobHate = kb.nextBoolean();
      
         if (jobHate == true){//Second ending
      
            Story2(fullName, address, zipcode, time, job, jobPlace, jobFriends);
     
         }
         
         if (jobHate == false){//Third ending
         System.out.println("Wow... " + fullName + ", you're boring.");
         }
      }
   }
   
   public static void Story(String fullName, String address, int zipcode, double time, boolean roommates, int roommateAmount){
   
      System.out.println("The once was a... person whose name was " + fullName + " and lived in " + address + " " + zipcode + ".");
      System.out.println("They seemed to live a very happy life... until they were robbed! Despite having " + roommateAmount + " burly, tall roommate(s)");
      System.out.println("News outlets said that the intruder had a " + roommateAmount + " chamber pistol. With he shot the roommate(s) dead.");
   
   }
   
   public static void Story2(String fullName, String address, int zipcode, double time, String job, String jobPlace, int jobFriends){
   
      System.out.println("The once was a... person whose name was " + fullName + " and lived in " + address + " " + zipcode + ".");
      System.out.println("Until one day they were murdered! Someone who also worked in " + jobPlace + " in the " + job + " department");
      System.out.println("had them killed! All " + jobFriends + " workers are being interrogated at the moment about the murder.");
      System.out.println("The police believe the assasination happened at " + time + "o'clock in the morning.");
      System.out.println("Poor " + fullName + "... their children were expecting them to arrive with " + (time*time) + " dollars worth of groceries.");  
   
   } 

}