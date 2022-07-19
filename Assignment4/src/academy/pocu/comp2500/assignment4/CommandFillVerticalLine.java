package academy.pocu.comp2500.assignment4;

public class CommandFillVerticalLine extends Command {
    private char[] beforeSaved;
    private char[] afterSaved;
    private char text;
    private int x;

    public CommandFillVerticalLine(int x, char character) {
        super();

        this.x = x;
        this.text = character;
    }

    @Override
    public boolean canRevert(Canvas canvas) {
        if (this.afterSaved == null) {
            return false;
        }

        for (int y = 0; y < canvas.getHeight(); y++) {
            if (this.afterSaved[y] != canvas.getPixel(this.x, y)) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected final void setAfterSaved(Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); y++) {
            this.afterSaved[y] = canvas.getPixel(this.x, y);
        }
    }

    @Override
    public boolean executeCommand(Canvas canvas) {
        if (isValidX(this.x)) {
            return false;
        }

        if (this.beforeSaved == null) {
            this.beforeSaved = new char[canvas.getHeight()];
            this.afterSaved = new char[canvas.getHeight()];

            for (int y = 0; y < canvas.getHeight(); y++) {
                this.beforeSaved[y] = canvas.getPixel(this.x, y);
            }
        }

        canvas.fillVerticalLine(this.x, this.text);
        return true;
    }

    @Override
    public void undoCommand(Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); y++) {
            canvas.drawPixel(this.x, y, this.beforeSaved[y]);
        }
    }
}
