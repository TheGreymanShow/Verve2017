package thegreymanshow.verve2017;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Sports extends AppCompatActivity {

    private Toolbar toolbar;
    FragmentTransaction manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        int orange = ContextCompat.getColor(this, R.color.orange);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitleTextColor(orange);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sports Mania");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {


        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            boolean done = getSupportFragmentManager().popBackStackImmediate();
        }
        else{
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == android.R.id.home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.reg) {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        } else if (id == R.id.share) {

            String shareBody = "Hey there! Are you a Sports Freak too ?? have what it takes to show it on the field ? Look what i found ! have a look at the amazing Sports extravaganza that Verve 2017 has to offer.Check them out here. http://verve2017.org/events.php#performing-arts or browse through them on the android app on the playstore from here https://play.google.com/store/apps/details?id=thegreymanshow.verve2017";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Verve 2017");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent,"Verve: Sports Mania"));

        }
        else if(id == R.id.longer) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports1());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.alley) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports2());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.smash) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports3());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.tt) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports12());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.s6) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports4());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.cage) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports5());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.pro) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports6());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.box) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports7());
            manager.addToBackStack(null);
            manager.commit();
        }
        else if (id == R.id.chess) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports8());
            manager.addToBackStack(null);
            manager.commit();
        }
        else if (id == R.id.min) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports9());
            manager.addToBackStack(null);
            manager.commit();
        }
        else if (id == R.id.carrom) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports11());
            manager.addToBackStack(null);
            manager.commit();
        }
        else if (id == R.id.throwb) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new sports10());
            manager.addToBackStack(null);
            manager.commit();
        }
    }

}
