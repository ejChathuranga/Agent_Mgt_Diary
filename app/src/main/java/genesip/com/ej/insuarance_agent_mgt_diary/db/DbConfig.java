package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import genesip.com.ej.insuarance_agent_mgt_diary.db.TableConfig.*;

/**
 * Created by ej on 3/22/2018.
 */

public class DbConfig extends SQLiteOpenHelper {

    public static final String DB_NAME = "AgentDiary_v1";
    public static final int DB_V = 1;

    /**
     * @param context
     * let's define queries for create each table
     */

    public static final String SQL_CREATE_AGENT = "CREATE TABLE "+ Agent.TABLE_NAME+" (\n" +
            "\t"+Agent._ID+"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t"+Agent.C_FIRSTNAME+"\tTEXT,\n" +
            ");";


    public DbConfig(Context context) {
        super(context, DB_NAME, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
