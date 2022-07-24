package academy.pocu.comp2500.assignment4;

public class Canvas {
    private static final char MIN_CHAR = 32;
    private static final char MAX_CHAR = 126;
    private final char[][] canvas;

    public Canvas(final int width, final int height) {
        this.canvas = new char[height][width];

        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                this.drawPixel(x, y, ' ');
            }
        }
    }

    public String getDrawing() {
        StringBuilder sb = new StringBuilder();

        // 첫번째 줄
        sb.append('+');
        for (int i = 0; i < getWidth(); i++) {
            sb.append("-");
        }
        sb.append('+');
        sb.append(System.lineSeparator());

        // 두번째 줄 ~
        for (int y = 0; y < this.getHeight(); y++) {
            sb.append('|');
            for (int x = 0; x < this.getWidth(); x++) {
                sb.append(this.getPixel(x, y));
            }
            sb.append('|');
            sb.append(System.lineSeparator());
        }

        // 마지막 줄
        sb.append('+');
        for (int i = 0; i < getWidth(); i++) {
            sb.append("-");
        }
        sb.append('+');
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    public int getWidth() {
        return this.canvas[0].length;
    }

    public int getHeight() {
        return this.canvas.length;
    }

    public void drawPixel(int x, int y, char character) {
        this.canvas[y][x] = character;
    }

    public char getPixel(int x, int y) {
        return this.canvas[y][x];
    }

    public boolean increasePixel(int x, int y) {
        if (this.getPixel(x, y) >= MAX_CHAR) {
            return false;
        }

        this.drawPixel(x, y, (char) (this.getPixel(x, y) + 1));
        return true;
    }

    public boolean decreasePixel(int x, int y) {
        if (this.getPixel(x, y) <= MIN_CHAR) {
            return false;
        }

        this.drawPixel(x, y, (char) (this.getPixel(x, y) - 1));
        return true;
    }

    public void toUpper(int x, int y) {
        this.drawPixel(x, y, Character.toUpperCase(this.getPixel(x, y)));
    }

    public void toLower(int x, int y) {
        this.drawPixel(x, y, Character.toLowerCase(this.getPixel(x, y)));
    }

    public void fillHorizontalLine(int y, char character) {
        for (int x = 0; x < this.getWidth(); ++x) {
            this.drawPixel(x, y, character);
        }
    }

    public void fillVerticalLine(int x, char character) {
        for (int y = 0; y < this.getHeight(); ++y) {
            this.drawPixel(x, y, character);
        }
    }

    public void clear() {
        for (int y = 0; y < this.getHeight(); ++y) {
            for (int x = 0; x < this.getWidth(); ++x) {
                this.drawPixel(x, y, ' ');
            }
        }
    }
}
