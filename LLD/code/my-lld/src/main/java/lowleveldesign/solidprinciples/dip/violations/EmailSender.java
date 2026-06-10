package lowleveldesign.solidprinciples.dip.violations;

public class EmailSender {
    public void sendEmail(String email, String message) {
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}
