package academy.pocu.comp2500.assignment4;

public class CommandDecreasePixel extends Command {
    private char beforeSaved;
    private char afterSaved;
    private int x;
    private int y;

    public CommandDecreasePixel(int x, int y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected boolean canRevert(Canvas canvas) {
        if (this.afterSaved == (char) DEFAULT_CHAR) {
            return false;
        }

        return this.afterSaved == canvas.getPixel(this.x, this.y);
    }

    @Override
    protected void setAfterSaved(Canvas canvas) {
        this.afterSaved = canvas.getPixel(x, y);
    }

    @Override
    protected boolean executeCommand(Canvas canvas) {
        if (isValidPosition(x, y) == false) {
            return false;
        }

        if (this.beforeSaved == (char) DEFAULT_CHAR) {
            this.beforeSaved = canvas.getPixel(this.x, this.y);
        }

        return canvas.decreasePixel(this.x, this.y);
    }

    @Override
    protected void undoCommand(Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.beforeSaved);
    }
}
