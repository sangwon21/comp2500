package academy.pocu.comp2500.assignment4;

public class CommandToLower extends Command {
    private char beforeSaved;
    private char afterSaved;
    private int x;
    private int y;

    public CommandToLower(int x, int y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    protected final boolean canRevert(final Canvas canvas) {
        if (this.afterSaved == DEFAULT_CHAR) {
            return false;
        }

        return this.afterSaved == canvas.getPixel(this.x, this.y);
    }

    @Override
    protected final void setAfterSaved(final Canvas canvas) {
        this.afterSaved = canvas.getPixel(this.x, this.y);
    }

    @Override
    protected final boolean executeCommand(final Canvas canvas) {
        if (this.isValidPosition(x, y) == false) {
            return false;
        }

        if (this.beforeSaved == (char) DEFAULT_CHAR) {
            this.beforeSaved = canvas.getPixel(this.x, this.y);
        }

        canvas.toLower(this.x, this.y);
        return true;
    }

    @Override
    protected final void undoCommand(final Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.beforeSaved);
    }


}
