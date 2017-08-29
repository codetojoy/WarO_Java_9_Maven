package org.peidevs.waro.player;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class HandTest {

    @Test
    public void testSelect_Basic() {
        List<Integer> cards = IntStream.range(1,10+1).boxed().collect(toList());
        Hand hand = new Hand(cards);

        // test
        Hand result = hand.select(5);

        assertEquals(9, result.cardsAsIntStream().boxed().count());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSelect_Illegal() {
        List<Integer> cards = IntStream.range(1,10+1).boxed().collect(toList());
        Hand hand = new Hand(cards);

        // test
        Hand result = hand.select(18);
    }

}
