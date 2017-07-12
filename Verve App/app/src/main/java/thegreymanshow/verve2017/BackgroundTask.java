package thegreymanshow.verve2017;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String,Void,String> {

    String Register_url = "http://www.verve2017.org/registerapp.php";
    Context context;
    Activity activity;
    AlertDialog.Builder builder;
    ProgressDialog progressDialog;
    String msg = "Thank you for Registering in Verve ! You'll be hearing from us soon. Stay Tuned !";
    String msg2 = "Oops ! looks like some server error occured. Try again later. ";

    public BackgroundTask(Context context) {
        this.context = context;
        activity = (Activity) context;
    }

    @Override
    protected void onPreExecute() {
        builder = new AlertDialog.Builder(activity);
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Registering");
        progressDialog.setMessage("Please wait while we render this request");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        if(params[0] == "register") {
            try {
                String id = params[1];
                String event = params[2];
                String name = params[3];
                String email = params[4];
                String phone = params[5];
                String college = params[6];
                String amba = params[7];
                String amount = params[8];
                String status = params[9];


                URL url = new URL(Register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                // send data to the server
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));


                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" +
                        URLEncoder.encode("event", "UTF-8") + "=" + URLEncoder.encode(event, "UTF-8") + "&" +
                        URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("college", "UTF-8") + "=" + URLEncoder.encode(college, "UTF-8") + "&" +
                        URLEncoder.encode("amba", "UTF-8") + "=" + URLEncoder.encode(amba, "UTF-8") + "&" +
                        URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(amount, "UTF-8") + "&" +
                        URLEncoder.encode("status", "UTF-8") + "=" + URLEncoder.encode(status, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                // Capture the response from server
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String stringBuilder="";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder+=line;
                }
                httpURLConnection.disconnect();
                Thread.sleep(2000);
                return stringBuilder;

            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected void  onPostExecute(String json) {

        try {
            progressDialog.dismiss();
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String code1 = JO.getString("code");

            if (code1.equals("Reg_true")) {
                builder.setTitle("Registration Successful");
                builder.setMessage(msg);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        activity.finish();
                    }
                });

                AlertDialog alertDialog1 = builder.create();
                alertDialog1.show();


            } else if (code1.equals("Reg_false")) {
                builder.setTitle("Registration Failed");
                builder.setMessage(msg2);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        activity.finish();
                    }
                });
                AlertDialog alertDialog1 = builder.create();
                alertDialog1.show();

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}

