import Worker.objects.*;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public class Worker {
    public String name;
    public String type;
    private String ip;
    private String port;

    public List<Pool> pools;
    public Hardware hardware;

    public Worker(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JsonValue
    public List<Pool> getPools() {
        return pools;
    }

    public void setPools(List<Pool> pools) {
        this.pools = pools;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (name != null ? !name.equals(worker.name) : worker.name != null) return false;
        if (type != null ? !type.equals(worker.type) : worker.type != null) return false;
        if (!ip.equals(worker.ip)) return false;
        return port.equals(worker.port);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + ip.hashCode();
        result = 31 * result + port.hashCode();
        return result;
    }
}
