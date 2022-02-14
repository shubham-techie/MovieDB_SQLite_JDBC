import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;


public class Database {
    String dbname; // database filename
    String url; // path for movie database

    // constructor to initialize database filename
    public Database(String dbname) {
        this.dbname = dbname;
        this.url = "jdbc:sqlite:D:/MovieDB_SQLite_JDBC/" + dbname;
    }

    // function to create movie database
    public void createDB() {

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                System.out.println(
                        "\"" + dbname + "\"" + " has been created using driver \"" + meta.getDriverName() + "\".");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}