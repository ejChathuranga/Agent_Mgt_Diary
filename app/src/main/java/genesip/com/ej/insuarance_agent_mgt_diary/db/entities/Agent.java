package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/27/2018.
 */

public class Agent implements BaseColumns {
    public String TABLE_NAME = "agents";;

    private String C_FIRSTNAME  = "firstName";
    private String C_LASTNAME  = "lastName";
    private String C_USERNAME = "username";
    private String C_PASS = "pass";
    private String C_MOBILE = "mobile";
    private String C_ROLE = "role";
    private String C_EMAIL = "email";
    private String C_SEC_QUE = "securityQuestion";
    private String C_ANSWER = "answer";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + C_FIRSTNAME + "\tTEXT,\n" +
            "\t" + C_LASTNAME + "\tTEXT,\n" +
            "\t" + C_USERNAME + "\tTEXT,\n" +
            "\t" + C_PASS + "\tTEXT,\n" +
            "\t" + C_MOBILE + "\tTEXT,\n" +
            "\t" + C_ROLE + "\tTEXT,\n" +
            "\t" + C_EMAIL + "\tTEXT,\n" +
            "\t" + C_SEC_QUE + "\tTEXT,\n" +
            "\t" + C_ANSWER + "\tTEXT\n" +
            ");";


    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String get_ID(){
        return _ID;
    }

    public String getC_FIRSTNAME() {
        return C_FIRSTNAME;
    }

    public String getC_LASTNAME() {
        return C_LASTNAME;
    }

    public String getC_USERNAME() {
        return C_USERNAME;
    }

    public String getC_PASS() {
        return C_PASS;
    }

    public String getC_MOBILE() {
        return C_MOBILE;
    }

    public String getC_ROLE() {
        return C_ROLE;
    }

    public String getC_EMAIL() {
        return C_EMAIL;
    }

    public String getC_SEC_QUE() {
        return C_SEC_QUE;
    }

    public String getC_ANSWER() {
        return C_ANSWER;
    }

    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
