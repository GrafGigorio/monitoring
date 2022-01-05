import org.w3c.dom.ranges.RangeException;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scan {
    public static void start()
    {
        Map<String, String> workers = new HashMap<>();
        for (int i = 2; i < 255; i++) {
            String temp = "192.168.52.";
            if(API.ping(temp + i, "4028"))
            {
                workers.put(temp + i, "4028");
                System.out.println(temp + i +":4028");
            }
            else if(API.ping(temp + i, "80"))
            {
                workers.put(temp + i, "80");
                System.out.println(temp + i +":80");
            }
        }
        String command = "stats";//stats pools summary
        String ip = "192.168.52.2" ;
        String port = "4028";

        //API.ping("1.1.1.1");
    }
    //private static
}
