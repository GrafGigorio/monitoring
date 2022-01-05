import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.beans.ConstructorProperties;

@JsonAutoDetect
public class User {
    public String login;
    public String pass;

    @ConstructorProperties({"login","pass"})
    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
}
