package notification.service;

public interface NotificationProviderFactory {
    public void initMyServiceCache();
    public NotificationService getService(String type);
}
