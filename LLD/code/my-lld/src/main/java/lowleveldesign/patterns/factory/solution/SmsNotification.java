package lowleveldesign.patterns.factory.solution;

import lowleveldesign.patterns.factory.solution.Notification;

public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}
