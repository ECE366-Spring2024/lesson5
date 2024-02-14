package com.example.inclass.rps;

import com.example.inclass.rps.util.DataTransferObject;

public class Game implements DataTransferObject {
    private int gameId;
    private String p1;
    private String p2;
    private int numTurns;
    private int currentTurn;
    private int p1Pts;
    private int p2Pts;
    private String winner;

    @Override
    public String getPlayerName() {
        // SHOULD FIX
        return "BAD!!!";
    }

    public int getGameId() {
        return gameId;
    }


    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public int getNumTurns() {
        return numTurns;
    }

    public void setNumTurns(int numTurns) {
        this.numTurns = numTurns;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getP1Pts() {
        return p1Pts;
    }

    public void setP1Pts(int p1Pts) {
        this.p1Pts = p1Pts;
    }

    public int getP2Pts() {
        return p2Pts;
    }

    public void setP2Pts(int p2Pts) {
        this.p2Pts = p2Pts;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", p1='" + p1 + '\'' +
                ", p2='" + p2 + '\'' +
                ", numTurns=" + numTurns +
                ", currentTurn=" + currentTurn +
                ", p1Pts=" + p1Pts +
                ", p2Pts=" + p2Pts +
                ", winner='" + winner + '\'' +
                '}';
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
