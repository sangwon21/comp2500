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

    public Post(User author, String title, String body) {
        this.createdDateTime = OffsetDateTime.now();
        this.title = title;
        this.body = body;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.reactions = new HashMap<>();
        this.modifiedDateTime = OffsetDateTime.now();
        this.author = author;
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

    public HashMap<User, HashSet<Reaction>> getReactions() {
        return reactions;
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

    // 9. registerPostTagAdder()
    public boolean addTag(String tag) {
        if (tags.contains(tag)) {
            return false;
        }
        tags.add(tag);
        return true;
    }


    // 10. registerCommentAdder()
    public void addComment(Comment comment) {
        if (comments.contains(comment)) {
            return;
        }
        comments.add(comment);
    }

    // 14. registerReactionAdder()
    public boolean addReaction(User user, Reaction reaction) {
        if (reactions.containsKey(user)) {
            if (reactions.get(user).contains(reaction)) {
                return false;
            }
            reactions.get(user).add(reaction);
            return true;
        }

        HashSet<Reaction> reactionSet = new HashSet<>();
        reactionSet.add(reaction);

        reactions.put(user, reactionSet);
        return true;
    }

    // 15. registerReactionRemover()
    public boolean removeReaction(User user, Reaction reaction) {
        if (!reactions.containsKey(user)) {
            return false;
        }

        if (reactions.get(user).contains(reaction)) {
            reactions.get(user).remove(reaction);
            return true;
        }
        return false;
    }

    public int getReactionCountFilteredByUser(User user) {
        return reactions.get(user).size();
    }
}
