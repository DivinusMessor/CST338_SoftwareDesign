// Yukio Rivera
// CST 338 - Software Design 
// Assignment 2 - Casino

import java.util.*;
import java.util.Stack;

import javax.sound.midi.SysexMessage;

public class assign2
{
   public static void main(String[] args) 
   {
      getBet();
      System.out.println("whirrrrrr .... and your pull is ...");
      // System.out.println(pull()+" ---pull");
      // TESTING ---------------------------
      ThreeString result = new ThreeString();
      // System.out.println(result+"----test");
      // result.string1_change("bar");
      // result.string2_change("space");
      // result.string3_change("hats");
      // result.string3_change("828282322222222222222222222222222222222222222222222222222222222282828");
      // System.out.println(result.toString());
      // System.out.println(randString());
      getPayMultiplier (pull());
      // TESTING ---------------------------
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
      String [] pull_slots = thePull.toString().split("[,]", 0);
      //System.out.println( pull_slots instanceof String);
      //System.out.println(pull_slots+ " ----test");
      // for(String myStr: pull_slots) {
      //    System.out.println(myStr);
      // }
      System.out.println(thePull.toString());
      System.out.println(pull_slots[0]+" index0");
      System.out.println(pull_slots[1]+" index1");
      System.out.println(pull_slots[2]+" index2");
      // cherries  [not cherries]  [any] pays 5 × bet (5 times the bet)
      if (pull_slots[0].equals("cherries") & !pull_slots[1].equals("cherries"))
      {
         System.out.println("payout was 5x");
      }
      //  cherries  cherries  [not cherries] pays 15 × bet 
      else if (pull_slots[0].equals("cherries") & pull_slots[1].equals("cherries") && !pull_slots[1].equals("cherries"))
      {
         System.out.println("payout was 5x");
      }
      return 0;
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
      return string1 + ", " + string2 + ", " + string3;
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




