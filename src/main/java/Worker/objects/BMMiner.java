package Worker.objects;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)

public class BMMiner {

    private String BMMiner;
    private String Miner;
    private String CompileTime;
    private String Type;
    @ConstructorProperties({"BMMiner","Miner","CompileTime","Type"})
    public BMMiner(String bmminer, String miner, String compileTime, String type) {
        BMMiner = bmminer;
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
