import java.util.*;
public class Math 
{
}
class MathQ   
{
   
   public static void main(String[] args)
   {
      prep();
   }

   public static void prep()
   {
      String[] quiz = new String[5];
      int[] answers = new int[5];
      int[] points = new int[5];
      Random rand = new Random();
      Scanner kb = new Scanner(System.in);
     
      boolean repeat = true;
      while(repeat)
      {
         int max = rand.nextInt(10)+11;
         int min = rand.nextInt(5)+5;
         populate(quiz, answers, points, max, min);
         int score = test(quiz, answers, points);
       
         System.out.println("Your score is " + score);
       
         System.out.println("Do you want to play again? ");
         String ans = kb.next();
         if (ans.equalsIgnoreCase("no"))
         {
            repeat = false;
         }

      }
     
 
 
   }

   public static void populate(String[] quiz, int[] answers,  int[] points, int max, int min)
   {
      char[] operation =  {'*', '/', '+','-'};  //all possible operations
      Random r = new Random();
      for(int i =  0; i < quiz.length; i++)
      {
         int num1 = r.nextInt(min, max + 1);

         int num2 = r.nextInt(min, max + 1);

         int index = r.nextInt(3)+1;
       
         char op = operation[index];
         
         String expression = (num1 + " " + op + " " + num2 + " ");//makes operation
         quiz[i] = expression;
         answers[i] = calculate(num1, op, num2);
         points[i]= r.nextInt(9)+1;
         
     
      }    
       
   }
   public static int calculate(int num1, char op, int num2)
   {
      switch(op)
      {
         case '*' : //checks for type of operation
            return num1 * num2;
         case '/' :
            return num1/num2;
         case '+' :
            return num1 + num2;
         case '-' :
            return num1 - num2;
         default :
            return -1;
      }
   }

   
   public static int test(String[] questions,  int[] answers, int[] values)
   {
      int score = 0;
      Scanner kb = new Scanner(System.in);
      for(int  i = 0; i < answers.length; i++)
      {
         System.out.print(questions[i]);
         int uanswer = kb.nextInt();
         if(uanswer == answers[i])
         {
              score = score + values[i];
              System.out.println("You earned " + score + " points");//constant point counter
         }
         else
            System.out.println("Incorrect answer");
                 
      }
     
      return score;
                       
 
   }
} 