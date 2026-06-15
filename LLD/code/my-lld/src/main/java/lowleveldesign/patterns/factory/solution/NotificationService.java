package lowleveldesign.patterns.factory.solution;

public class NotificationService {
    private NotificationFactory factory = new NotificationFactory();

    public void notifyUser(String type, String message) {
        Notification notification = factory.createNotification(type);
        notification.send(message);
    }
}
