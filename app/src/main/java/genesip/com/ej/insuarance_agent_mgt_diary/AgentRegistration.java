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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genesip.com.ej.insuarance_agent_mgt_diary.db.DbActivites;
import genesip.com.ej.insuarance_agent_mgt_diary.db.DbConfig;
import genesip.com.ej.insuarance_agent_mgt_diary.db.entities.Agent;

public class AgentRegistration extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AGENT REGISTRATION";
    private DbConfig dbConfig;
    private AgentRegAsync ara;

    private EditText firstName, lastName, username, pass, mobileNo, email, answer;
    private Spinner role, secQue;
    private Button reg;
    private Boolean responseSubmitted;

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String MOBILE_PATTERN = "\\d+";


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
        switch (v.getId()) {
            case (R.id.btnReg): {
                if (isEm(firstName) || isEm(lastName) || isEm(username) || isEm(pass) || isEm(mobileNo) || isEm(email) || isEm(answer)) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (!validLength(username) || !validLength(pass)) {
                        Toast.makeText(this, "Check username & password", Toast.LENGTH_SHORT).show();
                        username.setError("Please enter more than 3 characters");
                        pass.setError("Please enter more than 3 characters");
                    } else {
                        if (!validMobile(mobileNo)) {
                            Toast.makeText(this, "Enter valid mobile number", Toast.LENGTH_SHORT).show();
                            mobileNo.setError("Please Enter valid mobile No");
                        } else {
                            if (!validEmail(email)) {
                                Toast.makeText(this, "Enter valid Email", Toast.LENGTH_SHORT).show();
                                email.setError("Please enter valid email");
                            } else {
                                if (!checkUsername(username)) {
                                    username.setError("Username is already exist");
                                } else {
                                    new AgentRegAsync().execute();
                                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    private Boolean checkUsername(EditText username) {
        Boolean isAvailabe = DbActivites.getInstance(getApplicationContext()).usernameCheck(username.getText().toString());
        Log.d(TAG, "Username Available: " + isAvailabe);
        return isAvailabe;
    }

    private boolean isEm(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public boolean validEmail(EditText email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email.getText().toString().trim());
        return matcher.matches();
    }

    public boolean validMobile(EditText mobile) {
        pattern = Pattern.compile(MOBILE_PATTERN);
        matcher = pattern.matcher(mobile.getText().toString().trim());
        return matcher.matches();
    }

    private boolean validLength(EditText editText) {
        if (editText.getText().toString().trim().length() > 3)
            return true;
        return false;
    }

    private void clearFields() {
        firstName.setText("");
        lastName.setText("");
        username.setText("");
        pass.setText("");
        mobileNo.setText("");
        email.setText("");
        answer.setText("");
    }

    class AgentRegAsync extends AsyncTask<String, String, Boolean> {

        @Override
        protected void onPostExecute(Boolean s) {
            super.onPostExecute(s);
            if (s) {
                clearFields();
            }else{
                Log.e(TAG, "Error when inserting data into DB");
            }
        }

        @Override
        protected Boolean doInBackground(String... strings) {

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
            Agent agent = new Agent();
            DbActivites dbActivites = DbActivites.getInstance(getApplicationContext());

            values.put(agent.getC_FIRSTNAME(), firstNameA);
            values.put(agent.getC_LASTNAME(), lastNameA);
            values.put(agent.getC_USERNAME(), usernameA);
            values.put(agent.getC_PASS(), passA);
            values.put(agent.getC_MOBILE(), mobileNoA);
            values.put(agent.getC_ROLE(), roleA);
            values.put(agent.getC_EMAIL(), emailA);
            values.put(agent.getC_SEC_QUE(), secQueA);
            values.put(agent.getC_ANSWER(), answerA);

            responseSubmitted = dbActivites.saveIntoDB(values, "Agent");
            Log.d(TAG, "Updated :" + responseSubmitted);
            return responseSubmitted;
        }
    }
}


