It is a behavioral design pattern that defines multiple algorithms, encapsulates their dedicated logic in dedicated classes and enables changing an alogirthm's
behavior at runtime. It's useful when you have multiple ways to perform a task and want to choose the approach dynamically.

Example:- Go from home to office
Possible Strategies:-
1. By car
2. By bike
3. By bus
4. By train
5. By walk

The goal is same but methods are different
```
interface TravelStrategy {
    void travel();
}
```

```
class CarStrategy implements TravelStrategy {
    public void travel() {
        System.out.println("Travel by car");
    }
}

class BikeStrategy implements TravelStrategy {
    public void travel() {
        System.out.println("Travel by bike");
    }
}

class BusStrategy implements TravelStrategy {
    public void travel() {
        System.out.println("Travel by bus");
    }
}
```

```aiexclude
class TravelContext {
    private TravelStrategy strategy;

    public TravelContext(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void startTravel() {
        strategy.travel();
    }
}

TravelContext context = new TravelContext(new CarStrategy());
context.startTravel();
```