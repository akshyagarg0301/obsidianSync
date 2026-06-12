package lowleveldesign.patterns.observer.solution.pullmodel;

public interface NewsFeed {
    String getLatestHeadline();
    String getCategory();
    String getPublishedAt();
}
