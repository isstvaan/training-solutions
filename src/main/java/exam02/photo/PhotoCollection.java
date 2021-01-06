package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... photoNames) {
        for (String item : photoNames) {
            photos.add(new Photo(item));
        }
    }

    public void starPhoto(String photoName, Quality quality) {
        boolean founded = false;
        for (Photo item : photos) {
            if (item.getName().equals(photoName)) {
                item.setQuality(quality);
                founded = true;
            }
        }
        if (!founded) {
            throw new PhotoNotFoundException(photoName + " is not found");
        }
    }

    public int numberOfStars() {
        int stars = 0;
        for (Photo item : photos) {
            stars += item.getQuality().getValue();
        }
        return stars;
    }

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }
}
