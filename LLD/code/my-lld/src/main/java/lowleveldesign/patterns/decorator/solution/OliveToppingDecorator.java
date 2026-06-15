package lowleveldesign.patterns.decorator.solution;

public class OliveToppingDecorator extends PizzaDecorator{
    public OliveToppingDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String description() {
        return pizza.description() + " , Olive" ;
    }

    @Override
    public int cost() {
        return  pizza.cost() + 15;
    }
}
