package lowleveldesign.solidprinciples.dip.solutions;

public class EmailSender implements NotificationSender {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending email to " + to + " with message: " + message);
    }
}
