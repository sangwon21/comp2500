package academy.pocu.comp2500.lab4;

import java.time.OffsetDateTime;

public class Node {
    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private String value;

    public Node(String value) {
        this.value = value;
        this.createdAt = OffsetDateTime.now();
        this.modifiedAt = this.createdAt;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public OffsetDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    public String getValue() {
        this.modifiedAt = OffsetDateTime.now();
        return this.value;
    }

    public void setValue(String value) {
        this.modifiedAt = OffsetDateTime.now();
        this.value = value;
    }
}
