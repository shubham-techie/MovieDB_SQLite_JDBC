
public class Main {
    public static void main(String[] args) {

        String DATABASE_NAME = "movie.db";

        Database db = new Database(DATABASE_NAME);

        // creating movie database
        db.createDB();

    }
}
