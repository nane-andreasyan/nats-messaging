package API;
import Business.Services.Implementation.MessagingService;
import io.nats.client.*;

public class NatsSubscriber {

    private final MessagingService messageService;
    private final String subject;

    public NatsSubscriber(MessagingService messageService, String subject) {
        this.messageService = messageService;
        this.subject = subject;
    }

    public void subscribe() {
        try {
            Connection nc = Nats.connect("nats://localhost:4222");

            Dispatcher dispatcher = nc.createDispatcher((Message msg) -> {
                String raw = new String(msg.getData());
                System.out.println("Received message from NATS: " + raw);
                messageService.process(raw);
            });

            dispatcher.subscribe(subject);
            System.out.println("Subscribed to subject " + subject);
            Thread.currentThread().join();
        } catch (Exception e) {
            System.err.println("Error subscribing to NATS: " + e.getMessage());
        }
    }

}
