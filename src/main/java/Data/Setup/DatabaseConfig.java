package Data.Setup;

public class DatabaseConfig{

    public final static String url = System.getenv().getOrDefault("DB_URL","jdbc:postgresql://localhost:5432/naneandreasyan");
    public final static String user = System.getenv().getOrDefault("DB_USER", "naneandreasyan");
    public final static String password = System.getenv().getOrDefault("DB_PASSWORD", "1234");

}
