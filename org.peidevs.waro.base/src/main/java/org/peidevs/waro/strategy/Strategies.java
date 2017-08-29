package org.peidevs.waro.strategy;

import org.peidevs.waro.strategy.impl.*;

public class Strategies {
    public static Strategy getNextCardStrategy() {
        return new NextCard();
    }

    public static Strategy getMaxCardStrategy() {
        return new MaxCard();
    }
}
