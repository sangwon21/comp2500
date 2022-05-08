package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Post {
    private String authorId;
    private Set<String> tags;
    private String title;
    private String body;
    private List<Comment> comments;
    private Map<Reaction, Set<String>> reactions;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAtOrNull;

    public Post(String authorId, String title, String body) {
        this.title = title;
        this.body = body;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<>();
        this.modifiedAtOrNull = null;
        this.createdAt = OffsetDateTime.now();
        this.authorId = authorId;

        reactions.put(Reaction.ANGRY, new HashSet<>());
        reactions.put(Reaction.FUN, new HashSet<>());
        reactions.put(Reaction.GREAT, new HashSet<>());
        reactions.put(Reaction.LOVE, new HashSet<>());
        reactions.put(Reaction.SAD, new HashSet<>());
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public OffsetDateTime getModifiedAtOrNull() {
        return this.modifiedAtOrNull;
    }

    public String getTitle() {
        return this.title;
    }

    public Set<String> getTags() {
        Set<String> returnSet = new HashSet<>();

        for (String tag : this.tags) {
            returnSet.add(tag);
        }

        return returnSet;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public String getBody() {
        return this.body;
    }

    // 18. registerCommentListGetter()
    public List<Comment> getComments() {
        return comments.stream().sorted((a, b) -> {
            return b.compareVoter(a);
        }).collect(Collectors.toList());
    }

    public int getReactions(Reaction reactionType) {
        return this.reactions.get(reactionType).size();
    }

    // 7. registerPostTitleUpdater()
    public boolean setTitle(String title, String userId) {
        if (!this.authorId.equals(userId)) {
            return false;
        }

        this.title = title;
        this.modifiedAtOrNull = OffsetDateTime.now();
        return true;
    }

    // 8. registerPostBodyUpdater()
    public boolean setBody(String body, String userId) {
        if (!this.authorId.equals(userId)) {
            return false;
        }

        this.body = body;
        this.modifiedAtOrNull = OffsetDateTime.now();
        return true;
    }

    // 9. registerPostTagAdder()
    public boolean addTag(String tag) {
        this.modifiedAtOrNull = OffsetDateTime.now();
        return this.tags.add(tag);
    }

    // 10. registerCommentAdder()
    public boolean addComment(Comment comment) {
        this.modifiedAtOrNull = OffsetDateTime.now();
        return comments.add(comment);
    }

    // 14. registerReactionAdder()
    public boolean addReaction(Reaction reactionType) {
        Set<String> reactionSet = this.reactions.get(reactionType);
        this.modifiedAtOrNull = OffsetDateTime.now();
        return reactionSet.add(authorId);
    }

    // 15. registerReactionRemover()
    public boolean removeReaction(Reaction reactionType) {
        Set<String> reactionSet = this.reactions.get(reactionType);
        this.modifiedAtOrNull = OffsetDateTime.now();
        return reactionSet.remove(authorId);
    }

    public int compareCreatedAt(Post post) {
        return this.createdAt.compareTo(post.createdAt);
    }

    public int compareModifiedAt(Post post) {
        return this.modifiedAtOrNull.compareTo(post.modifiedAtOrNull);
    }

    public int compareTitle(Post post) {
        return this.title.compareTo(post.title);
    }
}
