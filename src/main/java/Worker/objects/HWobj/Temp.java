package Worker.objects.HWobj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.beans.ConstructorProperties;

@JsonAutoDetect
public class Temp {
    public byte temp;
    @ConstructorProperties({"temp"})
    public Temp(byte temp) {
        this.temp = temp;
    }

    public byte getTemp() {
        return temp;
    }
}
