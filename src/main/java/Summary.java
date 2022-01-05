import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.beans.ConstructorProperties;

@JsonAutoDetect
public class Summary {
    public int Elapsed;
    public double GHS_5s;
    public double GHS_av;
    public double GHS_30m;
    public int Found_Blocks;
    public int Getworks;
    public int Accepted;
    public int Rejected;
    public int Hardware_Errors;
    public double Utility;
    public int Discarded;
    public int Stale;
    public int Get_Failures;
    public int Local_Work;
    public int Remote_Failures;
    public int Network_Blocks;
    public long Total_MH;
    public double Work_Utility;
    public int Difficulty_Accepted;
    public int Difficulty_Rejected;
    public int Difficulty_Stale;
    public long Best_Share;
    public double Device_HardwareQQ;
    public double Device_RejectedQQ;
    public double Pool_RejectedQQ;
    public double Pool_StaleQQ;
    public int Last_getwork;
    @ConstructorProperties({ "Elapsed",
            "GHS 5s",
            "GHS av",
            "GHS 30m",
            "Found Blocks",
            "Getworks",
            "Accepted",
            "Rejected",
            "Hardware Errors",
            "Utility",
            "Discarded",
            "Stale",
            "Get Failures",
            "Local Work",
            "Remote Failures",
            "Network Blocks",
            "Total MH",
            "Work Utility",
            "Difficulty Accepted",
            "Difficulty Rejected",
            "Difficulty Stale",
            "Best Share",
            "Device Hardware%",
            "Device Rejected%",
            "Pool Rejected%",
            "Pool Stale%",
            "Last getwork"
                            })
    public Summary(int elapsed,
                   double GHS_5s,
                   double GHS_av,
                   double GHS_30m,
                   int found_Blocks,
                   int getworks,
                   int accepted,
                   int rejected,
                   int hardware_Errors,
                   double utility,
                   int discarded,
                   int stale,
                   int get_Failures,
                   int local_Work,
                   int remote_Failures,
                   int network_Blocks,
                   long total_MH,
                   double work_Utility,
                   int difficulty_Accepted,
                   int difficulty_Rejected,
                   int difficulty_Stale,
                   long best_Share,
                   double device_Hardware,
                   double device_Rejected,
                   double pool_Rejected,
                   double pool_Stale,
                   int last_getwork) {
        this.Elapsed = elapsed;
        this.GHS_5s = GHS_5s;
        this.GHS_av = GHS_av;
        this.GHS_30m = GHS_30m;
        this.Found_Blocks = found_Blocks;
        this.Getworks = getworks;
        this.Accepted = accepted;
        this.Rejected = rejected;
        this.Hardware_Errors = hardware_Errors;
        this.Utility = utility;
        this.Discarded = discarded;
        this.Stale = stale;
        this.Get_Failures = get_Failures;
        this.Local_Work = local_Work;
        this.Remote_Failures = remote_Failures;
        this.Network_Blocks = network_Blocks;
        this.Total_MH = total_MH;
        this.Work_Utility = work_Utility;
        this.Difficulty_Accepted = difficulty_Accepted;
        this.Difficulty_Rejected = difficulty_Rejected;
        this.Difficulty_Stale = difficulty_Stale;
        this.Best_Share = best_Share;
        this.Device_HardwareQQ = device_Hardware;
        this.Device_RejectedQQ = device_Rejected;
        this.Pool_RejectedQQ = pool_Rejected;
        this.Pool_StaleQQ = pool_Stale;
        this.Last_getwork = last_getwork;
    }
}
