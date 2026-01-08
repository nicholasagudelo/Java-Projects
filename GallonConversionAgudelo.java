/*
Name: Nicholas Agudelo
Date: February 24, 2023
Description: First a class constant gives a rate for the gallon conversion, then the first method gives a brief descrition of the program, and then the second method gives an example of how much liters are how much gallons.
*/
public class GallonConversionAgudelo  // <------ must change this name and then save it with the new name
{
   public static final double GALLON_RATE = 3.7;
 
   
   
   public static void main (String[] args)
   {
      description();
      conversion();
      
   }
   
   public static void description()//Just as it is named, this method displays the program description
   {
     System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n&  This program converts gallons to litters  &");
     System.out.println("&        1 Gallon is about 3.7 liters        &\n&                                            &\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
   } 
   
    
   
   public static void conversion()  //  This method converts liters to gallons with the class constant
   {
   
     for (int i=1; i<=100;i += 4){
         double n = i*GALLON_RATE;
         System.out.println(i + " " + n );
     }
     
   }
      
           
     
}   