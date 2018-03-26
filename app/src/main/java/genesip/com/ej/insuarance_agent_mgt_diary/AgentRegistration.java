package genesip.com.ej.insuarance_agent_mgt_diary;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import genesip.com.ej.insuarance_agent_mgt_diary.db.DbConfig;

public class AgentRegistration extends AppCompatActivity {

    private DbConfig dbConfig;

    private EditText firstNamr, lastName, username, pass, mobileNo, mail, ansewer ;
    private Spinner role, secQue;
    private Button reg;

    private SQLiteDatabase mDatabase;
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_registration);
        setTitle("Agent Registration");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbConfig = new DbConfig(getApplicationContext());
        mDatabase = dbConfig.getReadableDatabase();

    }
}
