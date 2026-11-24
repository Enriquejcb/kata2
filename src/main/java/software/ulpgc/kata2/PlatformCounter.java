package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlatformCounter {
    public Map<String, Integer> count(List<Game> games) {
        Map<String, Integer> gamesPerPlatform = new TreeMap<>();
        for (Game game : games) {
            gamesPerPlatform.merge(game.platform(), 1, Integer::sum);
        }
        return gamesPerPlatform;
    }
}
