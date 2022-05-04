package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Blog {
    ArrayList<Post> posts;
    SortingType postSortingType;
    private String tagFilter;
    private User authorFilter;

    // 1. registerBlogCreator()
    public Blog() {
        posts = new ArrayList<>();
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
            case WRITTEN_ASCENDING:
                posts.sort((a, b) -> {
                    return a.getCreatedDateTime().compareTo(b.getCreatedDateTime());
                });
                break;
            case WRITTEN_DESCENDING:
                posts.sort((a, b) -> {
                    return a.getCreatedDateTime().compareTo(b.getCreatedDateTime());
                });
                break;
            case REVISION_ASCENDING:
                posts.sort((a, b) -> {
                    return a.getCreatedDateTime().compareTo(b.getCreatedDateTime());
                });
                break;
            case REVISION_DESCENDING:
                posts.sort((a, b) -> {
                    return a.getCreatedDateTime().compareTo(b.getCreatedDateTime());
                });
                break;
            case TITLE_ORDER:
                break;
        }
        return posts;
    }

    // 5. registerPostListGetter()
    public List<Post> getPosts() {
        List<Post> filteredPosts = posts.stream().filter((post) -> {
            if (post.getTags().contains(this.tagFilter)) {
                return true;
            }
            return false;
        }).filter((post) -> {
            if (post.getAuthor().equals(this.authorFilter)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());


        return posts;
    }

    // 2. registerTagFilterSetter()
    public void setTagFilter(String tag) {
        this.tagFilter = tag;
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
