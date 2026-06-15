package lowleveldesign.patterns.factory.violation;


public class NotificationService {

        public void notifyUser(String type, String message) {
            Notification notification;

            if (type.equals("EMAIL")) {
                notification = new EmailNotification();
            } else if (type.equals("SMS")) {
                notification = new SmsNotification();
            } else {
                throw new IllegalArgumentException("Invalid notification type");
            }

            notification.send(message);
        }

}
