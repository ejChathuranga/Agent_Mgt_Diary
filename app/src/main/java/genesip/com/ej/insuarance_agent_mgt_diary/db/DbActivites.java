package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import genesip.com.ej.insuarance_agent_mgt_diary.db.entities.Agent;

/**
 * Created by ej on 3/28/2018.
 */

public class DbActivites {
    private static final String TAG = "DB ACTIVITIES";
    private static DbActivites instance = new DbActivites();
    static DbConfig dbHelp;

    private DbActivites() {}

    public static DbActivites getInstance(Context context) {
        dbHelp = new DbConfig(context);
        return instance;
    }

    public Boolean saveIntoDB(ContentValues values, String to) {
        SQLiteDatabase db = dbHelp.getWritableDatabase();

        try {
            if (to.equals("Agent")) {
                Agent agent = new Agent();
                Long response = db.insert(agent.getTABLE_NAME(), null, values);
                if (response != -1) {
                    return true;
                } else
                    return false;
            }
        } catch (SQLiteException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean loginCheck(String un, String pw) {
        SQLiteDatabase db = dbHelp.getReadableDatabase();
        Agent agent = new Agent();

        String query = "SELECT " + agent.getC_USERNAME() + ", " + agent.getC_PASS() + " FROM " + agent.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    if (cursor.getString(0).equals(un)) {
                        if (cursor.getString(1).equals(pw)) {
                            return true;
                        }
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean usernameCheck(String un) {
        SQLiteDatabase db = dbHelp.getReadableDatabase();
        Agent agent = new Agent();

        String query = "SELECT " + agent.getC_USERNAME() + " FROM " + agent.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    if (cursor.getString(0).equals(un)) {
                            return false;
                    }
                } while (cursor.moveToNext());
            }else {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }


}
