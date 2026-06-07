LLD majorly focusses on classess and object within a system.

	HLD -> LLD -> Actual Code

Goal is :
1.  To write clean code
2. Code should be flexible and maintainable 
3. Code should be easy to test.



# Categories
There are 3 patterns under which all design patterns are put into:-

1. Creational :- It controls the object creation. Various types of Creational Patterns are:-
	1. Singleton
	2. Builder
	3. Factory
	4. Abstract Factory
	5. Object Pool
	6. Prototype
	
2. Structural:- It focus on how different classses/objects are arranged together so that larger problem can be solved in most flexible way. It is about shape of the object. Various Design Pattern are:-
	1. Decorator 
	2. Proxy
	3. Composite
	4. Adapter
	5. Bridge
	6. Facade
	7. Flyweight
	
3. Behavioral:- It focus on how different object communicate or interact with each other. In structural pattern, we created skeleton of system but how skeleton behaves is guided by the behavioral pattern. **Behavioral patterns** are about **how objects communicate and divide responsibility**. Various Patterns are:-
	1. State
	2. Strategy
	3. Observer
	4. Chain of responsibility
	5. Iterator
	6. Visitor
	7. Command


## Structural pattern: Decorator

 You have a basic coffee:
 
```
Coffee coffee = new BasicCoffee();
```
Now you want to add milk, sugar, and whipped cream without creating many subclasses like:
```MilkSugarWhippedCoffee
MilkCoffee
SugarCoffee
MilkWhippedCoffee
```

Instead, you wrap the object:
```
Coffee coffee = new WhippedCream(
                    new Sugar(
                      new Milk(
                        new BasicCoffee()
                      )
                    )
                  );
```


## Behavioral pattern: Strategy

Now imagine the customer can pay in different ways:
```
paymentService.pay(new CreditCardPayment());
paymentService.pay(new UPIPayment());
paymentService.pay(new CashPayment());
```
Each payment method has different behavior:
```
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid using credit card");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid using cash");
    }
}
```

Here, the focus is not on wrapping or composing objects.

The focus is on **choosing different behavior**.

So this is **behavioral**.

## Creation Pattern: Factory
Imagine a customer orders different types of coffee:
```
Coffee coffee = new Latte();
Coffee coffee = new Espresso();
Coffee coffee = new Cappuccino();
```

Without a creational pattern, your code may have object creation logic everywhere:
```
Coffee coffee;

if (type.equals("latte")) {
    coffee = new Latte();
} else if (type.equals("espresso")) {
    coffee = new Espresso();
} else if (type.equals("cappuccino")) {
    coffee = new Cappuccino();
}
```
This works, but now many parts of your app need to know **which class to create**.

Instead, use a **Factory**.
```
interface Coffee {
    void prepare();
}

class Latte implements Coffee {
    public void prepare() {
        System.out.println("Preparing latte");
    }
}

class Espresso implements Coffee {
    public void prepare() {
        System.out.println("Preparing espresso");
    }
}

class Cappuccino implements Coffee {
    public void prepare() {
        System.out.println("Preparing cappuccino");
    }
}
```

Now create a factory:

```
class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        if (type.equalsIgnoreCase("latte")) {
            return new Latte();
        } else if (type.equalsIgnoreCase("espresso")) {
            return new Espresso();
        } else if (type.equalsIgnoreCase("cappuccino")) {
            return new Cappuccino();
        }

        throw new IllegalArgumentException("Unknown coffee type");
    }
}
```

Now the main code becomes simpler:
```
Coffee coffee = CoffeeFactory.createCoffee("latte");
coffee.prepare();
```


## Using all three together

```
Coffee coffee = CoffeeFactory.createCoffee("latte"); // Creational

coffee = new Milk(coffee);                           // Structural
coffee = new Sugar(coffee);                          // Structural

paymentService.setPaymentStrategy(new CardPayment()); // Behavioral
paymentService.pay(100);
```

**Structural patterns are about the “shape” of your objects.**  
**Behavioral patterns** are about the “conversation” between your objects.