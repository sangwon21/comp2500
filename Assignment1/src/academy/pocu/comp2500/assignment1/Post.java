package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.stream.Collectors;

public class Post {
    private final String authorId;
    private final Set<String> tags;
    private String title;
    private String body;
    private final List<Comment> comments;
    private final Map<Reaction, Set<String>> reactions;
    private final OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public Post(String authorId, String title, String body) {
        this.title = title;
        this.body = body;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        ;
        this.reactions = new HashMap<>();
        this.modifiedAt = OffsetDateTime.now();
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
        return this.modifiedAt;
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
        }).collect(Collectors.toUnmodifiableList());
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
        this.modifiedAt = OffsetDateTime.now();
        return true;
    }

    // 8. registerPostBodyUpdater()
    public boolean setBody(String body, String userId) {
        if (!this.authorId.equals(userId)) {
            return false;
        }

        this.body = body;
        this.modifiedAt = OffsetDateTime.now();
        return true;
    }

    // 9. registerPostTagAdder()
    public boolean addTag(String tag) {
        this.modifiedAt = OffsetDateTime.now();
        return this.tags.add(tag);
    }

    // 10. registerCommentAdder()
    public boolean addComment(Comment comment) {
        this.modifiedAt = OffsetDateTime.now();
        return comments.add(comment);
    }

    // 14. registerReactionAdder()
    public boolean addReaction(Reaction reactionType, String userId) {
        Set<String> reactionSet = this.reactions.get(reactionType);
        this.modifiedAt = OffsetDateTime.now();
        return reactionSet.add(userId);
    }

    // 15. registerReactionRemover()
    public boolean removeReaction(Reaction reactionType, String userId) {
        Set<String> reactionSet = this.reactions.get(reactionType);
        this.modifiedAt = OffsetDateTime.now();
        return reactionSet.remove(userId);
    }

    public int compareCreatedAt(Post post) {
        return this.createdAt.compareTo(post.createdAt);
    }

    public int compareModifiedAt(Post post) {
        return this.modifiedAt.compareTo(post.modifiedAt);
    }

    public int compareTitle(Post post) {
        return this.title.compareTo(post.title);
    }
}
