package com.example.warcardgame.objects;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private CardSuit cardSuit;
    private CardRank cardRank;
    private ArrayList<Card> deck;

    /**
     * This constructor calls a function that initializes a deck that holds an array of cards
     */
    public Deck() {
        this.deck = new ArrayList<Card>();
        createNewDeck();
    }

    public int deckSize(){
        return deck.size();
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card getCardFromDeck(int index){
        return deck.get(index);
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    /**
     * This function initializes a deck that holds an array of cards and shuffle the deck
     */
    public void createNewDeck(){
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardSuit, cardRank);
                deck.add( new Card(cardSuit, cardRank));
            }
        }
        //Shuffling the cards
        Collections.shuffle(deck);
    }
}

