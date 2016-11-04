package supcom.projetdevmob.com.collegementor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TabFragmentTwo extends Fragment {


    private static final String ARG_EXAMPLE = "this_is_a_constant";
    private String example_data;

    public TabFragmentTwo() {

    }

    public static TabFragmentTwo newInstance(int page, String title) {
        TabFragmentTwo tabFragmentTwo = new TabFragmentTwo();
       /* Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argmument);
        TabFragmentTwo.setArguments(args);
        return TabFragmentTwo;*/


        return tabFragmentTwo;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //example_data = getArguments().getString(ARG_EXAMPLE);
       // Log.i("Fragment created with ", example_data);
    }

    private Spinner spinner1, spinner2;
    String job ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_tab_fragment_two, container, false);
        spinner1 = (Spinner)rootview.findViewById(R.id.spinner1) ;

        List<String> categories = new ArrayList<String>();

        categories.add("Select your job ");
        categories.add("Pupil");
        categories.add("Student");
        categories.add("Engineer");
        categories.add("Technician");
        categories.add("searching for a job");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(rootview.getContext(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                job = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootview ;

    }

}
