package kamilbieg.studentorganizer.DataBase;

public class SqlQuery {

    public String createTable(){

        return "create table " + DatabaseStructure.TABLE_NAME + "(" +
                "id integer primary key autoincrement," +
                DatabaseStructure.COLUMN_NAME_TYPE + " string," +
                DatabaseStructure.COLUMN_NAME_NAME + " string," +
                DatabaseStructure.COLUMN_NAME_DATE + " string," +
                DatabaseStructure.COLUMN_NAME_STARTHOUR + " string," +
                DatabaseStructure.COLUMN_NAME_STOPTHOUR + " string," +
                DatabaseStructure.COLUMN_NAME_DESC + " string," +
                DatabaseStructure.COLUMN_NAME_NOTETYPE + " string);";
    }

    public String dropTable(){
        return "DROP TABLE IF EXISTS" + DatabaseStructure.TABLE_NAME;
    }
}
