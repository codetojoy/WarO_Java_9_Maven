package org.peidevs.waro.strategy.impl;

import org.peidevs.waro.strategy.Strategy;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

public class NextCard implements Strategy {
    @Override
    public int selectCard(int prizeCard, IntStream hand, int maxCard) {
        return hand.boxed().collect(toList()).get(0);
    }
}
