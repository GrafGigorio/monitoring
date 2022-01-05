package sql.demo;

import java.sql.*;

public class StockExchangeDB {
    // Блок объявления констант
    public static final String DB_URL = "jdbc:postgresql://10.11.11.51:5432/AntGet";
    public static final String DB_Driver = "org.h2.Driver";

    public static void main(String[] args) {
        try {
            Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД

            Connection connection = DriverManager.getConnection(DB_URL,"postgres", "postgres");//соединениесБД

            //connection.createStatement().executeQuery("select * from status");
            //connection.commit();

            ResultSet st = connection.prepareStatement("select * from status").executeQuery();


            System.out.println("Соединение с СУБД выполнено.");

            int columns = st.getMetaData().getColumnCount();
            // Перебор строк с данными
            while(st.next()){
                for (int i = 1; i <= columns; i++){
                    System.out.print(st.getString(i) + "\t");
                }
                System.out.println();
            }


            connection.close();       // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }
}