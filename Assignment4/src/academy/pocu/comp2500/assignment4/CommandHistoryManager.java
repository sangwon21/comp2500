package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private final Canvas canvas;
    private final ArrayList<ICommand> undoCommands;
    private final ArrayList<ICommand> redoCommands;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
        this.undoCommands = new ArrayList<>();
        this.redoCommands = new ArrayList<>();
    }

    public boolean execute(ICommand command) {
        if (command.execute(this.canvas)) {
            this.undoCommands.add(command);
            this.redoCommands.clear();
            return true;
        }

        return false;
    }

    public boolean canUndo() {
        return this.undoCommands.size() > 0;
    }

    public boolean undo() {
        if (canUndo() == false) {
            return false;
        }

        ICommand command = undoCommands.get(undoCommands.size() - 1);

        if (command.undo()) {
            this.undoCommands.remove(undoCommands.size() - 1);
            this.redoCommands.add(0, command);
            return true;
        }

        return false;
    }

    public boolean canRedo() {
        return this.redoCommands.size() > 0;
    }

    public boolean redo() {
        if (canRedo() == false) {
            return false;
        }

        ICommand command = this.redoCommands.get(0);


        if (command.redo()) {
            this.redoCommands.remove(0);
            this.undoCommands.add(command);
            return true;
        }

        return false;
    }
}
