package Worker.objects;

public class Pools {
    public String pool1;
    public String user1;
    public String pass1;
    public String pool1Status;

    public String pool2;
    public String user2;
    public String pass2;
    public String pool2Status;

    public String pool3;
    public String user3;
    public String pass3;
    public String pool3Status;

    public Pools(String pool1, String user1, String pass1) {
        this.pool1 = pool1;
        this.user1 = user1;
        this.pass1 = pass1;
        this.pool2 = pool1;
        this.user2 = user1;
        this.pass2 = pass1;
        this.pool3 = pool1;
        this.user3 = user1;
        this.pass3 = pass1;
    }

    public Pools(String pool1, String user1, String pass1, String pool1Status, String pool2, String user2, String pass2, String pool2Status, String pool3, String user3, String pass3, String pool3Status) {
        this.pool1 = pool1;
        this.user1 = user1;
        this.pass1 = pass1;
        this.pool1Status = pool1Status;
        this.pool2 = pool2;
        this.user2 = user2;
        this.pass2 = pass2;
        this.pool2Status = pool2Status;
        this.pool3 = pool3;
        this.user3 = user3;
        this.pass3 = pass3;
        this.pool3Status = pool3Status;
    }

    public String getPool1Status() {
        return pool1Status;
    }

    public void setPool1Status(String pool1Status) {
        this.pool1Status = pool1Status;
    }

    public String getPool2Status() {
        return pool2Status;
    }

    public void setPool2Status(String pool2Status) {
        this.pool2Status = pool2Status;
    }

    public String getPool3Status() {
        return pool3Status;
    }

    public void setPool3Status(String pool3Status) {
        this.pool3Status = pool3Status;
    }
}
