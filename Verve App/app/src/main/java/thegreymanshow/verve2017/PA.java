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

public class PA extends AppCompatActivity {

    private Toolbar toolbar;
    FragmentTransaction manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p);

        int orange = ContextCompat.getColor(this, R.color.orange);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitleTextColor(orange);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Performing Arts");
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

            String shareBody = "Hey there! Love setting the stage on fire ?? can you entertain the audience with your moves ?? Look what i found ! have a look at the amazing Performing Arts that Verve 2017 has to offer.Check them out here. http://verve2017.org/events.php#performing-arts or browse through them on the android app on the playstore from here https://play.google.com/store/apps/details?id=thegreymanshow.verve2017";
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Verve 2017");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent,"Verve: Performing Arts"));

        }
        else if (id == R.id.dance) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa1());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.vogue) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa2());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.redhun) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa3());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.spotlight) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa4());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.streets) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa5());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.vogue2) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa6());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.vogue3) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa7());
            manager.addToBackStack(null);
            manager.commit();
        } else if (id == R.id.mrmrsvit) {
            manager = getSupportFragmentManager().beginTransaction();
            manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            manager.add(R.id.eventsframe, new pa8());
            manager.addToBackStack(null);
            manager.commit();
        }
    }

}
