package lowleveldesign.patterns.observer.solution.pullmodel;

import java.util.ArrayList;
import java.util.List;

public class PullBasedNewsAgency implements NewsFeed {
    private final List<NewsFeedSubscriber> subscribers = new ArrayList<>();

    private String latestHeadline;
    private String category;
    private String publishedAt;

    public void subscribe(NewsFeedSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(NewsFeedSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishNews(String headline, String category, String publishedAt) {
        this.latestHeadline = headline;
        this.category = category;
        this.publishedAt = publishedAt;

        notifySubscribers();
    }

    private void notifySubscribers() {
        for (NewsFeedSubscriber subscriber : subscribers) {
            subscriber.onNewsUpdated(this);
        }
    }

    @Override
    public String getLatestHeadline() {
        return latestHeadline;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getPublishedAt() {
        return publishedAt;
    }
}
