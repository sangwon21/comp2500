package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class Comment {
    private String body;
    private HashSet<User> upVoters;
    private HashSet<User> downVoters;
    private ArrayList<Comment> subcomments;

    public Comment(String body) {
        upVoters = new HashSet<>();
        downVoters = new HashSet<>();
        subcomments = new ArrayList<>();
        this.body = body;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((body == null) ? 0 : body.hashCode());

        return hashCode;
    }

    // 11. registerSubcommentAdder()
    public void addSubcomment(Comment subcomment) {
        if (this.subcomments.contains(subcomment)) {
            return;
        }
        subcomments.add(subcomment);
    }

    public String getBody() {
        return this.body;
    }

    // 12. registerCommentUpdater()
    // 13. registerSubcommentUpdater()
    public void setBody(String body) {
        this.body = body;
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
