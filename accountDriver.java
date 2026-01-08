import java.util.*;

public class accountDriver //If two proyects are saved in the same folder, then they can communicate with eachother.
{
   public static void main(String []args)
   {
      Scanner kb = new Scanner (System.in);
      
      bankAccount myAccount = new bankAccount("123", "G", "F", 200);
      System.out.println(myAccount);
      System.out.println("How much money do you want to deposit? ");
      double amount = kb.nextDouble();
      myAccount.deposit(amount);
      System.out.println(myAccount);
      System.out.println("How much money do you want to withdraw? ");
      amount = kb.nextDouble();
      myAccount.withdraw(amount);
      System.out.println(myAccount);
      
      System.out.println(myAccount.getNumber());
      
      //Create another bank account
      bankAccount yourAccount = new bankAccount("456", "Jose", "Rodriguez", 1200);
      myAccount.transfer(yourAccount, 200);
  
      if (myAccount.equals(yourAccount))
      {
         
      }
   }
}