import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;

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

    // function to insert data in movies table
    public void insertData(String tableName, String mov_title, String lead_actor, String lead_actress, int release_year,
            String director) {

        // SQL statment for inserting values
        String sqlstmt = "INSERT INTO " + tableName
                + " (mov_title,lead_actor,lead_actress,release_year,director) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {

            // Setting values to insert in movies table
            pstmt.setString(1, mov_title);
            pstmt.setString(2, lead_actor);
            pstmt.setString(3, lead_actress);
            pstmt.setInt(4, release_year);
            pstmt.setString(5, director);

            //finally inserting value into movie table
            pstmt.executeUpdate();

            System.out.println("Inserted the data related to \"" + mov_title+"\"");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}