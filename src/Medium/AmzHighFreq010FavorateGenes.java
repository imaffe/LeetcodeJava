package Medium;

import sun.awt.XSettings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmzHighFreq010FavorateGenes {
    public Map<String, List<String>> favorite(Map<String, List<String>> userSongs, Map<String, List<String>> kinds) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songKind = new HashMap<>();
        for (String kind : kinds.keySet()) {
            List<String> songs = kinds.get(kind);
            for (String song : songs) {
                songKind.put(song, kind);
            }
        }

        for (String user : userSongs.keySet()) {
            Map<String, Integer> kindCount = new HashMap<>();
            int curMax = 0;
            List<String> songs = userSongs.get(user);
            List<String> userKinds = new ArrayList<>();
            for(String song: songs) {
                String kind = songKind.get(song);
                int newCount = 1;
                if (kindCount.containsKey(kind)) {
                    newCount = kindCount.get(kind) + 1;
                    kindCount.put(kind, newCount);
                } else {
                    kindCount.put(kind, 1);
                }

                if (newCount == curMax) {
                    userKinds.add(kind);
                } else if(newCount > curMax) {
                    curMax = newCount;
                    userKinds.clear();
                    userKinds.add(kind);
                } else ;
            }
            result.put(user, userKinds);
        }
        return result;
    }
}
