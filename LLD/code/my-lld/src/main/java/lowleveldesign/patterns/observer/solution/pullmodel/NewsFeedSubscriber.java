package lowleveldesign.patterns.observer.solution.pullmodel;

public interface NewsFeedSubscriber {
    void onNewsUpdated(NewsFeed newsFeed);
}
