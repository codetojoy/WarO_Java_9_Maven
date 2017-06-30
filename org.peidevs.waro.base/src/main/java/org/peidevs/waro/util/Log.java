package org.peidevs.waro.util;

import java.util.List;

import org.peidevs.waro.player.Player;
import org.peidevs.waro.player.Hand;

public class Log {
    private final boolean isVerbose;

    public Log(boolean isVerbose) {
        this.isVerbose = isVerbose;
    }

    public void log(String msg, Hand kitty, List<Player> players) {
        if (isVerbose) {
            System.out.println("---------------------------------- " + msg);
            System.out.println("TRACER kitty : " + kitty);
            players.stream().forEach( p -> System.out.println("TRACER p - " + p) );
        }
    }

    public void log(String msg, List<Player> players) {
        log(msg, players, 0);
    }

    public void log(String msg, List<Player> players, int prizeCard) {
        if (isVerbose) {
            System.out.println("----------------------------------- " + msg);
            if (prizeCard != 0) {
                System.out.println("TRACER prize - " + prizeCard);
            }
            players.stream().forEach( p -> System.out.println("TRACER p - " + p) );
        }
    }

}
