package genesip.com.ej.insuarance_agent_mgt_diary;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import genesip.com.ej.insuarance_agent_mgt_diary.db.DbActivites;
import genesip.com.ej.insuarance_agent_mgt_diary.db.DbConfig;
import genesip.com.ej.insuarance_agent_mgt_diary.db.entities.Agent;

public class AgentRegistration extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AGENT REGISTRATION";
    private DbConfig dbConfig;

    private EditText firstName, lastName, username, pass, mobileNo, email, answer ;
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

        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        username = findViewById(R.id.etUsername);
        pass = findViewById(R.id.etPass);
        mobileNo = findViewById(R.id.etMobileNo);
        role = findViewById(R.id.spinnerRole);
        email = findViewById(R.id.etEmail);
        secQue = findViewById(R.id.spinnerSecQuestion);
        answer = findViewById(R.id.etAnswer);
        reg = findViewById(R.id.btnReg);

        reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btnReg): {

                new AgentRegAsync().execute();
//                DbActivites obj = DbActivites.getInstance();
//                obj.showMassge();
//                Toast.makeText(this, "Woohhhaaaa", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    class AgentRegAsync extends AsyncTask<String, String, String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {

            String firstNameA = firstName.getText().toString();
            String lastNameA = lastName.getText().toString();
            String usernameA = username.getText().toString();
            String passA = pass.getText().toString();
            String mobileNoA = mobileNo.getText().toString();
            String roleA = role.getSelectedItem().toString();
            String emailA = email.getText().toString();
            String secQueA = secQue.getSelectedItem().toString();
            String answerA = answer.getText().toString();

            ContentValues values = new ContentValues();
            Agent agent  = new Agent();
            DbActivites dbActivites = DbActivites.getInstance();

            values.put(agent.getC_FIRSTNAME(), firstNameA);
            values.put(agent.getC_LASTNAME(), lastNameA);
            values.put(agent.getC_USERNAME(), usernameA);
            values.put(agent.getC_PASS(), passA);
            values.put(agent.getC_MOBILE(), mobileNoA);
            values.put(agent.getC_ROLE(), roleA);
            values.put(agent.getC_EMAIL(), emailA);
            values.put(agent.getC_SEC_QUE(), secQueA);
            values.put(agent.getC_ANSWER(), answerA);

            String response = dbActivites.saveIntoDB(values, getApplicationContext(), "Agent");
//            Toast.makeText(AgentRegistration.this, response, Toast.LENGTH_SHORT).show();
            Log.e(TAG,response);


            return null;
        }
    }
}


