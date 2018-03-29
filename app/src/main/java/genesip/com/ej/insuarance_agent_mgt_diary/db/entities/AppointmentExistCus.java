package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/27/2018.
 */

public class AppointmentExistCus implements BaseColumns {
    private String TABLE_NAME = "appointmentExistCus";

    private String cCustomerNumber = "customerNumber";
    private String cName = "name";
    private String cPolicyNumber = "policyNumber";
    private String cDate = "date";
    private String cTime = "time";
    private String cLocation = "location";
    private String cLocationLanLong = "locationLanLong";
    private String cRemark = "remark";
    private String cRemider = "remider";
    private String cRemideDate = "remindDate";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + cCustomerNumber + "\tTEXT,\n" +
            "\t" + cName + "\tTEXT,\n" +
            "\t" + cPolicyNumber + "\tTEXT,\n" +
            "\t" + cDate + "\tTEXT,\n" +
            "\t" + cTime + "\tTEXT,\n" +
            "\t" + cLocation + "\tTEXT,\n" +
            "\t" + cLocationLanLong + "\tTEXT,\n" +
            "\t" + cRemark + "\tTEXT,\n" +
            "\t" + cRemider + "\tTEXT\n" +
            "\t" + cRemideDate + "\tTEXT\n" +
            ");";

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String getcCustomerNumber() {
        return cCustomerNumber;
    }

    public String getcName() {
        return cName;
    }

    public String getcPolicyNumber() {
        return cPolicyNumber;
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

    public String getcRemideDate() {
        return cRemideDate;
    }

    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
