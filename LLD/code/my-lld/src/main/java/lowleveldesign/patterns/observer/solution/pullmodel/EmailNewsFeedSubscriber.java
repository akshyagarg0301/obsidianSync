package lowleveldesign.patterns.observer.solution.pullmodel;

public class EmailNewsFeedSubscriber implements NewsFeedSubscriber {
    @Override
    public void onNewsUpdated(NewsFeed newsFeed) {
        System.out.println("Email headline: " + newsFeed.getLatestHeadline());
    }
}