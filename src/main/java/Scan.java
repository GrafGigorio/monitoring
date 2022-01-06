import Worker.objects.BMMiner;
import Worker.objects.Hardware;
import Worker.objects.Pool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.external.jsoup.Jsoup;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.ranges.RangeException;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scan {
    public static void start()
    {
        List<Worker> workers = new ArrayList<>();
        for (int i = 2; i < 20; i++) {
            String temp = "192.168.52.";
            if(API.ping(temp + i, "4028"))//4028
            {
                workers.add(new Worker(temp +i, "4028"));
                System.out.println(temp + i +":4028");
            }
        }

        for (Worker wr : workers)
        {
            try {
                String html = Jsoup.connect("http://"+wr.getIp()).get().html();
                System.out.println();
                System.out.println(wr.getIp());
                System.out.println(html);
                wr.setType("WatsMiner");
            } catch (IOException e1) {
                if(e1.getMessage().contains("HTTP error fetching URL"))
                {
                    wr.setType("AntMiner");
                    try {
                        API send = new API("stats", wr.getIp(), wr.getPort());
                        System.out.println();
                        System.out.println(send.resp);
                        System.out.println();
                        wr.setHardware(new ObjectMapper().readValue(new JSONObject(send.resp).getJSONArray("main").getJSONObject(2).toString(), Hardware.class));//BMMiner1.0.0
                        //wr.setMiner(new ObjectMapper().readValue(new JSONObject(send.resp).getJSONObject("BMMiner1.0.0").toString(), BMMiner.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        API send = new API("pools", wr.getIp(), wr.getPort());
                        List<Pool> pools = new ArrayList<>();
                        System.out.println();
                        System.out.println(send.resp);
                        System.out.println();
                        pools.add(new ObjectMapper().readValue(new JSONObject(send.resp).getJSONArray("main").getJSONObject(1).toString(), Pool.class));
                        pools.add(new ObjectMapper().readValue(new JSONObject(send.resp).getJSONArray("main").getJSONObject(2).toString(), Pool.class));
                        pools.add(new ObjectMapper().readValue(new JSONObject(send.resp).getJSONArray("main").getJSONObject(3).toString(), Pool.class));
                        wr.setPools(pools);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    wr.setName(wr.getPools().get(0).workerName);
                }
            }
        }
    }
    //private static
}
/*
        String command = "pools";//stats pools summary
        String ip = "192.168.52.4" ;
        String port = "4028";

        API ddr = new API(command, ip, port);
        System.out.println(ddr.resp);
 */
