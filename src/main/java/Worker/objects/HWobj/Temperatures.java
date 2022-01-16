package Worker.objects.HWobj;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;
@JsonAutoDetect
public class Temperatures {
    public List<Temp> tempA;
    public List<Temp> tempB;
    public List<List<Temp>> tempPCB;
    public List<List<Temp>> tempChip;
    @ConstructorProperties({"tempA","tempB","tempChip","tempPCB"})
    public Temperatures()
    {
        this.tempA = new ArrayList<>();
        this.tempB = new ArrayList<>();
        this.tempChip = new ArrayList<>();
        this.tempPCB = new ArrayList<>();
    }

    public Temperatures(List<Temp> tempA, List<Temp> tempB, List<List<Temp>> tempPCB, List<List<Temp>> tempChip) {
        this.tempA = tempA;
        this.tempB = tempB;
        this.tempPCB = tempPCB;
        this.tempChip = tempChip;
    }
}
