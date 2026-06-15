package lowleveldesign.patterns.decorator.violation;

public class Demo {
    public static void main(String[] args) {
        PlainPizza plainPizza = new PlainPizza();
        System.out.println(plainPizza.cost());
        /**
         * Here we have to create new class for each combination of toppings.
         * This becomes messy very quickly.
         * This problem is called class explosion.
         */
    }
}
