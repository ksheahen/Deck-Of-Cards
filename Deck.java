// Code Challenge for Interview: Design the objects for a deck of cards
// 13 cards, 4 suits
// No jokers
// Optional: shuffling and i think the second option was a game

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

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
        Deck myDeck = new Deck();
        Frame frame = new Frame("Card Game");
        Button shuffleBtn = new Button("Shuffle");
        Label label = new Label();
        final List list = new List(52);

        shuffleBtn.setBounds(100, 270, 100, 30);
        list.setBounds(100, 100, 150, 150);
        label.setBounds(100, 310, 150, 20);

        for (int i = 0; i < 52; i++) {
                list.add(myDeck.cards.get(i).toString());
        }

        shuffleBtn.addActionListener((ActionEvent e) -> {
            int randomNum = (int)(Math.random() * 52);
            String randomCard = myDeck.cards.get(randomNum).toString();
            label.setText("Card: " + randomCard);
        });

        frame.add(shuffleBtn);
        frame.add(list);
        frame.add(label);

        frame.setSize(800, 800);
        frame.setLayout(null);
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