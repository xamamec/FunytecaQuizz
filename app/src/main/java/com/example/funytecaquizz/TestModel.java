package com.example.funytecaquizz;

public class TestModel {

    private String testID;
    private int topScore;
    private int tempo;

    public TestModel(String testID, int topScore, int tempo) {
        this.testID = testID;
        this.topScore = topScore;
        this.tempo = tempo;
    }

    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public int getTopScore() {
        return topScore;
    }

    public void setTopScore(int topScore) {
        this.topScore = topScore;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
