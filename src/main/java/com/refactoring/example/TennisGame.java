package com.refactoring.example;

public class TennisGame {

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[p1];
            ScoreBoard.Display((p1 == p2) ? s + "-All" : s + "-" + p[p2]);
            return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
        } else {
            if (p1 == p2)
                return "Deuce";
            s = p1 > p2 ? p1N : p2N;
            ScoreBoard.Display(((p1 - p2) * (p1 - p2) == 1) ? "Advantage " + s : "Win for " + s);
            return ((p1 - p2) * (p1 - p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    // report the score to the scoreboard
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            updateValue("p1", 1);
        else
            updateValue("p2", 1);
    }

    private void updateValue(String name, int value)  {
        if(name == "p1"){
            try {
                this.getClass().getDeclaredField(name).set(this, this.getClass().getDeclaredField(name).getInt(this) + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return;
        }
        if(name == "p2"){
            try {
                this.getClass().getDeclaredField(name).set(this, this.getClass().getDeclaredField(name).getInt(this) + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return;
        }
        throw new RuntimeException("Should never reach here!");
    }

}

