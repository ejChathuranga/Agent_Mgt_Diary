package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/27/2018.
 */

public class Customer implements BaseColumns {
    private String TABLE_NAME = "customer";

    private String cName = "name";
    private String cCustomerNumber = "customerNumber";
    private String cNIC = "nic";
    private String cDOB = "dob";
    private String cGender = "gender";
    private String cCivic = "civic";
    private String cHeight = "height";
    private String cWeight = "weight";
    private String cAnyDisease = "disease";
    private String cOccupation = "occupation";
    private String cAddress = "address";
    private String cAddressLanLong = "addressLanLong";
    private String cContactHome = "contactHome";
    private String cContactMobile = "contactMobile";
    private String cContactWork = "contactWork";
    private String cEmail = "email";
    private String cSpoName = "spoName";
    private String cSpoNIC= "spoNIC";
    private String cSpoDOB= "spoDOB";
    private String cSpoGender= "spoGender";
    private String cSpoOccupation= "spoOccupation";
    private String cSpoHeight= "spoHeight";
    private String cSpoWeight= "spoWeight";
    private String cSpoAnyDisease= "spoAnyDisease";
    private String cSpoWorkAddress= "spoWorkAddress";
    private String cSpoContactNum= "spoContactNum";
    private String cSpoEmail= "spoEmail";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + cName + "\tTEXT,\n" +
            "\t" + cCustomerNumber + "\tTEXT,\n" +
            "\t" + cNIC + "\tTEXT,\n" +
            "\t" + cDOB + "\tTEXT,\n" +
            "\t" + cGender + "\tTEXT,\n" +
            "\t" + cCivic + "\tTEXT,\n" +
            "\t" + cHeight + "\tTEXT,\n" +
            "\t" + cWeight + "\tTEXT,\n" +
            "\t" + cAnyDisease + "\tTEXT\n" +
            "\t" + cOccupation + "\tTEXT,\n" +
            "\t" + cAddress + "\tTEXT,\n" +
            "\t" + cAddressLanLong + "\tTEXT,\n" +
            "\t" + cContactHome + "\tTEXT,\n" +
            "\t" + cContactMobile + "\tTEXT,\n" +
            "\t" + cContactWork + "\tTEXT,\n" +
            "\t" + cEmail + "\tTEXT,\n" +
            "\t" + cSpoName + "\tTEXT,\n" +
            "\t" + cSpoNIC + "\tTEXT\n" +
            "\t" + cSpoDOB + "\tTEXT,\n" +
            "\t" + cSpoGender + "\tTEXT\n" +
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

    public String getcName() {
        return cName;
    }

    public String getcCustomerNumber() {
        return cCustomerNumber;
    }

    public String getcNIC() {
        return cNIC;
    }

    public String getcDOB() {
        return cDOB;
    }

    public String getcGender() {
        return cGender;
    }

    public String getcCivic() {
        return cCivic;
    }

    public String getcHeight() {
        return cHeight;
    }

    public String getcWeight() {
        return cWeight;
    }

    public String getcAnyDisease() {
        return cAnyDisease;
    }

    public String getcOccupation() {
        return cOccupation;
    }

    public String getcAddress() {
        return cAddress;
    }

    public String getcAddressLanLong() {
        return cAddressLanLong;
    }

    public String getcContactHome() {
        return cContactHome;
    }

    public String getcContactMobile() {
        return cContactMobile;
    }

    public String getcContactWork() {
        return cContactWork;
    }

    public String getcEmail() {
        return cEmail;
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
