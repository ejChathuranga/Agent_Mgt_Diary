package genesip.com.ej.insuarance_agent_mgt_diary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ej on 4/1/2018.
 */

class PreferencesStore extends AppCompatActivity {




    private final String userPreference = "userPreference";
    private final String userPref_name = "name";
    private final String userPref_role= "role";


    public PreferencesStore(){}


    public String getUserPreference() {
        return userPreference;
    }

    public String getUserPref_name() {
        return userPref_name;
    }

    public String getUserPref_role() {
        return userPref_role;
    }
}
