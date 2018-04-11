package genesip.com.ej.insuarance_agent_mgt_diary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ej on 4/1/2018.
 */

public class PreferencesStore extends AppCompatActivity {

    // for save user preferences
    private final String userPreference = "userPreference";
    private final String userPref_name = "name";
    private final String userPref_role = "role";

    //for save customer registration preferences
    private final String cusRegPreference = "cusRegPreference";
    private final String cusNo = "cusNo";
    private final String isCustomerAdded = "cusNo";
    private final String newCusAddedRow = "newCusAddedRow";


    public PreferencesStore() {
    }

    // for user preferences
    public String getUserPreference() {
        return userPreference;
    }

    public String getUserPref_name() {
        return userPref_name;
    }

    public String getUserPref_role() {
        return userPref_role;
    }


    //for customer preferences
    public String getCusRegPreference() {
        return cusRegPreference;
    }

    public String getCusNo() {
        return cusNo;
    }

    public String getIsCustomerAdded() {
        return isCustomerAdded;
    }

    public String getNewCusAddedRow() {
        return newCusAddedRow;
    }
}
