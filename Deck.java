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

///////////////////////////////////////////////////////////////////////////////////////////////////

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

        // Variables / Componenents
        Deck myDeck = new Deck();
        Frame frame = new Frame("Card Game");
        Button randomBtn = new Button("Random");
        Button shuffleBtn = new Button("Shuffle");
        Button clearBtn = new Button("Clear");
        Label label = new Label();
        final List list = new List(52);
        List output = new List(52);

        // Set bounds for components.
        randomBtn.setBounds(100, 270, 100, 30);
        shuffleBtn.setBounds(300, 270, 100, 30);
        clearBtn.setBounds(500, 270, 100, 30);
        list.setBounds(100, 100, 150, 150);
        output.setBounds(500, 100, 150, 150);
        label.setBounds(100, 310, 200, 30);

        // Add the cards to the list.
        for (int i = 0; i < 52; i++) {
                list.add(myDeck.cards.get(i).toString());
        }

        // When clicking the shuffle button, a random card will be choosen.
        randomBtn.addActionListener((ActionEvent e) -> {
            int randomNum = (int)(Math.random() * 52);
            String randomCard = myDeck.cards.get(randomNum).toString();
            label.setText("Card: " + randomCard);
        });

        // Shuffle the deck of cards.
        shuffleBtn.addActionListener((ActionEvent e) -> {
            myDeck.shuffleDeck();
            for (int i = 0; i < 52; i++) {
                output.add(myDeck.cards.get(i).toString());
            }
        });

        // Clear the list of shuffled cards.
        clearBtn.addActionListener((ActionEvent e) -> {
            output.clear();
        });

        // Add components (?) to the frame.
        frame.add(randomBtn);
        frame.add(list);
        frame.add(label);
        frame.add(output);
        frame.add(shuffleBtn);
        frame.add(clearBtn);

        // Set frame properties.
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