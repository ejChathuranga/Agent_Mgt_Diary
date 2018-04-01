package genesip.com.ej.insuarance_agent_mgt_diary;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import genesip.com.ej.insuarance_agent_mgt_diary.db.DbActivites;

public class AgentLogin extends AppCompatActivity  implements View.OnClickListener{

    private static final String TAG = "AGENT LOGIN";

    private EditText username, pass;
    private TextView forgotPass, newAccount;
    private Button regAgennt;
    private Boolean responseLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_login);

        regAgennt = findViewById(R.id.btnAgentLogin);
        username = findViewById(R.id.etLoginUsername);
        pass = findViewById(R.id.etLoginPass);
        forgotPass = findViewById(R.id.txtForgot);
        newAccount = findViewById(R.id.txtNewAccount);

        regAgennt.setOnClickListener(this);
        forgotPass.setOnClickListener(this);
        newAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgentLogin:{
                if(isEm(username) || isEm(pass)){
                    username.setError("Please enter username");
                    pass.setError("Please enter username");
                }else {
                    if (!validLength(username) || !validLength(pass)){
                        username.setError("Please enter valid username");
                        pass.setError("Please enter valid username");
                    }else{
                        new LoginAsync().execute();
                    }
                }
                break;
            }case R.id.txtForgot:{
                break;
            }case R.id.txtNewAccount:{
                startActivity(new Intent(AgentLogin.this, AgentRegistration.class));
                break;
            }
        }
    }

    private boolean isEm(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }


    private boolean validLength(EditText editText) {
        if (editText.getText().toString().trim().length() > 3)
            return true;
        return false;
    }

    class LoginAsync extends AsyncTask <String, String, Boolean>{

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                startActivity(new Intent(AgentLogin.this, Agent_dashboard.class));
            }

        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String userName = username.getText().toString().trim();
            String ps = pass.getText().toString().trim();
            DbActivites dbActivites = DbActivites.getInstance(getBaseContext());
            responseLogin = dbActivites.loginCheck(userName, ps);
            Log.e(TAG,"Respose:" +responseLogin);
            return responseLogin;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        username.setText("");
        pass.setText("");
    }
}
