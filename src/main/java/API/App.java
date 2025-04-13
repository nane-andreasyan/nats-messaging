package API;

import Business.Services.IMessagingService;
import Business.Services.Setup.ServiceCreator;

public class App {

    public static void main (String[] args) {
        IMessagingService service = ServiceCreator.createMessagingService();
        NatsSubscriber subscriber = new NatsSubscriber(service, "messages");
        subscriber.subscribe();
    }
}
