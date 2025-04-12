package Business.Services.Implementation;
import Business.Services.IMessagingService;
import Data.Entities.Message;
import Data.Services.Implementation.MessageDataService;

import java.sql.Timestamp;

public class MessagingService implements IMessagingService {

    public void process(String rawMessage) {
        if(rawMessage == null) {
            System.err.println("The message is null");
        }

        Message m = new Message();
        m.setContent(rawMessage);
        m.setTimestamp(new Timestamp(System.currentTimeMillis()));
        MessageDataService ds = new MessageDataService();
        ds.saveMessage(m);
    }


}
