package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Comment {
    private String text;
    private HashSet<User> upVoters;
    private HashSet<User> downVoters;
    private ArrayList<Comment> subcomments;
    private User author;
    private Post post;
    private OffsetDateTime createdDateTime;

    public Comment(Post post, User author, String text) {
        upVoters = new HashSet<>();
        downVoters = new HashSet<>();
        subcomments = new ArrayList<>();
        this.text = text;
        this.post = post;
        this.author = author;
        this.createdDateTime = OffsetDateTime.now();
    }

    // 11. registerSubcommentAdder()
    public void addSubcomment(Comment subcomment) {
        if (this.subcomments.contains(subcomment)) {
            return;
        }
        subcomments.add(subcomment);
    }

    public String getText() {
        return this.text;
    }

    // 12. registerCommentUpdater()
    // 13. registerSubcommentUpdater()
    public void setText(String text) {
        this.text = text;
    }

    // 16. registerCommentUpvoter():
    // 20. registerSubcommentUpvoter()
    public boolean addUpVoter(User user) {
        if (downVoters.contains(user)) {
            downVoters.remove(user);
        }

        if (upVoters.contains(user)) {
            return false;
        }

        upVoters.add(user);
        return true;
    }

    // 17. registerCommentDownvoter()
    // 21. registerSubcommentDownvoter()
    public boolean addDownVoter(User user) {
        if (upVoters.contains(user)) {
            upVoters.remove(user);
        }

        if (downVoters.contains(user)) {
            return false;
        }

        downVoters.add(user);
        return true;
    }

    // 19. registerSubcommentListGetter()
    public ArrayList<Comment> getSubcomments() {
        subcomments.sort((a, b) -> {
            return (a.upVoters.size() - a.downVoters.size()) - (b.upVoters.size() - b.downVoters.size());
        });
        return subcomments;
    }

    public int getUpvoter() {
        return this.upVoters.size();
    }

    public int getDownvoter() {
        return this.downVoters.size();
    }
}
