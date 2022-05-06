package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> posts;
    private SortingType sortingType;
    private List<String> tagFilters;
    private String authorFilterOrNull;
    private String authorId;
    private OffsetDateTime createdAt;

    // 1. registerBlogCreator()
    public Blog(String authorId) {
        this.posts = new ArrayList<>();
        this.tagFilters = new ArrayList<>();
        this.authorFilterOrNull = null;
        this.sortingType = SortingType.CREATED_AT_DESCENDING;
        this.authorId = authorId;
        this.createdAt = OffsetDateTime.now();
    }

    public String getAuthorId() {
        return this.authorId;
    }

    // 2. registerTagFilterSetter()
    public void setTagFilters(ArrayList<String> tags) {
        this.tagFilters = tags;
    }

    // 3. registerAuthorFilterSetter()
    public void setAuthorFilter(String user) {
        this.authorFilterOrNull = user;
    }

    // 4. registerPostOrderSetter()
    public void setPostSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    private List<Post> sortPosts(List<Post> posts) {
        switch (this.sortingType) {
            case CREATED_AT_ASCENDING:
                return posts.stream().sorted((a, b) -> {
                    return a.compareCreatedAt(b);
                }).collect(Collectors.toList());
            case CREATED_AT_DESCENDING:
                return posts.stream().sorted((a, b) -> {
                    return b.compareCreatedAt(a);
                }).collect(Collectors.toList());
            case MODIFIED_AT_ASCENDING:
                return posts.stream().sorted((a, b) -> {
                    return a.compareModifiedAt(b);
                }).collect(Collectors.toList());
            case MODIFIED_AT_DESCENDING:
                return posts.stream().sorted((a, b) -> {
                    return b.compareModifiedAt(a);
                }).collect(Collectors.toList());
            case TITLE_ORDER:
                return posts.stream().sorted((a, b) -> {
                    return a.compareTitle(b);
                }).collect(Collectors.toList());
        }
        return posts;
    }

    // 5. registerPostListGetter()
    public List<Post> getPosts() {
        List<Post> filteredPosts = posts.stream().filter((post) -> {
            if (tagFilters.size() == 0) {
                return true;
            }

            for (String tag : tagFilters) {
                if (post.getTags().contains(tag)) {
                    return true;
                }
            }

            return false;
        }).filter((post) -> {
            if (this.authorFilterOrNull == null || this.authorFilterOrNull.equals("")) {
                return true;
            }

            if (post.getAuthorId().equals(this.authorFilterOrNull)) {
                return true;
            }

            return false;
        }).collect(Collectors.toList());

        return sortPosts(filteredPosts);
    }

    // 6. registerPostAdder()
    public boolean addPost(Post post) {
        return posts.add(post);
    }
}
