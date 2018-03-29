package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/27/2018.
 */

public class Children implements BaseColumns {
    private String TABLE_NAME = "children";

    private String cCustomerNumber = "customerNumber";
    private String cName = "name";
    private String cDOB = "dob";
    private String cHeight = "height";
    private String cWeight = "weight";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + cCustomerNumber + "\tTEXT,\n" +
            "\t" + cName + "\tTEXT,\n" +
            "\t" + cDOB + "\tTEXT,\n" +
            "\t" + cHeight + "\tTEXT,\n" +
            "\t" + cWeight + "\tTEXT\n" +
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

    public String getcDOB() {
        return cDOB;
    }

    public String getcHeight() {
        return cHeight;
    }

    public String getcWeight() {
        return cWeight;
    }

    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
