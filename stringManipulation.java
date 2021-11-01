// Yukio Rivera
// CST 338 - Software Engineering
// Assignment 1 - String Manipulation

import java.util.Scanner;
import java.text.DecimalFormat;

class stringManipulation
{
   public static void main( String[] args )
   {
      // Part 1
      // Creating sc to take user input and requesting info
      // Q: Should I add a new line for user input?
      // Q: Should the output we put in the .txt file also include the questions that is asked to the user?
      Scanner scan = new Scanner (System.in);
      System.out.println ("Enter your first name and please capitalize "
      + "first letter ");
      String first = scan.next();
      System.out.println ("Enter your last name and please "
      + "capitalize first letter ");
      String last = scan.next();
      // Concatenating the two inputs into a variable
      // Also getting length of string
      String fullName = first + " " + last;
      int fullNameLen = fullName.replace( " ", "").length();
      // Printing the instructed output
      System.out.println ("Full Name is " + fullName + " and is " 
      + fullNameLen + " characters long");
      System.out.println ("Full name upper case, " 
      + fullName.toUpperCase());
      System.out.println ("Full name lower case, " 
      + fullName.toLowerCase());
      System.out.println ("");

      // Part 2 - does the program need to indicate the parts of the assignment?
      // Creating the two static functions and format for output
      int MIN_HOURS = 12;
      int MAX_HOURS = 20;
      String pattern = "##.#";
      // Printing range of study hours
      System.out.print ("Min hours to max study hours are: ");
      for (int i = MIN_HOURS; i <= MAX_HOURS; i++)
      {
         System.out.print (i + " ");
      }
      System.out.println("");
      System.out.println ("How many hours did you should spend on this"
      + " class this week? Enter a number to 3 decimal places please ");
      float studyTime = scan.nextFloat();
      DecimalFormat numberFormat = new DecimalFormat(pattern);
      System.out.print ("Study hours rounded to 1 decimal place: ");
      System.out.println(numberFormat.format(studyTime));
      // Q: Do we need to close?
      scan.close();
   }
}
