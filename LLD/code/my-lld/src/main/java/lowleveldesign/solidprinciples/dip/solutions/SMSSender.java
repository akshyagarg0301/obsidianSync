package lowleveldesign.solidprinciples.dip.solutions;

public class SMSSender implements NotificationSender{
    @Override
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + " with message: " + message);
    }
}
