package week05.d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songList;

    public Playlist(List<Song> songList) {
        if (songList == null) {
            throw new IllegalArgumentException("songList can't be null");
        }
        this.songList = songList;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> result = new ArrayList<>();

        for (Song item : songList) {
            if (item.getLengthInSeconds() / 60.0 > mins) {
                result.add(item);
            }
        }

        return result;
    }

    public List<Song> getSongList() {
        return songList;
    }
}
