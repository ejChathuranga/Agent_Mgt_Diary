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
            "\t" + cAnyDisease + "\tTEXT,\n" +
            "\t" + cOccupation + "\tTEXT,\n" +
            "\t" + cAddress + "\tTEXT,\n" +
            "\t" + cAddressLanLong + "\tTEXT,\n" +
            "\t" + cContactHome + "\tTEXT,\n" +
            "\t" + cContactMobile + "\tTEXT,\n" +
            "\t" + cContactWork + "\tTEXT,\n" +
            "\t" + cEmail + "\tTEXT\n" +
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



    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
