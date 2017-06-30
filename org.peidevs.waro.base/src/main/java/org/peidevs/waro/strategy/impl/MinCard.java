package org.peidevs.waro.strategy.impl;

import org.peidevs.waro.strategy.Strategy;

import java.util.stream.IntStream;
import java.util.OptionalInt;

public class MinCard implements Strategy {
    @Override
    public int selectCard(int prizeCard, IntStream hand, int maxCard) {
        OptionalInt result = hand.min();
        return result.getAsInt();
    }
}
