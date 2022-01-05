import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.beans.ConstructorProperties;

@JsonAutoDetect
public class Status {
    public String STATUS;
    public int When;
    public int Code;
    public String Msg;
    public String Description;

    @ConstructorProperties({"STATUS", "When", "Code", "Msg", "Description"})
    public Status(String STATUS, int when, int code, String msg, String description) {
        this.STATUS = STATUS;
        When = when;
        Code = code;
        Msg = msg;
        Description = description;
    }
}
