import javax.xml.crypto.Data;
import java.sql.Array;
import java.util.Arrays;

public class Assig4 {

    public static void main(String[] args) {

        // BarcodeImage dirtyImg = new BarcodeImage(); // Standard Image that isn't bottom L centered
        // String[] temp = new String[] {"Hello", "World", "World"};
        // BarcodeImage toTest = new BarcodeImage(temp);
        // BarcodeImage empty = new BarcodeImage();
        // System.out.println("The Barcode Image: ");
        // toTest.displayToConsole();
        // DataMatrix Tester = new DataMatrix(toTest);
        // Tester.translateImageToText();
        // Tester.displayTextToConsole();
        // empty.displayToConsole();
        // System.out.println();
        // DataMatrix tempDM = new DataMatrix(toTest);
        // System.out.print("HEIGHT: " + tempDM.getActualHeight());
        // System.out.print(" WIDTH: " + tempDM.getActualWidth());
        // // System.out.println("New Copy: ");
        // // tempDM.displayImageToConsole();
        // tempDM.displayTextToConsole();
        // tempDM.generateImageFromText();
        // tempDM.displayImageToConsole();


        String[] sImageIn =
        {
            "                                               ",
            "                                               ",
            "                                               ",
            "     * * * * * * * * * * * * * * * * * * * * * ",
            "     *                                       * ",
            "     ****** **** ****** ******* ** *** *****   ",
            "     *     *    ****************************** ",
            "     * **    * *        **  *    * * *   *     ",
            "     *   *    *  *****    *   * *   *  **  *** ",
            "     *  **     * *** **   **  *    **  ***  *  ",
            "     ***  * **   **  *   ****    *  *  ** * ** ",
            "     *****  ***  *  * *   ** ** **  *   * *    ",
            "     ***************************************** ",
            "                                               ",
            "                                               ",
            "                                               "

      };

      String[] sImageIn_2 =
      {
            "                                          ",
            "                                          ",
            "* * * * * * * * * * * * * * * * * * *     ",
            "*                                    *    ",
            "**** *** **   ***** ****   *********      ",
            "* ************ ************ **********    ",
            "** *      *    *  * * *         * *       ",
            "***   *  *           * **    *      **    ",
            "* ** * *  *   * * * **  *   ***   ***     ",
            "* *           **    *****  *   **   **    ",
            "****  *  * *  * **  ** *   ** *  * *      ",
            "**************************************    ",
            "                                          ",
            "                                          ",
            "                                          ",
            "                                          "

      };



      BarcodeImage bc = new BarcodeImage(sImageIn);
      DataMatrix dm = new DataMatrix(bc);

      //first secret message
      
    //   System.out.println("SCAN: " + dm.scan(bc));
    //   System.out.print("OLD: ");
    //   dm.displayImageToConsole();
    //   dm.cleanImage();
    //   System.out.println("NEW: ");
    //   dm.displayImageToConsole();
        dm.translateImageToText();
        dm.displayTextToConsole();


    // String info = "01000011";
    // int potentialInt = Integer.parseInt(info, 2);
    // System.out.println((char)potentialInt);

    //   DataMatrix hello = new DataMatrix("CSUMB");
    //   hello.displayTextToConsole();
    //   hello.generateImageFromText();
    //   hello.displayImageToConsole();
    }
}

//This class will realize all the essential data and methods associated with a 2D pattern,
//thought of conceptually as an image of a square or rectangular bar code.
class BarcodeImage implements Cloneable {
    //data
    public static final int MAX_HEIGHT = 30; // HEIGHT is the number of ROWS
    public static final int MAX_WIDTH = 65; // WIDTH is the number of COLUMNS
    private boolean[][] imageData;

    // Default constructor
    public BarcodeImage() {
        // First create a 2D array of correct sizing
        // HOW TO THINK ABOUT IT: imageData[NUM of ROWS][NUM of COLS]
        this.imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
        // Then loop through each member and fill it w FALSE
        for (int X = 0; X < MAX_WIDTH; X++) {
            for (int Y = 0; Y < MAX_HEIGHT; Y++) {
                this.imageData[Y][X] = false;
            }
        }
    }

    //explicit constructor
    public BarcodeImage(String[] strData) {
        // TODO: Maybe figure out how to call default constructor so we can
        // replace this code
        this.imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
        // Then loop through each member and fill it w FALSE
        for (int X = 0; X < MAX_WIDTH; X++) {
            for (int Y = 0; Y < MAX_HEIGHT; Y++) {
                this.imageData[Y][X] = false;
            }
        }

        // Check if we're w/in the size limits of MAX_WIDTH. Assumes input strings will all be the same length.
        if (checkSize(strData)) {
            int yTracker = 29;
            int xTracker = 0;

            for (int oldY = strData.length - 1; oldY >= 0; oldY--) { // Iterates through the strData arr in reverse.
                for (int oldX = 0; oldX < strData[oldY].length() - 1; oldX++) { // Iterates through the individual strings of strArr
                    if (strData[oldY].charAt(oldX) == '*') {
                        this.imageData[yTracker][xTracker] = true;
                    } else {
                        this.imageData[yTracker][xTracker] = false;
                    }
                    xTracker++;
                }
                xTracker = 0;
                yTracker--;
            }
        }
    }

    /**
     * getPixel: Accessor for each bit in the image
     *
     * @param row
     * @param col
     * @return
     */
    public boolean getPixel(int row, int col) {
        //checks if values of row & col are valid
        if (row >= 0 && row < MAX_HEIGHT && col >= 0 && col < MAX_WIDTH) {
            return this.imageData[row][col];
        }
        return false;
    }

    /**
     * setPixel: mutator for each bit in the image
     *
     * @param row
     * @param col
     * @param value
     * @return
     */
    public boolean setPixel(int row, int col, boolean value) {
        //checks if row & col are valid
        if (row >= 0 && row < MAX_HEIGHT && col >= 0 && col < MAX_WIDTH) {
            return this.imageData[row][col] = value;
        }
        return false;
    }

    /**
     * checkSize: checks the incoming data for every conceivable
     * size or null error.
     * @param data
     * @return
     */
    private boolean checkSize(String[] data) {
        if (data == null) {
            return false;
        }
        for (String each : data) {
            // Ensures each incoming string will be at MAX 64 long.
            if (each.length() > MAX_WIDTH) {
                return false;
            }
        }
        return true;
    }

     //displays barcode image to console
    public void displayToConsole() {
        // Prints by going down each row one at a time
        for (int Y = 0; Y < MAX_HEIGHT; Y++) {
            for (int X = 0; X < MAX_WIDTH; X++) {
                if(this.imageData[Y][X] == true){
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    /**
     * clone: clones the barcode image
     *
     * @return
     */
    public Object clone() throws CloneNotSupportedException {
        // Blank image
        BarcodeImage toClone = new BarcodeImage();
        // Clones by using MAX values to loop
        for (int Y = 0; Y < MAX_HEIGHT; Y++) {
            for (int X = 0; X < MAX_WIDTH; X++) {
                toClone.setPixel(Y, X, this.getPixel(Y, X));
            }
        }
        return toClone;
    }
}
//The class that will contain both a BarcodeImage member object and a
//text String member that represents the message encoded in the embedded image.
class DataMatrix implements BarcodeIO {
    //data
    public static final char BLACK_CHAR = '*';
    public static final char WHITE_CHAR = ' ';

    private BarcodeImage image;
    private String text;
    private int actualWidth;
    private int actualHeight;

    // Default Constructor
    public DataMatrix() {
        this.image = new BarcodeImage();
        this.text = "undefined";
        this.actualHeight = 0;
        this.actualWidth = 0;
    }
    //Explicit Constructors
    public DataMatrix(BarcodeImage image) {
        //sets image
        this.image = new BarcodeImage();

        //calls scan() to avoid duplication of code
        scan(image);
    }

    public DataMatrix(String text) {
        //sets text
        this.text = text;
        //calls readText() to avoid duplication of code
        this.readText(text);

    }
    /**
     * readText: mutator for text
     *
     * @param text
     * @return
     */
    public boolean readText(String text) {
        this.text = text;
        return true;
    }

    /**
     *scan: mutator for image
     *
     * @param image
     * @return
     */
    public boolean scan(BarcodeImage image) {
        //calls clone() and requires the catch of a
        //CloneNotSupportedException by using try/catch block
        try {
            this.image = (BarcodeImage) image.clone();
            this.cleanImage();
            this.actualWidth = this.computeSignalWidth();
            this.actualHeight = this.computeSignalHeight();
            return true;
        } catch (CloneNotSupportedException e) {
            return false;
        }
    }

    /**
     * getActualWidth : accessor for actualWidth
     * @return
     */
    public int getActualWidth() {
        return this.actualWidth;
    }

    /**
     * getActualHeight: accessor for actualHeight
     * @return
     */
    public int getActualHeight() {
        return this.actualHeight;
    }

    /**
     * computeSignalWidth: uses the "spine" to determine size of width
     * @return
     */
    private int computeSignalWidth() {
        int widthTracker = 0;
        int rowTracker = 29;
        // Start on the Last Row & count the closed borderline
        for (int X = 0; X < BarcodeImage.MAX_WIDTH; X++) {
            if (this.image.getPixel(rowTracker, X)) {
                widthTracker++;
            }
        }
        return widthTracker - 2;
    }

    /**
     * computeSignalHeight: uses the "spine" to determine size of height
     * @return
     */
    private int computeSignalHeight() {
        int heightTracker = 0;
        for (int Y = 0; Y < BarcodeImage.MAX_HEIGHT; Y++) {
            if (this.image.getPixel(Y, 0)) {
                heightTracker++;
            }
        }
        return heightTracker - 2;
    }

    /**
     * generateImageFromText:
     *
     */
    public boolean generateImageFromText() {
        if (this.text.length() < BarcodeImage.MAX_WIDTH - 2) {
            BarcodeImage newImage = new BarcodeImage(); // Fresh image
            char[] textChars = this.text.toCharArray(); // Turn text to chars
            int widthTracker = 1;
            // Iterates through each Char in the String
            for (int i = 0; i < textChars.length; i++) {
                // Create a binary string representation of our char "01100110"
                String toPrint = Integer.toBinaryString((int) textChars[i]).toString();
                String leadingZero = String.format("%8s", toPrint).replace(' ', '0');
                // Use that binary string to create a COL of *s
                for (int Y = 0; Y < leadingZero.length(); Y++) {
                    if (leadingZero.charAt(Y) == '1') {
                        newImage.setPixel(Y + 21, widthTracker, true);
                    }
                }
                widthTracker++;
            }

            widthTracker++; // Makes the LEFT & RIGHT Borderlines
            for (int Y = 20; Y < BarcodeImage.MAX_HEIGHT; Y++) {
                newImage.setPixel(Y, 0, true); // Solid Line
                if (Y % 2 != 0) { // Alternating pattern      
                    newImage.setPixel(Y, widthTracker - 1, true);
                }
            }
            // Makes the TOP & BOTTOM Borderlines
            for (int X = 0; X < widthTracker; X++) {
                newImage.setPixel(29, X, true); // Solid Line
                if (X % 2 == 0) { // Alternating pattern
                    newImage.setPixel(BarcodeImage.MAX_HEIGHT-10, X, true);
                }
            }
            this.image = newImage;
            return true;
        } else {
            // TODO: This checks if the text is 63 chars long (63 is the max cause of the borders) and if its longer then it won't generate anything. Check if this is the proper behavior.
            return false;
        }
    }

    public boolean translateImageToText() {
        String newText = "";
        int currentRow;
        int currentCol;

        for (currentCol = 1; currentCol < computeSignalWidth()+1; currentCol++) {
            String testBool = "";
            for (currentRow = 29 - computeSignalHeight(); currentRow < 29; currentRow++) {
                if (this.image.getPixel(currentRow, currentCol) == true) {
                    testBool += "1";
                } else {
                    testBool += "0";
                }
            }

            int potentialInt = Integer.parseInt(testBool, 2);
            char actualChar = (char)potentialInt;
            newText += actualChar;
        }

        if (text == null) {
            this.text = newText;
            return true;
        } else {
            return false;
        }
    }

    public void displayTextToConsole() {
        System.out.println(text);
    }

    public void displayImageToConsole() {
        this.image.displayToConsole();
    }

    /**
    *   cleanImage(): 
    *
    *
    *
    */
    public void cleanImage() {

        BarcodeImage newImg = new BarcodeImage();
        BarcodeImage savedImg = this.image;
        newImg.setPixel(BarcodeImage.MAX_HEIGHT - 1, 0, true);

        for (int Y = BarcodeImage.MAX_HEIGHT - 1; Y > 0; Y--) {
            for (int X = 0; X < BarcodeImage.MAX_WIDTH - 1; X++) {
                if (image.getPixel(Y, X)) {
                    int targetY = 29;
                    int targetX = 0;

                    for (int newY = Y; newY >= 0; newY--) {
                        for (int newX = X; newX < BarcodeImage.MAX_WIDTH; newX++) {
                            newImg.setPixel(targetY, targetX, savedImg.getPixel(newY, newX));
                            targetX++;
                        }
                        targetX = 0;
                        targetY--;
                    }

                    Y = 0;
                    X = BarcodeImage.MAX_WIDTH;
                }
            }

        }

        this.image = newImg;
    }
    }

    interface BarcodeIO {
    /**
     *  scan: accepts some image, represented as a BarcodeImage object to be
     *  described below, and stores a copy of this image. Depending on the
     *  sophistication of the implementing class, the internally stored image
     *  might be an exact clone of the parameter, or a refined, cleaned
     *  and processed image. Technically, there is no requirement that an
     *  implementing class use a BarcodeImage object internally, although we
     *  will do so. For the basic DataMatrix option, it will be an exact clone.
     *  Also, no translation is done here - i.e., any text string that might be
     *  part of an implementing class is not touched, updated or defined during
     *  the scan.
     *
     * @param image
     * @return
     */
    public boolean scan(BarcodeImage image);

    /**
     *  readText: accepts a text string to be eventually encoded in
     *  an image. No translation is done here - i.e., any BarcodeImage that
     *  might be part of an implementing class is not touched, updated or
     *  defined during the reading of the text.
     *
     *  @param text
     *  @return
     */
    public boolean readText(String text);

    /**
     *  generateImageFromText: Not technically an I/O operation, this method
     *  looks at the internal text stored in the implementing class and
     *  produces a companion BarcodeImage, internally (or an image in whatever
     *  format the implementing class uses). After this is called, we expect
     *  the implementing object to contain a fully-defined image and text that
     *  are in agreement with each other.
     *
     *  @return
     */
    public boolean generateImageFromText();

    /**
     *  translateImageToText: Not technically an I/O operation, this method
     *  looks at the internal image stored in the implementing class, and
     *  produces a companion text string, internally. After this is called, we
     *  expect the implementing object to contain a fully defined image and
     *  text that are in agreement with each other. public
     *  displayTextToConsole() - prints out the text string to the console.
     *
     *  @return
     */

    public boolean translateImageToText();

    // Prints out the text string to the console
    public void displayTextToConsole();

    // Prints out the image to the console.
    public void displayImageToConsole();
}