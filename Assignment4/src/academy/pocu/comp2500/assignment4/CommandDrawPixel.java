package academy.pocu.comp2500.assignment4;

public class CommandDrawPixel extends Command {
    private char beforeSaved;
    private char afterSaved;

    private char text;
    private int x;
    private int y;

    public CommandDrawPixel(int x, int y, char character) {
        super();

        this.x = x;
        this.y = y;
        this.text = character;
    }

    @Override
    protected final boolean canRevert(Canvas canvas) {
        if (this.afterSaved == (char) 0) {
            return false;
        }

        return this.afterSaved == canvas.getPixel(this.x, this.y);
    }

    @Override
    protected final void setAfterSaved(Canvas canvas) {
        this.afterSaved = canvas.getPixel(this.x, this.y);
    }

    @Override
    protected boolean executeCommand(Canvas canvas) {
        if (isValidPosition(x, y) == false) {
            return false;
        }

        if (this.beforeSaved == (char) DEFAULT_CHAR) {
            this.beforeSaved = canvas.getPixel(this.x, this.y);
        }

        canvas.drawPixel(this.x, this.y, this.text);
        return true;
    }

    @Override
    protected void undoCommand(Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.beforeSaved);
    }
}
