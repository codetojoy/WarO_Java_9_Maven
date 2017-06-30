package org.peidevs.waro.table;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;

import org.peidevs.waro.player.Player;
import org.peidevs.waro.player.Hand;

public class Dealer {

    public Table deal(int numCards, List<Player> players) {
        Table table = null;

        List<Hand> hands = deal(numCards, players.size()).collect(toList());
        Hand kitty = hands.remove(0);
        List<Player> newPlayers = new ArrayList<>();

        for (int i = 0; i < hands.size(); i++) {
            Player player = players.get(i);
            Hand hand = hands.get(i);
            newPlayers.add( player.reset(hand) );
        }

        table = new Table(newPlayers, kitty);

        return table;
    }

    // ------- internal

    protected Stream<Hand> deal(int numCards, int numPlayers) {
        int numGroups = numPlayers + 1; // include kitty
        assertEvenNumberOfCards(numCards, numGroups);

        List<Integer> deck = buildShuffledDeck(numCards);
        int numCardsPerHand = numCards / numGroups;

        // TODO: is there a way to partition using Java 8 ?
        Stream<Hand> hands = Lists.partition(deck, numCardsPerHand).stream().map(cards -> new Hand(cards));

        return hands;
    }

    protected List<Integer> buildShuffledDeck(int numCards) {
        List<Integer> cards = IntStream.range(1,numCards+1).boxed().collect(toList());
        Collections.shuffle(cards, new Random(new Date().getTime()));
        return cards;
    }

    protected void assertEvenNumberOfCards(int numCards, int numGroups) {
        if ((numCards % numGroups) != 0) {
            throw new IllegalArgumentException("uneven # of cards");
        }
    }
}
