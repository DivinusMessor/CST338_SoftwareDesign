/*
 * CST 338 - Software Design - Assig 3
 * Warren Ngoun
 * Yukio Rivera
 * Jennah Yasin
 * Luis Jimenez
 * Decks of Cards: This program is made up of 3 classes, (Card, Hand, and 
 * Deck) which is ultimately used to create 
 * a card game that can be played with a human.
 */

import java.util.Scanner;
import java.util.Random;

public class Assig3 {

    public static void main(String[] args) {
        
        // Phase 1:
        // Card first = new Card();
        // Card second = new Card('7', Card.Suit.CLUBS);
        // Card third = new Card('1', Card.Suit.HEARTS);
        // System.out.println("CARDS: " + first.toString() + " " 
        // + secondtoString() + " " + third.toString());
        // Setting a bad card good
        // third.set('3', Card.Suit.SPADES);
        // System.out.println("SET: " + third.toString());
        // Setting a good card bad
        // third.set('1', Card.Suit.SPADES);
        // System.out.println("SET: " + third.toString());
        // Testing equals()
        // third.set('A', Card.Suit.SPADES);
        // System.out.println("EQUALS: " + third.equals(first));

        // Phase 2:
        // Hand tempHand = new Hand();
        // Card first = new Card();
        // Card second = new Card('7', Card.Suit.CLUBS);
        // Card third = new Card('T', Card.Suit.HEARTS);
        // Card fourth = new Card('Q', Card.Suit.DIAMONDS);
        // Card fifth = new Card('9', Card.Suit.CLUBS);
        // Loop to fill the Hand
        // for (int i = 0; i < Hand.MAX_CARDS; i++) {
        //     tempHand.takeCard(first);
        //     tempHand.takeCard(second);
        //     tempHand.takeCard(third);
        //     tempHand.takeCard(fourth);
        //     tempHand.takeCard(fifth);
        // }
        // Printing out Hand after filling
        // System.out.println("HAND: " + tempHand.toString()); 
        // Testing if False is being sent when hand full
        // System.out.println("BOOL: " + tempHand.takeCard(first));
        // Plaing Cards & Printing them
        // for (int i = 0; i < tempHand.MAX_CARDS; i++) {
        //     System.out.println("CARD: " + tempHand.playCard());
        // }
        // Displaying Hand after playing all cards
        // System.out.println("HAND: " + tempHand.toString()); 

        // Testing resetHand()
        // tempHand.resetHand();
        // System.out.println("HAND SIZE: " + tempHand.getNumCards()); 
        // System.out.println("HAND: " + tempHand.toString()); 
        // Testing inspectCard
        // System.out.println("1: " + tempHand.inspectCard(0));
        // System.out.println("2: " + tempHand.inspectCard(1));
        // System.out.println("3: " + tempHand.inspectCard(2));
        // System.out.println("4: " + tempHand.inspectCard(3));
        // System.out.println("5: " + tempHand.inspectCard(4));
        // Testing illegal int arguments
        // System.out.println("5: " + tempHand.inspectCard(-5));
        // System.out.println("10: " + tempHand.inspectCard(100));

        // Phase 3:
        // Creates a deck with two packs
        Deck tempDeck = new Deck(2);
        int initialDeckSize = tempDeck.getTopCard();
        // Deals all of the cards in the loop until deck is empty
        for (int i = 0; i <= initialDeckSize; i++) {
            System.out.print(tempDeck.dealCard() + " / ");
        }
        
        System.out.println();
        System.out.println();
        tempDeck.init(2); // Reset deck by initializing back same 2 packs
        tempDeck.shuffle(); // Shuffles the deck
        // Re-deals all of the cards until the deck is empty
        for (int i = 0; i <= initialDeckSize; i++) {
            System.out.print(tempDeck.dealCard() + " / ");
        }

        System.out.println();
        System.out.println();
        // Repeats process above again using only 1 deck
        Deck tempDeck2 = new Deck();
        int initialDeckSize2 = tempDeck2.getTopCard();
        for (int i = 0; i <= initialDeckSize2; i++) {
            System.out.print(tempDeck2.dealCard() + " / ");
        }
        System.out.println();
        System.out.println();

        tempDeck2.init(1);
        tempDeck2.shuffle();
        for (int i = 0; i <= initialDeckSize2; i++) {
            System.out.print(tempDeck2.dealCard() + " / ");
        }
        System.out.println();
        System.out.println();
        // PHASE 4:
        Scanner keyboard = new Scanner(System.in);
        int numHands;
        System.out.print("How many hands? (1-10 please): ");
        numHands = keyboard.nextInt();
        // Checks if user input is valid (1-10)
        if (numHands >= 1 && numHands <= 10) {
            // If valid, creates new deck and deals deck into hand
            Deck tempDeck3 = new Deck();
            Hand[] playerHand = new Hand[numHands];
            // Deals all of the cards until the hand is empty
            for (int i = 0; i < playerHand.length; i++) {
                playerHand[i] = new Hand();
            }
        
            int playerCount = 0;
            while (tempDeck3.getTopCard() >= 0) {
                
                playerHand[playerCount].takeCard(tempDeck3.dealCard());
                playerCount++;
                if (playerCount == numHands) {
                    playerCount = 0;
                }
            }
            // Prints out the unshuffled dealt deck to user
            System.out.println("Here are our hands," 
            + " from unshuffled deck:");
            for (int i = 0; i < playerHand.length; i++) {
                System.out.println(playerHand[i].toString());
                System.out.println();
                playerHand[i].resetHand();
            }
            tempDeck3.init(1); // Resets back to original deck
            tempDeck3.shuffle(); // Shuffles the deck
            while (tempDeck3.getTopCard() >= 0) {
                playerHand[playerCount].takeCard(tempDeck3.dealCard());
                playerCount++;
                if (playerCount == numHands) {
                    playerCount = 0;
                }
            }
            System.out.println();
            System.out.println();
            // Prints out shuffled deck
            System.out.println("Here are our hands, from SHUFFLED deck:");
            for (int i = 0; i < playerHand.length; i++) {
                System.out.println(playerHand[i].toString());
                System.out.println();
            }
            System.out.println("Press any key to continue . . . ");
        }
     }
}  
/* Card: A public class that creates a card with a 
   value and suit and checks its validity in errorFlag.*/
class Card {
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
    Card() {
        // Sets default card to A of SPADES
        this.value = 'A';
        this.suit = Suit.SPADES;
        this.errorFlag = false;
    }

    // Copy Constructor
    Card(Card origCard) {
        // Duplicates the original card constructor
        this.value = origCard.getValue();
        this.suit = origCard.getSuit();
        this.errorFlag = origCard.getErrorFlag();
    }
    
    // toString: Returns the string representation of the card.
    public String toString() {
        // returns the value and suit of card or a string if errorFlag true
        if (errorFlag){
            return "[invalid]";
        } else {
            return value + " of " + suit;
        }
    }

    /**
    *   set: Mutator that accepts legal values. When bad values are passed, 
    *   errorFlag is set to true and other values are 
    *   left alone. If good values are passed, they're stored 
    *   & errorFlag is set to false. Uses isValid to test.
    *
    *   @param: takes the potential value and suit of the card
    *   @return: true or false depending if the card was valid 
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
    *   equals: Compares all the fields (members) and if they're identical.
    *
    *   @param: The card that you want to check against.
    *   @return: True or false depending if the two cards have the same data. 
    */
    public boolean equals(Card card) {
        if (value == card.getValue() 
        && errorFlag == card.getErrorFlag() 
        && suit == card.getSuit()) {
            return true;
        }
        return false;
    }

    /**
    *   isValid: Verifies that the suit and value of the card is correct. 
    *   Legal values are ('A', '2', ... '9', 'T', 'J', 'Q',' K').
    *
    *   @param: Takes in a character for it's value and a Suit data type as 
    *   suit
    *   @return: A boolean; true if it's valid and false otherwise
    */
    private boolean isValid(char value, Suit suit) {
        if (suit == Suit.SPADES || suit == Suit.HEARTS 
        || suit == Suit.DIAMONDS || suit == Suit.CLUBS) {
            if (value == 'A' || value == 'T' || value == 'J' 
            || value == 'Q' || value == 'K' || value == '2' 
            || value == '3' || value == '4' || value == '5' 
            || value == '6' ||value == '7' 
            || value == '8' || value == '9') {
                return true;
            }
        }
        return false;
    }
}

// Hand: A class that represents the cards held by a single player.
class Hand {
    public static final int MAX_CARDS = 50;
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
        this.myCards[getNumCards()].set(' ', null);
    }
    
    /**
    *   takeCard: Adds a card to the next available position in the myCards 
    *   array (your hand) if there's space.
    *
    *   @param: The input card object to be taken 
    *   @return: returns true if a card was taken from the deck and false 
    *   if the hand is full 
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
    *   playCard: returns and removes the card in top 
    *   position of the array  
    *
    *   @return: returns the card that is going to be played 
    */
    public Card playCard() {
        if (numCards > 0) {
            numCards--;
        }
        return new Card('1', Card.Suit.SPADES);
    }

    /* toString: a stringizer that displays the entire hand */
    public String toString() {
        String toPrint = "Hand = (";
        for (int i = 0; i < numCards; i++) {
            toPrint +=  myCards[i].toString();
            if (i != (numCards - 1)) {
                toPrint += ", ";
            }
        }
        return toPrint + ")";
    }

    //returns the number of Cards in the hand
    public int getNumCards() {
        return this.numCards;
    }

    /**
    *   inspectCard: Accessor for an individual card. Returns a card with 
    *   errorFlag = true if k is bad.
    *
    *   @param: takes an integer and checks the card in the index of integer k
    *   @return: returns the card that is at index k
    */
    Card inspectCard(int k) {
        if (k < 0 || k > MAX_CARDS) {
            Card badCard = new Card('1', Card.Suit.SPADES);
            return badCard;
        }
        return myCards[k];
    }
}

/* Deck: A class that represents the source of the cards for dealing 
*  and, as the game progresses, the place from which players 
*  can receive new cards
*/
class Deck {
    public static final int MAX_CARDS = 312;
    private static Card[] masterPack; // Consistent pack of cards

    private Card[] cards; // General deck array w cards
    private int topCard; // Index for topmost card

    // Explicit Constructor
    public Deck(int numPacks) {
        allocateMasterPack();
        
        if (numPacks > 0 && numPacks < 7) {
            this.cards = new Card [52 * numPacks]; // increase init size
            this.init(numPacks);
            this.topCard = (52 * numPacks) - 1;
        } else {
            // Same as Default Constructor
            this.cards = new Card [52];
            this.init(1);
            this.topCard = 51;
        } 
    }

    // Default Constructor. Assumes 1 Pack.
    public Deck() {
        allocateMasterPack();
        this.cards = new Card [52];
        this.topCard = 51;
        this.init(1);
    }
    
    /**
    *   init: Re-populate cards[] with the standard 52 ?? numPacks cards. 
    *   Assumes that you only 
    *   call init w the same number of initial packs.
    *
    *   @param: numPacks is the amount of packs to add
    */
    public void init(int numPacks) {
        for (int k = 0; k < numPacks * 52; k++) {
            this.cards[k] = new Card(masterPack[k % 52]); // divides init
        }
        this.topCard = (numPacks * 52) - 1; 
    }

    /**
    *   shuffle: Mixes up the cards by using the standard random generator
    *   to procedurally swap each card w/ a random other. 
    *   Does this toShuffleCount amount of times for more 
    *   thoroughly mixed cards.
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
                Card temp = new Card (cards[i].getValue(), 
                cards[i].getSuit());
                cards[i] = cards[change];
                cards[change] = temp;
            }
        }
    }

    /**
    *   dealCard: Returns and removes the card in the top occupied position of 
    *   cards[] or just "the topmost card".
    *
    *   @return: the topmost Card if there's still one, otherwise a card w/ 
    *   errorFlag = true.
    */
    Card dealCard() {
        if (topCard >= 0) {
            // IF deck isn't empty
            Card toReturn = new Card(cards[topCard]);
            cards[topCard] = null;
            topCard--;
            return toReturn;
        }
        // Deck is empty
        return new Card('1', Card.Suit.SPADES);
    }

    // returns topCard
    public int getTopCard() {
        return this.topCard;
    }

    /**
    *   inspectCard: Accessor for an individual card. Returns a card with 
    *   errorFlag = true if k is bad.
    *
    *   @param: the index of the specific card in the deck
    *   @return: the Card at the specified index
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
    *   allocateMasterPack: Constructs a standard playing card deck to be 
    *   copied from if needed. Even if many 
    *   Deck objects are constructed, this will not allow itself to be 
    *   executed more than once.
    */
    private static void allocateMasterPack() {
        // if masterPack is null, we make our first copy or do nothing
        if (masterPack == null) {
            masterPack = new Card[52];
            // Declare two suit/value arrays for generation.
            Card.Suit[] suitArray = Card.Suit.values();
            char[] charArray = new char[]{'A', '2', '3', '4', 
            '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
            int masterIndex = 0;
            // double for loop for index to generate all needed cards
            for (int i = 0; i < suitArray.length; i++) {
                for (int j = 0; j < charArray.length; j++) {
                    masterPack[masterIndex] = new Card(charArray[j], 
                    suitArray[i]);
                    masterIndex++;
                }
            }
        }
    }
}

/************************* Sample Output for Phases 3 & 4 *********************

K of SPADES / Q of SPADES / J of SPADES / T of SPADES / 9 of SPADES / 8 of SPADES / 7 of SPADES / 6 of SPADES / 5 of SPADES / 4 of SPADES / 3 of SPADES / 2 of SPADES / A of SPADES / K of HEARTS / Q of HEARTS / J of HEARTS / T of HEARTS / 9 of HEARTS / 8 of HEARTS / 7 of HEARTS / 6 of HEARTS / 5 of HEARTS / 4 of HEARTS / 3 of HEARTS / 2 of HEARTS / A of HEARTS / K of DIAMONDS / Q of DIAMONDS / J of DIAMONDS / T of DIAMONDS / 9 of DIAMONDS / 8 of DIAMONDS / 7 of DIAMONDS / 6 of DIAMONDS / 5 of DIAMONDS / 4 of DIAMONDS / 3 of DIAMONDS / 2 of DIAMONDS / A of DIAMONDS / K of CLUBS / Q of CLUBS / J of CLUBS / T of CLUBS / 9 of CLUBS / 8 of CLUBS / 7 of CLUBS / 6 of CLUBS / 5 of CLUBS / 4 of CLUBS / 3 of CLUBS / 2 of CLUBS / A of CLUBS / K of SPADES / Q of SPADES / J of SPADES / T of SPADES / 9 of SPADES / 8 of SPADES / 7 of SPADES / 6 of SPADES / 5 of SPADES / 4 of SPADES / 3 of SPADES / 2 of SPADES / A of SPADES / K of HEARTS / Q of HEARTS / J of HEARTS / T of HEARTS / 9 of HEARTS / 8 of HEARTS / 7 of HEARTS / 6 of HEARTS / 5 of HEARTS / 4 of HEARTS / 3 of HEARTS / 2 of HEARTS / A of HEARTS / K of DIAMONDS / Q of DIAMONDS / J of DIAMONDS / T of DIAMONDS / 9 of DIAMONDS / 8 of DIAMONDS / 7 of DIAMONDS / 6 of DIAMONDS / 5 of DIAMONDS / 4 of DIAMONDS / 3 of DIAMONDS / 2 of DIAMONDS / A of DIAMONDS / K of CLUBS / Q of CLUBS / J of CLUBS / T of CLUBS / 9 of CLUBS / 8 of CLUBS / 7 of CLUBS / 6 of CLUBS / 5 of CLUBS / 4 of CLUBS / 3 of CLUBS / 2 of CLUBS / A of CLUBS / 

K of SPADES / 2 of DIAMONDS / 4 of CLUBS / 6 of SPADES / 3 of HEARTS / T of SPADES / J of SPADES / 6 of CLUBS / 7 of HEARTS / 9 of SPADES / J of DIAMONDS / 9 of SPADES / K of CLUBS / 9 of HEARTS / 9 of DIAMONDS / J of HEARTS / T of SPADES / K of SPADES / J of SPADES / 8 of CLUBS / Q of SPADES / T of HEARTS / 9 of CLUBS / 3 of HEARTS / 4 of CLUBS / 5 of DIAMONDS / T of DIAMONDS / 5 of HEARTS / 3 of DIAMONDS / J of CLUBS / 5 of DIAMONDS / 7 of DIAMONDS / 3 of CLUBS / 5 of CLUBS / 7 of SPADES / 9 of HEARTS / 7 of CLUBS / Q of DIAMONDS / 8 of HEARTS / Q of HEARTS / 2 of SPADES / Q of DIAMONDS / 9 of CLUBS / 4 of DIAMONDS / 8 of HEARTS / 3 of CLUBS / 2 of HEARTS / 7 of HEARTS / 6 of DIAMONDS / 5 of HEARTS / T of CLUBS / 5 of SPADES / 3 of SPADES / 8 of SPADES / K of HEARTS / 8 of CLUBS / 4 of SPADES / J of DIAMONDS / A of CLUBS / 2 of DIAMONDS / T of CLUBS / T of DIAMONDS / 6 of SPADES / K of DIAMONDS / 4 of SPADES / K of CLUBS / 3 of SPADES / 7 of CLUBS / 5 of SPADES / 7 of DIAMONDS / Q of CLUBS / 4 of HEARTS / 8 of DIAMONDS / 2 of CLUBS / 3 of DIAMONDS / A of HEARTS / 6 of HEARTS / 6 of HEARTS / 7 of SPADES / 2 of SPADES / 5 of CLUBS / A of DIAMONDS / 8 of DIAMONDS / 2 of CLUBS / 8 of SPADES / T of HEARTS / K of HEARTS / A of HEARTS / A of CLUBS / Q of HEARTS / 6 of DIAMONDS / 4 of HEARTS / Q of SPADES / J of CLUBS / 4 of DIAMONDS / 2 of HEARTS / Q of CLUBS / A of SPADES / J of HEARTS / A of SPADES / A of DIAMONDS / 6 of CLUBS / 9 of DIAMONDS / K of DIAMONDS / 

K of SPADES / Q of SPADES / J of SPADES / T of SPADES / 9 of SPADES / 8 of SPADES / 7 of SPADES / 6 of SPADES / 5 of SPADES / 4 of SPADES / 3 of SPADES / 2 of SPADES / A of SPADES / K of HEARTS / Q of HEARTS / J of HEARTS / T of HEARTS / 9 of HEARTS / 8 of HEARTS / 7 of HEARTS / 6 of HEARTS / 5 of HEARTS / 4 of HEARTS / 3 of HEARTS / 2 of HEARTS / A of HEARTS / K of DIAMONDS / Q of DIAMONDS / J of DIAMONDS / T of DIAMONDS / 9 of DIAMONDS / 8 of DIAMONDS / 7 of DIAMONDS / 6 of DIAMONDS / 5 of DIAMONDS / 4 of DIAMONDS / 3 of DIAMONDS / 2 of DIAMONDS / A of DIAMONDS / K of CLUBS / Q of CLUBS / J of CLUBS / T of CLUBS / 9 of CLUBS / 8 of CLUBS / 7 of CLUBS / 6 of CLUBS / 5 of CLUBS / 4 of CLUBS / 3 of CLUBS / 2 of CLUBS / A of CLUBS / 

K of SPADES / 7 of SPADES / 2 of HEARTS / 6 of SPADES / J of SPADES / 4 of CLUBS / 6 of HEARTS / 7 of CLUBS / A of SPADES / 2 of CLUBS / T of DIAMONDS / Q of SPADES / 6 of CLUBS / 5 of HEARTS / A of DIAMONDS / 7 of DIAMONDS / 7 of HEARTS / 8 of CLUBS / 9 of CLUBS / Q of CLUBS / K of CLUBS / K of DIAMONDS / 4 of DIAMONDS / 9 of DIAMONDS / T of CLUBS / K of HEARTS / 5 of CLUBS / 8 of HEARTS / 5 of SPADES / 5 of DIAMONDS / A of CLUBS / 9 of HEARTS / 8 of DIAMONDS / 2 of SPADES / 3 of SPADES / 6 of DIAMONDS / J of DIAMONDS / T of HEARTS / 8 of SPADES / Q of DIAMONDS / J of CLUBS / Q of HEARTS / 3 of HEARTS / J of HEARTS / A of HEARTS / 4 of SPADES / 2 of DIAMONDS / T of SPADES / 9 of SPADES / 3 of CLUBS / 3 of DIAMONDS / 4 of HEARTS / 

How many hands? (1-10 please): 6
Here are our hands, from unshuffled deck:
Hand = (K of SPADES, 7 of SPADES, A of SPADES, 8 of HEARTS, 2 of HEARTS, 9 of DIAMONDS, 3 of DIAMONDS, T of CLUBS, 4 of CLUBS)

Hand = (Q of SPADES, 6 of SPADES, K of HEARTS, 7 of HEARTS, A of HEARTS, 8 of DIAMONDS, 2 of DIAMONDS, 9 of CLUBS, 3 of CLUBS)

Hand = (J of SPADES, 5 of SPADES, Q of HEARTS, 6 of HEARTS, K of DIAMONDS, 7 of DIAMONDS, A of DIAMONDS, 8 of CLUBS, 2 of CLUBS)

Hand = (T of SPADES, 4 of SPADES, J of HEARTS, 5 of HEARTS, Q of DIAMONDS, 6 of DIAMONDS, K of CLUBS, 7 of CLUBS, A of CLUBS)

Hand = (9 of SPADES, 3 of SPADES, T of HEARTS, 4 of HEARTS, J of DIAMONDS, 5 of DIAMONDS, Q of CLUBS, 6 of CLUBS)

Hand = (8 of SPADES, 2 of SPADES, 9 of HEARTS, 3 of HEARTS, T of DIAMONDS, 4 of DIAMONDS, J of CLUBS, 5 of CLUBS)



Here are our hands, from SHUFFLED deck:
Hand = (6 of DIAMONDS, 8 of DIAMONDS, Q of CLUBS, 3 of DIAMONDS, 7 of DIAMONDS, 8 of SPADES, Q of SPADES, 2 of SPADES, T of CLUBS)

Hand = (7 of HEARTS, K of HEARTS, 9 of DIAMONDS, 3 of HEARTS, 5 of HEARTS, A of SPADES, 6 of CLUBS, 6 of SPADES, K of CLUBS)

Hand = (8 of HEARTS, 2 of HEARTS, 5 of DIAMONDS, A of CLUBS, 8 of CLUBS, 6 of HEARTS, 7 of SPADES, Q of DIAMONDS)

Hand = (3 of SPADES, A of DIAMONDS, 2 of CLUBS, J of DIAMONDS, 5 of SPADES, 9 of SPADES, 4 of HEARTS, 3 of CLUBS)

Hand = (K of SPADES, 4 of SPADES, 2 of DIAMONDS, T of HEARTS, 9 of HEARTS, K of DIAMONDS, Q of HEARTS, 4 of CLUBS, J of HEARTS)

Hand = (9 of CLUBS, 5 of CLUBS, T of SPADES, 7 of CLUBS, J of CLUBS, T of DIAMONDS, A of HEARTS, 4 of DIAMONDS, J of SPADES)

Press any key to continue . . . 
******************************************************/