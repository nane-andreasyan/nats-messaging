package src.Data.Services;

import src.Data.Entities.Message;

public interface IMessageDataService {
    public Message getMessage(int id);

    public void saveMessage(Message m);
}

