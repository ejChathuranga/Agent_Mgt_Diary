package genesip.com.ej.insuarance_agent_mgt_diary.appointment;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import genesip.com.ej.insuarance_agent_mgt_diary.R;

public class Appointment_dashboard extends AppCompatActivity implements View.OnClickListener,
        ExistingClientAppointment_frag.OnFragmentInteractionListener,
        PotentialClientAppointment_frag.OnFragmentInteractionListener,
        TodayAppointments_frag.OnFragmentInteractionListener,
        AllAppointments_frag.OnFragmentInteractionListener {

    private Button existCustomer, potentialCus, todayAppintments, allAppointments;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_dashboard);

        if (savedInstanceState != null) {
            return;
        }

        fragmentManager = getSupportFragmentManager();

        existCustomer = findViewById(R.id.btnExistCus);
        potentialCus = findViewById(R.id.btnPotentilCus);
        todayAppintments = findViewById(R.id.btnTodayAppintments);
        allAppointments = findViewById(R.id.btnAllAppointments);

        existCustomer.setOnClickListener(this);
        potentialCus.setOnClickListener(this);
        todayAppintments.setOnClickListener(this);
        allAppointments.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExistCus: {
                try {
                    ExistingClientAppointment_frag genaral = new ExistingClientAppointment_frag();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragContainerAppointment, genaral);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnPotentilCus: {
                try {
                    PotentialClientAppointment_frag spouse = new PotentialClientAppointment_frag();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragContainerAppointment, spouse);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnTodayAppintments: {
                try {

                    TodayAppointments_frag child = new TodayAppointments_frag();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragContainerAppointment, child);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnAllAppointments: {
                try {

                    AllAppointments_frag policy = new AllAppointments_frag();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragContainerAppointment, policy);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
