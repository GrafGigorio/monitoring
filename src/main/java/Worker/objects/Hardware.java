package Worker.objects;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.beans.ConstructorProperties;
import java.security.PublicKey;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)

public class Hardware {
    @JsonIgnore
    public String version;

    public int GHS_5s;
    public int GHS_av;

    public short fan1;
    public short fan2;
    public short fan3;
    public short fan4;

    public byte temp1;
    public byte temp2;
    public byte temp3;

    public byte temp2_1;
    public byte temp2_2;
    public byte temp2_3;

    public String temp_pcb1;
    public String temp_pcb2;
    public String temp_pcb3;

    public String temp_chip1;
    public String temp_chip2;
    public String temp_chip3;

    public int total_rateideal;
    public int total_rate;

    public short chain_acn1;//Число чипов на лезвии
    public short chain_acn2;
    public short chain_acn3;

    public String chain_acs1;//Статусы чипов
    public String chain_acs2;
    public String chain_acs3;

    public int chain_hw1;//Аппаратные ошибки по лезвию
    public int chain_hw2;
    public int chain_hw3;

    public int chain_rate1;//Текущий рэйт лезвия
    public int chain_rate2;
    public int chain_rate3;

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

        this.fan1 = Short.parseShort(fan1);
        this.fan2 = Short.parseShort(fan2);
        this.fan3 = Short.parseShort(fan3);
        this.fan4 = Short.parseShort(fan4);

        this.temp1 = (byte) Integer.parseInt(temp1);//
        this.temp2 = (byte) Integer.parseInt(temp2);//
        this.temp3 = (byte) Integer.parseInt(temp3);//

        this.temp2_1 = (byte) Integer.parseInt(temp2_1);//
        this.temp2_2 = (byte) Integer.parseInt(temp2_2);//
        this.temp2_3 = (byte) Integer.parseInt(temp2_3);//

        this.temp_pcb1 = temp_pcb1;
        this.temp_pcb2 = temp_pcb2;
        this.temp_pcb3 = temp_pcb3;

        this.temp_chip1 = temp_chip1;
        this.temp_chip2 = temp_chip2;
        this.temp_chip3 = temp_chip3;

        this.total_rateideal = (int)(Double.parseDouble(total_rateideal) * 1000);
        this.total_rate = (int)(Double.parseDouble(total_rate) * 1000);

        this.chain_acn1 = (short) Integer.parseInt(chain_acn1);
        this.chain_acn2 = (short) Integer.parseInt(chain_acn2);
        this.chain_acn3 = (short) Integer.parseInt(chain_acn3);

        this.chain_acs1 = chain_acs1;
        this.chain_acs2 = chain_acs2;
        this.chain_acs3 = chain_acs3;

        this.chain_hw1 = chain_hw1 == null ? 0 : Integer.parseInt(chain_hw1);
        this.chain_hw2 = chain_hw2 == null ? 0 : Integer.parseInt(chain_hw2);
        this.chain_hw3 = chain_hw3 == null ? 0 : Integer.parseInt(chain_hw3);

        this.chain_rate1 = chain_rate1== null ? 0 : (int)(Double.parseDouble(chain_rate1) * 1000);
        this.chain_rate2 = chain_rate2== null ? 0 : (int)(Double.parseDouble(chain_rate2) * 1000);
        this.chain_rate3 = chain_rate3== null ? 0 : (int)(Double.parseDouble(chain_rate3) * 1000);

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

    public short getFan1() {
        return fan1;
    }

    public short getFan2() {
        return fan2;
    }

    public short getFan3() {
        return fan3;
    }

    public short getFan4() {
        return fan4;
    }

    public byte getTemp1() {
        return temp1;
    }

    public byte getTemp2() {
        return temp2;
    }

    public byte getTemp3() {
        return temp3;
    }

    public byte getTemp2_1() {
        return temp2_1;
    }

    public byte getTemp2_2() {
        return temp2_2;
    }

    public byte getTemp2_3() {
        return temp2_3;
    }

    public String getTemp_pcb1() {
        return temp_pcb1;
    }

    public String getTemp_pcb2() {
        return temp_pcb2;
    }

    public String getTemp_pcb3() {
        return temp_pcb3;
    }

    public String getTemp_chip1() {
        return temp_chip1;
    }

    public String getTemp_chip2() {
        return temp_chip2;
    }

    public String getTemp_chip3() {
        return temp_chip3;
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

    public int getChain_hw1() {
        return chain_hw1;
    }

    public int getChain_hw2() {
        return chain_hw2;
    }

    public int getChain_hw3() {
        return chain_hw3;
    }

    public int getChain_rate1() {
        return chain_rate1;
    }

    public int getChain_rate2() {
        return chain_rate2;
    }

    public int getChain_rate3() {
        return chain_rate3;
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
}
