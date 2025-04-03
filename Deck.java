// Code Challenge for Interview: Design the objects for a deck of cards
// 13 cards, 4 suits
// No jokers
// Optional: shuffling and i think the second option was a game

import java.util.ArrayList;

// Suit constants
enum Suits {
    SPADES,
    DIAMONDS,
    CLUBS,
    HEARTS
}

// Class to create each card.
class Card {
    
    Suits suit;
    int value;
    
    // Constructor.
    public Card(Suits suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // toString method for output purposes.
    @Override
    public String toString() {
        return value + " of " + suit;
    }
}


public class Deck {

    // Declare ArrayList (vector) to store card objects in.
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        // For each suit, create 13 cards and add it to the ArrayList cards.
        for (Suits suit : Suits.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Card(suit, i));
            }
        }
    
    }

    // Output the deck of cards.
    public void printDeck() {
        for (Card card: cards) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        // Create a new Deck object and output it.
        Deck myDeck = new Deck();
        myDeck.printDeck();
    }
}