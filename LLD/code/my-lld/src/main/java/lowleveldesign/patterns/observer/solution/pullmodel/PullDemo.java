package lowleveldesign.patterns.observer.solution.pullmodel;

public class PullDemo {
    public static void main(String[] args) {
        PullBasedNewsAgency agency = new PullBasedNewsAgency();

        agency.subscribe(new EmailNewsFeedSubscriber());
        agency.subscribe(new AuditNewsFeedSubscriber());

        agency.publishNews(
                "Java Observer Pattern",
                "Design Patterns",
                "10:30 AM"
        );
        /**
         * Here, the subject sends itself:
         * observer.update(this);
         */

    }
}
