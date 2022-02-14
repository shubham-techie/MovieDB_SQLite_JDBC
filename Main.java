
public class Main {
    public static void main(String[] args) {

        String DATABASE_NAME = "movie.db";
        String DB_TABLE_NAME = "movies";

        Database db = new Database(DATABASE_NAME);

        // creating movie database
        db.createDB();

        // creating movies table
        db.createTable(DB_TABLE_NAME);
    }
}
