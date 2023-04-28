import java.util.*;

public class RecentlyPlayedStore {

    private Map<String, LinkedList<String>> store;
    private int capacity;

    public RecentlyPlayedStore(int capacity) {
        this.store = new HashMap<>();
        this.capacity = capacity;
    }

    public void addSong(String user, String song) {
        LinkedList<String> songs = store.get(user);
        if (songs == null) {
            songs = new LinkedList<>();
            store.put(user, songs);
        }
        songs.remove(song);
        songs.addFirst(song);
        if (songs.size() > capacity) {
            songs.removeLast();
        }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        LinkedList<String> songs = store.get(user);
        if (songs == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(songs);
    }
}