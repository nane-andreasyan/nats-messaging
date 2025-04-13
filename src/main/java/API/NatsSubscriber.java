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

            String natsUrl = System.getenv().getOrDefault("NATS_URL", "nats://localhost:4222");
            Connection nc = Nats.connect(natsUrl);

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
