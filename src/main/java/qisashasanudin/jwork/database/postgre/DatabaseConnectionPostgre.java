package qisashasanudin.jwork.database.postgre;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Praktikum OOP - Program "JWork" - class DatabaseConnectionPostgre: berfungsi
 * untuk membuat koneksi terhadap database
 *
 * @author Qisas Tazkia Hasanudin
 * @version 1.0
 */
public class DatabaseConnectionPostgre {

    /**
     * method getBonusDatabase, berfungsi melakukan koneksi dengan database dan
     * mereturn state dari koneksi tersebut
     * 
     * @return Connection c
     */
    public static Connection connection() {
        // instance variable
        Connection c = null;
        String db_url = "jdbc:postgresql://localhost:5432/";
        String db_name = "jwork";
        String db_user = "postgres";
        String db_password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(db_url + db_name, db_user, db_password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database.");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
