package API;

import Business.Services.Implementation.MessagingService;

public class App {

    public static void main (String[] args) {
        MessagingService service = new MessagingService();
        NatsSubscriber subscriber = new NatsSubscriber(service, "messages");

        subscriber.subscribe();
    }
}
