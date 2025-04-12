package Data.Services.Implementation;

import Data.Entities.Message;
import Data.Services.IMessageDataService;
import java.Data.Setup.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDataService implements IMessageDataService {
    @Override
    public Message getMessage(int id) {
        String sql = "SELECT * FROM messages WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.user, DatabaseConfig.password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    Message msg = new Message();
                    msg.setId(rs.getInt("id"));
                    msg.setContent(rs.getString("content"));
                    msg.setTimestamp(rs.getTimestamp("timestamp"));
                    return msg;
                }
            } catch (SQLException e) {
                System.err.println("Failed to get message: " + e.getMessage());
            }
            return null;
    }

    @Override
    public void saveMessage(Message m) {
        String sql = "INSERT INTO messages (content, timestamp) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.user, DatabaseConfig.password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, m.getContent());
                stmt.setTimestamp(2, m.getTimestamp());
                stmt.executeUpdate();
                System.out.println("Message saved to DB.");
        } catch (SQLException e) {
            System.err.println("Failed to save message: " + e.getMessage());
        }
    }

}
