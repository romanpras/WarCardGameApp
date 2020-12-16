package com.example.warcardgame.objects;

public class RetrieveData {
    private String player1ImgIconName;
    private String player2ImgIconName;
    private Player player1;
    private Player player2;
    private WinnerPlayer winner = null;

    public RetrieveData() {

    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getPlayer1ImgIconName() {
        return player1ImgIconName;
    }

    public String getPlayer2ImgIconName() {
        return player2ImgIconName;
    }

    public WinnerPlayer getWinnerPlayer() {
        return winner;
    }

    public void setPlayer1ImgIconName(String player1ImgIconName) {
        this.player1ImgIconName = player1ImgIconName;
    }

    public void setPlayer2ImgIconName(String player2ImgIconName) {
        this.player2ImgIconName = player2ImgIconName;
    }

    public void setWinnerPlayer(WinnerPlayer winner) {
        this.winner = winner;
    }
}
