package org.peidevs.waro.player;

import java.util.List;

import org.peidevs.waro.strategy.Strategy;

public class Player {
    private final String name;
    private final Strategy strategy;
    private final PlayerStats playerStats;
    private final int maxCard;
    private final Hand hand;

    public Player(String name, Strategy strategy, int maxCard) {
        this(name, strategy, maxCard, new Hand(), new PlayerStats());
    }

    public Player(String name, Strategy strategy, int maxCard, Hand hand) {
        this(name, strategy, maxCard, hand, new PlayerStats());
    }

    private Player(String name, Strategy strategy, int maxCard, Hand hand, PlayerStats playerStats) {
        this.name = name;
        this.strategy = strategy;
        this.maxCard = maxCard;
        this.hand = hand;
        this.playerStats = playerStats;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public String toString() {
        return "name: " + name + " stats: " + playerStats.toString() + " hand: " + hand.toString();
    }

    public String toString(int numGames) {
        return "name: " + name + " won: " + playerStats.getNumGamesWon() + " of " + numGames + " games";
    }

    public int getNumGamesWon() { return playerStats.getNumGamesWon(); }

    public int getTotal() { return playerStats.getTotal(); }

    public String getName() { return name; }

    public Player winsGame() {
        PlayerStats newPlayerStats = playerStats.winsGame();
        Player newPlayer = new Player(name, strategy, maxCard, hand, newPlayerStats);
        return newPlayer;
    }

    public Player winsRound(Bid bid) {
        Hand newHand = hand.select(bid.getOffer());
        PlayerStats newPlayerStats = playerStats.winsRound(bid.getPrizeCard());
        Player newPlayer = new Player(name, strategy, maxCard, newHand, newPlayerStats);
        return newPlayer;
    }

    public Player losesRound(Bid bid) {
        Hand newHand = hand.select(bid.getOffer());
        Player newPlayer = new Player(name, strategy, maxCard, newHand, this.playerStats);
        return newPlayer;
    }

    public Bid getBid(int prizeCard) {
        int offer = strategy.selectCard(prizeCard, hand.cardsAsIntStream(), maxCard);
        // TODO: ensure that offer is contained in hand ! (no cheaters)

        Bid bid = new Bid(prizeCard, offer, this);

        return bid;
    }

    public long getNumCardsInHand() {
        return hand.cardsAsIntStream().boxed().count();
    }

    public Player reset(Hand newHand) {
        PlayerStats newPlayerStats = playerStats.reset();
        Player newPlayer = new Player(name, strategy, maxCard, newHand, newPlayerStats);
        return newPlayer;
    }
}
