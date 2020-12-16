package com.example.warcardgame.objects;

public class Player {
    private String name;
    private Hand hand;
    private int score = 0;

    public Player(){

    }

    /**
     * This constructor initializes an Player
     * @param name  Name of the player
     * @param hand  A hand that contains a deck of cards
     */
    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
