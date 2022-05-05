package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Comment {
    private String text;
    private Set<String> upVoters;
    private Set<String> downVoters;
    private List<Comment> subcomments;
    private String userId;
    private OffsetDateTime createdDateTime;

    public Comment(String userId, String text) {
        upVoters = new HashSet<>();
        downVoters = new HashSet<>();
        subcomments = new ArrayList<>();
        this.text = text;
        this.userId = userId;
        this.createdDateTime = OffsetDateTime.now();
    }

    // 11. registerSubcommentAdder()
    public void addSubcomment(Comment subcomment) {
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
    public boolean addUpVoter(String userId) {
        downVoters.remove(userId);

        return upVoters.add(userId);
    }

    // 17. registerCommentDownvoter()
    // 21. registerSubcommentDownvoter()
    public boolean addDownVoter(String userId) {
        upVoters.remove(userId);

        return downVoters.add(userId);
    }

    // 19. registerSubcommentListGetter()
    public List<Comment> getSubcomments() {
        subcomments.sort((a, b) -> {
            return (b.upVoters.size() - b.downVoters.size()) - (a.upVoters.size() - a.downVoters.size());
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
