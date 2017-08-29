package org.peidevs.waro.player;

import org.peidevs.waro.strategy.Strategy;
import org.peidevs.waro.strategy.impl.*;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class PlayerTest {

    @Test
    public void testReset_Basic() {
        Strategy strategy = new MaxCard();
        int maxCard = 40;
        int prizeCard = 10;
        List<Integer> cards = IntStream.range(1,5).boxed().collect(toList());
        Hand hand = new Hand(cards);
        Player player = new Player("Randy", strategy, maxCard, hand);
        Bid bid = player.getBid(prizeCard);
        player = player.winsRound(bid);
        assertEquals(3, player.getNumCardsInHand());
        assertEquals(1, player.getPlayerStats().getNumRoundsWon());

        List<Integer> newCards = IntStream.range(6,8+1).boxed().collect(toList());
        Hand newHand = new Hand(newCards);

        // test
        Player result = player.reset(newHand);

        assertEquals(3, result.getNumCardsInHand());
        assertEquals(0, result.getPlayerStats().getNumRoundsWon());
    }

    @Test
    public void testGetBid_Basic() {
        Strategy strategy = new MaxCard();
        int maxCard = 40;
        int prizeCard = 10;
        List<Integer> cards = IntStream.range(1,5).boxed().collect(toList());
        Hand hand = new Hand(cards);
        Player player = new Player("Randy", strategy, maxCard, hand);

        // test
        Bid bid = player.getBid(prizeCard);

        assertEquals(player, bid.getBidder());
        assertEquals(4, bid.getOffer());
        assertEquals(prizeCard, bid.getPrizeCard());
   }
}
