import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

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

    // function to create movies table
    public void createTable(String tableName) {

        // SQL statement for creating table
        String sqlstmt = "CREATE TABLE IF NOT EXISTS " + tableName + "(\n"
                + "id  INTEGER PRIMARY KEY NOT NULL,\n"
                + "mov_title TEXT NOT NULL,\n"
                + "lead_actor TEXT,\n"
                + "lead_actress TEXT,\n"
                + "release_year INTEGER NOT NULL,\n"
                + "director TEXT NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            // creating table
            stmt.execute(sqlstmt);

            System.out.println("\"" + tableName + "\"" + " table has been created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

  
}