package com.example.warcardgame.objects;

public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;
    private String imgIconName;
    private int value;


    public Card (){

    }

    /**
     * This constructor produces a card
     * @param cardSuit The card symbol (HEART, CLUB, DIAMOND, SPADE)
     * @param cardRank The card number (TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE)
     */
    public Card(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
        setImgIconName(cardSuit,cardRank);
        setValueFromRank(cardRank);
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * This function gives a numerical value to any number of card
     * @param cardRank The card number (TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE)
     */
    public void setValueFromRank(CardRank cardRank){
        switch (cardRank){
            case TWO:
                this.setValue(2);
                break;
            case THREE:
                this.setValue(3);
                break;
            case FOUR:
                this.setValue(4);
                break;
            case FIVE:
                this.setValue(5);
                break;
            case SIX:
                this.setValue(6);
                break;
            case SEVEN:
                this.setValue(7);
                break;
            case EIGHT:
                this.setValue(8);
                break;
            case NINE:
                this.setValue(9);
                break;
            case TEN:
                this.setValue(10);
                break;
            case JACK:
                this.setValue(11);
                break;
            case QUEEN:
                this.setValue(12);
                break;
            case KING:
                this.setValue(13);
                break;
            case ACE:
                this.setValue(14);
                break;
        }
    }

    public String getImgIconName(){
        return this.imgIconName;
    }

    /**
     * This function initializes each image to its exact name
     * @param cardSuit  The card symbol (HEART, CLUB, DIAMOND, SPADE)
     * @param cardRank  The card number (TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE)
     */
    public void setImgIconName(CardSuit cardSuit, CardRank cardRank){
        if(cardSuit == CardSuit.HEART) {
            if (cardRank == CardRank.TWO) {
                this.imgIconName = "img_heart_two";
            } else if (cardRank == CardRank.THREE) {
                this.imgIconName = "img_heart_three";
            } else if (cardRank == CardRank.FOUR) {
                this.imgIconName = "img_heart_four";
            } else if (cardRank == CardRank.FIVE) {
                this.imgIconName = "img_heart_five";
            } else if (cardRank == CardRank.SIX) {
                this.imgIconName = "img_heart_six";
            } else if (cardRank == CardRank.SEVEN) {
                this.imgIconName = "img_heart_seven";
            } else if (cardRank == CardRank.EIGHT) {
                this.imgIconName = "img_heart_eight";
            } else if (cardRank == CardRank.NINE) {
                this.imgIconName = "img_heart_nine";
            }else if(cardRank == CardRank.TEN){
                this.imgIconName = "img_heart_ten";
            }else if(cardRank == CardRank.JACK){
                this.imgIconName = "img_heart_jack";
            }else if(cardRank == CardRank.QUEEN){
                this.imgIconName = "img_heart_queen";
            }else if(cardRank == CardRank.KING){
                this.imgIconName = "img_heart_king";
            }else if(cardRank == CardRank.ACE){
                this.imgIconName = "img_heart_ace";
            }

        }else if(cardSuit == CardSuit.CLUB){
            if (cardRank == CardRank.TWO) {
                this.imgIconName = "img_club_two";
            } else if (cardRank == CardRank.THREE) {
                this.imgIconName = "img_club_three";
            } else if (cardRank == CardRank.FOUR) {
                this.imgIconName = "img_club_four";
            } else if (cardRank == CardRank.FIVE) {
                this.imgIconName = "img_club_five";
            } else if (cardRank == CardRank.SIX) {
                this.imgIconName = "img_club_six";
            } else if (cardRank == CardRank.SEVEN) {
                this.imgIconName = "img_club_seven";
            } else if (cardRank == CardRank.EIGHT) {
                this.imgIconName = "img_club_eight";
            } else if (cardRank == CardRank.NINE) {
                this.imgIconName = "img_club_nine";
            }else if(cardRank == CardRank.TEN){
                this.imgIconName = "img_club_ten";
            }else if(cardRank == CardRank.JACK){
                this.imgIconName = "img_club_jack";
            }else if(cardRank == CardRank.QUEEN){
                this.imgIconName = "img_club_queen";
            }else if(cardRank == CardRank.KING){
                this.imgIconName = "img_club_king";
            }else if(cardRank == CardRank.ACE){
                this.imgIconName = "img_club_ace";
            }

        }else if(cardSuit == CardSuit.DIAMOND) {
            if (cardRank == CardRank.TWO) {
                this.imgIconName = "img_diamond_two";
            } else if (cardRank == CardRank.THREE) {
                this.imgIconName = "img_diamond_three";
            } else if (cardRank == CardRank.FOUR) {
                this.imgIconName = "img_diamond_four";
            } else if (cardRank == CardRank.FIVE) {
                this.imgIconName = "img_diamond_five";
            } else if (cardRank == CardRank.SIX) {
                this.imgIconName = "img_diamond_six";
            } else if (cardRank == CardRank.SEVEN) {
                this.imgIconName = "img_diamond_seven";
            } else if (cardRank == CardRank.EIGHT) {
                this.imgIconName = "img_diamond_eight";
            } else if (cardRank == CardRank.NINE) {
                this.imgIconName = "img_diamond_nine";
            } else if (cardRank == CardRank.TEN) {
                this.imgIconName = "img_diamond_ten";
            } else if (cardRank == CardRank.JACK) {
                this.imgIconName = "img_diamond_jack";
            } else if (cardRank == CardRank.QUEEN) {
                this.imgIconName = "img_diamond_queen";
            } else if (cardRank == CardRank.KING) {
                this.imgIconName = "img_diamond_king";
            } else if (cardRank == CardRank.ACE) {
                this.imgIconName = "img_diamond_ace";
            }

        }else if(cardSuit == CardSuit.SPADE){
            if(cardRank == CardRank.TWO){
                this.imgIconName="img_spade_two";
            }else if(cardRank == CardRank.THREE){
                this.imgIconName="img_spade_three";
            }else if(cardRank == CardRank.FOUR){
                this.imgIconName = "img_spade_four";
            }else if(cardRank == CardRank.FIVE){
                this.imgIconName = "img_spade_five";
            }else if(cardRank == CardRank.SIX){
                this.imgIconName = "img_spade_six";
            }else if(cardRank == CardRank.SEVEN){
                this.imgIconName = "img_spade_seven";
            }else if(cardRank == CardRank.EIGHT){
                this.imgIconName = "img_spade_eight";
            }else if(cardRank == CardRank.NINE){
                this.imgIconName = "img_spade_nine";
            }else if(cardRank == CardRank.TEN){
                this.imgIconName = "img_spade_ten";
            }else if(cardRank == CardRank.JACK){
                this.imgIconName = "img_spade_jack";
            }else if(cardRank == CardRank.QUEEN){
                this.imgIconName = "img_spade_queen";
            }else if(cardRank == CardRank.KING){
                this.imgIconName = "img_spade_king";
            }else if(cardRank == CardRank.ACE){
                this.imgIconName = "img_spade_ace";
            }
        }
    }
}
