SOLID stands for
1. S - Single REsponsibility
2. O - Open/Closed
3. L - Liskov Substitution
4. I - Interface Segregation
5. D - Dependency Inversion

Advantages of using SOLID principles:
1. Code is more maintainable
2. Help us write more readable better code
3. Avoid duplicate code
4. Easy to understand
5. Flexible code
6. Easy to test
7. Reduce complexity


## 1. Single Responsibility Principle

A class should have one and only one reason to change meaning it shoudld have one and only one job or responsibility.

##2. Open Closed Principle

A class should be open for extension and closed for modification. means that new functionality can be added through inheritance rather than by modifying exwsting code
As existing code is already tested and deployed in production, adding modificaitons would introduce an additional risk and require additional testing efforts.

SRP:
“Does this class have only one job?”

OCP:
“Can I add new behavior without changing existing code?”

SRP is about separating responsibilities. OCP is about extending behavior safely.

##3 Liskov Substitution Principle
It means that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.
means if class B is subtype of A then we should be able to replace objects of A with B without breaking the behavior of the application.
LSP violation can happen when a child class:

throws unexpected exceptions
does nothing when it should do something
returns wrong or fake results
requires stricter input than parent
gives weaker output than parent
changes expected behavior

If a child class/subclass says it is a type of the parent, it must behave in a way the parent promises.So LSP is about behavioral correctness, not just exceptions.
# Liskov Substitution Principle: Is It Only About `UnsupportedOperationException`?

No. **LSP is not only about throwing `UnsupportedOperationException`.**

Throwing `UnsupportedOperationException` is just the **most obvious symptom** of an LSP violation.

LSP is mainly about this:

> If a child class or subclass says it is a type of the parent, it must behave in a way the parent promises.

So LSP is about **behavioral correctness**, not just exceptions.

---

## Example 1: LSP Violation with Exception

```java
interface Bird {
    void fly();
}
```

```java
class Ostrich implements Bird {
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}
```

This violates LSP because code expects every `Bird` to fly.

```java
void makeBirdFly(Bird bird) {
    bird.fly();
}
```

This works for a flying bird, but breaks for `Ostrich`.

---

## Example 2: LSP Violation Without Exception

```java
interface Payment {
    boolean pay(double amount);
}
```

Expected behavior:

```text
pay(amount) returns true if payment succeeds
pay(amount) returns false if payment fails
```

Bad implementation:

```java
class FakePayment implements Payment {
    public boolean pay(double amount) {
        return true;
    }
}
```

This does not throw an exception, but it still violates LSP.

Why?

Because it lies. It says payment succeeded even though no real payment happened.

So the child implementation does not behave correctly as a `Payment`.

---

## Example 3: LSP Violation by Doing Nothing

```java
interface Printer {
    void print(String document);
}
```

```java
class BrokenPrinter implements Printer {
    public void print(String document) {
        // Does nothing
    }
}
```

No exception is thrown.

But if code expects this:

```java
void printInvoice(Printer printer) {
    printer.print("Invoice");
}
```

Then `BrokenPrinter` breaks the expected behavior of `Printer`.

So this can also violate LSP.

---

## Example 4: LSP Violation by Changing Rules

Parent/interface allows any positive amount:

```java
interface Discount {
    double apply(double amount);
}
```

Expected behavior:

```text
Any positive amount is accepted.
```

Bad implementation:

```java
class PremiumDiscount implements Discount {
    public double apply(double amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("Minimum amount is 1000");
        }

        return amount * 0.20;
    }
}
```

This violates LSP because the child class made the rules stricter than the parent promised.

The parent says:

```text
Give me any positive amount.
```

The child says:

```text
No, only amount above 1000.
```

That breaks substitution.

---

## LSP Violation Can Happen When a Child Class

```text
Throws unexpected exceptions
Does nothing when it should do something
Returns wrong or fake results
Requires stricter input than the parent
Gives weaker output than the parent
Changes expected behavior
```

---

## Simple Way to Remember

`UnsupportedOperationException` is a common example, but **LSP is really about whether the child behaves correctly as the parent type**.

Ask this question:

> Can I replace the parent object with the child object without breaking the expected behavior?

If yes, it follows LSP.

If no, it violates LSP.


##4 Interface seggregation Principle 
A class should not be forced to implement methods it does not use.

##5 Dependency Inversion Principle

The **Dependency Inversion Principle**, or **DIP**, says:

> High-level classes should not depend directly on low-level classes.  
> Both should depend on abstractions, like interfaces.

In simple words:

> Do not hardcode concrete classes inside business logic. Depend on interfaces instead.

---

## First Understand High-Level and Low-Level

Suppose we have user registration.

### High-Level Class

This contains business logic:

```java
public class UserService {
    public void registerUser(String email) {
        // registration flow
    }
}
```

`UserService` is high-level because it handles the main business rule.

### Low-Level Class

This handles technical details:

```java
public class EmailSender {
    public void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email);
    }
}
```

`EmailSender` is low-level because it handles a detail: sending email.

---

## DIP Violation

```java
public class UserService {

    private EmailSender emailSender = new EmailSender();

    public void registerUser(String email) {
        System.out.println("Saving user: " + email);

        emailSender.sendEmail(email, "Welcome!");
    }
}
```

### What Is the Problem?

`UserService` directly depends on `EmailSender`.

```java
private EmailSender emailSender = new EmailSender();
```

This creates tight coupling.

Now if tomorrow you want to send SMS instead of email, you must modify `UserService`.

```java
private SmsSender smsSender = new SmsSender();
```

That is bad because the business logic class is tightly connected to a specific low-level implementation.

---

## Better Solution: Depend on an Interface

Create an abstraction:

```java
public interface NotificationSender {
    void send(String to, String message);
}
```

Now email sender implements that interface:

```java
public class EmailSender implements NotificationSender {

    public void send(String to, String message) {
        System.out.println("Sending email to " + to + ": " + message);
    }
}
```

SMS sender can also implement it:

```java
public class SmsSender implements NotificationSender {

    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
```

Now `UserService` depends on the interface, not the concrete class:

```java
public class UserService {

    private final NotificationSender notificationSender;

    public UserService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void registerUser(String email) {
        System.out.println("Saving user: " + email);

        notificationSender.send(email, "Welcome!");
    }
}
```

Usage:

```java
NotificationSender sender = new EmailSender();
UserService userService = new UserService(sender);

userService.registerUser("test@example.com");
```

Or later:

```java
NotificationSender sender = new SmsSender();
UserService userService = new UserService(sender);

userService.registerUser("9876543210");
```

`UserService` did not change.

That follows DIP.

---

## Why Is This Better?

Because `UserService` only knows this:

```java
NotificationSender
```

It does not care whether the actual sender is:

```text
EmailSender
SmsSender
WhatsAppSender
PushNotificationSender
```

So we can add new notification types without changing `UserService`.

---

## Simple Memory

Bad:

```text
UserService directly creates EmailSender.
```

Good:

```text
UserService depends on NotificationSender interface.
EmailSender implements NotificationSender.
SmsSender implements NotificationSender.
```

---

## DIP vs Dependency Injection

These two are related, but not the same.

### Dependency Inversion Principle

This is the design principle:

```text
Depend on abstractions, not concrete classes.
```

### Dependency Injection

This is one way to apply DIP:

```java
public UserService(NotificationSender notificationSender) {
    this.notificationSender = notificationSender;
}
```

Here, the dependency is passed from outside instead of being created inside the class.

So:

```text
DIP = principle
Dependency Injection = technique to achieve it
```

---

## Final Idea

DIP asks:

> Is my business logic depending directly on technical details?

If yes, improve it by introducing an interface.

```text
High-level business code -> interface
Low-level technical code -> interface
```

That is Dependency Inversion Principle.


