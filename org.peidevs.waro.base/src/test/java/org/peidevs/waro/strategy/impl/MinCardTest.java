package org.peidevs.waro.strategy.impl;

import org.peidevs.waro.strategy.Strategy;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import java.util.stream.*;

public class MinCardTest {

    @Test
    public void testSelectCard() {
        Strategy strategy = new MinCard();
        int maxCard = 50;
        int prizeCard = 10;
        int handSize = 20;
        IntStream hand = IntStream.range(1,handSize+1).boxed().mapToInt(i -> i);

        // test
        int result = strategy.selectCard(prizeCard, hand, maxCard);

        assertEquals(1, result);
    }

}
