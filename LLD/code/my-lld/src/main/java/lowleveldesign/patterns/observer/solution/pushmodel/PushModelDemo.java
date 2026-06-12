package lowleveldesign.patterns.observer.solution.pushmodel;

public class PushModelDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsSubscriber emailSubscriber = new EmailSubscriber();
        NewsSubscriber smsSubscriber = new SmsSubscriber();

        newsAgency.registerObserver(emailSubscriber);
        newsAgency.registerObserver(smsSubscriber);
        newsAgency.setLatestNews("Observer pattern explained in Java");

        /**
         * in push model:- The observer does not ask for data. It receives the data directly.
         */
    }
}
