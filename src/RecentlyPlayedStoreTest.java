

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecentlyPlayedStoreTest {

    private RecentlyPlayedStore store;

    @BeforeEach
    public void setUp() {
        store = new RecentlyPlayedStore(3);
    }

    @Test
    public void testAddSong() {
        store.addSong("Alice", "S1");
        store.addSong("Alice", "S2");
        store.addSong("Alice", "S3");
        store.addSong("Alice", "S4");
        store.addSong("Bob", "S1");
        store.addSong("Bob", "S2");
        store.addSong("Bob", "S3");
        store.addSong("Bob", "S4");

        assertEquals(Arrays.asList("S4", "S3", "S2"), store.getRecentlyPlayedSongs("Alice"));
        assertEquals(Arrays.asList("S4", "S3", "S2"), store.getRecentlyPlayedSongs("Bob"));
    }

    @Test
    public void testGetRecentlyPlayedSongsEmpty() {
        assertEquals(Collections.emptyList(), store.getRecentlyPlayedSongs("Alice"));
    }
}