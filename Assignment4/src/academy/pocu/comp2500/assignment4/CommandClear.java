package academy.pocu.comp2500.assignment4;

public class CommandClear extends Command {
    private char[][] beforeSaved;
    private char[][] afterSaved;

    public CommandClear() {
    }

    @Override
    protected boolean canRevert(Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                if (this.afterSaved[y][x] != canvas.getPixel(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    protected void setAfterSaved(Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                this.afterSaved[y][x] = canvas.getPixel(x, y);
            }
        }
    }

    @Override
    protected boolean executeCommand(Canvas canvas) {
        if (beforeSaved == null) {
            this.beforeSaved = new char[canvas.getHeight()][canvas.getWidth()];
            this.afterSaved = new char[canvas.getHeight()][canvas.getWidth()];

            for (int y = 0; y < canvas.getHeight(); y++) {
                for (int x = 0; x < canvas.getWidth(); x++) {
                    this.beforeSaved[y][x] = canvas.getPixel(x, y);
                }
            }
        }

        canvas.clear();
        return true;
    }

    @Override
    protected void undoCommand(Canvas canvas) {
        for (int y = 0; y < canvas.getHeight(); y++) {
            for (int x = 0; x < canvas.getWidth(); x++) {
                canvas.drawPixel(x, y, this.beforeSaved[y][x]);
            }
        }
    }
}