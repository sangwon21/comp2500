package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Post {
    private String blogId;
    private String userId;
    private Set<String> tags;
    private String title;
    private String body;
    private ArrayList<Comment> comments;
    private HashMap<Reaction, Set<String>> reactions;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public Post(String blogId, String userId, String title, String body) {
        this.blogId = blogId;
        this.createdDateTime = OffsetDateTime.now();
        this.title = title;
        this.body = body;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<>();
        this.modifiedDateTime = OffsetDateTime.now();
        this.userId = userId;

        reactions.put(Reaction.ANGRY, new HashSet<>());
        reactions.put(Reaction.FUN, new HashSet<>());
        reactions.put(Reaction.GREAT, new HashSet<>());
        reactions.put(Reaction.LOVE, new HashSet<>());
        reactions.put(Reaction.SAD, new HashSet<>());
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public String getTitle() {
        return this.title;
    }

    public Set<String> getTags() {
        return this.tags;
    }

    public String getAuthor() {
        return this.userId;
    }

    public String getBody() {
        return this.body;
    }

    // 18. registerCommentListGetter()
    public ArrayList<Comment> getComments() {
        comments.sort((a, b) -> {
            return (b.getUpvoter() - b.getDownvoter()) - (a.getUpvoter() - a.getDownvoter());
        });
        return comments;
    }

    public HashMap<Reaction, Set<String>> getReactions() {
        return reactions;
    }

    // 7. registerPostTitleUpdater()
    public void setTitle(String title, String userId) {
        if (!this.userId.equals(userId)) {
            return;
        }

        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    // 8. registerPostBodyUpdater()
    public void setBody(String body, String userId) {
        if (!this.userId.equals(userId)) {
            return;
        }

        this.body = body;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    // 9. registerPostTagAdder()
    public boolean addTag(String tag) {
        return this.tags.add(tag);
    }


    // 10. registerCommentAdder()
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    // 14. registerReactionAdder()
    public boolean addReaction(String userId, Reaction reactionType) {
        Set<String> reactionSet = this.reactions.get(reactionType);

        return reactionSet.add(userId);
    }

    // 15. registerReactionRemover()
    public boolean removeReaction(String userId, Reaction reactionType) {
        Set<String> reactionSet = this.reactions.get(reactionType);

        return reactionSet.remove(userId);
    }
}
