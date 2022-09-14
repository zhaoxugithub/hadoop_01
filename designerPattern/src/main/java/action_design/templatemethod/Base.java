package action_design.templatemethod;

public abstract class Base {
    abstract void op1();

    abstract void op2();

    public void make() {
        op1();
        op2();
    }
}
