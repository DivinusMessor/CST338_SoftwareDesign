import java.util.Scanner;
import java.util.Random;

public class Assig3 {

    public static void main(String[] args) {
        
        // //Phase 1:
        // Card first = new Card();
        // Card second = new Card('7', Card.Suit.CLUBS);
        // Card third = new Card('1', Card.Suit.HEARTS);
        // System.out.println("CARDS: " + first.toString() + " " + second.toString() + " " + third.toString());
        // // Setting a bad card good
        // third.set('3', Card.Suit.SPADES);
        // System.out.println("SET: " + third.toString());
        // // Setting a good card bad
        // third.set('1', Card.Suit.SPADES);
        // System.out.println("SET: " + third.toString());
        // // Testing equals()
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
        // // Testing illegal int arguments
        // System.out.println("5: " + tempHand.inspectCard(-5));
        // System.out.println("10: " + tempHand.inspectCard(100));

        // Phase 3:
        Deck tempDeck = new Deck(2);
        int initialDeckSize = tempDeck.getTopCard();
        for (int i = 0; i <= initialDeckSize; i++) {
            System.out.print(tempDeck.dealCard() + " / ");
        }
        System.out.println();
        System.out.println();
        tempDeck.init(2);
        tempDeck.shuffle();
        for (int i = 0; i <= initialDeckSize; i++) {
            System.out.print(tempDeck.dealCard() + " / ");
        }

        System.out.println();
        System.out.println();

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
        System.out.println("Press any key to continue . . . ");

        // PHASE 4:
        Scanner keyboard = new Scanner(System.in);
        int numHands;
        System.out.print("How many hands? (1-10 please): ");
        numHands = keyboard.nextInt();

        if (numHands >= 1 && numHands <= 10) {
            
            Deck tempDeck3 = new Deck();
            Hand[] playerHand = new Hand[numHands];

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
            System.out.println("Here are our hands, from unshuffled deck:");
            for (int i = 0; i < playerHand.length; i++) {
                System.out.println(playerHand[i].toString());
                System.out.println();
                playerHand[i].resetHand();
            }
            tempDeck3.init(1);
            tempDeck3.shuffle();
            while (tempDeck3.getTopCard() >= 0) {
                
                playerHand[playerCount].takeCard(tempDeck3.dealCard());
                playerCount++;
                if (playerCount == numHands) {
                    playerCount = 0;
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("Here are our hands, from SHUFFLED deck:");
            for (int i = 0; i < playerHand.length; i++) {
                System.out.println(playerHand[i].toString());
                System.out.println();
            }
            System.out.println("Press any key to continue . . . ");
        }
     }
}  

class Card {
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    private char value;
    private Suit suit;
    private boolean errorFlag;

    // Explicit Constructor
    Card(char value, Suit suit) {
        set(value, suit);
    }

    // Default Constructor
    Card() {
        this.value = 'A';
        this.suit = Suit.SPADES;
        this.errorFlag = false;
    }

    // Copy Constructor
    Card(Card origCard) {
        this.value = origCard.getValue();
        this.suit = origCard.getSuit();
        this.errorFlag = origCard.getErrorFlag();
    }

    public String toString() {
        if (errorFlag){
            return "[invalid]";
        } else {
            return value + " of " + suit;
        }
    }

    /**
    *   set: Takes mutator that accepts legal values.  When bad values are passed, errorFlag is set to true and other values are 
    *   left alone. If good values are passed, they're stored & errorFlag is set to false. Uses isValid to test.
    */
    public boolean set(char value, Suit suit) {
        
        if (isValid(value, suit)) {
            // STORE SET 
            this.value = value;
            this.suit = suit;
            errorFlag = false;
            return true;
        } 
        errorFlag = true;
        return false;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public char getValue() {
        return this.value;
    }

    public boolean getErrorFlag() {
        return this.errorFlag;
    }

    // equals: returns true if all the fields (members) are identical and false, otherwise.
    public boolean equals(Card card) {
        if (value == card.getValue() && errorFlag == card.getErrorFlag() && suit == card.getSuit()) {
            return true;
        }
        return false;
    }

    /**
    *   isValid:
    *
    *   @param
    *   @return
    */
    private boolean isValid(char value, Suit suit) {
        // LEGAL CHARS: ('A', '2', '3', ... 'T', 'J', 'Q',' K')
        if (suit == Suit.SPADES || suit == Suit.HEARTS || suit == Suit.DIAMONDS || suit == Suit.CLUBS) {
            if (value == 'A' || value == 'T' || value == 'J' || value == 'Q' || value == 'K' || value == '2' || value == '3' || value == '4' || value == '5' || value == '6' || value == '7' || value == '8' || value == '9') {
                return true;
            }
        }
        return false;
    }
}

class Hand {
    public static final int MAX_CARDS = 50;
    private Card[] myCards;
    private int numCards;

    // Default Constructor
    Hand() {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    public void resetHand() {
        numCards = 0;
        //Set index back to 0 and sets data inside to null
        this.myCards[getNumCards()].set(' ', null);
    }
    
    /* takeCard: Adds a card to the next available position in the myCards array (your hand). This is an object copy, not a reference copy, since the source of the Card might destroy or change its data after our Hand gets it -- we want our local data to be exactly as it was when we received it.*/
    public boolean takeCard(Card card) {
        if (numCards < MAX_CARDS && card != null) {
        // if (numCards < MAX_CARDS && card != null && !card.getErrorFlag()) {
            myCards[numCards] = new Card(card);
            numCards++;
            return true;
        }
        // Our hand is full
        return false;
    }

    /*playCard: returns and removes the card in the top occupied 
    position of the array.*/
    public Card playCard() {
        if (numCards > 0) {
            numCards--;
        }
        return myCards[numCards]; // TODO: What to return if hand is empty?
    }

    /* toString: a stringizer that the client can use to display the entire hand*/
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

    public int getNumCards() {
        return this.numCards;
    }

    /* inspectCard: Accessor for an individual card. Returns a card with errorFlag = true if k is bad.*/
    Card inspectCard(int k) {
        if (k < 0 || k > MAX_CARDS) {
            Card badCard = new Card('1', Card.Suit.SPADES);
            return badCard;
        }
        return myCards[k];
    }
}

class Deck {
    public static final int MAX_CARDS = 312;
    private static Card[] masterPack; // Consistent pack of standard cards.

    private Card[] cards; // General deck array w cards
    private int topCard; // Index for topmost card

    // Explicit Constructor
    public Deck(int numPacks) {
        allocateMasterPack();

        if (numPacks > 0 && numPacks < 7) {
            this.cards = new Card [52 * numPacks];
            this.init(numPacks);
            this.topCard = (52 * numPacks) - 1;
        } else {
            // Same as Default Constructor
            this.cards = new Card [52];
            this.init(1);
            this.topCard = 51;
        } 
    }

    //Default Constructor. Assumes 1 Pack.
    public Deck() {
        allocateMasterPack();
        this.cards = new Card [52];
        this.topCard = 51;
        this.init(1);
    }

    /* init: Re-populate cards[] with the standard 52 × numPacks cards. Assumes that you only call init w the same number of initial packs.*/
    public void init(int numPacks) {

        // Outer for loop keeps track of how many packs are being added.
        for (int k = 0; k < numPacks * 52; k++) {

            this.cards[k] = new Card (masterPack [k % 52]);
        }
        this.topCard = (numPacks * 52) - 1; 
    }

    /* shuffle: Mixes up the cards with the help of the standard random number generator.*/
    public void shuffle() {
        int toShuffleCnt = 2;
        Random shuffleCards = new Random();
        // int size = cards.length + 1; //sets size of between 0 - topCard
        
        for (int j = 0; j < toShuffleCnt; j++) {
            /* Ex: For a single 52 card deck, this'll shuffle cards about 104 times.*/
            for (int i = 0; i < topCard; i++) {
                int change = shuffleCards.nextInt(topCard);
                
                Card temp = new Card (cards[i].getValue(), cards[i].getSuit());
                cards[i] = cards[change];
                cards[change] = temp;
            }
        }
    }

    /* dealCard: Returns and removes the card in the top occupied position of cards[]. Make sure there are still cards available.  This is an object copy, not a reference copy, since the source of the Card might destroy or change its data after it is sent out.*/
    Card dealCard() {
        if (topCard >= 0) { // At the last card, this would set it to -1
            // IF deck isn't empty
            Card toReturn = new Card(cards[topCard]);
            cards[topCard] = null; // Does something w old topCard
            topCard--;
            return toReturn;
        }
        // Deck is empty?
        return new Card('1', Card.Suit.SPADES); // TODO: Left for now
    }

    public int getTopCard() {
        return this.topCard;
    }

    /* inspectCard:  Accessor for an individual card. Returns a card with errorFlag = true if k is bad.*/
    public Card inspectCard(int k) {
        if (k < 0 || k > topCard) {
            // Incorect Case
            Card badCard = new Card('1', Card.Suit.SPADES);
            return badCard;
        }
        return cards[k]; // Correct Case
    }

    /* allocateMasterPack: Constructs a standard playing card deck to be copied from if needed. Even if many Deck objects are constructed in a given program, this will not allow itself to be executed more than once.*/
    private static void allocateMasterPack() {
        if (masterPack == null) {
            masterPack = new Card[52];

            // Card.Suit[] suitArray = new Card.Suit[]{Card.Suit.DIAMONDS, Card.Suit.HEARTS, Card.Suit.SPADES, Card.Suit.CLUBS};
            Card.Suit[] suitArray = Card.Suit.values();
            char[] charArray = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
            int masterIndex = 0; // could use i * 13 + j maybe
            for (int i = 0; i < suitArray.length; i++) {
                for (int j = 0; j < charArray.length; j++) {
                    masterPack[masterIndex] = new Card(charArray[j], suitArray[i]);
                    // System.out.println(masterPack[masterIndex] + " ");
                    masterIndex++;
                }
            }
        }
    }
}

/******************** Sample Output for Phase 3

K of SPADES / Q of SPADES / J of SPADES / T of SPADES / 9 of SPADES / 8 of SPADES / 7 of SPADES / 6 of SPADES / 5 of SPADES / 4 of SPADES / 3 of SPADES / 2 of SPADES / A of SPADES / K of HEARTS / Q of HEARTS / J of HEARTS / T of HEARTS / 9 of HEARTS / 8 of HEARTS / 7 of HEARTS / 6 of HEARTS / 5 of HEARTS / 4 of HEARTS / 3 of HEARTS / 2 of HEARTS / A of HEARTS / K of DIAMONDS / Q of DIAMONDS / J of DIAMONDS / T of DIAMONDS / 9 of DIAMONDS / 8 of DIAMONDS / 7 of DIAMONDS / 6 of DIAMONDS / 5 of DIAMONDS / 4 of DIAMONDS / 3 of DIAMONDS / 2 of DIAMONDS / A of DIAMONDS / K of CLUBS / Q of CLUBS / J of CLUBS / T of CLUBS / 9 of CLUBS / 8 of CLUBS / 7 of CLUBS / 6 of CLUBS / 5 of CLUBS / 4 of CLUBS / 3 of CLUBS / 2 of CLUBS / A of CLUBS / K of SPADES / Q of SPADES / J of SPADES / T of SPADES / 9 of SPADES / 8 of SPADES / 7 of SPADES / 6 of SPADES / 5 of SPADES / 4 of SPADES / 3 of SPADES / 2 of SPADES / A of SPADES / K of HEARTS / Q of HEARTS / J of HEARTS / T of HEARTS / 9 of HEARTS / 8 of HEARTS / 7 of HEARTS / 6 of HEARTS / 5 of HEARTS / 4 of HEARTS / 3 of HEARTS / 2 of HEARTS / A of HEARTS / K of DIAMONDS / Q of DIAMONDS / J of DIAMONDS / T of DIAMONDS / 9 of DIAMONDS / 8 of DIAMONDS / 7 of DIAMONDS / 6 of DIAMONDS / 5 of DIAMONDS / 4 of DIAMONDS / 3 of DIAMONDS / 2 of DIAMONDS / A of DIAMONDS / K of CLUBS / Q of CLUBS / J of CLUBS / T of CLUBS / 9 of CLUBS / 8 of CLUBS / 7 of CLUBS / 6 of CLUBS / 5 of CLUBS / 4 of CLUBS / 3 of CLUBS / 2 of CLUBS / A of CLUBS / 

K of SPADES / Q of DIAMONDS / 7 of HEARTS / 6 of DIAMONDS / J of DIAMONDS / 9 of DIAMONDS / 8 of CLUBS / 9 of SPADES / 9 of SPADES / 3 of HEARTS / T of CLUBS / 7 of DIAMONDS / 7 of HEARTS / 2 of DIAMONDS / Q of HEARTS / J of HEARTS / 8 of HEARTS / 3 of HEARTS / K of HEARTS / J of HEARTS / K of DIAMONDS / 2 of HEARTS / Q of HEARTS / 6 of HEARTS / 8 of SPADES / 4 of HEARTS / 6 of DIAMONDS / K of CLUBS / K of DIAMONDS / 4 of HEARTS / Q of DIAMONDS / T of HEARTS / Q of CLUBS / 6 of SPADES / 6 of CLUBS / K of SPADES / 2 of CLUBS / 5 of DIAMONDS / 9 of HEARTS / 8 of DIAMONDS / 2 of SPADES / J of DIAMONDS / 8 of SPADES / 2 of SPADES / 3 of CLUBS / 9 of HEARTS / 5 of DIAMONDS / 5 of CLUBS / Q of CLUBS / T of DIAMONDS / 8 of DIAMONDS / 2 of HEARTS / 6 of SPADES / T of DIAMONDS / 5 of HEARTS / 5 of CLUBS / J of CLUBS / K of HEARTS / 8 of CLUBS / 4 of CLUBS / A of CLUBS / 7 of CLUBS / T of SPADES / 3 of DIAMONDS / 9 of DIAMONDS / K of CLUBS / 3 of SPADES / 9 of CLUBS / A of DIAMONDS / 7 of CLUBS / 6 of CLUBS / J of CLUBS / T of HEARTS / T of SPADES / 4 of DIAMONDS / 3 of DIAMONDS / A of SPADES / 7 of SPADES / 3 of SPADES / 2 of DIAMONDS / A of CLUBS / 7 of DIAMONDS / J of SPADES / 2 of CLUBS / 6 of HEARTS / A of SPADES / Q of SPADES / 7 of SPADES / 5 of SPADES / 5 of HEARTS / J of SPADES / 4 of SPADES / 4 of SPADES / 4 of DIAMONDS / 5 of SPADES / 8 of HEARTS / Q of SPADES / T of CLUBS / A of HEARTS / A of HEARTS / 9 of CLUBS / 4 of CLUBS / 3 of CLUBS / A of DIAMONDS / 

K of SPADES / Q of SPADES / J of SPADES / T of SPADES / 9 of SPADES / 8 of SPADES / 7 of SPADES / 6 of SPADES / 5 of SPADES / 4 of SPADES / 3 of SPADES / 2 of SPADES / A of SPADES / K of HEARTS / Q of HEARTS / J of HEARTS / T of HEARTS / 9 of HEARTS / 8 of HEARTS / 7 of HEARTS / 6 of HEARTS / 5 of HEARTS / 4 of HEARTS / 3 of HEARTS / 2 of HEARTS / A of HEARTS / K of DIAMONDS / Q of DIAMONDS / J of DIAMONDS / T of DIAMONDS / 9 of DIAMONDS / 8 of DIAMONDS / 7 of DIAMONDS / 6 of DIAMONDS / 5 of DIAMONDS / 4 of DIAMONDS / 3 of DIAMONDS / 2 of DIAMONDS / A of DIAMONDS / K of CLUBS / Q of CLUBS / J of CLUBS / T of CLUBS / 9 of CLUBS / 8 of CLUBS / 7 of CLUBS / 6 of CLUBS / 5 of CLUBS / 4 of CLUBS / 3 of CLUBS / 2 of CLUBS / A of CLUBS / 

K of SPADES / 8 of HEARTS / 3 of CLUBS / A of SPADES / 2 of HEARTS / 9 of HEARTS / 4 of DIAMONDS / J of HEARTS / T of HEARTS / T of CLUBS / 2 of DIAMONDS / 8 of CLUBS / T of SPADES / 7 of DIAMONDS / A of DIAMONDS / 3 of HEARTS / 4 of CLUBS / 9 of SPADES / 8 of SPADES / A of HEARTS / Q of CLUBS / 4 of SPADES / J of CLUBS / 7 of SPADES / K of DIAMONDS / Q of HEARTS / 6 of SPADES / 7 of HEARTS / Q of SPADES / K of HEARTS / 5 of SPADES / A of CLUBS / 3 of DIAMONDS / 7 of CLUBS / 4 of HEARTS / 3 of SPADES / 2 of CLUBS / Q of DIAMONDS / 8 of DIAMONDS / 9 of DIAMONDS / 6 of DIAMONDS / 6 of HEARTS / T of DIAMONDS / 5 of DIAMONDS / J of SPADES / J of DIAMONDS / 9 of CLUBS / 2 of SPADES / 5 of CLUBS / K of CLUBS / 5 of HEARTS / 6 of CLUBS / 
Press any key to continue . . . 

*/