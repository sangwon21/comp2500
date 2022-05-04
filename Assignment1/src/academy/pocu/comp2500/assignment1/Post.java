package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Post {
    private User author;
    private ArrayList<String> tags;
    private String title;
    private String body;
    private ArrayList<Comment> comments;
    private HashMap<User, HashSet<Reaction>> reactions;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private Blog blog;

    public Post(Blog blog, User author, String title, String body) {
        this.createdDateTime = OffsetDateTime.now();
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<>();
        this.modifiedDateTime = null;
        this.author = author;
        this.blog = blog;
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

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public User getAuthor() {
        return this.author;
    }

    // 7. registerPostTitleUpdater()
    public void setTitle(String title) {
        this.title = title;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    // 8. registerPostBodyUpdater()
    public void setBody(String body) {
        this.body = body;
        this.modifiedDateTime = OffsetDateTime.now();
    }

    public String getBody() {
        return this.body;
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

    public int getReactionCountFilteredByUser(User user) {
        return reactions.get(user).size();
    }

    // 18. registerCommentListGetter()
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
