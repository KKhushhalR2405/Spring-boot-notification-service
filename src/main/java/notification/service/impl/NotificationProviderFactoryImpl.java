package notification.service.impl;

import notification.request.SendNotificationRequest;
import notification.service.NotificationProviderFactory;
import notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationProviderFactoryImpl implements NotificationProviderFactory {
    @Autowired
    private List<NotificationService> services;

    private static final Map<String, NotificationService> myServiceCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        for(NotificationService service : services) {
            myServiceCache.put(service.getType(), service);
        }
    }

    public NotificationService getService(String type) {
        NotificationService service = myServiceCache.get(type);
        if(service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }
}
