package genesip.com.ej.insuarance_agent_mgt_diary.client;


import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import genesip.com.ej.insuarance_agent_mgt_diary.R;

public class Client_reg_main extends AppCompatActivity implements
        View.OnClickListener,
        Frag_client_reg_policy.OnFragmentInteractionListener,
        Frag_client_reg_spouse.OnFragmentInteractionListener,
        Frag_client_reg_child.OnFragmentInteractionListener,
        Frag_client_reg_genaral.OnFragmentInteractionListener {

    private Button genralDetails, spouseDetails, childDetails, policyDetails;

    FragmentManager fragmentManager;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_reg_main);

        if (savedInstanceState != null) {
            return;
        }

        fragmentManager = getSupportFragmentManager();

        genralDetails = findViewById(R.id.btnGenaralDetails);
        spouseDetails = findViewById(R.id.btnSpouseDetails);
        childDetails = findViewById(R.id.btnChildDetails);
        policyDetails = findViewById(R.id.btnPolicyDetails);

        genralDetails.setOnClickListener(this);
        spouseDetails.setOnClickListener(this);
        childDetails.setOnClickListener(this);
        policyDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGenaralDetails: {
                try {
                    Frag_client_reg_genaral genaral = new Frag_client_reg_genaral();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, genaral);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnSpouseDetails: {
                try {
                    Frag_client_reg_spouse spouse = new Frag_client_reg_spouse();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, spouse);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnChildDetails: {
                try {

                    Frag_client_reg_child child = new Frag_client_reg_child();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, child);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Please restart the mobile device", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.btnPolicyDetails: {
                try {

                    Frag_client_reg_policy policy = new Frag_client_reg_policy();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, policy);
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
}
