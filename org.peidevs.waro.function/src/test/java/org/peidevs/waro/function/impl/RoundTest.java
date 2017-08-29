package org.peidevs.waro.function.impl;

import org.peidevs.waro.player.*;
import org.peidevs.waro.strategy.Strategy;
import org.peidevs.waro.strategy.impl.*;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class RoundTest {

    @Test
    public void testApply_Basic() {
        int numCards = 12;
        int maxCard = numCards;
        Strategy strategy = new MaxCard();
        List<Player> players = new ArrayList<>();
        
        Hand h1 = new Hand(Arrays.asList(new Integer[]{1,2,3}));
        Player p1 = new Player("p1", strategy, maxCard, h1);

        Hand h2 = new Hand(Arrays.asList(new Integer[]{4,5,6}));
        Player p2 = new Player("p2", strategy, maxCard, h2);

        Hand h3 = new Hand(Arrays.asList(new Integer[]{7,8,9}));
        Player p3 = new Player("p3", strategy, maxCard, h3);
        
        players.add(p1);
        players.add(p2);
        players.add(p3);
        
        int prizeCard = 10;
        
        // test
        List<Player> newPlayers = new Round(prizeCard).apply(players.stream()).collect(toList());
        
        assertEquals(3, newPlayers.size());
        assertEquals(2, newPlayers.get(0).getNumCardsInHand());
        assertEquals(2, newPlayers.get(1).getNumCardsInHand());
        assertEquals(2, newPlayers.get(2).getNumCardsInHand());
        assertEquals(1, newPlayers.stream().filter(p -> p.getPlayerStats().getNumRoundsWon() == 1).count());
        assertEquals(1, newPlayers.stream().filter(p -> p.getPlayerStats().getTotal() == 10).count());
        assertEquals(2, newPlayers.stream().filter(p -> p.getPlayerStats().getNumRoundsWon() == 0).count());
        assertEquals(2, newPlayers.stream().filter(p -> p.getPlayerStats().getTotal() == 0).count());
    }

    @Test
    public void testGetAllBids_Basic() {
        Round round = new Round();
        int numCards = 12;
        int maxCard = numCards;
        Strategy strategy = new MaxCard();
        List<Player> players = new ArrayList<>();
        
        Hand h1 = new Hand(Arrays.asList(new Integer[]{1,2,3}));
        Player p1 = new Player("p1", strategy, maxCard, h1);

        Hand h2 = new Hand(Arrays.asList(new Integer[]{4,5,6}));
        Player p2 = new Player("p2", strategy, maxCard, h2);

        Hand h3 = new Hand(Arrays.asList(new Integer[]{7,8,9}));
        Player p3 = new Player("p3", strategy, maxCard, h3);
        
        players.add(p1);
        players.add(p2);
        players.add(p3);
        
        // test
        List<Bid> result = round.getAllBids(players.stream(), 10);
        
        assertEquals(3, result.size());
    }
    
    @Test
    public void testFindWinningBid_Basic() {
        Round round = new Round();
        int maxCard = 50;
        Strategy strategy = new MaxCard();
        
        Player p1 = new Player("Beethoven", strategy, maxCard, new Hand());
        Player p2 = new Player("Chopin", strategy, maxCard, new Hand());
        Player p3 = new Player("Mozart", strategy, maxCard, new Hand());
        
        int prizeCard = 20;
        List<Bid> bids = new ArrayList<>();
        bids.add( new Bid(prizeCard, 10, p1) );
        bids.add( new Bid(prizeCard, 12, p2) );
        bids.add( new Bid(prizeCard, 14, p3) );
        
        // test
        Bid result = round.findWinningBid(bids);
        
        assertEquals("Mozart", result.getBidder().getName());
    }
}
