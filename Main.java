
public class Main {
    public static void main(String[] args) {

        String DATABASE_NAME = "movie.db";
        String DB_TABLE_NAME = "movies";

        Database db = new Database(DATABASE_NAME);

        // creating movie database
        db.createDB();

        // creating movies table
        db.createTable(DB_TABLE_NAME);

        // inserting data into movies table
        db.insertData(DB_TABLE_NAME, "The Avengers", "Steve Rogers", "Alice Eve", 2012, "Joss Whedon");
        db.insertData(DB_TABLE_NAME, "Captain America", "Jackson Spidell", "Jeremy Renner", 2016, "Anthony");
        db.insertData(DB_TABLE_NAME, "Squid Game", "Lee Jung-jae", "HoYeon Jung", 2021, "Hwang Dong-hyuk");
        db.insertData(DB_TABLE_NAME, "The Lost City", "Sandra Bullock", "Patti Harrison", 2022, "Aaron Nee");

        // Querying
        db.selectQuery(DB_TABLE_NAME);
    }
}
