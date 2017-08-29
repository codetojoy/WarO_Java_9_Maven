package org.peidevs.waro.table;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

import org.peidevs.waro.player.*;
import org.peidevs.waro.strategy.*;

public class DealerTest {
    private final Strategy strategy = Strategies.getMaxCardStrategy();

    @Test
    public void testDeal_Table_Basic() {
        Dealer dealer = new Dealer();

        int numCards = 12;
        int maxCard = numCards;
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

        // test (use new numCards value)
        Table table = dealer.deal(20, players);

        assertEquals(5, table.getKitty().cardsAsIntStream().count());
        assertEquals(5, table.getPlayers().get(0).getNumCardsInHand());
        assertEquals(5, table.getPlayers().get(1).getNumCardsInHand());
        assertEquals(5, table.getPlayers().get(2).getNumCardsInHand());
    }

    @Test
    public void testDeal_Basic() {
        Dealer dealer = new Dealer();
        int numCards = 40;
        int numPlayers = 4;

        // test
        Stream<Hand> hands = dealer.deal(numCards, numPlayers);
        
        List<Hand> handList = hands.collect(toList());
        assertEquals(8, handList.get(0).cardsAsIntStream().count());
        assertEquals(8, handList.get(1).cardsAsIntStream().count());
        assertEquals(8, handList.get(2).cardsAsIntStream().count());
        assertEquals(8, handList.get(3).cardsAsIntStream().count());
        assertEquals(8, handList.get(4).cardsAsIntStream().count());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDeal_Uneven() {
        Dealer dealer = new Dealer();
        int numCards = 42;
        int numPlayers = 4;

        // test
        dealer.deal(numCards, numPlayers);        
    }

    @Test
    public void testBuildShuffledDeck() {
        Dealer dealer = new Dealer();
        int numCards = 4;
        
        // test
        List<Integer> result = dealer.buildShuffledDeck(numCards);
        
        assertEquals(4, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
    }

}
