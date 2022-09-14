package action_design.command;

public abstract class Command {
    abstract void doit();
    abstract void undo();
}
