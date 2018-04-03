package genesip.com.ej.insuarance_agent_mgt_diary.db.entities;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/27/2018.
 */

public class Policy implements BaseColumns {
    private String TABLE_NAME = "policy";

    private String cCustomerNumber = "customerNumber";
    private String cCustomerName = "customerName";
    private String cPolicyNumber = "policyNumber";
    private String cNameOfPolicy = "nameOfPolicy";
    private String cTermOfPolicy = "termOfPolicy";
    private String cEndDate = "endDate";
    private String cPremium = "premium";
    private String cPaymentMood = "paymentMood";
    private String cDueDate = "dueDate";
    private String cNextPaymentDate = "nextPaymentDate";
    private String cPaymentReminderDate = "paymentReminderDate"; // date that reminder need to be activate
    private String cPolicyImage01 = "policyImage01";
    private String cPolicyImage02 = "policyImage02";

    private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
            "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t" + cCustomerNumber + "\tTEXT,\n" +
            "\t" + cCustomerName + "\tTEXT,\n" +
            "\t" + cPolicyNumber + "\tTEXT,\n" +
            "\t" + cNameOfPolicy + "\tTEXT,\n" +
            "\t" + cTermOfPolicy + "\tTEXT,\n" +
            "\t" + cEndDate + "\tTEXT,\n" +
            "\t" + cPremium + "\tTEXT,\n" +
            "\t" + cPaymentMood + "\tTEXT,\n" +
            "\t" + cDueDate + "\tTEXT,\n" +
            "\t" + cNextPaymentDate + "\tTEXT,\n" +
            "\t" + cPaymentReminderDate + "\tTEXT,\n" +
            "\t" + cPolicyImage01 + "\tTEXT,\n" +
            "\t" + cPolicyImage02 + "\tTEXT\n" +
            ");";

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String getcCustomerNumber() {
        return cCustomerNumber;
    }

    public String getcCustomerName() {
        return cCustomerName;
    }

    public String getcPolicyNumber() {
        return cPolicyNumber;
    }

    public String getcNameOfPolicy() {
        return cNameOfPolicy;
    }

    public String getcTermOfPolicy() {
        return cTermOfPolicy;
    }

    public String getcEndDate() {
        return cEndDate;
    }

    public String getcPremium() {
        return cPremium;
    }

    public String getcPaymentMood() {
        return cPaymentMood;
    }

    public String getcDueDate() {
        return cDueDate;
    }

    public String getcNextPaymentDate() {
        return cNextPaymentDate;
    }

    public String getcPaymentReminderDate() {
        return cPaymentReminderDate;
    }

    public String getcPolicyImage01() {
        return cPolicyImage01;
    }

    public String getcPolicyImage02() {
        return cPolicyImage02;
    }

    public String getCREATE_TABLE() {
        return CREATE_TABLE;
    }
}
