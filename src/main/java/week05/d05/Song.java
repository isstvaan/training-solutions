package week05.d05;

public class Song {
    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (!isValid(name)) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        if (!isValid(artist)) {
            throw new IllegalArgumentException("Artist can't be empty.");
        }

        if (lengthInSeconds < 1) {
            throw new IllegalStateException("Invalid length");
        }

        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    private boolean isValid(String str) {
        return str != null && !str.isBlank();
    }

    @Override
    public String toString() {
        return "Artist: " + artist + " title: " + name + " length:" + lengthInSeconds + " sec";
    }
}
