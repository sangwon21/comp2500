package academy.pocu.comp2500.lab3;

import java.util.ArrayList;
import java.util.List;

public class ListItem {
    private String text;
    private List<ListItem> listItems;
    private char bulletStyle;

    public ListItem(final String text) {
        this(text, '*');
    }

    public ListItem(final String text, final char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        this.listItems = new ArrayList<>();
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void setBulletStyle(final char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public ListItem getSublistItem(final int index) {
        return this.listItems.get(index);
    }

    public void addSublistItem(final ListItem listItem) {
        this.listItems.add(listItem);
    }

    private String makeInitialBlank(final int depth) {
        StringBuilder initialBlank = new StringBuilder();;
        final int limit = depth * 4;
        for (int i = 0; i < limit; i++) {
            initialBlank.append(" ");
        }

        return initialBlank.toString();
    }

    private String makeBulletStyle(final int depth, final char bulletStyle) {
        StringBuilder bulletStyleString = new StringBuilder();

        bulletStyleString.append(makeInitialBlank(depth)).append(bulletStyle).append(" ");

        return bulletStyleString.toString();
    }

    private String helper(ListItem list, int startIndex, int depth) {
        StringBuilder tmp = new StringBuilder();

        tmp.append(makeBulletStyle(depth, list.bulletStyle)).append(list.text).append('\n');

        for (int i = startIndex; i < list.listItems.size(); i++) {
            ListItem target = list.listItems.get(i);
            tmp.append(helper(target, i + 1, depth + 1));
        }

        return tmp.toString();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();;
        result.append(makeBulletStyle(0, this.bulletStyle)).append(this.text).append('\n');

        for (int i = 0; i < listItems.size(); i++) {
            result.append(helper(this.listItems.get(i), i, 1));
        }

        return result.toString();
    }

    public void removeSublistItem(int index) {
        this.listItems.remove(index);
    }
}
