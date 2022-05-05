package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> posts;
    private SortingType postSortingType;
    private List<String> tagFilters;
    private String authorFilter;
    private String userId;

    // 1. registerBlogCreator()
    public Blog(String userId) {
        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
        authorFilter = null;
        postSortingType = SortingType.CREATED_AT_ASCENDING;
        this.userId = userId;
    }

    // 6. registerPostAdder()
    public void addPost(Post post) {
        if (posts.contains(post)) {
            return;
        }
        posts.add(post);
    }

    public List<String> getTagFilters() {
        return this.tagFilters;
    }

    public String getAuthorFilter() {
        return this.authorFilter;
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
                    return a.getCreatedDateTime().compareTo(b.getCreatedDateTime());
                }).collect(Collectors.toList());
            case CREATED_AT_DESCENDING:
                return posts.stream().sorted((a, b) -> {
                    return b.getCreatedDateTime().compareTo(a.getCreatedDateTime());
                }).collect(Collectors.toList());
            case MODIFIED_AT_ASCENDING:
                return posts.stream().sorted((a, b) -> {
                    return a.getModifiedDateTime().compareTo(b.getModifiedDateTime());
                }).collect(Collectors.toList());
            case MODIFIED_AT_DESCENDING:
                return posts.stream().sorted((a, b) -> {
                    return b.getCreatedDateTime().compareTo(a.getCreatedDateTime());
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
            if (this.authorFilter == null) {
                return true;
            }

            if (post.getAuthorId().equals(this.authorFilter)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        return sortPosts(filteredPosts);
    }

    // 2. registerTagFilterSetter()
    public void setTagFilters(ArrayList<String> tags) {
        this.tagFilters = tags;
    }

    // 3. registerAuthorFilterSetter()
    public void setAuthorFilter(String author) {
        this.authorFilter = author;
    }

    // 4. registerPostOrderSetter()
    public void setPostSortingType(SortingType sortingType) {
        this.postSortingType = sortingType;
    }
}
