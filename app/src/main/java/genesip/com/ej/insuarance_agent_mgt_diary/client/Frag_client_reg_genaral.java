package genesip.com.ej.insuarance_agent_mgt_diary.client;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.icu.text.StringPrepParseException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Locale;

import genesip.com.ej.insuarance_agent_mgt_diary.R;


public class Frag_client_reg_genaral extends Fragment implements View.OnClickListener {

    private EditText cusName, cusNo, cusNIC, cusDOB, cusHeight, cusWeight, cusDeseaseDiscrip,
            cusOccupation, cusAddress, cusHomeNo, cusMobileNo, cusWorkNo, cusEmail;
    private Spinner cusGender, cusCivilStatus, cusWeightScale, cusHeightScale, cusDeseaseOrNot;
    private Button cusSave;
    private TextView cusShowAge;
    private Calendar myCalendar;

    DatePickerDialog.OnDateSetListener dob = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateStartingDate(cusDOB);
        }
    };


    public Frag_client_reg_genaral() {
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_client_reg_genaral, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myCalendar = Calendar.getInstance();
        isDisease = false;
        isSavedCustemrInfo = false;

        fragmentManager = getFragmentManager();

        cusName = view.findViewById(R.id.etCusName);
        cusNo = view.findViewById(R.id.etCusNo);
        cusNIC = view.findViewById(R.id.etCusNIC);
        cusDOB = view.findViewById(R.id.etCusDOB);
        cusHeight = view.findViewById(R.id.etCusHeight);
        cusWeight = view.findViewById(R.id.etCusWeight);
        cusDiseaseDiscrip = view.findViewById(R.id.etCusDeseaseDescrip);
        cusOccupation = view.findViewById(R.id.etCusOccupation);
        cusAddress = view.findViewById(R.id.etCusAddress);
        cusHomeNo = view.findViewById(R.id.etCusHomeNo);
        cusMobileNo = view.findViewById(R.id.etCusMobileNo);
        cusWorkNo = view.findViewById(R.id.etCusWorkNo);
        cusEmail = view.findViewById(R.id.etCusEmail);

        cusGender = view.findViewById(R.id.spinnerGender);
        cusCivilStatus = view.findViewById(R.id.spinnerCivilStatus);
        cusWeightScale = view.findViewById(R.id.spinnerWeightScale);
        cusHeightScale = view.findViewById(R.id.spinnerHeightScale);
        cusDiseaseOrNot = view.findViewById(R.id.spinnerDiseaseOrNot);

        cusSave = view.findViewById(R.id.btnCusSave);
        cusShowAge = view.findViewById(R.id.txtShowAge);

        cusSave.setOnClickListener(this);
        cusDOB.setOnClickListener(this);


        cusDOB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                getAge();

            }
        });

        cusCivilStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        Toast.makeText(getActivity(), "Please fill only General & Policy details", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 2: {
                        Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3: {
                        Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cusDiseaseOrNot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        cusDiseaseDiscrip.setVisibility(View.INVISIBLE);
                        isDisease = false;
                        break;
                    }
                    case 1: {
                        cusDiseaseDiscrip.setVisibility(View.VISIBLE);
                        isDisease = true;
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cusCivilStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Button btnSpouse = (Button)getActivity().findViewById(R.id.btnSpouseDetails);
                Button btnChild = (Button)getActivity().findViewById(R.id.btnChildDetails);
                if(position==1){
                    btnSpouse.setVisibility(View.GONE);
                    btnChild.setVisibility(View.GONE);
                }else{
                    btnChild.setVisibility(View.VISIBLE);
                    btnSpouse.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCusSave: {
                getAge();
                Toast.makeText(getContext(), "Hurrerr", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.etCusDOB: {
                try {
                    new DatePickerDialog(getContext(), dob, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                } catch (DateTimeException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void updateStartingDate(EditText editText) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalendar.getTime()));
    }

    private void getAge() {
        try {
            Calendar today = Calendar.getInstance();
            int birthYear = myCalendar.get(Calendar.YEAR);
            int nowYear = today.get(Calendar.YEAR);
            cusShowAge.setText("Age: ~" + (nowYear - birthYear));

        } catch (Exception ex) {
            Toast.makeText(getContext(), "Couldn't find age !", Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }
}
