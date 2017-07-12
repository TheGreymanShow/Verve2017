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

public class Technical extends AppCompatActivity {

    private Toolbar toolbar;
    FragmentTransaction manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);

        int orange = ContextCompat.getColor(this, R.color.orange);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitleTextColor(orange);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Technical Events");
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

            String shareBody = "Hey there! Interested in Technology ? are you a geek too ? Look what i found ! have a look at the amazing Technical events that Verve 2017 has to offer.Check them out here. http://verve2017.org/events.php#performing-arts or browse through them on the android app on the playstore from here https://play.google.com/store/apps/details?id=thegreymanshow.verve2017";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Verve 2017");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent,"Verve: Tech Events"));

        }
        if (id == R.id.wheel) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech1());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.hurt) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech2());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.code) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech3());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.lan) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech4());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.robo) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech5());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.glow) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech6());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.tpp) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech7());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.scavenger) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech8());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.lazermaze) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech9());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.startup) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech10());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.geo) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech11());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.touchme) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech12());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.lazertag) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech13());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.circuit) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech14());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.arcade) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech15());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.robosoccer) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new tech16());
            manager.addToBackStack(null);
            manager.commit();
        }

    }

}
