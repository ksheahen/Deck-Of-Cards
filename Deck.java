// Code Challenge for Interview: Design the objects for a deck of cards
// 13 cards, 4 suits
// No jokers
// Optional: shuffling and i think the second option was a game

import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Suit constants
enum Suits {
    SPADES,
    DIAMONDS,
    CLUBS,
    HEARTS
}

// Rank constants
enum Ranks {
    ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
    JACK, QUEEN, KING
}

// Class to create each card.
class Card {
    
    Suits suit;
    Ranks rank;
    
    // Constructor.
    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // toString method for output purposes.
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}


public class Deck {

    // Declare ArrayList (vector) to store card objects in.
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        // For each suit, create 13 cards and add it to the ArrayList cards.
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    
    }

    // Output the deck of cards.
    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    // Shuffle the deck using the Collections.shuffle() method.
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }


    public static void main(String[] args) {
        // Create a new Deck object, shuffle it, and output it.
        // Deck myDeck = new Deck();
        // myDeck.shuffleDeck();
        // myDeck.printDeck();

        Frame frame = new Frame("Card Game");
        Label label = new Label("Hello World");

        label.setAlignment(Label.CENTER);
        frame.add(label);
        frame.setSize(300, 300);

        frame.setVisible(true);

        // Exits the program upon closing the window.
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}