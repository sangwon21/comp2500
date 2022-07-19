package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class OverdrawAnalyzer extends Canvas {
    private ArrayList<ArrayList<Character>> historyArray;

    public OverdrawAnalyzer(final int width, final int height) {
        super(width, height);

        this.historyArray = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.historyArray.add(new ArrayList<>());
            }
        }
    }

    @Override
    public void drawPixel(int x, int y, char text) {
        if (super.getPixel(x, y) == text) {
            return;
        }

        if (this.historyArray != null) {
            ArrayList<Character> history = getPixelHistory(x, y);
            history.add(text);
        }

        super.drawPixel(x, y, text);
    }

    public ArrayList<Character> getPixelHistory(int x, int y) {
        return this.historyArray.get(x + y * getWidth());
    }

    public int getOverdrawCount(int x, int y) {
        return getPixelHistory(x, y).size();
    }

    public int getOverdrawCount() {
        int sum = 0;

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                sum += getOverdrawCount(x, y);
            }
        }

        return sum;
    }
}
