package lowleveldesign.solidprinciples.dip.violations;

public class Demo {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.registerUser("test@example.com");
    }
}
/**
 * here UserService directly depends on EmailSender. This is a violation of DIP.
 * This creates tight coupling.
 * Now if tomorrow you want to send SMS instead of email, you must modify UserService.
 */
