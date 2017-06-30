package org.peidevs.waro.player;

public class Bid {
    private final int prizeCard;
    private final int offer;
    private final Player bidder;

    public Bid(int prizeCard, int offer, Player bidder) {
        this.prizeCard = prizeCard;
        this.offer = offer;
        this.bidder = bidder;
    }

    public int getPrizeCard() { return prizeCard; }
    public int getOffer() { return offer; }
    public Player getBidder() { return bidder; }
}
