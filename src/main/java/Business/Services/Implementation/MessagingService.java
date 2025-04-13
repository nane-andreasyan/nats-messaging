package Business.Services.Implementation;
import Business.Services.IMessagingService;
import Data.Entities.Message;
import Data.Services.IMessageDataService;

import java.sql.Timestamp;

public class MessagingService implements IMessagingService {

    protected IMessageDataService ms;

    public MessagingService(IMessageDataService ms) {
        this.ms = ms;
    }


    public void process(String rawMessage) {
        if(rawMessage == null) {
            System.err.println("The message is null");
        }

        Message m = new Message();
        m.setContent(rawMessage);
        m.setTimestamp(new Timestamp(System.currentTimeMillis()));
        ms.saveMessage(m);
    }

}
