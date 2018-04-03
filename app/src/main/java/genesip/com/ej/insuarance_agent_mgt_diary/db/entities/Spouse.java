package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 4/3/2018.
 */

public class Spouse implements BaseColumns {
    private String TABLE_NAME = "spouse";

    private String cCustomerNumber = "customerNumber";
    private String cSpoName = "spoName";
    private String cSpoNIC = "spoNIC";
    private String cSpoDOB = "spoDOB";
    private String cSpoGender = "spoGender";
    private String cSpoOccupation = "spoOccupation";
    private String cSpoHeight = "spoHeight";
    private String cSpoWeight = "spoWeight";
    private String cSpoAnyDisease = "spoAnyDisease";
    private String cSpoWorkAddress = "spoWorkAddress";
    private String cSpoContactNum = "spoContactNum";
    private String cSpoEmail = "spoEmail";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + cCustomerNumber + "\tTEXT,\n" +
            "\t" + cSpoName + "\tTEXT,\n" +
            "\t" + cSpoNIC + "\tTEXT,\n" +
            "\t" + cSpoDOB + "\tTEXT,\n" +
            "\t" + cSpoGender + "\tTEXT,\n" +
            "\t" + cSpoOccupation + "\tTEXT,\n" +
            "\t" + cSpoHeight + "\tTEXT,\n" +
            "\t" + cSpoWeight + "\tTEXT,\n" +
            "\t" + cSpoAnyDisease + "\tTEXT,\n" +
            "\t" + cSpoWorkAddress + "\tTEXT,\n" +
            "\t" + cSpoContactNum + "\tTEXT,\n" +
            "\t" + cSpoEmail + "\tTEXT\n" +
            ");";

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String getcCustomerNumber() {
        return cCustomerNumber;
    }

    public String getcSpoName() {
        return cSpoName;
    }

    public String getcSpoNIC() {
        return cSpoNIC;
    }

    public String getcSpoDOB() {
        return cSpoDOB;
    }

    public String getcSpoGender() {
        return cSpoGender;
    }

    public String getcSpoOccupation() {
        return cSpoOccupation;
    }

    public String getcSpoHeight() {
        return cSpoHeight;
    }

    public String getcSpoWeight() {
        return cSpoWeight;
    }

    public String getcSpoAnyDisease() {
        return cSpoAnyDisease;
    }

    public String getcSpoWorkAddress() {
        return cSpoWorkAddress;
    }

    public String getcSpoContactNum() {
        return cSpoContactNum;
    }

    public String getcSpoEmail() {
        return cSpoEmail;
    }

    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
