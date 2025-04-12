package src.Data.Entities;

import java.sql.Timestamp;

public class Message {
    public String content;
    public Timestamp timestamp;
    public int id;

    public Message() {
    }

    public Message(int id, String content, Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }


    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
