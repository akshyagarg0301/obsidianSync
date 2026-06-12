package lowleveldesign.patterns.observer.solution.pushmodel;

public class SmsSubscriber implements NewsSubscriber{
    @Override
    public void update(String news) {
        System.out.println("SMS received news: " + news);
    }
}
