package Worker.objects.HWobj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.beans.ConstructorProperties;

@JsonAutoDetect
public class ChainRate {
    public int rate;
    @ConstructorProperties({"rate"})
    public ChainRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
