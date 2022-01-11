import Worker.objects.Hardware;
import Worker.objects.Pool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQL {
    Connection connection;
    String DB_URL;
    String DB_Driver;
    ResultSet st;

    public SQL(String DB_URL, String DB_Driver) throws SQLException {
        this.DB_URL = DB_URL;
        this.DB_Driver = DB_Driver;
        connection = DriverManager.getConnection(DB_URL,"postgres", "postgres");//соединениесБД
    }

    public List<Worker> getWorckers() throws SQLException, ClassNotFoundException, JsonProcessingException {//7 8

        List<Worker> workers = new ArrayList<>();
        Class.forName(DB_Driver);
        StringBuilder sb = new StringBuilder();
        st = connection.prepareStatement("select * from workers").executeQuery();
        int columns = st.getMetaData().getColumnCount();
        // Перебор строк с данными
        while(st.next()){
            Worker db;
            workers.add(db = new Worker(st.getString(8), st.getString(9)));
            db.setType(st.getString(10));
            db.setHardware(new ObjectMapper().readValue(st.getString(11), Hardware.class) );

            List<Pool> pools = new ArrayList<>();//567

            pools.add(new ObjectMapper().readValue(st.getString(5), Pool.class));
            pools.add(new ObjectMapper().readValue(st.getString(6), Pool.class));
            pools.add(new ObjectMapper().readValue(st.getString(7), Pool.class));

            db.setPools(pools);
            db.setName(st.getString(2));

            for (int i = 1; i <= columns; i++){

                sb.append(st.getString(i) + "\t");
            }
            sb.append("\n");
        }
        return workers;
    }

    public boolean addWorker(Worker worker){
        String dd ="";
        try {
            if(!worker.type.contains("Antminer"))
                return true;
            String idnt = worker.getIp() + ":" + worker.getPort();
            StringBuilder header = new StringBuilder("workername,identify,ip,port,type,last_status,version");

            StringBuilder values = new StringBuilder();

            values.append("\'"+worker.name+"\',");
            values.append("\'"+idnt+"\',");
            values.append("\'"+worker.getIp()+"\',");
            values.append("\'"+worker.getPort()+"\',");
            values.append("\'"+worker.getType()+"\',");
            values.append("\'"+new JSONObject(worker.getHardware()).toString()+"\'::json,");
            values.append("\'"+ worker.getHardware().version+"\'::json");

            List<Pool> pools = worker.getPools();

            for (int i = 0; i < pools.size(); i++) {
                header.append(",pool" + (i+1));
                ObjectMapper map = new ObjectMapper();

                Pool daq = pools.get(i);
                try {
                    values.append(",\'"+map.writeValueAsString(daq)+"\'::json");
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }

            }
            dd ="insert into public.workers (" + header + ") values (" + values + ");";
            connection.createStatement().execute(dd);

            return true;
        }
        catch (SQLException d)
        {
            if(d.getMessage() == ("org.postgresql.util.PSQLException: Запрос не вернул результатов."))
                return true;
            return false;
        }
    }
    public boolean commit()
    {
        try {
            connection.commit();
            return true;
        }
        catch (SQLException e)
        {
            if(e.getMessage().equals("org.postgresql.util.PSQLException: Запрос не вернул результатов."))
                return true;
            return false;
        }
    }

    protected void finalize() throws Throwable {
        if(connection != null)
        {
            connection.close();
        }
        super.finalize();
    }
}
