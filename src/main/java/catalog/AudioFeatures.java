package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }

        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Empty performers");
        }

        if (length < 0) {
            throw new IllegalArgumentException("Invalid length");
        }

        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers, new ArrayList<>());
    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(composer);
        contributors.addAll(performers);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
