package lowleveldesign.patterns.observer.solution.pushmodel;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements NewsPublisher {
    private final List<NewsSubscriber> subscribers = new ArrayList<>();

    private String latestNews;

    @Override
    public void notifyObservers() {
        for (NewsSubscriber newsSubscriber: subscribers) {
            newsSubscriber.update(latestNews);
        }
    }

    @Override
    public void removeObserver(NewsSubscriber observer) {
        subscribers.remove(observer);
    }

    @Override
    public void registerObserver(NewsSubscriber observer) {
        subscribers.add(observer);
    }

    public void setLatestNews(String news) {
        this.latestNews = news;
        notifyObservers();
    }
}
