package genesip.com.ej.insuarance_agent_mgt_diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import genesip.com.ej.insuarance_agent_mgt_diary.client.Client_reg_main;

public class Agent_dashboard extends AppCompatActivity implements OnClickListener {
    private PreferencesStore prefStore;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    private Button addNewClient, makeAppointment, todayPayments, staticalReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dashboard);

        prefStore = new PreferencesStore();
        preferences = getSharedPreferences(prefStore.getUserPreference(),0);
        String username = preferences.getString(prefStore.getUserPref_name(),"");
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

        addNewClient = findViewById(R.id.btnAddNewClient);
        makeAppointment = findViewById(R.id.btnNewAppointment);
        todayPayments = findViewById(R.id.btnShowToadyPayment);
        staticalReport = findViewById(R.id.btnShowStaticalReport);

        addNewClient.setOnClickListener(this);
        makeAppointment.setOnClickListener(this);
        todayPayments.setOnClickListener(this);
        staticalReport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddNewClient: {
                startActivity(new Intent(Agent_dashboard.this, Client_reg_main.class));
                break;
            }
        }
    }
}
