package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Comment {
    private String text;
    private Set<String> upVoters;
    private Set<String> downVoters;
    private List<Comment> subcomments;
    private String authorId;
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;

    public Comment(String authorId, String text) {
        upVoters = new HashSet<>();
        downVoters = new HashSet<>();
        subcomments = new ArrayList<>();
        this.text = text;
        this.authorId = authorId;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = OffsetDateTime.now();
    }

    // 11. registerSubcommentAdder()
    public boolean addSubcomment(Comment subcomment) {

        return subcomments.add(subcomment);
    }

    public String getText() {
        return this.text;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    // 12. registerCommentUpdater()
    // 13. registerSubcommentUpdater()
    public boolean setText(String text, String authorId) {
        if (!this.authorId.equals(authorId)) {
            return false;
        }

        this.text = text;
        this.modifiedAt = OffsetDateTime.now();
        return true;
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
        return subcomments.stream().sorted((a, b) -> {
            return (b.compareVoter(a));
        }).collect(Collectors.toList());
    }

    public int getUpvoter() {
        return this.upVoters.size();
    }

    public int getDownvoter() {
        return this.downVoters.size();
    }

    public int compareVoter(Comment comment) {
        return (this.getUpvoter() - this.getDownvoter()) - (comment.getUpvoter() - comment.getDownvoter());
    }
}
