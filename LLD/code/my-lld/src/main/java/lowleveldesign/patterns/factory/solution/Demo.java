package lowleveldesign.patterns.factory.solution;

public class Demo {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.notifyUser("EMAIL", "Hello, this is a test email");
        notificationService.notifyUser("SMS", "Hello, this is a test SMS");
        /**
         * NotificationService no longer creates objects directly. It only asks the factory for a Notification.
         * That is the main idea of Factory Method: hide object creation logic from the client code.
         */

    }
}
