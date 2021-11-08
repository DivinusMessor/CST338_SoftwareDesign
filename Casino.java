// Yukio Rivera
// CST 338 - Software Design 
// Assignment 2 - Casino

// Q: How do we store getBet() into a variable to get the result and multiply it with WinningMultiplier()
// Q: that variable is how we add it to the array and use numPull to index what position the array is in


import java.util.*;


public class Casino
{
   public static void main(String[] args) 
   {
      while (getBet() != 0)
      {
      // System.out.println(pull()+" ---pull");
      // TESTING ---------------------------
      // System.out.println(result+"----test");
      // result.string1_change("bar");
      // result.string2_change("space");
      // result.string3_change("hats");
      // result.string3_change("828282322222222222222222222222222222222222222222222222222222222282828");
      // System.out.println(result.toString());
      // System.out.println(randString());
      // ThreeString result = new ThreeString();
      // TESTING ---------------------------
      System.out.println("whirrrrrr .... and your pull is ...");
      ThreeString result = pull();
      int payOut = getPayMultiplier(result);
      display (result, payOut);

      // getPayMultiplier (pull());
      }
      
   }

   public static int getBet()
      {
         System.out.print("How much would you like to bet (1 - 100) or 0 to quit? "); // Initial prompt for input
         Scanner keyboard_input = new Scanner(System.in);
         int user_bet = keyboard_input.nextInt();
         boolean checkBet = false;
         while (checkBet == false)
         {
            if (user_bet == 0)
            {
               System.out.println("UserQuit");
               checkBet = true;
            }
            else if (user_bet >= 1 && user_bet <= 100)
            {
               checkBet = true;
            }
            else
            {
               System.out.print("How much would you like to bet (1 - 100) or 0 to quit? ");
               user_bet = keyboard_input.nextInt();
            }
         }
         return user_bet;
      }

   static ThreeString pull()
   {
      // placeholder
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
      // System.out.println(ranNum+" rannum");
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
         slot = "7";
      }
      return slot;
   }

   static int getPayMultiplier (ThreeString thePull)
   {
      // System.out.println(thePull.toString());
      // slot_pull = thePull.toString();
      // thePull.string1_change("7");
      // thePull.string2_change("7");
      // thePull.string3_change("7");
      String [] pull_slots = thePull.toString().split("  ");
      // System.out.println( Arrays.toString(pull_slots) + "---pulltestlength");
      // System.out.println( pull_slots[0] + "---1test");
      // System.out.println( pull_slots[1] + "---2test");
      // System.out.println( pull_slots[2] + "---3test");
      //System.out.println(("cherries".equals(pull_slots[1])) + "-----equaltest");
      // System.out.println(thePull.toString());
      
      //  cherries  [not cherries]  [any] pays 5 × bet (5 times the bet)
      if (pull_slots[0].equals("cherries") && !"cherries".equals(pull_slots[1]))
      {
         return 5;
      }
      //  cherries  cherries  [not cherries] pays 15 × bet 
      else if (pull_slots[0].equals("cherries") && pull_slots[1].equals("cherries") && !pull_slots[2].equals("cherries"))
      {
         return 15;
      }
      //  cherries  cherries  cherries pays 30 × bet 
      else if (pull_slots[0].equals("cherries") && pull_slots[1].equals("cherries") && pull_slots[2].equals("cherries"))
      {
         return 30;
      }
      //  BAR  BAR  BARpays 50 × bet 
      else if (pull_slots[0].equals("BAR") && pull_slots[1].equals("BAR") && pull_slots[2].equals("BAR"))
      {
         return 50;
      }
      //  7  7  7 pays 100 × bet 
      else if (pull_slots[0].equals("7") && pull_slots[1].equals("7") && pull_slots[2].equals("7"))
      {
         return 100;
      }
   return 0;
   }

   static void display (ThreeString thePull, int winnings )
   {
      System.out.println(thePull.toString());
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
   // final means that the value cannot be changed 
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   private String string1;
   private String string2;
   private String string3;
   private static int [] pullWinnings = new int[MAX_LEN]; 
   private static int numPulls;

   ThreeString()
   {
      string1 = "";
      string2 = "";
      string3 = "";
      
   }

   // Is this a mutator? Accessor? issues here 
   private boolean validString( String str )
   {
      return (( str != null && str.length() <= MAX_LEN ));
   }

   // setters
   // Q: Is there a way to make an argument a default but give opinion to change
   // Can you use getters? should they be seperated?
   // setter/getter example:
   // private void change_string1(String str){
   //    string1 = str;
   // }
   // private String return_string1(){
   //    return string1;
   // }
   String string1_change(String str)
   {
      if (validString( str ))
      {
         string1 = str;
      }
      return string1;
   }
   String string2_change(String str)
   {
      if (validString( str ))
      {
         string2 = str;
      }
      return string2;
   }
   String string3_change(String str)
   {
      if (validString( str ))
      {
         string3 = str;
      }
      return string3;
   }

   // Returns 
   public String toString() 
   {
      String combinedString = string1 + "  " + string2 + "  " + string3;
      return combinedString;
   }

   // boolean saveWinnings(int winnings), and String toStringWinnings()
   // How can i save an int in winnings if its a boolean?
   // saveWinnings() will return a boolean according to whether there was space to save the incoming value of winnings.  If it returns false, then have the main stop playing the game.
   // toStringWinnings() should also be called from the main, where it will print the returned string. It should not print from inside of the method.
   boolean saveWinnings(int winnings)
   {
      return (winnings < (MAX_PULLS - 1));
   }

   String toStringWinnings()
   {
      int pullWin = 0;
      String pullWinningsString;

      for (int i = 0; i<numPulls; i++)
      {
         pullWinnings[i] = pullWin;
      }
      pullWinningsString = Integer.toString(pullWin);
      return pullWinningsString;
   }
}




