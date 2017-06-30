package org.peidevs.waro;

import org.peidevs.waro.function.Tourney;

import org.peidevs.waro.player.Player;
import org.peidevs.waro.config.ConfigService;

import java.util.List;
import static java.util.Comparator.comparing;

// To configure players, numGames, etc, see org.peidevs.waro.config.Config
// This is compile-time configuration

public class Main {

    public static void main(String... args) {
        // read configuration
        ConfigService configService = new ConfigService();
        int numCards = configService.getNumCards();
        int numGames = configService.getNumGames();
        boolean isVerbose = configService.isVerbose();
        List<Player> players = configService.getPlayers();

        // play the games
        Tourney tourney = new Tourney(numCards, numGames, isVerbose);

        tourney.apply(players)
               .stream()
               .sorted(comparing(Player::getNumGamesWon).reversed())
               .forEach(p -> System.out.println(p.toString(numGames)));
    }
}
