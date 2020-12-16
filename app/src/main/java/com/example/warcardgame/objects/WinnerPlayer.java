package com.example.warcardgame.objects;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import java.util.Date;

public class WinnerPlayer implements Comparable<WinnerPlayer> {
    private String playerName;
    private int score;
    private String date;
    private double longitude;
    private double latitude;
    private MoveActivity moveActivity;

    public WinnerPlayer() {
    }

    /**
     * This constructor initializes a winning player
     * @param playerName    Name of the winning player
     * @param score The score of the winning player
     * @param moveActivity  Which window to move to
     */
    public WinnerPlayer(String playerName , int score, MoveActivity moveActivity) {
        this.playerName = playerName;
        this.score = score;
        this.moveActivity = moveActivity;
    }



    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MoveActivity getMoveActivity() {
        return moveActivity;
    }

    public void setMoveActivity(MoveActivity moveActivity) {
        this.moveActivity = moveActivity;
    }

    @Override
    public int compareTo(WinnerPlayer o) {
        return playerName.compareTo(o.playerName);
    }

    /**
     * This function checks whether the object is of the same type
     * @param obj   Winner player type object
     * @return  true or false
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return getPlayerName().equals(((WinnerPlayer) obj).playerName);
    }
}
