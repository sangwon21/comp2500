package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Blog {
    private final List<Post> posts;
    private SortingType sortingType;
    private List<String> tagFilters;
    private String authorFilterOrNull;
    private final String authorId;
    private final OffsetDateTime createdAt;

    // 1. registerBlogCreator()
    public Blog(final String authorId) {
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
    public void setTagFilters(final ArrayList<String> tags) {
        this.tagFilters = tags;
    }

    // 3. registerAuthorFilterSetter()
    public void setAuthorFilter(final String user) {
        this.authorFilterOrNull = user;
    }

    // 4. registerPostOrderSetter()
    public void setSortingType(final SortingType sortingType) {
        this.sortingType = sortingType;
    }

    private List<Post> sortList(final List<Post> posts, Comparator<Post> comparator) {
        return posts.stream().sorted(comparator).collect(Collectors.toUnmodifiableList());
    }

    private List<Post> sortPosts(final List<Post> posts) {
        Comparator<Post> createdAtComparator = (a, b) -> a.compareCreatedAt(b);
        Comparator<Post> modifiedAtComparator = (a, b) -> a.compareModifiedAt(b);
        Comparator<Post> titleComparator = (a, b) -> a.compareTitle(b);

        switch (this.sortingType) {
            case CREATED_AT_ASCENDING:
                return this.sortList(posts, createdAtComparator);
            case MODIFIED_AT_ASCENDING:
                return this.sortList(posts, modifiedAtComparator);
            case MODIFIED_AT_DESCENDING:
                return this.sortList(posts, modifiedAtComparator.reversed());
            case TITLE_ORDER:
                return this.sortList(posts, titleComparator);
            case CREATED_AT_DESCENDING:
            default:
                return this.sortList(posts, createdAtComparator.reversed());
        }
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

    // 6. registerPostAdder()
    public boolean addPost(final Post post) {
        return posts.add(post);
    }
}
