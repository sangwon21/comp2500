package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class Comment {
    private String text;
    private HashSet<User> upVoters;
    private HashSet<User> downVoters;
    private ArrayList<Comment> subcomments;
    private User author;
    private Post post;

    public Comment(Post post, User author, String text) {
        upVoters = new HashSet<>();
        downVoters = new HashSet<>();
        subcomments = new ArrayList<>();
        this.text = text;
        this.post = post;
        this.author = author;
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
    public void addUpVoter(User user) {
        if (downVoters.contains(user)) {
            downVoters.remove(user);
        }

        upVoters.add(user);
    }

    // 17. registerCommentDownvoter()
    // 21. registerSubcommentDownvoter()
    public void addDownVoter(User user) {
        if (upVoters.contains(user)) {
            upVoters.remove(user);
        }

        downVoters.add(user);
    }

    // 19. registerSubcommentListGetter()
    public ArrayList<Comment> getSubcomments() {
        return subcomments;
    }

    public int getUpvoter() {
        return this.upVoters.size();
    }

    public int getDownvoter() {
        return this.downVoters.size();
    }
}
