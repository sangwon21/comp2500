package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Post {
    private User author;
    private UUID postId;
    private ArrayList<String> tags;
    private String title;
    private String body;
    private ArrayList<Comment> comments;
    private HashMap<User, HashSet<Reaction>> reactions;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public Post(User author) {
        this.author = author;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public User getAuthor() {
        return this.author;
    }

    // 7. registerPostTitleUpdater()
    public void setTitle(String title) {
        this.title = title;
    }

    // 8. registerPostBodyUpdater()
    public void setBody(String body) {
        this.body = body;
    }

    // 9. registerPostTagAdder()
    public void addTag(String tag) {
        if (tags.contains(tag)) {
            return;
        }
        tags.add(tag);
    }

    // 10. registerCommentAdder()
    public void addComment(Comment comment) {
        if (comments.contains(comment)) {
            return;
        }
        comments.add(comment);
    }

    // 14. registerReactionAdder()
    public void addReaction(User user, Reaction reaction) {
        if (reactions.containsKey(user)) {
            reactions.get(user).add(reaction);
            return;
        }

        HashSet<Reaction> reactionSet = new HashSet<>();
        reactionSet.add(reaction);

        reactions.put(user, reactionSet);
    }

    // 15. registerReactionRemover()
    public void removeReaction(User user, Reaction reaction) {
        if (!reactions.containsKey(user)) {
            return;
        }

        reactions.get(user).remove(reaction);
    }

    // 18. registerCommentListGetter()
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
