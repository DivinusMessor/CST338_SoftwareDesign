// Yukio Rivera
// CST 338 - Software Design
// Assignment 2 - Casino

import java.util.*;

public class Casino
{
   public static void main(String[] args)
   {
      int userBet = getBet();
      int totalWinningsEarned = 0;
      ThreeString result = new ThreeString();
      while (userBet != 0)
      {
      System.out.println("whirrrrrr .... and your pull is ...");
      result = pull();
      int payOut = getPayMultiplier(result) * userBet;
         if (result.saveWinnings(payOut))
         {
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

   static ThreeString pull()
   {
      ThreeString gamble = new ThreeString();
      gamble.string1_change(randString());
      gamble.string2_change(randString());
      gamble.string3_change(randString());
      return gamble;
   }

   private static String randString()
   {
      int ranNum = (int)(Math.random()*1000);
      String slot = "";
      // space 1/2  (50%)
      if (ranNum > 500)
      {
         slot = "space";
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

   static int getPayMultiplier (ThreeString thePull)
   {
      String [] pull_slots = thePull.toString().split("  ");
      if (pull_slots[0].equals("cherries") && 
      !"cherries".equals(pull_slots[1]))
      {
         return 5;
      }
      //  cherries  cherries  [not cherries] pays 15 × bet
      else if (pull_slots[0].equals("cherries") 
      && pull_slots[1].equals("cherries") 
      && !pull_slots[2].equals("cherries"))
      {
         return 15;
      }
      //  cherries  cherries  cherries pays 30 × bet
      else if (pull_slots[0].equals("cherries") 
      && pull_slots[1].equals("cherries") 
      && pull_slots[2].equals("cherries"))
      {
         return 30;
      }
      //  BAR  BAR  BARpays 50 × bet
      else if (pull_slots[0].equals("BAR") 
      && pull_slots[1].equals("BAR") 
      && pull_slots[2].equals("BAR"))
      {
         return 50;
      }
      //  7  7  7 pays 100 × bet
      else if (pull_slots[0].equals("7") 
      && pull_slots[1].equals("7") 
      && pull_slots[2].equals("7"))
      {
         return 100;
      }
   return 0;
   }

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

   ThreeString()
   {
      string1 = "";
      string2 = "";
      string3 = "";

   }

   private boolean validString( String str )
   {
      return (( str != null && str.length() <= MAX_LEN ));
   }

   boolean string1_change(String str)
   {
      if (validString( str ))
      {
         string1 = str;
         return true;
      }
      return false;
   }
   boolean string2_change(String str)
   {
      if (validString( str ))
      {
         string2 = str;
         return true;
      }
      return false;
   }
   boolean string3_change(String str)
   {
      if (validString( str ))
      {
         string3 = str;
         return true;
      }
      return false;
   }

   public String toString()
   {
      String combinedString = string1 + "  " + string2 + "  " + string3;
      return combinedString;
   }

   boolean saveWinnings(int winnings)
   {
      if (numPulls < 40)
      {
         pullWinnings[numPulls] = winnings;
         numPulls += 1;
         return true;
      }
      return false;
   }

   String toStringWinnings()
   {
      String pullWinningsString = "";
      int temp = 0;
      for (int n = 0; n<numPulls; n++)
      {
         temp = pullWinnings[n];
         pullWinningsString += String.valueOf(temp) + " ";
      }
      return pullWinningsString;

   }
}
