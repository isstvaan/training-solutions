package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {
    List<Post> posts;
    // private String user;


    public PostFinder(List<Post> posts) {
        this.posts = new ArrayList<>(posts);
    }


    private boolean filterPost(Post post, String user) {
        LocalDate now = LocalDate.now();
        return (post.getPublishedAt().isBefore(now) || post.getOwner().equals(user))
                && isNotEmpty(post.getContent())
                && isNotEmpty(post.getTitle())
                && (post.getDeletedAt() == null || post.getDeletedAt().isAfter(now));
    }


    public List<Post> findPost(String user) {
        return posts.stream()
                .filter(o -> filterPost(o, user))
                .collect(Collectors.toList());
    }

    private boolean isNotEmpty(String str) {
        return str != null && !str.isBlank();
    }

}
