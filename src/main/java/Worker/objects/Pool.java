package Worker.objects;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.beans.ConstructorProperties;
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)

public class Pool {
    @JsonRawValue
    public String URL;
    public String user;
    public String workerName;
    public String pool1Status;

    @ConstructorProperties({"URL", "User", "Status"})
    public Pool(String URL, String userDD, String pool1Status) {
        this.URL = URL;

        this.user = userDD.split("\\.")[0];
        this.workerName = userDD.split("\\.")[1];
        this.pool1Status = pool1Status;
    }

}
