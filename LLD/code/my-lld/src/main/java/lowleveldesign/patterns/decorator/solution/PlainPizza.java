package lowleveldesign.patterns.decorator.solution;

public class PlainPizza implements Pizza {
    @Override
    public int cost() {
        return 100;
    }

    @Override
    public String description() {
        return "Plain Pizza";
    }
}
