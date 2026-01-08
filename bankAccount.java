public class bankAccount //Week 14
{
   //Instance variables
   private String accNumber;
   private String firstName;
   private String lastName;
   private double balance;
   
   //Constructor
   public bankAccount(String accNumber, String firstName, String lastName, double balance)
   {
      this.accNumber = accNumber;
      this.firstName = firstName;
      this.lastName =  lastName;
      this.balance = balance;
   }
   
   public void close()
   {
      System.out.println("We owe you: " + balance);
      balance = 0;
   }
   
   public void transfer(bankAccount other, double amount)
   {
      if (amount > 0 && this.balance > amount)
      {
         this.balance = this.balance - amount;
         other.balance = other.balance + amount;
      }
   }
   
   public boolean equals(bankAccount other)
   {
      return this.accNumber.equals(other.accNumber);
   }
   
   //Placeholder
   public bankAccount()
   {
      accNumber = "Unknown";
      firstName = "Unknown";
      lastName = "Unknown";
      balance = 0;
   }
   
   //Setter methods
   public void setNumber(String newNumber)
   {
      accNumber = newNumber;
   }
   
   public void setFirst(String newFirst)
   {
      firstName = newFirst;
   }

   public void setLast(String newLast)
   {
      lastName = newLast;
   }

   public void setBalance(double newBalance)
   {
      balance = newBalance;
   }

   
   //Getter method
   public String getNumber()
   {
      return accNumber;
   }
   
   public String getFirst()
   {
      return firstName;
   }
   
   public String getLast()
   {
      return lastName;
   }

   public double getBalance()
   {
      return balance;
   }

   
   //toString Method
   public String toString()
   {
      String s = "";
      s = s + firstName + " " + lastName + "\n";
      s = s + "Account number: " + accNumber + "\n";
      s = s + "Balance: " + balance;
      
   return s;
   }
   
   public void deposit(double amount)
   {
      if(amount > 0)
      {
         balance = balance + amount;
      }
   }
   
   public void withdraw (double amount)
   {
      if (amount > 0 && balance > amount)
      {
         balance = balance - amount;
         System.out.println("Make sure to take your hard earned dollar");
      }
      else
      {
         System.out.println("Not enough funds, you broke fuck. Come back when you're balling");
      }
   }
}

