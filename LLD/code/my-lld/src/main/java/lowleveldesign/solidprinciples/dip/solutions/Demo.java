package lowleveldesign.solidprinciples.dip.solutions;

public class Demo {
    public static void main(String[] args) {
        NotificationSender sender = new EmailSender();
        UserService userService = new UserService(sender);
        userService.registerUser("test@example.com");
    }
}
