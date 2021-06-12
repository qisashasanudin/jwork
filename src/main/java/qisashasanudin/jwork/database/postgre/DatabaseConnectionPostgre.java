package qisashasanudin.jwork.database.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnectionPostgre {
    public static Connection connection(){
        Connection c = null;
        Statement stat = null;
        String db_url = "jdbc:postgresql://localhost:5432/";
        String db_name = "jwork";
        String db_user = "postgres";
        String db_password = "postgres";

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(db_url + db_name, db_user, db_password);

            if(c != null){
                System.out.println("Connected to database successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to connect to database.");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
