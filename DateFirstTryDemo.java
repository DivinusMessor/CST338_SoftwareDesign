public class DateFirstTryDemo
{
   public static void main ( String[] args )
   {
      DateFirstTry date1, date2;
      date1 = new DateFirstTry();
      date2 = new DateFirstTry();
      date1.month = "Decemeber";
      date1.day = 31;
      date1.year = 2012;
      System.out.println("date1: ");
      date1.writeOutPut();

      date2.month = "July";
      date2.day = 31;
      date2.year = 2012;
      System.out.println("date2: ");
      date2.writeOutPut();
   }
}