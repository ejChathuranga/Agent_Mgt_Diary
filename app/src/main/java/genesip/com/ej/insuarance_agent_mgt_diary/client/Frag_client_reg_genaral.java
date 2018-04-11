package genesip.com.ej.insuarance_agent_mgt_diary.client;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genesip.com.ej.insuarance_agent_mgt_diary.PreferencesStore;
import genesip.com.ej.insuarance_agent_mgt_diary.R;
import genesip.com.ej.insuarance_agent_mgt_diary.db.DbActivites;
import genesip.com.ej.insuarance_agent_mgt_diary.db.entities.Customer;


public class Frag_client_reg_genaral extends Fragment implements View.OnClickListener {

    private static final String TAG = "CUSTOMER GENERAL";

    private EditText cusName, cusNo, cusNIC, cusDOB, cusHeight, cusWeight, cusDiseaseDiscrip,
            cusOccupation, cusAddress, cusHomeNo, cusMobileNo, cusWorkNo, cusEmail;
    private Spinner cusGender, cusCivilStatus, cusWeightScale, cusHeightScale, cusDiseaseOrNot;
    private Button cusSave;
    private TextView cusShowAge;
    private Calendar myCalendar;
    private Boolean isDisease, isSavedCustemrInfo;

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    // for the preferences
    private PreferencesStore prefStore;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    FragmentManager fragmentManager;

    Long addedRowId = null;

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

        prefStore = new PreferencesStore();
        preferences = getActivity().getSharedPreferences(prefStore.getCusRegPreference(), 0);
        editor = preferences.edit();
        editor.putBoolean(prefStore.getIsCustomerAdded(), false);
        editor.commit();

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
                Button btnPolicy = (Button)getActivity().findViewById(R.id.btnPolicyDetails);
                if(position==1){
                    btnSpouse.setVisibility(View.GONE);
                    btnChild.setVisibility(View.GONE);
                    btnPolicy.setText("2. Policies Details");
                }else{
                    btnChild.setVisibility(View.VISIBLE);
                    btnSpouse.setVisibility(View.VISIBLE);
                    btnPolicy.setText("4. Policies Details");
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
                if (isSavedCustemrInfo) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext());
                    dialog.setTitle("Entry Update Confirmation");
                    dialog.setMessage("Are you sure you want to update current entry?");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new saveClientAsync().execute();
                        }
                    });
                    dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();

                } else {
                    if (isEm(cusName) || isEm(cusNo) || isEm(cusNIC)) {
                        Toast.makeText(getContext(), "Please fill mandatory fields ", Toast.LENGTH_SHORT).show();
                        cusName.setError("");
                        cusNo.setError("");
                        cusNIC.setError("");
                    } else {
                        if (isEm(cusEmail)) {
                            new saveClientAsync().execute();
                        } else {
                            if (!validEmail(cusEmail)) {
                                cusEmail.setError("Please provide valid email");
                            } else {
                                new saveClientAsync().execute();
                            }
                        }
                    }
                }

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

    private boolean isEm(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private void updateStartingDate(EditText editText) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalendar.getTime()));
    }

    public boolean validEmail(EditText email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email.getText().toString().trim());
        return matcher.matches();
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

    public class saveClientAsync extends AsyncTask<String, Void, Long> {

        private Boolean isUpdated = false;

        @Override
        protected void onPostExecute(Long response) {
            super.onPostExecute(response);

            if (isUpdated) {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {

                        Toast.makeText(getActivity(), "Updated...!!", Toast.LENGTH_SHORT).show();
                    }
                });


            } else {
                if (response != null) {
                    Log.d(TAG, "Data was saved, Row id is:" + response);
                    isSavedCustemrInfo = true;

                    editor.putBoolean(prefStore.getIsCustomerAdded(), true);
                    editor.putString(prefStore.getCusNo(), cusNo.getText().toString());
                    editor.putLong(prefStore.getNewCusAddedRow(), response);

                    editor.commit();

                    try {
                        if (cusCivilStatus.getSelectedItem().toString().equals("Single")) {
                            Frag_client_reg_policy policy = new Frag_client_reg_policy();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragmentContainer, policy);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        } else {
                            Frag_client_reg_spouse spouse = new Frag_client_reg_spouse();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragmentContainer, spouse);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }

                    } catch (Exception ex) {
                    }

                } else {
                    Log.e(TAG, "Error saving data into db");
                }
            }

        }

        @Override
        protected Long doInBackground(String... strings) {
            Long rowId = null;

            ContentValues values = new ContentValues();
            Customer customer = new Customer();
            DbActivites dbActivites = DbActivites.getInstance(getActivity());

            values.put(customer.getcName(), cusName.getText().toString());
            values.put(customer.getcCustomerNumber(), cusNo.getText().toString());
            values.put(customer.getcNIC(), cusNIC.getText().toString());
            values.put(customer.getcDOB(), cusDOB.getText().toString());
            values.put(customer.getcGender(), cusGender.getSelectedItem().toString());
            values.put(customer.getcCivic(), cusCivilStatus.getSelectedItem().toString());
            values.put(customer.getcHeight(), cusHeight.getText().toString() + cusHeightScale.getSelectedItem().toString());
            values.put(customer.getcWeight(), cusWeight.getText().toString() + cusWeightScale.getSelectedItem().toString());
            if (isDisease) {
                values.put(customer.getcAnyDisease(), cusDiseaseDiscrip.getText().toString());
            }
            values.put(customer.getcOccupation(), cusOccupation.getText().toString());
            values.put(customer.getcAddress(), cusAddress.getText().toString());
            values.put(customer.getcAddressLanLong(), "88.88888, 100.0000");
            values.put(customer.getcContactHome(), cusHomeNo.getText().toString());
            values.put(customer.getcContactMobile(), cusMobileNo.getText().toString());
            values.put(customer.getcContactWork(), cusWorkNo.getText().toString());
            values.put(customer.getcEmail(), cusEmail.getText().toString());



            if (preferences.getBoolean(prefStore.getIsCustomerAdded(), false)) {
                isUpdated = dbActivites.updateIntoDB(values, preferences.getLong(prefStore.getNewCusAddedRow(),0), "CUSTOMER");
            } else {
                rowId = dbActivites.saveIntoDB(values, "CUSTOMER");
                addedRowId = rowId;
            }

            return rowId;
        }
    }

    private void clearFields() {
        cusName.setText("");
        cusNo.setText("");
        cusNIC.setText("");
        cusDOB.setText("");
        cusHeight.setText("");
        cusWeight.setText("");
        cusDiseaseDiscrip.setText("");
        cusOccupation.setText("");
        cusAddress.setText("");
        cusHomeNo.setText("");
        cusMobileNo.setText("");
        cusWorkNo.setText("");
        cusEmail.setText("");
    }
}
