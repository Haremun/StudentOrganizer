package kamilbieg.studentorganizer.Database;

public class SqlQuery {

    public String createTable(){

        return "create table " + DatabaseStructure.TABLE_NAME + "(" +
                "id integer primary key autoincrement," +
                DatabaseStructure.COLUMN_NAME_CLASS_TYPE + " text," +
                DatabaseStructure.COLUMN_NAME_NAME + " text," +
                DatabaseStructure.COLUMN_NAME_START_DATE + " text," +
                DatabaseStructure.COLUMN_NAME_END_DATE + " text," +
                DatabaseStructure.COLUMN_NAME_START_HOUR + " text," +
                DatabaseStructure.COLUMN_NAME_END_HOUR + " text," +
                DatabaseStructure.COLUMN_NAME_DESC + " text," +
                DatabaseStructure.COLUMN_NAME_NOTE_TYPE + " text);";
    }

    public String dropTable(){
        return "DROP TABLE IF EXISTS" + DatabaseStructure.TABLE_NAME;
    }
}
