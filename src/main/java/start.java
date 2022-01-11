import java.util.List;

public class start {
    public static void main(String[] args) throws Exception {
        String DB_URL = "jdbc:postgresql://10.11.11.51:5432/AntGet";
        String DB_Driver = "org.h2.Driver";


        List<Worker> workers = new Scan().start();

        SQL sq = new SQL(DB_URL,DB_Driver);
        for(Worker worker : workers)
        {
            sq.addWorker(worker);
        }

        List<Worker> ddd = sq.getWorckers();

        System.out.println();
        System.out.println(ddd);
        System.out.println();


    }
}
