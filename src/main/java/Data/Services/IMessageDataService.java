package Data.Services;

import Data.Entities.Message;

public interface IMessageDataService {
    public Message getMessage(int id);

    public void saveMessage(Message m);
}

