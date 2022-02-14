import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

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

                System.out.println("\n" +
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

            System.out.println("\n" + "\"" + tableName + "\"" + " table has been created.\n");

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

            // finally inserting value into movie table
            pstmt.executeUpdate();

            System.out.println("Inserted the data of movie \"" + mov_title + "\".");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // function to execute Queries on table
    public void selectQuery(String tableName) {

        try (Scanner sc = new Scanner(System.in)) {

            // getting input whether to print All query or selective
            System.out.println("\n1.Print all parameters \n2.Print only movie_title,release_year,director");

            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            System.out.println();

            String sqlstmt;

            switch (choice) {

                // query for all parameters
                case 1:
                    sqlstmt = "SELECT * FROM " + tableName;
                    break;

                // query to print selective parameters
                case 2:
                    sqlstmt = "SELECT id,mov_title,release_year,director FROM " + tableName;
                    break;

                default:
                    System.out.println("Error! Enter valid choice.");
                    return;
            }

            try (Connection conn = DriverManager.getConnection(url);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sqlstmt)) {

                // if query to print all parameters
                if (choice == 1) {

                    System.out.println("id" + "\t" + "movie_title" + "\t" + "lead_actor" + "\t" + "lead_actress" + "\t"
                            + "release_year" + "\t" + "director");
                    System.out.println(
                            "------------------------------------------------------------------------------------");

                    // looping through the resultSet to print each data
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" + rs.getString("mov_title") + "\t"
                                + rs.getString("lead_actor") + "\t" + rs.getString("lead_actress") + "\t"
                                + rs.getInt("release_year") + "\t" + rs.getString("director"));
                    }
                }

                // if query to print selective parameters
                else if (choice == 2) {

                    System.out.println("id" + "\t" + "movie_title" + "\t" + "release_year" + "\t" + "director");
                    System.out.println("---------------------------------------------------");

                    // looping through the resultSet to print each data
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + "\t" + rs.getString("mov_title") + "\t"
                                + rs.getInt("release_year") + "\t" + rs.getString("director"));
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}