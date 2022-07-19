package academy.pocu.comp2500.assignment4;

public class CommandFillHorizontalLine extends Command {
    private char[] beforeSaved;
    private char[] afterSaved;
    private char text;
    private int y;

    public CommandFillHorizontalLine(int y, char character) {
        super();

        this.y = y;
        this.text = character;
    }

    @Override
    public void setAfterSaved(Canvas canvas) {
        for (int x = 0; x < canvas.getWidth(); x++) {
            this.afterSaved[x] = canvas.getPixel(x, this.y);
        }
    }

    @Override
    protected final boolean canRevert(Canvas canvas) {
        if (this.afterSaved == null) {
            return false;
        }

        for (int x = 0; x < canvas.getWidth(); x++) {
            if (this.afterSaved[x] != canvas.getPixel(x, this.y)) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected final boolean executeCommand(Canvas canvas) {
        if (isValidY(this.y) == false) {
            return false;
        }

        if (this.beforeSaved == null) {
            this.beforeSaved = new char[canvas.getWidth()];
            this.afterSaved = new char[canvas.getWidth()];

            for (int x = 0; x < canvas.getWidth(); x++) {
                this.beforeSaved[x] = canvas.getPixel(x, this.y);
            }
        }

        canvas.fillHorizontalLine(this.y, this.text);
        return true;
    }

    @Override
    protected final void undoCommand(Canvas canvas) {
        for (int x = 0; x < canvas.getWidth(); x++) {
            canvas.drawPixel(x, this.y, this.beforeSaved[x]);
        }
    }
}
