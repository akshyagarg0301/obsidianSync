package lowleveldesign.patterns.observer.violation;

public class SmsService {

    public void sendSms(String news) {
        System.out.println("SMS sent:" + news);
    }
}
