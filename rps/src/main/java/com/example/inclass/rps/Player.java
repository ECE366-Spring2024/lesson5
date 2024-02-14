package com.example.inclass.rps;

import com.example.inclass.rps.util.DataTransferObject;

public class Player implements DataTransferObject {

    private String playerName;
    private String password;
    private int wins;

    @Override
    public String getPlayerName() {
        return playerName;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName=" + playerName +
                ", password='" + password + '\'' +
                ", wins='" + wins + '\'' +
                '}';
    }
}