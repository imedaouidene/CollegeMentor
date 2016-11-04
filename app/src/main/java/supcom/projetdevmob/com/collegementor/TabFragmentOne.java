package supcom.projetdevmob.com.collegementor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragmentOne extends Fragment {


    private static final String ARG_EXAMPLE = "this_is_a_constant";
    private String example_data;

    public TabFragmentOne() {

    }

    public static TabFragmentOne newInstance(int page, String title) {
        TabFragmentOne tabFragmentOne = new TabFragmentOne();
       /* Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argmument);
        tabFragmentOne.setArguments(args);
        return tabFragmentOne;*/

        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        tabFragmentOne.setArguments(args);
        return tabFragmentOne;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        example_data = getArguments().getString(ARG_EXAMPLE);
//        Log.i("Fragment created with ", example_data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment1, container, false);

    }

}
