package thegreymanshow.verve2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    FragmentTransaction manager;
    TabLayout mtablayout;
    ViewPager mviewpager;
    private FloatingActionButton fab;
    ArrayList<Fragment> fragments= new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppRater.app_launched(this);

        int orange = ContextCompat.getColor(this,R.color.orange);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitleTextColor(orange);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Verve");

        mtablayout = (TabLayout) findViewById(R.id.tablayout);
        mviewpager = (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this,getSupportFragmentManager(),mtablayout,mviewpager,toolbar);

        adapter.addFragment(new Home(),"Verve");
        adapter.addFragment(new Events(),"Events");
        adapter.addFragment(new Showcase(),"Showcase");
        adapter.addFragment(new Aboutus(),"About us");
        adapter.addFragment(new ContactUs(),"Contact us");

        mviewpager.setAdapter(adapter);
        mviewpager.setOffscreenPageLimit(2);
        mtablayout.setupWithViewPager(mviewpager);
        adapter.setTabIcons();

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.share)
        {
            String shareBody = "Hey there ! The most happenning festival in the city - Verve, has arrived.To explore it, visit http://verve2017.org/ and download the Android App here https://play.google.com/store/apps/details?id=thegreymanshow.verve2017";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Verve 2017");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent,"Verve 2017"));
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view)
    {
        int id = view.getId();

        if(id == R.id.technical)
        {
            Intent intent = new Intent(getApplicationContext(),Technical.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.PA)
        {
            Intent intent = new Intent(getApplicationContext(),PA.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.sports)
        {
            Intent intent = new Intent(getApplicationContext(),Sports.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.lit)
        {
            Intent intent = new Intent(getApplicationContext(),LIT.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.fine)
        {
            Intent intent = new Intent(getApplicationContext(),FA.class);
            startActivity(intent);
            finish();
        }
        else if(id == R.id.website)
        {
            String url = "http://www.verve2017.org";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
        else if(id == R.id.facebook)
        {
            String url = "http://www.facebook.com/vervethefest";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
        else if(id == R.id.youtube)
        {
            String url = "https://www.youtube.com/results?search_query=vit+student+council";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
        else if(id == R.id.insta)
        {
            String url = "http://www.instagram.com/verve.vit";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }


    }

}

