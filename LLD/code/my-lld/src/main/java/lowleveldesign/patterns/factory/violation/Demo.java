package lowleveldesign.patterns.factory.violation;

public class Demo {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.notifyUser("EMAIL", "Hello, this is a test email");
        notificationService.notifyUser("SMS", "Hello, this is a test SMS");
        /**
         * The class NotificationService is:
         *
         * tightly coupled to EmailNotification and SmsNotification
         * responsible for both object creation and business logic
         * forced to change whenever a new notification type is added
         */
    }
}
