import java.util.List;

public class start {
    public static void main(String[] args) throws Exception {


        String command = "stats";//stats pools summary
        String ip = "192.168.52.4" ;
        String port = "4028";

//        API ddr = new API(command, ip, port);
//        System.out.println(ddr.resp);
        String DB_URL = "jdbc:postgresql://10.11.11.51:5432/AntGet";
        String DB_Driver = "org.h2.Driver";


        List<Worker> workers = new Scan().start();

        SQL sq = new SQL(DB_URL,DB_Driver);

        for(Worker worker : workers)
        {
            sq.addWorker(worker);
        }
        //sq.commit();


        String  ddd =sq.getWorckers();
        System.out.println();
        System.out.println(ddd);
        System.out.println();

/*
        String addr = "http://192.168.52.7:/cgi-bin/miner_summary.cgi";

        List<Worker> machines = new ArrayList<>();
        User user1 = new User("root", "root");
        User user2 = new User("root", "admin");
        Worker wr = Req.GetWorker(new URL(addr), user1);

        JsonMapper map = new JsonMapper();


        System.out.println(map.writeValueAsString(wr));
*/
//        URL url = new URL(addr);

//        for (int i = 2; i < 255; i++) {
//            try {
//                url = new URL(addr.replace("52.2", "52." + i));
//                Worker wr = Req.GetWorker(url, user1);
//                machines.add(wr);
//                System.out.println(wr.adress.getHost() + ": AVG " + wr.summary.GHS_av);
//            } catch (Exception ea) {
//                System.out.println(url.getHost() + ": AVG " + ea.getMessage());
//            }
//        }

    }

}
