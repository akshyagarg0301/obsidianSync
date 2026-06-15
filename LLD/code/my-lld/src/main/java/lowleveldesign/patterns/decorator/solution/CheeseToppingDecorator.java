package lowleveldesign.patterns.decorator.solution;

public class CheeseToppingDecorator extends PizzaDecorator {

    CheeseToppingDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int cost() {
        return pizza.cost() + 20;
    }

    @Override
    public String description() {
        return pizza.description() + ", Cheese";
    }
}
