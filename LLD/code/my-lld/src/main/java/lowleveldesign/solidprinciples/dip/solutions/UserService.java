package lowleveldesign.solidprinciples.dip.solutions;

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
