package main;

import java.util.LinkedList;

public class LinksGameModel {

    private final LinkedList<Integer> linkedList;
    private int playerOneScore;
    private int playerTwoScore;
    private boolean playerOnesTurn;

    public LinksGameModel(LinkedList<Integer> linkedList) {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.playerOnesTurn = true;
        this.linkedList = linkedList;
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public boolean isPlayerOnesTurn() {
        return playerOnesTurn;
    }

    public void setPlayerOnesTurn(boolean playerOnesTurn) {
        this.playerOnesTurn = playerOnesTurn;
    }
}
