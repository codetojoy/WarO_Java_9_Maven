package org.peidevs.waro.function.impl;

import org.peidevs.waro.player.Player;
import org.peidevs.waro.player.Bid;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class Round implements UnaryOperator<Stream<Player>> {
    private final int prizeCard;

    public Round(int prizeCard) {
        this.prizeCard = prizeCard;
    }

    protected Round() {
        this.prizeCard = -1;
    }

    @Override
    public Stream<Player> apply(Stream<Player> players) {
        List<Bid> bids = getAllBids(players, prizeCard);

        Bid winningBid = findWinningBid(bids);

        Player newWinner = winningBid.getBidder().winsRound(winningBid);

        String winner = winningBid.getBidder().getName();

        Stream<Player> result = Stream.concat( Stream.of(newWinner),
                                               bids.stream()
                                                   .filter(b -> ! b.getBidder().getName().equals(winner))
                                                   .map(b -> b.getBidder().losesRound(b)));

        return result;
    }

    // --------- internal

    protected List<Bid> getAllBids(Stream<Player> players, int prizeCard) {
        return players.map(p -> p.getBid(prizeCard)).collect(toList());
    }

    protected Bid findWinningBid(List<Bid> bids) {
        Bid winningBid = bids.stream().max( comparing(Bid::getOffer) ).get();
        return winningBid;
    }
}
