package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/22/2018.
 */

public class TableConfig {

    public TableConfig() {
    }

    public static class Agent implements BaseColumns {
        public static final String TABLE_NAME = "agents";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t" + "firstName" + "\tTEXT,\n" +
                "\t" + "lastName" + "\tTEXT,\n" +
                "\t" + "username" + "\tTEXT,\n" +
                "\t" + "pass" + "\tTEXT,\n" +
                "\t" + "mobile" + "\tTEXT,\n" +
                "\t" + "role" + "\tTEXT,\n" +
                "\t" + "email" + "\tTEXT,\n" +
                "\t" + "securityQuestion" + "\tTEXT,\n" +
                "\t" + "answer" + "\tTEXT\n" +
                ");";
    }

    public static class Customer implements BaseColumns {
        public static final String TABLE_NAME = "customer";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t" + "name" + "\tTEXT,\n" +
                "\t" + "customerNumber" + "\tTEXT,\n" +
                "\t" + "nic" + "\tTEXT,\n" +
                "\t" + "dob" + "\tTEXT,\n" +
                "\t" + "gender" + "\tTEXT,\n" +
                "\t" + "civic" + "\tTEXT,\n" +
                "\t" + "height" + "\tTEXT,\n" +
                "\t" + "weight" + "\tTEXT,\n" +
                "\t" + "anyDisease" + "\tTEXT\n" +
                "\t" + "occupation" + "\tTEXT,\n" +
                "\t" + "address" + "\tTEXT,\n" +
                "\t" + "addressLanLong" + "\tTEXT,\n" +
                "\t" + "contactHome" + "\tTEXT,\n" +
                "\t" + "contactMobile" + "\tTEXT,\n" +
                "\t" + "contactWork" + "\tTEXT,\n" +
                "\t" + "email" + "\tTEXT,\n" +
                "\t" + "spoName" + "\tTEXT,\n" +
                "\t" + "spoNIC" + "\tTEXT\n" +
                "\t" + "spoDOB" + "\tTEXT,\n" +
                "\t" + "spoGender" + "\tTEXT\n" +
                "\t" + "spoOccupation" + "\tTEXT,\n" +
                "\t" + "spoHeight" + "\tTEXT,\n" +
                "\t" + "spoWeight" + "\tTEXT,\n" +
                "\t" + "spoAnyDisease" + "\tTEXT,\n" +
                "\t" + "spoWorkAddress" + "\tTEXT,\n" +
                "\t" + "spoContactNumber" + "\tTEXT,\n" +
                "\t" + "spoEmail" + "\tTEXT\n" +
                ");";

    }

    public static class Children implements BaseColumns {
        public static final String TABLE_NAME = "children";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t" + "customerNumber" + "\tTEXT,\n" +
                "\t" + "name" + "\tTEXT,\n" +
                "\t" + "dob" + "\tTEXT,\n" +
                "\t" + "height" + "\tTEXT,\n" +
                "\t" + "weight" + "\tTEXT\n" +
                ");";
    }

    public static class Policy implements BaseColumns {
        public static final String TABLE_NAME = "policy";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t" + "customerNumber" + "\tTEXT,\n" +
                "\t" + "customerName" + "\tTEXT,\n" +
                "\t" + "policyNumber" + "\tTEXT,\n" +
                "\t" + "nameOfPolicy" + "\tTEXT,\n" +
                "\t" + "termOfPolicy" + "\tTEXT,\n" +
                "\t" + "endDate" + "\tTEXT,\n" +
                "\t" + "premium" + "\tTEXT,\n" +
                "\t" + "paymentMood" + "\tTEXT,\n" +
                "\t" + "dueDate" + "\tTEXT\n" +
                "\t" + "nextPaymentDate" + "\tTEXT,\n" +
                "\t" + "policyImage01" + "\tTEXT,\n" +
                "\t" + "policyImage02" + "\tTEXT\n" +
                ");";
    }

    public static class AppointmentExistCus implements BaseColumns {
        public static final String TABLE_NAME = "appointmentExistCus";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t" + "customerNumber" + "\tTEXT,\n" +
                "\t" + "name" + "\tTEXT,\n" +
                "\t" + "policyNumber" + "\tTEXT,\n" +
                "\t" + "date" + "\tTEXT,\n" +
                "\t" + "time" + "\tTEXT,\n" +
                "\t" + "location" + "\tTEXT,\n" +
                "\t" + "locationLanLong" + "\tTEXT,\n" +
                "\t" + "remark" + "\tTEXT,\n" +
                "\t" + "remider" + "\tTEXT\n" +
                ");";
    }

    public static class AppointmentPotentialCus implements BaseColumns {
        public static final String TABLE_NAME = "appointmentPotentialCus";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "\t" + _ID + "\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t" + "name" + "\tTEXT,\n" +
                "\t" + "date" + "\tTEXT,\n" +
                "\t" + "time" + "\tTEXT,\n" +
                "\t" + "location" + "\tTEXT,\n" +
                "\t" + "locationLanLong" + "\tTEXT,\n" +
                "\t" + "remark" + "\tTEXT,\n" +
                "\t" + "remider" + "\tTEXT\n" +
                ");";
    }

}
