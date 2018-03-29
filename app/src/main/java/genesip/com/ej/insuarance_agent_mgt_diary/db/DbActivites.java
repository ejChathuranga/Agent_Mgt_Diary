package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import genesip.com.ej.insuarance_agent_mgt_diary.db.entities.Agent;

/**
 * Created by ej on 3/28/2018.
 */

public class DbActivites {
    private static final String TAG = "DB ACTIVITES";
    private static DbActivites instance = new DbActivites();

    private DbActivites() {
    }

    public static DbActivites getInstance() {
        return instance;
    }

    public void showMassge() {
        Log.e(TAG, "Testing Singleton");
    }

    public String saveIntoDB(ContentValues values, Context context, String from) {
        DbConfig dbHelp = new DbConfig(context);
        SQLiteDatabase db = dbHelp.getWritableDatabase();

        if (from.equals("Agent")) {
            Agent agent = new Agent();
            Long response = db.insert(agent.getTABLE_NAME(), null, values);
            if (response != -1) {
                return "Agent Registered";
            } else
                return "Failed";
        }

        return "Failed";
    }


}
