package lowleveldesign.patterns.observer.violation;

public class EmailService {
    public void sendEmail(String news) {
        System.out.println("Email sent:" + news);
    }
}
