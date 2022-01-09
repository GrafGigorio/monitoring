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
    private String wrType ="";

    public List<Worker> start() throws Exception {
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
               // System.out.println();
                System.out.println(wr.getIp() + "Wats");
                //System.out.println(html);
                wr.setType("WatsMiner");
            } catch (IOException e1) {
                if(e1.getMessage().contains("HTTP error fetching URL"))
                {
                    wr.setHardware(getHardware(wr.getIp(),wr.getPort()));
                    wr.setType(wrType);
                    wr.setPools(getPolls(wr.getIp(),wr.getPort()));

                    wr.setName(wr.getPools().get(0).workerName);
                }
            }
        }
        return workers;
    }

    private Hardware getHardware(String ip,String port) throws Exception {
        API send = null;

            send = new API("stats", ip, port);
            JSONArray json = new JSONObject(send.resp).getJSONArray("main");
            wrType = json.getJSONObject(1).getString("Type").toString();
            return new ObjectMapper().readValue(json.getJSONObject(2).toString(), Hardware.class);//BMMiner1.0.0
    }

    private List<Pool> getPolls(String ip,String port) throws Exception {
        try {
            API send = new API("pools", ip, port);
            List<Pool> pools = new ArrayList<>();

            JSONArray json = new JSONObject(send.resp).getJSONArray("main");
            pools.add(new ObjectMapper().readValue(json.getJSONObject(1).toString(), Pool.class));
            pools.add(new ObjectMapper().readValue(json.getJSONObject(2).toString(), Pool.class));
            pools.add(new ObjectMapper().readValue(json.getJSONObject(3).toString(), Pool.class));
            return pools;
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
    }
}
/*
        String command = "pools";//stats pools summary
        String ip = "192.168.52.4" ;
        String port = "4028";

        API ddr = new API(command, ip, port);
        System.out.println(ddr.resp);
 */
