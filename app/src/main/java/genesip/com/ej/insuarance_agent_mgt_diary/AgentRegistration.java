package genesip.com.ej.insuarance_agent_mgt_diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AgentRegistration extends AppCompatActivity {

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



    }
}
