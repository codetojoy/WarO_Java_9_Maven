package org.peidevs.waro.function;

import java.util.List;
import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.toList;

import org.peidevs.waro.player.Player;
import org.peidevs.waro.util.Log;

import org.peidevs.waro.function.impl.Game;

public class Tourney implements UnaryOperator<List<Player>> {
    private final Log logger;
    private final boolean isVerbose;
    private final int numCards;
    private final int numGames;

    public Tourney(int numCards, int numGames, boolean isVerbose) {
        this.numCards = numCards;
        this.numGames = numGames;
        this.logger = new Log(isVerbose);
        this.isVerbose = isVerbose;
    }

    @Override
    public List<Player> apply(List<Player> players) {
        UnaryOperator<List<Player>> game = new Game(numCards, isVerbose);
        Stream<List<Player>> stream = Stream.iterate(players, game).limit(numGames + 1);
        List<List<Player>> results = stream.collect(toList());
        List<Player> newPlayers = results.get(results.size() - 1);
        logger.log("END TOURNEY", newPlayers);

        return newPlayers;
    }

}
