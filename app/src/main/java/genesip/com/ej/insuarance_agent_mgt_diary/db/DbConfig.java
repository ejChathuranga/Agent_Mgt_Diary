package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//import genesip.com.ej.insuarance_agent_mgt_diary.db.TableConfig.*;
import genesip.com.ej.insuarance_agent_mgt_diary.db.entities.*;

/**
 * Created by ej on 3/22/2018.
 */

public class DbConfig extends SQLiteOpenHelper {

    public static final String DB_NAME = "AgentDiary_v2";
    public static final int DB_V = 3;

    Agent nAgent = new Agent();
    AppointmentExistCus nAppointmentExistCus = new AppointmentExistCus();
    AppointmentPotentialCus nAppointmentPotentialCus = new AppointmentPotentialCus();
    Children nChildren = new Children();
    Customer nCustomer = new Customer();
    Policy nPolicy = new Policy();


    public final String SQL_DROP_AGENT = "DROP TABLE IF EXISTS " + nAgent.getTABLE_NAME();
    public final String SQL_DROP_APMNT_EXT_CUS = "DROP TABLE IF EXISTS " + nAppointmentExistCus.getTABLE_NAME();
    public final String SQL_DROP_APMNT_POT_CUS = "DROP TABLE IF EXISTS " + nAppointmentPotentialCus.getTABLE_NAME();
    public final String SQL_DROP_CHILD = "DROP TABLE IF EXISTS " + nChildren.getTABLE_NAME();
    public final String SQL_DROP_CUS = "DROP TABLE IF EXISTS " + nCustomer.getTABLE_NAME();
    public final String SQL_DROP_POLICY = "DROP TABLE IF EXISTS " + nPolicy.getTABLE_NAME();


    public DbConfig(Context context) {
        super(context, DB_NAME, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(nAgent.getCREATE_TABLE());
        db.execSQL(nAppointmentExistCus.getCREATE_TABLE());
        db.execSQL(nAppointmentPotentialCus.getCREATE_TABLE());
        db.execSQL(nChildren.getCREATE_TABLE());
        db.execSQL(nCustomer.getCREATE_TABLE());
        db.execSQL(nPolicy.getCREATE_TABLE());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<3){
            db.execSQL(SQL_DROP_AGENT);
            db.execSQL(SQL_DROP_APMNT_EXT_CUS);
            db.execSQL(SQL_DROP_APMNT_POT_CUS);
            db.execSQL(SQL_DROP_CHILD);
            db.execSQL(SQL_DROP_CUS);
            db.execSQL(SQL_DROP_POLICY);
            onCreate(db);
        }

    }
}
