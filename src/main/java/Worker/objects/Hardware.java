package Worker.objects;
import Worker.objects.HWobj.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.beans.ConstructorProperties;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)

public class Hardware {
    @JsonIgnore
    public String version;

    public int GHS_5s;
    public int GHS_av;

    public List<Fan> fans = new ArrayList<>();

    public Temperatures temperatures = new Temperatures();

    public int total_rateideal;
    public int total_rate;

    public short chain_acn1;//Число чипов на лезвии
    public short chain_acn2;
    public short chain_acn3;

    public String chain_acs1;//Статусы чипов
    public String chain_acs2;
    public String chain_acs3;

    public List<ChainHW> chainHWS = new ArrayList<>();//Аппаратные ошибки по лезвию

    public List<ChainRate> rates = new ArrayList<>();//Текущий рэйт лезвий

    public int freq1;//Частота лезвия
    public int freq2;
    public int freq3;


    @ConstructorProperties({
            "GHS_5s",
             "GHS_av",
             "fan1",
             "fan2",
             "fan3",
             "fan4",
             "temp1",
             "temp2",
             "temp3",
             "temp2_1",
             "temp2_2",
             "temp2_3",
             "temp_pcb1",
             "temp_pcb2",
             "temp_pcb3",
             "temp_chip1",
             "temp_chip2",
             "temp_chip3",
             "total_rateideal",
             "total_rate",
             "chain_acn1",
             "chain_acn2",
             "chain_acn3",
             "chain_acs1",
             "chain_acs2",
             "chain_acs3",
             "chain_hw1",
             "chain_hw2",
             "chain_hw3",
             "chain_rate1",
             "chain_rate2",
             "chain_rate3",
             "freq1",
             "freq2",
             "freq3",
             "miner_id"})
    public Hardware(String GHS_5s,
                    String GHS_av,
                    String fan1,
                    String fan2,
                    String fan3,
                    String fan4,
                    String temp1,
                    String temp2,
                    String temp3,
                    String temp2_1,
                    String temp2_2,
                    String temp2_3,
                    String temp_pcb1,
                    String temp_pcb2,
                    String temp_pcb3,
                    String temp_chip1,
                    String temp_chip2,
                    String temp_chip3,
                    String total_rateideal,
                    String total_rate,
                    String chain_acn1,
                    String chain_acn2,
                    String chain_acn3,
                    String chain_acs1,
                    String chain_acs2,
                    String chain_acs3,
                    String chain_hw1,
                    String chain_hw2,
                    String chain_hw3,
                    String chain_rate1,
                    String chain_rate2,
                    String chain_rate3,
                    String freq1,
                    String freq2,
                    String freq3) {

        this.GHS_5s = (int)(Double.parseDouble(GHS_5s) * 1000);
        this.GHS_av = (int)(Double.parseDouble(GHS_av) * 1000);;

        this.fans.add( new Fan(Short.parseShort(fan1)));
        this.fans.add( new Fan(Short.parseShort(fan2)));
        this.fans.add( new Fan(Short.parseShort(fan3)));
        this.fans.add( new Fan(Short.parseShort(fan4)));

        this.temperatures.tempA.add(new Temp((byte) Integer.parseInt(temp1)));
        this.temperatures.tempA.add(new Temp((byte) Integer.parseInt(temp2)));
        this.temperatures.tempA.add(new Temp((byte) Integer.parseInt(temp3)));

        this.temperatures.tempB.add(new Temp((byte) Integer.parseInt(temp2_1)));
        this.temperatures.tempB.add(new Temp((byte) Integer.parseInt(temp2_2)));
        this.temperatures.tempB.add(new Temp((byte) Integer.parseInt(temp2_3)));

        this.temperatures.tempPCB.add(stringToTemp(temp_pcb1));
        this.temperatures.tempPCB.add(stringToTemp(temp_pcb2));
        this.temperatures.tempPCB.add(stringToTemp(temp_pcb3));

        this.temperatures.tempChip.add(stringToTemp(temp_chip1));
        this.temperatures.tempChip.add(stringToTemp(temp_chip2));
        this.temperatures.tempChip.add(stringToTemp(temp_chip3));

        this.total_rateideal = (int)(Double.parseDouble(total_rateideal) * 1000);
        this.total_rate = (int)(Double.parseDouble(total_rate) * 1000);

        this.chain_acn1 = (short) Integer.parseInt(chain_acn1);
        this.chain_acn2 = (short) Integer.parseInt(chain_acn2);
        this.chain_acn3 = (short) Integer.parseInt(chain_acn3);

        this.chain_acs1 = chain_acs1;
        this.chain_acs2 = chain_acs2;
        this.chain_acs3 = chain_acs3;

        this.chainHWS.add(new ChainHW(chain_hw1 == null ? 0 : Integer.parseInt(chain_hw1)));
        this.chainHWS.add(new ChainHW(chain_hw2 == null ? 0 : Integer.parseInt(chain_hw2)));
        this.chainHWS.add(new ChainHW(chain_hw3 == null ? 0 : Integer.parseInt(chain_hw3)));

        this.rates.add(new ChainRate(chain_rate1== null ? 0 : (int)(Double.parseDouble(chain_rate1) * 1000)));
        this.rates.add(new ChainRate(chain_rate2== null ? 0 : (int)(Double.parseDouble(chain_rate2) * 1000)));
        this.rates.add(new ChainRate(chain_rate3== null ? 0 : (int)(Double.parseDouble(chain_rate3) * 1000)));

        this.freq1 = Integer.parseInt(freq1.split("\\.")[0]);
        this.freq2 = Integer.parseInt(freq2.split("\\.")[0]);
        this.freq3 = Integer.parseInt(freq3.split("\\.")[0]);
    }

    public int getGHS_5s() {
        return GHS_5s;
    }

    public int getGHS_av() {
        return GHS_av;
    }

    public List<Fan> getFans() {
        return fans;
    }

    public Temperatures getTemperatures() {
        return temperatures;
    }

    public int getTotal_rateideal() {
        return total_rateideal;
    }

    public int getTotal_rate() {
        return total_rate;
    }

    public short getChain_acn1() {
        return chain_acn1;
    }

    public short getChain_acn2() {
        return chain_acn2;
    }

    public short getChain_acn3() {
        return chain_acn3;
    }

    public String getChain_acs1() {
        return chain_acs1;
    }

    public String getChain_acs2() {
        return chain_acs2;
    }

    public String getChain_acs3() {
        return chain_acs3;
    }

    public List<ChainHW> getChainHWS() {
        return chainHWS;
    }

    public List<ChainRate> getRates() {
        return rates;
    }

    public int getFreq1() {
        return freq1;
    }

    public int getFreq2() {
        return freq2;
    }

    public int getFreq3() {
        return freq3;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private static List<Temp> stringToTemp(String inStr)
    {
        String[] temps = inStr.split("-");
        List<Temp> temps1 = new ArrayList<>();

        for (String dd : temps)
        {
            temps1.add(new Temp( (byte) Integer.parseInt(dd)));
        }
        return temps1;
    }
}
