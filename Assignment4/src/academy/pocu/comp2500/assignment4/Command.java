package academy.pocu.comp2500.assignment4;

public abstract class Command implements ICommand {

    private Canvas canvas;
    private boolean undoAvailable;
    protected final static int DEFAULT_CHAR = 0;

    protected Command() {
    }

    protected abstract boolean canRevert(final Canvas canvas);

    protected abstract void setAfterSaved(final Canvas canvas);

    protected abstract boolean executeCommand(final Canvas canvas);

    protected abstract void undoCommand(final Canvas canvas);

    protected boolean isValidX(int x) {
        return 0 <= x && x < canvas.getWidth();
    }

    protected boolean isValidY(int y) {
        return 0 <= y && y < canvas.getHeight();
    }

    protected boolean isValidPosition(int x, int y) {
        return 0 <= x && x < canvas.getWidth() && 0 <= y && y < canvas.getHeight();
    }

    @Override
    public boolean execute(final Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        this.undoAvailable = executeCommand(this.canvas);

        if (this.undoAvailable) {
            setAfterSaved(this.canvas);
        }

        return this.undoAvailable;
    }

    @Override
    public boolean undo() {
        if (this.canvas == null || this.undoAvailable == false || canRevert(this.canvas) == false) {
            return false;
        }

        undoCommand(this.canvas);
        this.undoAvailable = false;

        setAfterSaved(this.canvas);
        return true;
    }

    @Override
    public boolean redo() {
        if (this.canvas == null || this.undoAvailable || canRevert(this.canvas) == false) {
            return false;
        }

        this.undoAvailable = executeCommand(this.canvas);
        if (this.undoAvailable) {
            setAfterSaved(this.canvas);
        }

        return this.undoAvailable;
    }
}
