/*
Name: Nicholas Agudelo
Date: May 5, 2023
*/

public class employee
{
   private String firstName;
   private String lastName;
   private double salary;
   private double commRate;
   private double sales; //per month
   
   public employee()
   {
   }
   
   public employee(String f, String l, double s, double c, double sa)
   {
      firstName = f;
      lastName = l;
      salary = s;
      commRate = c;
      sales = sa;
   }
   //Start of "get" methods.
   public String getFirst()
   {
      return firstName;
   }
   
   public String getLast()
   {
      return lastName;
   }
   
   public double getSalary()
   {
      return salary;
   }
   
   public double getComms()
   {
      return commRate;
   }
   
   public double getSales()
   {
      return sales;
   }
   //End of "get" methods.
   
   
   
   //Start of "set" methods.
   public void setFirst(String newF)
   {
      firstName = newF;
   }
   
   public void setLast(String newL)
   {
      lastName = newL;
   }
   
   public void setSalary(double newS)
   {
      salary = newS;
   }
   
   public void setComm(double newC)
   {
      commRate = newC;
   }
   
   public void setSales(double newSales)
   {
      sales = newSales;
   }
   //End of "set" methods.
   
   
   
   //Start of miscellaneous methods.
   public String toString()
   {
      String s = "";
      s = s + "****************************\n";
      s = s + "Name: " + firstName + " " + lastName + "\n";
      s = s + "Base salary: $" + salary + "\n";
      s = s + "Commission rate: " + commRate + "\n";
      s = s + "Total sales this month: " + sales + "\n";
      s = s + "Commission made: " + calculateComm() + "\n";
      s = s + "Total monthly pay: " + monthlyPay() + "\n";
      s = s + "****************************\n";
      
   return s;
   }
   
      public double calculateComm()
   {
      double totalComm = (sales * commRate)/100;
      return totalComm;
   }
   
   public double monthlyPay()
   {
      double totalComm = calculateComm();
      double totalPay = totalComm + salary;
      return totalPay;
   }
   
   public void sale(double amount)
   {
      double totalSales = sales + amount;
   }
   
   public void reduceSales(double amount)
   {
      double totalSales = sales - amount;
   }
   //End of miscellaneous methods.
}

class employeeDriver //Start of driver class.
{
   public static void main(String []args)
   {
      employee myEmployee = new employee();
      
      employee employee01 = new employee("Jane", "Doe", 2500, 2.7, 10500);
      employee employee02 = new employee("John", "Doe", 2700, 2.7, 10000);
      employee employee03 = new employee("Joe" , "Doe", 10000, 5.4, 2);
      
      System.out.println(employee01);
      System.out.println(employee02);
      System.out.println(employee03);
   }
}