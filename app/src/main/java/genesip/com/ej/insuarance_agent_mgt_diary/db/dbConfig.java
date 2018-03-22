package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ej on 3/22/2018.
 */

public class dbConfig extends SQLiteOpenHelper {

    public static final String DB_NAME = "AgentDiary_v1";
    public static final int DB_V = 1;

    /**
     * @param context
     */

    public dbConfig(Context context) {
        super(context, DB_NAME, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
