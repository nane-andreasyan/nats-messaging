package Business.Services.Setup;

import Business.Services.IMessagingService;
import Business.Services.Implementation.MessagingService;
import Data.Services.IMessageDataService;
import Data.Services.Implementation.MessageDataService;

public class ServiceCreator {
    public static IMessagingService createMessagingService() {
        IMessageDataService dataRepo = new MessageDataService();
        return new MessagingService(dataRepo);
    }
}