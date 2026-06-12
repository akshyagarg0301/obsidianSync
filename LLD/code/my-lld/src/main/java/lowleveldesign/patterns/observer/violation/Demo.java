package lowleveldesign.patterns.observer.violation;

public class Demo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        newsAgency.setLatestNews("Breaking News");

        /**
         * Now if i have to add another observer then i have to change NewsAgency
         * which causes break of Open Closed Principle. Also Sms and Email service are tightly coupled here. NewsAgency is depending on concrete classes
         * News Agency knows too much about how notifications are sent.
         */
    }
}
