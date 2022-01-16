package Worker.objects.HWobj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.beans.ConstructorProperties;

@JsonAutoDetect
public class ChainHW {
    public int errors;
    @ConstructorProperties({"errors"})
    public ChainHW(int errors) {
        this.errors = errors;
    }

    public int getErrors() {
        return errors;
    }
}
