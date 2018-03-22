package genesip.com.ej.insuarance_agent_mgt_diary.db;

import android.provider.BaseColumns;

/**
 * Created by ej on 3/22/2018.
 */

public class TableConfig {

    public TableConfig() {
    }

    public static class Agent implements BaseColumns{
        public static final String TABLE_NAME = "agents";
        public static final String C_FIRSTNAME= "firstName";
        public static final String C_LASTNAME = "lastName";
        public static final String C_USERNAME = "username";
        public static final String C_PASS = "pass";
        public static final String C_MOBILE = "mobile";
        public static final String C_ROLE = "role";
        public static final String C_EMAIL = "email";
        public static final String C_SEC_QUE = "securityQuestion";
        public static final String C_ANSWER = "answer";
    }

    public static class Customer  implements BaseColumns{
        public static final String TABLE_NAME = "customer";
    }

}
