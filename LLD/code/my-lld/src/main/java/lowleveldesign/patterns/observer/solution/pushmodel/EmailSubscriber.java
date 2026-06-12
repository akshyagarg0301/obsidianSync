package lowleveldesign.patterns.observer.solution.pushmodel;

public class EmailSubscriber implements NewsSubscriber {

    @Override
    public void update(String news) {
        System.out.println("Email sent:" + news);
    }
}
