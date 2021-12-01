/*
 * CST 338 - Software Design - Assig 5
 * Warren Ngoun
 * Yukio Rivera
 * Jennah Yasin
 * Luis Jimenez
 * Decks of Cards: This program is made up of 3 classes, (Card, Hand, and
 * Deck) which is ultimately used to create
 * a card game that can be played with a human.
 */
 
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  // This is the file EndingListener

public class Assig5_Phase {

    // static for the 57 icons and their corresponding labels
    // normally we would not have a separate label for each card, but
    // if we want to display all at once using labels, we need to.
   
    static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
    static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
      
    static void loadCardIcons() {
        // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
        File folder = new File("./Cards");
        File[] listFiles = folder.listFiles();

        // in a SHORT loop.  For each file name, read it in and use it to
        // instantiate each of the 57 Icons in the icon[] array.
        for (int i = 0; i < listFiles.length; i++) {
            icon[i] = new ImageIcon(listFiles[i].getPath());
        }
    }

    static Card randomCardGenerator() {
        // Begin w two arrays for value generation
        char[] cardVals = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9' , 'T', 'J', 'K', 'Q', 'X'};
        Card.Suit[] suitVals = Card.Suit.values();
        // Then generate random values from the arrays
        Random randGen = new Random();
        char returnVal = cardVals[randGen.nextInt(cardVals.length)];
        Card.Suit returnSuit = suitVals[randGen.nextInt(suitVals.length)];
        // Return the new card
        return new Card(returnVal, returnSuit);
    }

    /**
     * updateHandDisplay: 
     */
    static void updateComputerDisplay(Hand computerHand, JPanel clearPanel) {
        clearPanel.removeAll();
        for (int i = 0; i < computerHand.getNumCards(); i++) {
            // JLabel temp = new JLabel(GUICard.getIcon(hand.inspectCard(i)));
            clearPanel.add(new JLabel(GUICard.getBackCardIcon()));
        }
    }

    //static void updatePlayerDisplay(Hand playerHand, JPanel playerPanel, CardGameOutline SuitMatchGame) {
        //playerPanel.removeAll(); // Wipes the players panel clean
        // Then iterates through the remaining hand to generate new buttons
        //for (int i = 0; i < playerHand.getNumCards(); i++) {
            // Creates a temp button w the card icon from players hand
           // JButton tempButton = new JButton(GUICard.getIcon(playerHand.inspectCard(i)));

           // tempButton.setActionCommand("" + i); // Sets up the "Index" of the card as a command

           // tempButton.addActionListener(new ActionListener() {
           // }

          //  tempButton.add(playerPanel); // Adds the button to the panel
            /*

            for (int k = 0; k < NUM_CARDS_PER_HAND; k++){
            JButton tempButton = new JButton(GUICard.getIcon(SuitMatchGame.getHand(1).inspectCard(k)));
            tempButton.setActionCommand("" + k);
            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    SuitMatchGame.playCard(1, Integer.parseInt(e.getActionCommand()));
                    System.out.println(SuitMatchGame.getHand(1).toString());
                }
            });

            

            myCardTable.pnlHumanHand.add(tempButton);
            // myCardTable.pnlHumanHand.add(humanLabels[k]); // Creates Labels not buttons

            }

            */
        //}

        // static void playerCardClicked() {
        //     updatePlayerDisplay(playerHand, playerPanel);
        // }
    //}

    // class playCards implements Hand{
    //     Hand.show
    // }
   
    static int NUM_CARDS_PER_HAND = 7;
    static int NUM_PLAYERS = 2;
    static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
    static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
    static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS];
    // New Array to Handle Buttons instead of Labels
    static JButton[] humanCards = new JButton[NUM_CARDS_PER_HAND];
    static int winnings[];
    
    public static void main(String[] args) {
        int numPacksPerDeck = 1;
        int numJokersPerPack = 2;
        int numUnusedCardsPerPack = 0;
        Card[] unusedCardsPerPack = null;

        CardGameOutline SuitMatchGame = new CardGameOutline( 
                numPacksPerDeck, numJokersPerPack,  
                numUnusedCardsPerPack, unusedCardsPerPack, 
                NUM_PLAYERS, NUM_CARDS_PER_HAND);
        SuitMatchGame.deal();

        // Establish main frame in which program will run
        CardTable myCardTable 
             = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
        myCardTable.setSize(900, 700); // 800 600 was original
        myCardTable.setLocationRelativeTo(null);
        myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUICard.loadCardIcons(); // Generate all the card icons

        // CREATE LABELS --------------
        for (int k = 0; k < NUM_CARDS_PER_HAND; k++) {
            //computerLabels[k] = new JLabel(GUICard.getBackCardIcon()); // USE THIS
            computerLabels[k] = new JLabel(GUICard.getIcon(SuitMatchGame.getHand(0).inspectCard(k)));
        }

        for (int k = 0; k < NUM_CARDS_PER_HAND; k++) {
            humanLabels[k] = new JLabel(GUICard.getIcon(
                SuitMatchGame.getHand(1).inspectCard(k)));
        }
        
        // ADD LABELS TO PANELS
        for (int k = 0; k < NUM_CARDS_PER_HAND; k++) {
            myCardTable.pnlComputerHand.add(computerLabels[k]);
        }

        for (int k = 0; k < NUM_CARDS_PER_HAND; k++) {
            JButton tempButton = new JButton(GUICard.getIcon(SuitMatchGame.getHand(1).inspectCard(k)));
            tempButton.setActionCommand("" + k);
            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    //SuitMatchGame.playCard(1, Integer.parseInt(e.getActionCommand()));
                    System.out.println(SuitMatchGame.getHand(1).toString());
                    Card humansCard = SuitMatchGame.playCard(1, Integer.parseInt(e.getActionCommand()));
                    playedCardLabels[1] = new JLabel(GUICard.getIcon(humansCard));
                    myCardTable.pnlPlayArea.add(playedCardLabels[1]);
                    System.out.println(Integer.parseInt(e.getActionCommand()));
                    myCardTable.pnlHumanHand.remove(Integer.parseInt(e.getActionCommand()));
                    myCardTable.setVisible(true);
                }
                
            });

            myCardTable.pnlHumanHand.add(tempButton);
            // myCardTable.pnlHumanHand.add(humanLabels[k]); // Creates Labels not buttons

        }
        
        // Show everything to the user
        myCardTable.setVisible(true);
        
        // Creates playArea labels
         playLabelText[0] = new JLabel("Computer", JLabel.CENTER);
         playLabelText[1] = new JLabel("You", JLabel.CENTER);

        // Adds playArea labels to panel
        // myCardTable.pnlPlayArea.add(playLabelText[0]);
        // myCardTable.pnlPlayArea.add(playLabelText[1]);

        // MAIN GAME CODE
        boolean gameOver = false;

        // Start with Computer playing a RANDOM card from its hand.
        Card robotsCard = SuitMatchGame.playCard(0, 1);
        playedCardLabels[0] = new JLabel(GUICard.getIcon(robotsCard)); // Create Icon for card
        myCardTable.pnlPlayArea.add(playedCardLabels[0]); // Add Card to Middle
        updateComputerDisplay(SuitMatchGame.getHand(0), myCardTable.pnlComputerHand); // Update the PCs Cards

        // while (gameOver == false) {
        //     System.out.print(SuitMatchGame.getHand(1).getNumCards());
        //     if (SuitMatchGame.getHand(1).getNumCards() == 0) {
        //         gameOver = true;
        //     }
        //     else if(SuitMatchGame.getHand(1).getNumCards() == 6){
        //         //System.out.println("there are 7");
        //     }
        // }
        System.out.println("YOU won?");
    }
}

class CustomActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}

class CardTable extends JFrame {
    static int MAX_CARDS_PER_HAND = 56;
    static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
   
    private int numCardsPerHand;
    //changed from private int numPlayers to public static int numPlayers
    public static int numPlayers;

    public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

    /*
    * CardTable: The constructor filters input, adds any panels to the 
    * JFrame, and establishes layouts according to the general description below.
    */
    CardTable(String title, int numCardsPerHand, int numPlayers) {
        this.setTitle(title);
      
        // set up layout which will control placement of buttons, etc.
        // FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);  
        BorderLayout layout = new BorderLayout(); 
        setLayout(layout);

        if (numPlayers <= MAX_PLAYERS || numCardsPerHand <= MAX_CARDS_PER_HAND) {
            //computer hand label & border
            pnlComputerHand = new JPanel();
            Border pcOld = new LineBorder(Color.BLACK, 1, true);
            Border pcNew = BorderFactory.createTitledBorder(pcOld, "Computer Hand");
            pnlComputerHand.setBorder(pcNew);

            //play area label & border
            pnlPlayArea = new JPanel();
            pnlPlayArea.setLayout(new GridLayout(2, 2));
            // Create a thin border in play area to divide the 3 sections visually
             Border oldBorder = new LineBorder(Color.BLACK, 1, true);
             Border border = BorderFactory.createTitledBorder(oldBorder, "Playing Area");
             pnlPlayArea.setBorder(border);

            //human hand label & border
            pnlHumanHand = new JPanel();
            Border humanOld = new LineBorder(Color.BLACK, 1, true);
            Border humanNew = BorderFactory.createTitledBorder(pcOld, "Your Hand");
            pnlHumanHand.setBorder(humanNew);
            
            //sepearates the three panels into the window 3x1
            JPanel threePanels = new JPanel();
            threePanels.setLayout(new GridLayout(3,1));
            
            threePanels.add(pnlComputerHand);
            threePanels.add(pnlPlayArea);
            threePanels.add(pnlHumanHand);

            this.add(threePanels);
        }
    }

    // Accessors
    public int getNumCardsPerHand() {
        return this.numCardsPerHand;
    }

    public int getNumPlayers() {
        return this.numPlayers;
    }
}

class GUICard {
    private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
    private static Icon iconBack;
    static boolean iconsLoaded = false;

    static void loadCardIcons() {
        if (!iconsLoaded) {
            int cardTracker = 0;
            // For each value, append the suits onto them & create an icon
            char[] s_list = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9' , 'T', 'J', 'Q', 'K', 'X'};
            for (char cardVal : s_list) {
                iconCards[cardTracker][0] = new ImageIcon("./Cards/" + cardVal + "C.gif"); // Clubs
                iconCards[cardTracker][1] = new ImageIcon("./Cards/" + cardVal + "D.gif"); // Diamonds
                iconCards[cardTracker][2] = new ImageIcon("./Cards/" + cardVal + "H.gif"); // Hearts
                iconCards[cardTracker][3] = new ImageIcon("./Cards/" + cardVal + "S.gif"); // Spades
                cardTracker++;
            }
            // After looping, set the card back by itself
            iconBack = new ImageIcon("./Cards/BK.gif");
            iconsLoaded = true; // So we can't loop again
        }
    }

    static public Icon getIcon(Card card) {
        return iconCards[card.getValueAsInt()][card.getSuitAsInt()];
    }

    static public Icon getBackCardIcon() {
        return iconBack;
    }
    
}

/*
 * Card: A public class that creates a card with a value and suit and checks its
 * validity in errorFlag.
 */
class Card {
    public static char[] valuRanks = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9' , 'T', 'J', 'K', 'Q', 'X'};

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    // Private member data
    private char value;
    private Suit suit;
    private boolean errorFlag;

    // Explicit Constructor
    Card(char value, Suit suit) {
        set(value, suit);
    }

    // Default Constructor
    Card () {
        // Sets default card to A of SPADES
        this.value = 'A';
        this.suit = Suit.SPADES;
        this.errorFlag = false;
    }

    // Copy Constructor
    Card (Card origCard) {
        if (origCard != null) {
            this.value = origCard.getValue();
            this.suit = origCard.getSuit();
            this.errorFlag = origCard.getErrorFlag();
        } else {
            this.value = 'A';
            this.suit = Suit.SPADES;
            this.errorFlag = true;
        }
    }

    // // Copy Constructor
    // Card (Card origCard) {
    //     // Duplicates the original card constructor
    //     this.value = origCard.getValue();
    //     this.suit = origCard.getSuit();
    //     this.errorFlag = origCard.getErrorFlag();
    // }

    // toString: Returns the string representation of the card.
    public String toString() {
        // returns the value and suit of card or a string if errorFlag true
        if (errorFlag) {
            return "[invalid]";
        } else {
            return value + " of " + suit;
        }
    }

    /**
     * set: Mutator that accepts legal values. When bad values are passed, errorFlag
     * is set to true and other values are left alone. If good values are passed,
     * they're stored & errorFlag is set to false. Uses isValid to test.
     *
     * @param: takes the potential value and suit of the card
     * @return: true or false depending if the card was valid
     */
    public boolean set(char value, Suit suit) {

        if (isValid(value, suit)) {
            this.value = value;
            this.suit = suit;
            errorFlag = false;
            return true;
        }
        errorFlag = true;
        return false;
    }

    // Returns the suit
    public Suit getSuit() {
        return this.suit;
    }

    // Returns the value
    public char getValue() {
        return this.value;
    }

    // Returns errorFlag
    public boolean getErrorFlag() {
        return this.errorFlag;
    }

    /**
     * equals: Compares all the fields (members) and if they're identical.
     *
     * @param: The card that you want to check against.
     * @return: True or false depending if the two cards have the same data.
     */
    public boolean equals(Card card) {
        if (value == card.getValue() && errorFlag == card.getErrorFlag() && suit == card.getSuit()) {
            return true;
        }
        return false;
    }

    /**
     * isValid: Verifies that the suit and value of the card is correct. Legal
     * values are ('A', '2', ... '9', 'T', 'J', 'Q',' K').
     *
     * @param: Takes in a character for it's value and a Suit data type as suit
     * @return: A boolean; true if it's valid and false otherwise
     */
    private boolean isValid(char value, Suit suit) {
        if (suit == Suit.SPADES || suit == Suit.HEARTS || suit == Suit.DIAMONDS || suit == Suit.CLUBS) {
            if (value == 'A' || value == 'T' || value == 'J' || value == 'Q' || value == 'K' || value == '2'
                    || value == '3' || value == '4' || value == '5' || value == '6' || value == '7' || value == '8'
                    || value == '9' || value == 'X') {
                return true;
            }
        }
        return false;
    }

    public int getValueAsInt() {
        switch (this.getValue()) {
            case 'A':
                return 0;
            case '2':
                return 1;
            case '3':
               return 2;
            case '4':
               return 3;
            case '5':
               return 4;
            case '6':
               return 5;
            case '7':
               return 6;
            case '8':
               return 7;
            case '9':
               return 8;
            case 'T':
               return 9;
            case 'J':
               return 10;
            case 'Q':
               return 11;
            case 'K':
               return 12;
            case 'X':
               return 13;
            default:
                return 0;
        }
    }

    public int getSuitAsInt() {
        switch (this.getSuit()) {
            case CLUBS:
                return 0;
            case DIAMONDS:
                return 1;
            case HEARTS:
                return 2;
            case SPADES:
                return 3;
            default:
                return 0;
        }
    }

    static void arraySort(Card[] unsortedCards, int arraySize) {
        Card tempCard = new Card();
        // Uses a nested for loop instead of recursion to run bubble sort
        for (int outer = 0; outer < arraySize; outer++) {
            for (int inner = 1; inner < (arraySize - outer); inner++) {
                // Set a temporary card as the "comparison" card
                tempCard = unsortedCards[inner - 1];
                // If our compare card is greater than our current card swap them
                if (tempCard.getValueAsInt() > unsortedCards[inner].getValueAsInt()) {
                    unsortedCards[inner - 1] = unsortedCards[inner];
                    unsortedCards[inner] = tempCard;
                }
            }
        }
    } 
}

// Hand: A class that represents the cards held by a single player.
class Hand {
    // added +4 to maxcards to include joker (orig 50)
    // public static final int MAX_CARDS = 50;
    public static final int MAX_CARDS = 54;
    private Card[] myCards;
    private int numCards;

    // Default Constructor
    Hand() {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    // resetHand: Resets by setting index to 0 and data to null
    public void resetHand() {
        numCards = 0;
        //this.myCards[getNumCards()].set(' ', null); COMMENTED OUT BY Jennah
    }

    /**
     * takeCard: Adds a card to the next available position in the myCards array
     * (your hand) if there's space.
     *
     * @param: The input card object to be taken
     * @return: returns true if a card was taken from the deck and false if the hand
     *          is full
     */
    public boolean takeCard(Card card) {
        if (numCards < MAX_CARDS && card != null) {
            myCards[numCards] = new Card(card);
            numCards++;
            return true;
        }
        // Our hand is full
        return false;
    }

    /**
     * playCard: returns and removes the card in top position of the array
     *
     * @return: returns the card that is going to be played
     */
    public Card playCard(int cardIndex) {
        // Case for when the HAND is EMPTY
        if (numCards == 0) {
            // Creates a card that DOES NOT work
            return new Card('M', Card.Suit.SPADES);
        } else {
            // Otherwise we just "play" the card & adjust the rest of the hand
            Card indexCard = myCards[cardIndex];

            numCards--;
            for (int i = cardIndex; i < numCards; i++) {
                myCards[i] = myCards[i + 1];
            }
        
            myCards[numCards] = null;
            return indexCard;
        }
    }

    /* toString: a stringizer that displays the entire hand */
    public String toString() {
        String toPrint = "Hand = (";
        for (int i = 0; i < numCards; i++) {
            toPrint += myCards[i].toString();
            if (i != (numCards - 1)) {
                toPrint += ", ";
            }
        }
        return toPrint + ")";
    }

    // returns the number of Cards in the hand
    public int getNumCards() {
        return this.numCards;
    }

    /**
     * inspectCard: Accessor for an individual card. Returns a card with errorFlag =
     * true if k is bad.
     *
     * @param: takes an integer and checks the card in the index of integer k
     * @return: returns the card that is at index k
     */
    Card inspectCard(int k) {
        if (k < 0 || k > MAX_CARDS) {
            Card badCard = new Card('1', Card.Suit.SPADES);
            return badCard;
        }
        return myCards[k];
    }
    
    // Changed from myCards[k]
    void sortHands() {
        // int k;
        // for (k = 0; k < CardTable.numPlayers; k++)
        sort();
    }

    public void sort() {
        // Card.arraySort(this.myCards, this.myCards.length);
        Card.arraySort(myCards, numCards);
    }
}

/*
 * Deck: A class that represents the source of the cards for dealing and, as the
 * game progresses, the place from which players can receive new cards
 */
class Deck {
    public static final int MAX_CARDS = 312;
    private static final int DECK_SIZE = 56;
    private static Card[] masterPack; // Consistent pack of cards

    private Card[] cards; // General deck array w cards
    private int topCard; // Index for topmost card

    // Explicit Constructor
    public Deck(int numPacks) {
        allocateMasterPack();

        if (numPacks > 0 && numPacks < 7) {
            this.cards = new Card[DECK_SIZE * numPacks]; // increase init size
            this.init(numPacks);
            this.topCard = (DECK_SIZE * numPacks) - 1;
        } else {
            // Same as Default Constructor
            this.cards = new Card[DECK_SIZE];
            this.init(1);
            this.topCard = DECK_SIZE - 1;
        }
    }

    // Default Constructor. Assumes 1 Pack.
    public Deck() {
        allocateMasterPack();
        this.cards = new Card[DECK_SIZE];
        this.topCard = DECK_SIZE - 1;
        this.init(1);
    }

    /**
     * init: Re-populate cards[] with the standard DECK_SIZE × numPacks cards. Assumes that
     * you only call init w the same number of initial packs.
     *
     * @param: numPacks is the amount of packs to add
     */
    public void init(int numPacks) {
        for (int k = 0; k < numPacks * DECK_SIZE; k++) {
            this.cards[k] = new Card(masterPack[k % DECK_SIZE]); // divides init
        }
        this.topCard = (numPacks * DECK_SIZE) - 1;
    }
            

    /**
     * shuffle: Mixes up the cards by using the standard random generator to
     * procedurally swap each card w/ a random other. Does this toShuffleCount
     * amount of times for more thoroughly mixed cards.
     */
    public void shuffle() {
        Random shuffleCards = new Random();
        int toShuffleCnt = 2;
        // Ex: For a single 52 card deck, this'll shuffle cards about 104
        // times.
        for (int j = 0; j < toShuffleCnt; j++) {
            for (int i = 0; i < topCard; i++) {
                int change = shuffleCards.nextInt(topCard); // Generates Index
                // Swapping the i-th card w/ the generated one
                Card temp = new Card(cards[i].getValue(), cards[i].getSuit());
                cards[i] = cards[change];
                cards[change] = temp;
            }
        }
    }

    /**
     * dealCard: Returns and removes the card in the top occupied position of
     * cards[] or just "the topmost card".
     *
     * @return: the topmost Card if there's still one, otherwise a card w/ errorFlag
     *          = true.
     */
    Card dealCard() {
        Card toReturn = new Card('1', Card.Suit.SPADES);
        if (topCard >= 0) {
            // IF deck isn't empty
            //Card toReturn = new Card(cards[topCard]);
            //cards[topCard] = null;
            //topCard--;
            //return toReturn;
            return cards[--topCard];
        }
        else{
            return toReturn;
        }
        // Deck is empty
        //return new Card('1', Card.Suit.SPADES);
    }

    // Returns topCard
    public int getTopCard() {
        return this.topCard;
    }

    /**
     * inspectCard: Accessor for an individual card. Returns a card with errorFlag =
     * true if k is bad.
     *
     * @param: the index of the specific card in the deck
     * @return: the Card at the specified index
     */
    public Card inspectCard(int k) {
        if (k < 0 || k > topCard) {
            // Incorect Case
            Card badCard = new Card('1', Card.Suit.SPADES);
            return badCard;
        }
        return cards[k]; // Correct Case
    }

    /**
     * allocateMasterPack: Constructs a standard playing card deck to be copied from
     * if needed. Even if many Deck objects are constructed, this will not allow
     * itself to be executed more than once.
     */
    private static void allocateMasterPack() {
        // if masterPack is null, we make our first copy or do nothing
        if (masterPack == null) {
            masterPack = new Card[DECK_SIZE];
            // Declare two suit/value arrays for generation.
            // {Card.Suit.SPADES,}
            //Card.Suit[] suitArray = new Card.Suit [] {Card.Suit.SPADES, Card.Suit.HEARTS, Card.Suit.DIAMONDS, Card.Suit.CLUBS};
            Card.Suit[] suitArray = Card.Suit.values();
            char[] charArray = new char[] { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
            int masterIndex = 0;
            // double for loop for index to generate all needed cards
            for (int i = 0; i < suitArray.length; i++) {
                for (int j = 0; j < charArray.length; j++) {
                    masterPack[masterIndex] = new Card(charArray[j], suitArray[i]);
                    masterIndex++;
                }
            }
        }
    }  

    /**
    * addCard: make sure that there are not too many instances of the card in the deck if you add it. 
    * then put card at the top of the deck.
    *
    * @param: card object to search for
    * @return: boolean to see if it was sucessful at adding a card
    */
    public boolean addCard(Card card) {
        int maxInstances = (cards.length % 52) + 1;
        int found = 0;
        
        for (int i = 0; i < cards.length; i ++) {
            if (cards[i].equals(card)) {
                found++;
            }
            // Checks if there is room at the end of the array
            if (i == topCard && found < maxInstances) { 
                //cards[topCard + 1] = card; //UNCOMMENTED
                cards[topCard++] = card;
                //topCard++;                  //UNCOMMENTED
                return true;
            }
        }
        return false;
    }

    /**
    * removeCard: Removes a specific card from the deck. Put the current top card into its place.  
    * Checks that the card you need is actually still in the deck first.
    *
    * @param: card to search for
    * @return: True if operation was done, False if card wasn't found in the first place
    */
    public boolean removeCard(Card card) {

        boolean doSwap = false;
        int toSwapIndex = 0;
        
        // Use a for loop w boolean to check if a card exists.
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(card)) {
                // If the current card in the deck is EQUAL to our search card
                toSwapIndex = i;
            }
        }

        if (doSwap) {
            Card topSwap = new Card(cards[getTopCard()]); // Topmost Card
            Card temp = new Card(cards[toSwapIndex]); // Our Mid-deck Card 
            cards[toSwapIndex] = topSwap; // Perform Swaps
            cards[topCard] = temp;
            
            return true;
        } else {
            return false;
        }
    }

    /**
    * sort(): put all of the cards in the deck back into the right order 
    * according to their values. Uses Card's arraySort (bubblesort) to do so.  
    */
    void sort() {
        Card.arraySort(cards, getNumCards());
    }

    /**
    * getNumCards: Returns the count of remaining cards in the 
    * deck using topCard + 1.
    *
    * @return: returns number remaining cards in the deck. 
    */
    int getNumCards() {
        return this.topCard + 1;
    }
}


class CardGameOutline { //implements ActionListeners{
    private static final int MAX_PLAYERS = 50;
    private int numPlayers;
    private int numPacks;            // # standard 52-card packs per deck
                                     // ignoring jokers or unused cards
    private int numJokersPerPack;    // if 2 per pack & 3 packs per deck, get 6
    private int numUnusedCardsPerPack;  // # cards removed from each pack
    private int numCardsPerHand;        // # cards to deal each player
    private Deck deck;               // holds the initial full deck and gets smaller (usually) during play
    private Hand[] hand;             // one Hand for each player
    private Card[] unusedCardsPerPack;   // an array holding the cards not used in the game.  
                                        //e.g. pinochledoes not use cards 2-8 of any suit
    public CardGameOutline(int numPacks, int numJokersPerPack,
        int numUnusedCardsPerPack,  Card[] unusedCardsPerPack,
        int numPlayers, int numCardsPerHand){
            int k;
            // filter bad values
            if (numPacks < 1 || numPacks > 6)
                numPacks = 1;
            if (numJokersPerPack < 0 || numJokersPerPack > 4)
                numJokersPerPack = 0;
            if (numUnusedCardsPerPack < 0 || numUnusedCardsPerPack > 50) //  > 1  card
                numUnusedCardsPerPack = 0;
            if (numPlayers < 1 || numPlayers > MAX_PLAYERS)
                numPlayers = 4;
            // one of many ways to assure at least one full deal to all players
            if  (numCardsPerHand < 1 ||
                numCardsPerHand >  numPacks * (52 - numUnusedCardsPerPack)
                 / numPlayers )
                numCardsPerHand = numPacks * (52 - numUnusedCardsPerPack) / numPlayers;
            // allocate
            this.unusedCardsPerPack = new Card[numUnusedCardsPerPack];
            this.hand = new Hand[numPlayers];
            for (k = 0; k < numPlayers; k++)
                this.hand[k] = new Hand();
            this.deck = new Deck(numPacks);
            // assign to members
            this.numPacks = numPacks;
            this.numJokersPerPack = numJokersPerPack;
            this.numUnusedCardsPerPack = numUnusedCardsPerPack;
            this.numPlayers = numPlayers;
            this.numCardsPerHand = numCardsPerHand;
            for (k = 0; k < numUnusedCardsPerPack; k++)
                this.unusedCardsPerPack[k] = unusedCardsPerPack[k];
            // prepare deck and shuffle
            this.newGame();
        }

        // constructor overload/default for game like bridge
        public CardGameOutline(){
            this(1, 0, 0, null, 4, 13);
        }

        public Hand getHand(int k){
            // hands start from 0 like arrays
            // on error return automatic empty hand
            if (k < 0 || k >= numPlayers)
                return new Hand();

            return hand[k];
        }

        public Card getCardFromDeck() { 
            return deck.dealCard(); 
        }
        public int getNumCardsRemainingInDeck() { 
            return deck.getNumCards(); 
        }

        public void newGame(){
            int k, j;
            // clear the hands
            for (k = 0; k < numPlayers; k++)
                hand[k].resetHand();
            // restock the deck
            deck.init(numPacks);

            // remove unused cards
            for (k = 0; k < numUnusedCardsPerPack; k++)
                 deck.removeCard( unusedCardsPerPack[k] );
            // add jokers
            for (k = 0; k < numPacks; k++)
                for ( j = 0; j < numJokersPerPack; j++)
                    deck.addCard( new Card('X', Card.Suit.values()[j]) );
            // shuffle the cards
            deck.shuffle();
        }
        public boolean deal(){
            // returns false if not enough cards, but deals what it can
            int k, j;
            boolean enoughCards;
            
            // clear all hands
            for (j = 0; j < numPlayers; j++)
                hand[j].resetHand();
            
            enoughCards = true;
            for (k = 0; k < numCardsPerHand && enoughCards ; k++){
                for (j = 0; j < numPlayers; j++)
                    if (deck.getNumCards() > 0)
                        hand[j].takeCard( deck.dealCard() );
                    else{
                        enoughCards = false;
                        break;
                    }
            }
            return enoughCards;
        }
        void sortHands(){
            int k;
            for (k = 0; k < numPlayers; k++)
                hand[k].sort();
        }

        Card playCard(int playerIndex, int cardIndex){
            // returns bad card if either argument is bad
            if (playerIndex < 0 ||  playerIndex > numPlayers - 1 ||
                cardIndex < 0 || cardIndex > numCardsPerHand - 1){
                //Creates a card that does not work
                return new Card('M', Card.Suit.SPADES);
            }
            // return the card played
            return hand[playerIndex].playCard(cardIndex);
        }
        
        boolean takeCard(int playerIndex){
            // returns false if either argument is bad
            if (playerIndex < 0 || playerIndex > numPlayers - 1)
                return false;
                
            // Are there enough Cards?
            if (deck.getNumCards() <= 0)
                return false;
        return hand[playerIndex].takeCard(deck.dealCard());
        }
}
