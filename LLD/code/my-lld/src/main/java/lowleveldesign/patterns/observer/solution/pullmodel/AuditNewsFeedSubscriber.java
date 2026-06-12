package lowleveldesign.patterns.observer.solution.pullmodel;

public class AuditNewsFeedSubscriber implements NewsFeedSubscriber {
    @Override
    public void onNewsUpdated(NewsFeed newsFeed) {
        System.out.println(
                "Audit: " +
                        newsFeed.getLatestHeadline() +
                        ", category: " +
                        newsFeed.getCategory() +
                        ", published at: " +
                        newsFeed.getPublishedAt()
        );
    }
}
