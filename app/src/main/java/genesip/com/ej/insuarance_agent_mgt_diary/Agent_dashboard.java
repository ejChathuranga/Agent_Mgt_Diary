package genesip.com.ej.insuarance_agent_mgt_diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import genesip.com.ej.insuarance_agent_mgt_diary.client.Client_reg_main;

public class Agent_dashboard extends AppCompatActivity implements OnClickListener {

    private Button addNewClient, makeAppointment, todayPayments, staticalReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dashboard);

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
