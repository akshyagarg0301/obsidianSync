package lowleveldesign.patterns.factory.solution;

public class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equals("EMAIL")) {
            return new EmailNotification();
        } else if (type.equals("SMS")) {
            return new SmsNotification();
        }

        throw new IllegalArgumentException("Invalid notification type");
    }
}
