package lowleveldesign.patterns.observer.violation;

class NewsAgency {

    private String latestNews;

    private EmailService emailService = new EmailService();
    private SmsService smsService = new SmsService();

    public void setLatestNews(String news) {
        this.latestNews = news;

        emailService.sendEmail(news);
        smsService.sendSms(news);
    }
}
