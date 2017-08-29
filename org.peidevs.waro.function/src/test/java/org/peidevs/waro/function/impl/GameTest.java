package org.peidevs.waro.function.impl;

import org.peidevs.waro.player.*;
import org.peidevs.waro.strategy.*;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class GameTest {
    private final Strategy strategy = Strategies.getNextCardStrategy();

    @Test
    public void testApply_Basic() {
        int numCards = 12;
        int maxCard = numCards;
        List<Player> players = new ArrayList<>();
        
        Player p1 = new Player("p1", strategy, maxCard, new Hand());
        Player p2 = new Player("p2", strategy, maxCard, new Hand());
        Player p3 = new Player("p3", strategy, maxCard, new Hand());
        
        players.add(p1);
        players.add(p2);
        players.add(p3);
                
        // test
        List<Player> newPlayers = new Game(numCards, false).apply(players);
        
        assertEquals(3, newPlayers.size());
        assertEquals(0, newPlayers.get(0).getNumCardsInHand());
        assertEquals(0, newPlayers.get(1).getNumCardsInHand());
        assertEquals(0, newPlayers.get(2).getNumCardsInHand());
        assertEquals(1, newPlayers.stream().filter(p -> p.getPlayerStats().getNumGamesWon() == 1).count());
        assertEquals(2, newPlayers.stream().filter(p -> p.getPlayerStats().getNumGamesWon() == 0).count());
        int maxTotal = maxCard + (maxCard - 1) + (maxCard - 2);
        assertEquals(3, newPlayers.stream().filter(p -> p.getPlayerStats().getTotal() <= maxTotal).count());
        assertEquals(3, newPlayers.stream().map(p -> p.getPlayerStats().getNumRoundsWon()).mapToInt(i->i).sum());                
    }

    @Test
    public void testPlay_Basic() {
        int numCards = 12;
        int maxCard = numCards;
        List<Player> players = new ArrayList<>();
        
        Hand h1 = new Hand(Arrays.asList(new Integer[]{1,5,9}));
        Player p1 = new Player("p1", strategy, maxCard, h1);

        Hand h2 = new Hand(Arrays.asList(new Integer[]{4,8,6}));
        Player p2 = new Player("p2", strategy, maxCard, h2);

        Hand h3 = new Hand(Arrays.asList(new Integer[]{7,2,3}));
        Player p3 = new Player("p3", strategy, maxCard, h3);
        
        players.add(p1);
        players.add(p2);
        players.add(p3);
        
        Hand kitty = new Hand(Arrays.asList(new Integer[]{10,11,12}));
        
        // test
        List<Player> newPlayers = new Game(numCards, false).play(kitty, players.stream()).collect(toList());
        
        assertEquals(3, newPlayers.size());
        assertEquals(0, newPlayers.get(0).getNumCardsInHand());
        assertEquals(0, newPlayers.get(1).getNumCardsInHand());
        assertEquals(0, newPlayers.get(2).getNumCardsInHand());
        assertEquals(3, newPlayers.stream().filter(p -> p.getPlayerStats().getNumRoundsWon() == 1).count());
        assertEquals(1, newPlayers.stream().filter(p -> p.getPlayerStats().getTotal() == 10).count());
        assertEquals(1, newPlayers.stream().filter(p -> p.getPlayerStats().getTotal() == 11).count());
        assertEquals(1, newPlayers.stream().filter(p -> p.getPlayerStats().getTotal() == 12).count());
    }
}
