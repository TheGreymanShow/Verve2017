package thegreymanshow.verve2017;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    private ViewPager viewPager;
    private TextView[] dots;
    private LinearLayout dotsLayout;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager2);
        dotsLayout = (LinearLayout) view.findViewById(R.id.layoutDots);
        HomeSliderAdapter adapter = new HomeSliderAdapter(getActivity());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(viewListener);
        addBottomDots(0);

        return view;
    }

    private void addBottomDots(int position)
    {
        dots = new TextView[7];
        int colorActive = Color.parseColor("#ffb300");
        int colorInactive = Color.parseColor("#ffffff");
        dotsLayout.removeAllViews();

        for(int i=0;i<7;i++)
        {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length > 0)
            dots[position].setTextColor(colorActive);

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



}
