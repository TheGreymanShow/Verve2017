package thegreymanshow.verve2017;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Showcase extends Fragment {

    ViewPager quotespager;


    public Showcase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_showcase, container, false);

        quotespager = (ViewPager) view.findViewById(R.id.viewpager3);
        QuotesPager adapter2 = new QuotesPager(getActivity());
        quotespager.setAdapter(adapter2);

        return view;
    }

}
