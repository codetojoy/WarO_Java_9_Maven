package org.peidevs.waro.player;

public class PlayerStats {
    private final int total;
    private final int numGamesWon;
    private final int numRoundsWon;

    public PlayerStats() {
        this(0,0,0);
    }

    private PlayerStats(int total, int numGamesWon, int numRoundsWon) {
        this.total = total;
        this.numGamesWon = numGamesWon;
        this.numRoundsWon = numRoundsWon;
    }

    public String toString() {
        return " total: " + total + " # games: " + numGamesWon + " # rounds: " + numRoundsWon;
    }

    public int getTotal() { return total; }

    public int getNumRoundsWon() { return numRoundsWon; }

    public int getNumGamesWon() { return numGamesWon; }

    public PlayerStats winsGame() {
        PlayerStats newPlayerStats = new PlayerStats(this.total, this.numGamesWon + 1, this.numRoundsWon);
        return newPlayerStats;
    }

    public PlayerStats winsRound(int prizeCard) {
        PlayerStats newPlayerStats = new PlayerStats(this.total + prizeCard, this.numGamesWon, this.numRoundsWon + 1);
        return newPlayerStats;
    }

    public PlayerStats reset() {
        PlayerStats newPlayerStats = new PlayerStats(0, this.numGamesWon, 0);
        return newPlayerStats;
    }
}
