package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import genesip.com.ej.insuarance_agent_mgt_diary.db.TableConfig.*;

/**
 * Created by ej on 3/22/2018.
 */

public class DbConfig extends SQLiteOpenHelper {

    public static final String DB_NAME = "AgentDiary_v1";
    public static final int DB_V = 4;


    public static final String SQL_DROP_AGENT = "DROP TABLE IF EXISTS " + Agent.TABLE_NAME;
    public static final String SQL_DROP_CUSTOMER = "DROP TABLE IF EXISTS " + Customer.TABLE_NAME;
    public static final String SQL_DROP_CHILDREN = "DROP TABLE IF EXISTS " + Children.TABLE_NAME;
    public static final String SQL_DROP_POLICY = "DROP TABLE IF EXISTS " + Policy.TABLE_NAME;
    public static final String SQL_DROP_APP_EXT_CUS = "DROP TABLE IF EXISTS " + AppointmentExistCus.TABLE_NAME;
    public static final String SQL_DROP_APP_POT_CUS = "DROP TABLE IF EXISTS " + AppointmentPotentialCus.TABLE_NAME;


    public DbConfig(Context context) {
        super(context, DB_NAME, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Agent.CREATE_TABLE);
        db.execSQL(Customer.CREATE_TABLE);
        db.execSQL(Children.CREATE_TABLE);
        db.execSQL(Policy.CREATE_TABLE);
        db.execSQL(AppointmentExistCus.CREATE_TABLE);
        db.execSQL(AppointmentPotentialCus.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<4){
            db.execSQL(SQL_DROP_AGENT);
            db.execSQL(SQL_DROP_CUSTOMER);
            db.execSQL(SQL_DROP_APP_EXT_CUS);
            db.execSQL(SQL_DROP_CHILDREN);
            db.execSQL(SQL_DROP_POLICY);
            db.execSQL(SQL_DROP_APP_POT_CUS);
            onCreate(db);
        }

    }
}
