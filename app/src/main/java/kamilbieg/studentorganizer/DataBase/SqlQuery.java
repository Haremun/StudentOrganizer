package kamilbieg.studentorganizer.DataBase;

public class SqlQuery {

    public String createTable(){

        return "create table " + DatabaseStructure.TABLE_NAME + "(" +
                "id integer primary key autoincrement," +
                DatabaseStructure.COLUMN_NAME_TYPE + " text," +
                DatabaseStructure.COLUMN_NAME_NAME + " text," +
                DatabaseStructure.COLUMN_NAME_DATE + " text," +
                DatabaseStructure.COLUMN_NAME_STARTHOUR + " text," +
                DatabaseStructure.COLUMN_NAME_STOPTHOUR + " text," +
                DatabaseStructure.COLUMN_NAME_DESC + " text," +
                DatabaseStructure.COLUMN_NAME_NOTETYPE + " text);";
    }

    public String dropTable(){
        return "DROP TABLE IF EXISTS" + DatabaseStructure.TABLE_NAME;
    }
}
