package genesip.com.ej.insuarance_agent_mgt_diary.client;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import genesip.com.ej.insuarance_agent_mgt_diary.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_client_reg_policy extends Fragment {


    public Frag_client_reg_policy() {
        // Required empty public constructor
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_client_reg_policy, container, false);
    }

}
