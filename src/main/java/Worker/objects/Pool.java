package Worker.objects;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.beans.ConstructorProperties;
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)

public class Pool {
    @JsonSerialize
    public String URL;
    @JsonSerialize
    public String user;
    @JsonSerialize
    public String pool1Status;

    @ConstructorProperties({"URL", "User", "Status"})
    public Pool(String URL, String User, String pool1Status) {
        this.URL = URL;
        this.user = User;
        this.pool1Status = pool1Status;
    }
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPool1Status() {
        return pool1Status;
    }

    public void setPool1Status(String pool1Status) {
        this.pool1Status = pool1Status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pool pool = (Pool) o;

        if (!URL.equals(pool.URL)) return false;
        return user.equals(pool.user);
    }

    @Override
    public int hashCode() {
        int result = URL.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
