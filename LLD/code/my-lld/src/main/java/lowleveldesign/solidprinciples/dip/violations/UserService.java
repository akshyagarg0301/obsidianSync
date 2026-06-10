package lowleveldesign.solidprinciples.dip.violations;

public class UserService {
    private final EmailSender emailSender = new EmailSender();

    public void registerUser(String email) {
        System.out.println("Saving user: " + email);
        emailSender.sendEmail(email, "Welcome!");
    }
}
