package academy.pocu.comp2500.assignment4;

public class CommandToUpper extends Command {
    private char beforeSaved;
    private char afterSaved;

    private int x;
    private int y;

    public CommandToUpper(int x, int y) {
        super();

        this.x = x;
        this.y = y;
    }

    @Override
    public boolean canRevert(Canvas canvas) {
        if (this.afterSaved == (char) DEFAULT_CHAR) {
            return false;
        }

        return this.afterSaved == canvas.getPixel(this.x, this.y);
    }

    @Override
    public void setAfterSaved(Canvas canvas) {
        this.afterSaved = canvas.getPixel(this.x, this.y);
    }

    @Override
    public boolean executeCommand(Canvas canvas) {
        if (isValidPosition(this.x, this.y) == false) {
            return false;
        }

        if (this.beforeSaved == DEFAULT_CHAR) {
            this.beforeSaved = canvas.getPixel(this.x, this.y);
        }

        canvas.toUpper(this.x, this.y);
        return true;
    }

    @Override
    public void undoCommand(final Canvas canvas) {
        canvas.drawPixel(this.x, this.y, this.beforeSaved);
    }
}
