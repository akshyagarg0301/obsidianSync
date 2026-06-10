package lowleveldesign.solidprinciples.dip.solutions;

public interface NotificationSender {
    void send(String to, String message);
}
