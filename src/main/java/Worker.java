import Worker.objects.*;

import java.util.List;

public class Worker {
    public String name;
    public String type;
    private String ip;
    private String port;

    public List<Pool> pools;
    //public BMMiner miner;
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
}
