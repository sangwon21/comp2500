package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Blog {
    ArrayList<Post> posts;
    SortingType postSortingType;
    private ArrayList<String> tagFilters;
    private User authorFilter;
    private User owner;

    // 1. registerBlogCreator()
    public Blog(User owner) {
        posts = new ArrayList<>();
        tagFilters = new ArrayList<>();
        authorFilter = null;
        postSortingType = SortingType.CREATED_AT_ASCENDING;
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((owner == null) ? 0 : owner.hashCode());

        return hashCode;
    }

    // 6. registerPostAdder()
    public void addPost(Post post) {
        if (posts.contains(post)) {
            return;
        }
        posts.add(post);
    }

    private List<Post> sortPosts(List<Post> posts) {
        switch (this.postSortingType) {
            case CREATED_AT_ASCENDING:
                posts.stream().sorted((a, b) -> {
                    return a.getCreatedDateTime().compareTo(b.getCreatedDateTime());
                });
                break;
            case CREATED_AT_DESCENDING:
                posts.sort((a, b) -> {
                    return b.getCreatedDateTime().compareTo(a.getCreatedDateTime());
                });
                break;
            case MODIFIED_AT_ASCENDING:
                posts.sort((a, b) -> {
                    return a.getModifiedDateTime().compareTo(b.getModifiedDateTime());
                });
                break;
            case MODIFIED_AT_DESCENDING:
                posts.sort((a, b) -> {
                    return b.getCreatedDateTime().compareTo(a.getCreatedDateTime());
                });
                break;
            case TITLE_ORDER:
                posts.sort((a, b) -> {
                    return a.getTitle().compareTo(b.getTitle());
                });
                break;
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

            if (post.getAuthor().equals(this.authorFilter)) {
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
    public void setAuthorFilter(User author) {
        this.authorFilter = author;
    }

    // 4. registerPostOrderSetter()
    public void setPostSortingType(SortingType sortingType) {
        this.postSortingType = sortingType;
    }
}
