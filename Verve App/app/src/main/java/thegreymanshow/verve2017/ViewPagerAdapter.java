package thegreymanshow.verve2017;

/**
 * Created by akshay dangare on 1/10/2017.
 */


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();
    android.support.v7.widget.Toolbar toolbar;

    int[] icons = new int[]{R.drawable.ic_home2,R.drawable.ic_events2,R.drawable.ic_show2,R.drawable.c,R.drawable.ic_contactus2};
    int[] iconsSelected = new int[]{R.drawable.ic_home,R.drawable.ic_events,R.drawable.ic_show,R.drawable.c2,R.drawable.ic_contactus};
    Context context;
    TabLayout tabLayout;
    ViewPager viewPager;

    public ViewPagerAdapter(Context context, FragmentManager fm, TabLayout tabLayout, ViewPager viewPager, android.support.v7.widget.Toolbar toolbar) {
        super(fm);
        this.context = context;
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
        this.toolbar = toolbar;
        this.viewPager.addOnPageChangeListener(this);

    }

    public void setTabIcons() {



        for(int i = 0; i < icons.length; i++) {
            if(i == 0) {
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).setIcon(iconsSelected[i]);
            }
            else {
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).setIcon(icons[i]);
            }
        }
    }

    void addFragment(Fragment fragment,String string){
        this.fragments.add(fragment);
        this.strings.add(string);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < fragments.size(); i++) {
            if(i == position) {
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).setIcon(iconsSelected[i]);
                toolbar.setTitle(strings.get(i));
            }
            else {
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).setIcon(icons[i]);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
