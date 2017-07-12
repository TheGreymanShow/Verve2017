package thegreymanshow.verve2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



public class Register extends AppCompatActivity {

    Spinner spinner;
    Button fab;
    EditText name;
    EditText email;
    EditText phone;
    EditText college;
    EditText amba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.events,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        final String event = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        name = (EditText) findViewById(R.id.field1);
        email = (EditText) findViewById(R.id.field2);
        phone = (EditText) findViewById(R.id.field3);
        college = (EditText) findViewById(R.id.field4);
        amba = (EditText) findViewById(R.id.field5);


        fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask = new BackgroundTask(Register.this);
                backgroundTask.execute("register","",event,name.getText().toString(),email.getText().toString(),phone.getText().toString(),college.getText().toString(),amba.getText().toString(),"0","Hold");
            /*name.getText().toString(),email.getText().toString(s),phone.getText().toString(),college.getText().toString(),amba.getText().toString()*/
            }
        });

    }


}
