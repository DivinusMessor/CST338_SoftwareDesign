// Yukio Rivera
// CST 338 - Software Design 
// Assignment 2 - Casino

class Casino
{

   public static int getBet()
   {
      System.out.println ("GetBet");
      return 0;
   }
   
   public ThreeString pull()
   {
      // "This method instantiates and returns a ThreeString object to the client."
      ThreeString rand_pull = new ThreeString();
      return rand_pull;

   }

   public static randString()
   {
      // It produces and returns a single random string based on the required probabilities.
      return "randomString";
   }

   public static void main ( String[] args ) 
   {
      System.out.println("assignment 2");
   }

   // This get the multiplier for the winnings 
   int getPayMultiplier (ThreeString thePull)
   {
      // After main() gets a ThreeString object from pull(), which we will call pullString, it needs to know what the payout will be.
      return 0;
   }

   void display (ThreeString thePull, int winnings ) 
   {
      // displays the output
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
   private static int [] pullWinnings = new int[MAX_PULLS]; // In the array fill with the number that was won from the pull
   private static int numPulls; // tracks the number of pulls that have been done

   // Default constructor??
   public ThreeString()
   {
      ThreeString rand_pull = new ThreeString();
      rand_pull.string1 = "";
      rand_pull.string2 = "";
      rand_pull.string3 = "";
      
   }

   // Is this a mutator? Accessor? issues here 
   boolean validString( String str )
   {
      return (( str != null && str.length() <= MAX_LEN ));
   }

   // Returns 
   public String toString() 
   {
      return string1 + "," + string2 + "," + string3;
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

