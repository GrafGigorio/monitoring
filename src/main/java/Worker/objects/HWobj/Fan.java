package Worker.objects.HWobj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.beans.ConstructorProperties;

@JsonAutoDetect
public class Fan {
    public short speed;
    @ConstructorProperties({"speed"})
    public Fan(short speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
