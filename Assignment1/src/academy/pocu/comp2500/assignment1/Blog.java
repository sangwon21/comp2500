package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> posts;
    private SortingType postSortingType;
    private List<String> tagFilters;
    private String authorFilterOrNull;
    private String userId;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    // 1. registerBlogCreator()
    public Blog(String userId) {
        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
        authorFilterOrNull = null;
        postSortingType = SortingType.CREATED_AT_ASCENDING;
        this.userId = userId;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    // 6. registerPostAdder()
    public void addPost(Post post) {
        this.modifiedAt = OffsetDateTime.now();
        posts.add(post);
    }

    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public List<String> getTagFilters() {
        return this.tagFilters;
    }

    public String getAuthorFilter() {
        return this.authorFilterOrNull;
    }

    public String getUserId() {
        return this.userId;
    }

    public SortingType getPostSortingType() {
        return this.postSortingType;
    }

    private List<Post> sortPosts(List<Post> posts) {
        switch (this.postSortingType) {
            case CREATED_AT_ASCENDING:
                return posts.stream().sorted((a, b) -> {
                    return a.getCreatedAt().compareTo(b.getCreatedAt());
                }).collect(Collectors.toList());
            case CREATED_AT_DESCENDING:
                return posts.stream().sorted((a, b) -> {
                    return b.getCreatedAt().compareTo(a.getCreatedAt());
                }).collect(Collectors.toList());
            case MODIFIED_AT_ASCENDING:
                return posts.stream().sorted((a, b) -> {
                    return a.getModifiedAt().compareTo(b.getModifiedAt());
                }).collect(Collectors.toList());
            case MODIFIED_AT_DESCENDING:
                return posts.stream().sorted((a, b) -> {
                    return b.getCreatedAt().compareTo(a.getCreatedAt());
                }).collect(Collectors.toList());
            case TITLE_ORDER:
                return posts.stream().sorted((a, b) -> {
                    return a.getTitle().compareTo(b.getTitle());
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
            if (this.authorFilterOrNull == null) {
                return true;
            }

            if (post.getAuthorId().equals(this.authorFilterOrNull)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        return sortPosts(filteredPosts);
    }

    // 2. registerTagFilterSetter()
    public void setTagFilters(ArrayList<String> tags) {
        this.modifiedAt = OffsetDateTime.now();
        this.tagFilters = tags;
    }

    // 3. registerAuthorFilterSetter()
    public void setAuthorFilter(String authorId) {
        this.modifiedAt = OffsetDateTime.now();
        this.authorFilterOrNull = authorId;
    }

    // 4. registerPostOrderSetter()
    public void setPostSortingType(SortingType sortingType) {
        this.modifiedAt = OffsetDateTime.now();
        this.postSortingType = sortingType;
    }
}
