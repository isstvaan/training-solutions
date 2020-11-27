package week05.d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayListTest {

    @Test
    public void testConstructorTrows() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Playlist(null));
        assertEquals("songList can't be null", ex.getMessage());
    }

    @Test
    public void testFindByLengthGreaterThan() {

        //GIVEN
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Test1", 10, "Test2"));
        songs.add(new Song("Test2", 30, "Test2"));
        songs.add(new Song("Test3", 60, "Test3"));
        songs.add(new Song("Test4", 120, "Test4"));
        songs.add(new Song("Test5", 240, "Test5"));

        assertEquals(2, new Playlist(songs).findByLengthGreaterThan(1).size());
    }

    @Test
    public void testToString() {

        //GIVEN
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Test1", 10, "Test2"));
        songs.add(new Song("Test2", 30, "Test2"));

        assertEquals("[Artist: Test2 title: Test1 length:10 sec, Artist: Test2 title: Test2 length:30 sec]", new Playlist(songs).getSongList().toString());
    }
}
