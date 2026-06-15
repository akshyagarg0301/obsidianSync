package lowleveldesign.patterns.decorator.solution;

public class Demo {
    public static void main(String[] args) {
        Pizza pizza = new OliveToppingDecorator(
                new CheeseToppingDecorator(
                        new PlainPizza()
                )
        );

        System.out.println(pizza.description());
        System.out.println(pizza.cost());
    }
    /**
     * Now, adding a new topping does not require changing existing classes.
     */
}
