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
   
   public static ThreeString pull()
   {
      // "This method instantiates and returns a ThreeString object to the client."
      return ThreeString = new ThreeString("cherries",  "BAR" , "space");
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
      // 
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
   private static int [] pullWinnings = new int[MAX_LEN]; 
   private static int numPulls;

   // Default constructor??
   ThreeString()
   {

   }
   // Is this a mutator? Accessor? issues here 
   boolean validString( String str )
   {
      // Can I do return (( str != null & str.length() <= MAX_LEN ))
      if ( str != null & str.length() <= MAX_LEN )
      {
         return true;
      }
      else
      {
         return false;
      }  
   }

   // Returns 
   public String toString() 
   {
      return "method that will return all of the strings as one string";
   }

   // boolean saveWinnings(int winnings), and String toStringWinnings()
   // How can i save an int in winnings if its a boolean?
   // saveWinnings() will return a boolean according to whether there was space to save the incoming value of winnings.  If it returns false, then have the main stop playing the game.
   // toStringWinnings() should also be called from the main, where it will print the returned string. It should not print from inside of the method.
}

