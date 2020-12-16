package com.example.warcardgame.objects;


public class GameManager {
    private Player player1;
    private Player player2;
    private RetrieveData retrieveData = new RetrieveData();

    public GameManager() {

    }

    /**
     * This function initialize two players
     * @param playerNameOne String name one
     * @param playerNameTwo String name two
     */

    public void initGame(String playerNameOne,String playerNameTwo){
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck);
        hand1.splitDeckToHand(0,26);
        Hand hand2 = new Hand(deck);
        hand2.splitDeckToHand(26,52);
        player1 = new Player(playerNameOne,hand1);
        player2 = new Player(playerNameTwo,hand2);

    }

    /**
     * This function performs one step of the game
     * @return RetrieveDate object that contain parameters of each player
     */
    public RetrieveData gameStep(){
        if(!player1.getHand().isEmpty()){
            Card[] cards = getTwoCardsFromPlayers();
            compareAndUpdateScore(cards);
            retrieveData.setPlayer1ImgIconName(cards[0].getImgIconName());
            retrieveData.setPlayer2ImgIconName(cards[1].getImgIconName());
            retrieveData.setPlayer1(player1);
            retrieveData.setPlayer2(player2);
        }else {
            retrieveData.setWinnerPlayer(checkWinner());
        }
        return retrieveData;
    }


    /**
     * This function get two cards from the hand (26 cards), initialize
     * and remove them from the pack
     * @return Array of two cards from two players
     */
    public Card[] getTwoCardsFromPlayers(){
        Card[] cards = new Card[2];
        cards[0] = player1.getHand().getCardFromHand(0);
        player1.getHand().getCardsInHand().remove(0);
        cards[1] = player2.getHand().getCardFromHand(0);
        player2.getHand().getCardsInHand().remove(0);
        return cards;
    }

    /**
     * This function compare between the value of 2 cards and
     * update the score of the players
     * @param cards Array of two cards from two players
     */
    public void compareAndUpdateScore(Card[] cards){
        if(cards[0].getValue() > cards[1].getValue())
            player1.setScore(1);
        else if(cards[1].getValue() > cards[0].getValue())
            player2.setScore(1);
    }

    /**
     * This function check if the game end with wining (who is the winner) or draw
     * @return WinnerPlayer
     */
    public WinnerPlayer checkWinner() {
        //Player 1 winner
        if (player1.getScore() > player2.getScore()) {
            return new WinnerPlayer(player1.getName(),player1.getScore(), MoveActivity.WINNER);
            //Player 2 winner
        } else if(player1.getScore() < player2.getScore()){
            return new WinnerPlayer(player2.getName(),player2.getScore(), MoveActivity.WINNER);
        }else
            return new WinnerPlayer(player1.getName(),player1.getScore(), MoveActivity.DRAW);
    }
}
