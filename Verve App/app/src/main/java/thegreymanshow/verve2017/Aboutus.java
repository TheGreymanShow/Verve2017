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
public class Aboutus extends Fragment {

    ViewPager vitpager;
    private TextView[] dots;
    private LinearLayout dotsLayout;

    public Aboutus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_aboutus, container, false);

        vitpager = (ViewPager) view.findViewById(R.id.viewpager4);
        dotsLayout = (LinearLayout) view.findViewById(R.id.layoutDots);
        VitPagerAdapter adapter3 = new VitPagerAdapter(getActivity());
        vitpager.setAdapter(adapter3);
        vitpager.addOnPageChangeListener(viewListener);
        addBottomDots(0);

        return view;
    }

    private void addBottomDots(int position)
    {
        dots = new TextView[14];
        int colorActive = Color.parseColor("#ffb300");
        int colorInactive = Color.parseColor("#ffffff");
        dotsLayout.removeAllViews();

        for(int i=0;i<14;i++)
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
