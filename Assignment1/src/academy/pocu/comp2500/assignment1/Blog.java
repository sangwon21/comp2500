package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> posts;
    private SortingType postSortingType;
    private List<String> tagFilters;
    private String authorFilterOrNull;
    private String userId;
    private OffsetDateTime createdAt;

    // 1. registerBlogCreator()
    public Blog(String userId) {
        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
        authorFilterOrNull = null;
        postSortingType = SortingType.CREATED_AT_ASCENDING;
        this.userId = userId;
        this.createdAt = OffsetDateTime.now();
    }

    // 6. registerPostAdder()
    public boolean addPost(String authorId, String title, String body) {
        return posts.add(new Post(authorId, title, body));
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
        System.out.println("getPosts");
        System.out.println(this.posts);
        System.out.println("tagFilter");
        System.out.println(this.tagFilters);
        List<Post> filteredPosts = posts.stream().filter((post) -> {
            if (tagFilters.size() == 0) {
                return true;
            }

            for (String tag : tagFilters) {
                System.out.println("post.getTags");
                System.out.println(post.getTags());
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
        System.out.println(filteredPosts);
        return sortPosts(filteredPosts);
    }

    // 2. registerTagFilterSetter()
    public void setTagFilters(ArrayList<String> tags) {
        this.tagFilters = tags;
    }

    // 3. registerAuthorFilterSetter()
    public void setAuthorFilter(String authorId) {
        this.authorFilterOrNull = authorId;
    }

    // 4. registerPostOrderSetter()
    public void setPostSortingType(SortingType sortingType) {
        this.postSortingType = sortingType;
    }
}
