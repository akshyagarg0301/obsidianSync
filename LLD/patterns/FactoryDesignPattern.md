# Factory Method Design Pattern - Revision Notes

## 1. What is Factory Method?

The **Factory Method** is a creational design pattern that hides object creation logic inside a method.

Instead of creating objects directly using `new`, the client asks a factory method to create the object.

```java
Notification notification = notificationFactory.createNotification("EMAIL");
```

The client does not need to know which concrete class is being created internally.

---

## 2. Main Idea

Factory Method helps you create objects without exposing the object creation logic to the caller.

The caller depends on an interface or abstract type, while the factory decides the actual implementation.

```java
interface Notification {
    void send(String message);
}
```

Concrete implementations:

```java
class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
```

Factory class:

```java
class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equals("EMAIL")) {
            return new EmailNotification();
        } else if (type.equals("SMS")) {
            return new SmsNotification();
        }

        throw new IllegalArgumentException("Unknown notification type");
    }
}
```

Usage:

```java
NotificationFactory factory = new NotificationFactory();

Notification notification = factory.createNotification("EMAIL");
notification.send("Hello!");
```

---

## 3. Problem Without Factory Method

Without Factory Method, object creation is scattered across the codebase.

```java
Notification notification = new EmailNotification();
```

If the implementation changes later, many places in the code may need to be updated.

Example problem:

```java
if (type.equals("EMAIL")) {
    notification = new EmailNotification();
} else if (type.equals("SMS")) {
    notification = new SmsNotification();
}
```

If this logic appears in many places, the code becomes hard to maintain.

---

## 4. Solution With Factory Method

Move the object creation logic to a separate factory method.

```java
Notification notification = factory.createNotification(type);
```

Now the creation logic is centralized in one place.

---

## 5. Real-World Example: Payment Processor

Suppose an application supports multiple payment methods.

Interface:

```java
interface PaymentProcessor {
    void pay(double amount);
}
```

Implementations:

```java
class CreditCardProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid by credit card: " + amount);
    }
}

class PaypalProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid by PayPal: " + amount);
    }
}
```

Factory:

```java
class PaymentProcessorFactory {
    public PaymentProcessor create(String method) {
        switch (method) {
            case "CREDIT_CARD":
                return new CreditCardProcessor();
            case "PAYPAL":
                return new PaypalProcessor();
            default:
                throw new IllegalArgumentException("Unsupported payment method");
        }
    }
}
```

Usage:

```java
PaymentProcessor processor =
    new PaymentProcessorFactory().create("PAYPAL");

processor.pay(100.0);
```

---

## 6. When Should You Use Factory Method?

Use Factory Method when:

- Object creation logic is complex.
- The exact class to create depends on input or configuration.
- You want to avoid using `new` everywhere.
- You want the code to depend on interfaces instead of concrete classes.
- You want to centralize object creation logic.
- New object types may be added in the future.

---

## 7. Benefits

### 1. Encapsulation of Object Creation

The client does not need to know how objects are created.

```java
factory.createNotification("EMAIL");
```

The factory handles the details internally.

### 2. Loose Coupling

The client depends on an interface, not on concrete classes.

```java
Notification notification;
```

Instead of:

```java
EmailNotification notification;
```

### 3. Easy Maintenance

If object creation logic changes, only the factory class needs to be updated.

### 4. Cleaner Code

The business logic does not get mixed with object creation logic.

---

## 8. Factory Method vs Constructor

| Constructor | Factory Method |
|---|---|
| Creates one specific class | Can choose between multiple classes |
| Uses `new` directly | Hides `new` inside a method |
| Caller knows the concrete class | Caller may only know the interface |
| Less flexible | More flexible |

Example constructor usage:

```java
EmailNotification notification = new EmailNotification();
```

Example factory method usage:

```java
Notification notification = factory.createNotification("EMAIL");
```

---

## 9. Factory Method vs Simple Factory

A **Simple Factory** usually has one factory class with a method that returns different objects based on input.

```java
class NotificationFactory {
    public Notification createNotification(String type) {
        // creation logic
    }
}
```

A classic **Factory Method Pattern** often uses inheritance, where subclasses decide which object to create.

Example:

```java
abstract class NotificationCreator {
    abstract Notification createNotification();
}

class EmailNotificationCreator extends NotificationCreator {
    Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsNotificationCreator extends NotificationCreator {
    Notification createNotification() {
        return new SmsNotification();
    }
}
```

In interviews, many people loosely call both approaches "Factory Method," but technically they are slightly different.

---

## 10. Classic Factory Method Structure

```java
interface Product {
    void use();
}

class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}

abstract class Creator {
    abstract Product createProduct();

    public void doSomething() {
        Product product = createProduct();
        product.use();
    }
}

class CreatorA extends Creator {
    Product createProduct() {
        return new ConcreteProductA();
    }
}

class CreatorB extends Creator {
    Product createProduct() {
        return new ConcreteProductB();
    }
}
```

Usage:

```java
Creator creator = new CreatorA();
creator.doSomething();
```

Here, `CreatorA` decides to create `ConcreteProductA`.

---

## 11. Important Terms

| Term | Meaning |
|---|---|
| Product | Interface or abstract class for objects being created |
| Concrete Product | Actual implementation class |
| Creator | Class that declares the factory method |
| Concrete Creator | Subclass that implements the factory method |
| Client | Code that uses the created object |

---

## 12. Quick Memory Trick

Think of a restaurant.

You order food from the waiter. You do not directly go to the kitchen and cook it.

Similarly, the client asks the factory for an object. The client does not directly create the object.

```java
factory.create("PIZZA");
```

The factory decides how to create it.

---

## 13. Interview-Friendly Definition

Factory Method is a creational design pattern that defines a method for creating objects, but lets the factory or subclasses decide which concrete class to instantiate.

It helps achieve loose coupling by making the client depend on an interface rather than concrete implementations.

---

## 14. Common Interview Questions

### Q1. Why use Factory Method?

To centralize object creation logic, reduce coupling, and make code easier to maintain and extend.

### Q2. What problem does it solve?

It prevents object creation logic from being scattered across the codebase.

### Q3. Does Factory Method remove the need for `new`?

No. It hides `new` inside the factory method so the client does not use it directly.

### Q4. Is Factory Method a creational pattern?

Yes. It is one of the creational design patterns.

### Q5. What is the main advantage?

The client code does not depend on concrete classes.

---

## 15. One-Line Summary

Factory Method lets you create objects through a method instead of directly using constructors, so the client does not need to know the exact class being created.

---

## 16. Revision Checklist

Before an interview or exam, remember:

- Factory Method is a creational design pattern.
- It hides object creation logic.
- It promotes loose coupling.
- It usually returns an interface or abstract type.
- It centralizes object creation.
- It is useful when object type depends on input or configuration.
- It makes future changes easier.

