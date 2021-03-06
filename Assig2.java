// Yukio Rivera
// CST 338 - Software Design
// Assignment 2 - Casino

import java.util.*;

/* The program will loop, asking the user for a bet amount from 0 to 100
   (assume dollars, you can use ints or longs).  If the user types a 0 that
   means she wants to quit.  Otherwise, accept the amount as their bet and
   simulate a slot machine pull. */

public class Assig2
{
   public static void main( String[] args )
   {
      int userBet = getBet();
      int totalWinningsEarned = 0;
      ThreeString result = new ThreeString();

      while (userBet != 0)
      {
      result = pull();
      int payOut = getPayMultiplier(result) * userBet;
         if (result.saveWinnings(payOut))
         {
            System.out.println("whirrrrrr .... and your pull is ...");
            totalWinningsEarned += payOut;
            display (result, payOut);
            System.out.println();
            userBet = getBet();
         }
         else
         {
            userBet = 0;
         }
      }
      System.out.println("Thanks for playing at the Casino!");
      System.out.println("Your individual winnings were:");
      System.out.println(result.toStringWinnings() + "\nYour total winnings"
      + "were: $" + totalWinningsEarned);
   }

   // Method that gets the bet from the user and returns it to main()
   public static int getBet()
      {
         System.out.print("How much would you like to bet (1 - 100)"
         + " or 0 to quit? ");
         Scanner keyboard_input = new Scanner(System.in);
         int user_bet = keyboard_input.nextInt();
         boolean checkBet = false;
         while (checkBet == false)
         {
            if (user_bet == 0)
            {
               checkBet = true;
            }
            else if (user_bet >= 1 && user_bet <= 100)
            {
               checkBet = true;
            }
            else
            {
               System.out.print("How much would you like to bet (1 - 100)"
               + " or 0 to quit? ");
               user_bet = keyboard_input.nextInt();
            }
         }
         return user_bet;
      }

   /* Method will simulate a random pull of the slot machine --
      it generates three random strings and returns them as a ThreeString object*/
   public static ThreeString pull()
   {
      ThreeString gamble = new ThreeString();
      gamble.string1_change(randString());
      gamble.string2_change(randString());
      gamble.string3_change(randString());
      return gamble;
   }

   // Randomly chooses space, cheeies, BAR, or 7 for pull
   private static String randString()
   {
      int ranNum = (int)(Math.random()*1000);
      String slot = "";
      // space 1/2  (50%)
      if (ranNum > 500)
      {
         slot = "(space)";
      }
      // cherries 1/4  (25%)
      else if (ranNum > 250)
      {
         slot = "cherries";
      }
      else if (ranNum > 125)
      {
         // BAR 1/8  (12.5%)
         slot = "BAR";
      }
      else
      {
         // 7 1/8  (12.5%)
         slot = "7";
      }
      return slot;
   }

   // Returns the winning amount multiplier
   static int getPayMultiplier (ThreeString thePull )
   {
      String [] pull_slots = thePull.toString().split("  ");
      if (pull_slots[0].equals("cherries") &&
      !"cherries".equals(pull_slots[1]))
      {
         return 5;
      }
      //  cherries  cherries  [not cherries] pays 15 ?? bet
      else if (pull_slots[0].equals("cherries")
      && pull_slots[1].equals("cherries")
      && !pull_slots[2].equals("cherries"))
      {
         return 15;
      }
      //  cherries  cherries  cherries pays 30 ?? bet
      else if (pull_slots[0].equals("cherries")
      && pull_slots[1].equals("cherries")
      && pull_slots[2].equals("cherries"))
      {
         return 30;
      }
      //  BAR  BAR  BARpays 50 ?? bet
      else if (pull_slots[0].equals("BAR")
      && pull_slots[1].equals("BAR")
      && pull_slots[2].equals("BAR"))
      {
         return 50;
      }
      //  7  7  7 pays 100 ?? bet
      else if (pull_slots[0].equals("7")
      && pull_slots[1].equals("7")
      && pull_slots[2].equals("7"))
      {
         return 100;
      }
   return 0;
   }

   /* Method will be used at the end of each loop-pass when the user needs
      to see the results of her pull, and receive the news about how much
      she won (or not): */
   public static void display (ThreeString thePull, int winnings )
   {
      System.out.println(" " + thePull.toString());
      if (winnings > 0)
      {
         System.out.println("congratulations, you win: " + winnings);
      }
      else
      {
         System.out.println("sorry, you lose.");
      }
   }
}

class ThreeString
{
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   private String string1;
   private String string2;
   private String string3;
   private static int [] pullWinnings = new int[MAX_PULLS];
   private static int numPulls;

   // Default Constructor
   ThreeString()
   {
      string1 = "";
      string2 = "";
      string3 = "";

   }

   // A Private Helper Method
   private boolean validString (String str )
   {
      return (( str != null && str.length() <= MAX_LEN ));
   }

   // Mutators and Accessors
   public boolean string1_change (String str )
   {
      if (validString( str ))
      {
         string1 = str;
         return true;
      }
      return false;
   }

   public boolean string2_change (String str )
   {
      if (validString( str ))
      {
         string2 = str;
         return true;
      }
      return false;
   }

   public boolean string3_change (String str )
   {
      if (validString( str ))
      {
         string3 = str;
         return true;
      }
      return false;
   }

   // Returns the pull as a string
   public String toString()
   {
      String combinedString = string1 + "  " + string2 + "  " + string3;
      return combinedString;
   }

   // Updated the array and keeps track of what pull number the user is on
   boolean saveWinnings (int winnings )
   {
      if (numPulls < 40)
      {
         pullWinnings[numPulls] = winnings;
         numPulls += 1;
         return true;
      }
      return false;
   }

   // Returns the array as a string
   String toStringWinnings()
   {
      String pullWinningsString = "";
      int temp = 0;
      for (int n = 0; n<numPulls; n++)
      {
         temp = pullWinnings[n];
         pullWinningsString += Integer.toString(temp) + " ";
      }
      return pullWinningsString;

   }
}