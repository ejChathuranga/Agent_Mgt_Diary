package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/27/2018.
 */

public class AppointmentPotentialCus implements BaseColumns {
    private String TABLE_NAME = "appointmentPotentialCus";

    private String cName = "name";
    private String cDate = "date";
    private String cTime = "time";
    private String cLocation = "location";
    private String cLocationLanLong = "locationLanLong";
    private String cRemark = "remark";
    private String cRemider = "remider";
    private String cRemiderDate = "remiderDate";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + cName + "\tTEXT,\n" +
            "\t" + cDate + "\tTEXT,\n" +
            "\t" + cTime + "\tTEXT,\n" +
            "\t" + cLocation + "\tTEXT,\n" +
            "\t" + cLocationLanLong + "\tTEXT,\n" +
            "\t" + cRemark + "\tTEXT,\n" +
            "\t" + cRemider + "\tTEXT\n" +
            "\t" + cRemiderDate + "\tTEXT\n" +
            ");";

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String getcName() {
        return cName;
    }

    public String getcDate() {
        return cDate;
    }

    public String getcTime() {
        return cTime;
    }

    public String getcLocation() {
        return cLocation;
    }

    public String getcLocationLanLong() {
        return cLocationLanLong;
    }

    public String getcRemark() {
        return cRemark;
    }

    public String getcRemider() {
        return cRemider;
    }

    public String getcRemiderDate() {
        return cRemiderDate;
    }

    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
