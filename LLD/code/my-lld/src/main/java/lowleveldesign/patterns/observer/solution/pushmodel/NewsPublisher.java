package lowleveldesign.patterns.observer.solution.pushmodel;

public interface NewsPublisher {
    void registerObserver(NewsSubscriber observer);
    void removeObserver(NewsSubscriber observer);
    void notifyObservers();
}
