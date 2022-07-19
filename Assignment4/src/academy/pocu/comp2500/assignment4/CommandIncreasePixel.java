package academy.pocu.comp2500.assignment4;

public class CommandIncreasePixel extends Command {
    private char beforeSaved;
    private char afterSaved;
    private int x;
    private int y;

    public CommandIncreasePixel(int x, int y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected final boolean canRevert(Canvas canvas) {
        if (this.afterSaved == (char) DEFAULT_CHAR) {
            return false;
        }

        return this.afterSaved == canvas.getPixel(this.x, this.y);
    }


    @Override
    protected final void setAfterSaved(Canvas canvas) {
        this.afterSaved = canvas.getPixel(this.x, this.y);
    }

    @Override
    protected final boolean executeCommand(Canvas canvas) {
        if (isValidPosition(this.x, this.y)) {
            return false;
        }

        if (this.beforeSaved == (char) DEFAULT_CHAR) {
            this.beforeSaved = canvas.getPixel(this.x, this.y);
        }

        return canvas.increasePixel(this.x, this.y);
    }

    @Override
    protected final void undoCommand(Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.beforeSaved);
    }
}
