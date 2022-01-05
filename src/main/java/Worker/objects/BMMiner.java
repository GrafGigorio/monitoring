package Worker.objects;

public class BMMiner {

    private String BMMiner;
    private String Miner;
    private String CompileTime;
    private String Type;

    public BMMiner(String BMMiner, String miner, String compileTime, String type) {
        this.BMMiner = BMMiner;
        Miner = miner;
        CompileTime = compileTime;
        Type = type;
    }

    public String getBMMiner() {
        return BMMiner;
    }

    public String getMiner() {
        return Miner;
    }

    public String getCompileTime() {
        return CompileTime;
    }

    public String getType() {
        return Type;
    }
}
