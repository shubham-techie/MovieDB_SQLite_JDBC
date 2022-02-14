
public class Main {
    public static void main(String[] args) {

        String DATABASE_NAME = "movie.db";
        String DB_TABLE_NAME = "movies";

        Database db = new Database(DATABASE_NAME);

        // creating movie database
        db.createDB();

        // creating movies table
        db.createTable(DB_TABLE_NAME);

        // inserting data into movies tabe
        db.insertData(DB_TABLE_NAME, "The Avengers", "Steve Rogers", "Alice Eve", 2012, "Joss Whedon");
        db.insertData(DB_TABLE_NAME, "Captain America: Civil War", "Jackson Spidell", "Jeremy Renner", 2016, "Anthony");
    }
}
