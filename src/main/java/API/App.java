package API;

import API.NatsSubscriber;
import Business.Services.IMessagingService;
import Business.Services.Implementation.MessagingService;

public class App {

    public static void main (String[] args) {
        MessagingService service = new MessagingService();
        NatsSubscriber subscriber = new NatsSubscriber(service, "messages");

        subscriber.subscribe();
    }

}

