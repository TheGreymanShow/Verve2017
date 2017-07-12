package thegreymanshow.verve2017;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by akshay dangare on 1/23/2017.
 */

public class AppRater {

    private final static String APP_TITLE = "Verve17";
    private final static String APP_PACKAGE_NAME = "thegreymanshow.verve2017";

    private final static int DAYS_UNTIL_PROMPT = 1;
    private final static int LAUNCH_UNTIL_PROMPT = 3;

    public static void app_launched(Context context){
        SharedPreferences prefs = context.getSharedPreferences("rate_app",0);
        if(prefs.getBoolean("dontshowagain",false)) {
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();

        long launch_count = prefs.getLong("launch_count",0) + 1;
        editor.putLong("launch_count",launch_count);

        long date_first_launch = prefs.getLong("date_first_launch",0);
        if(date_first_launch == 0)
        {
            date_first_launch = System.currentTimeMillis();
            editor.putLong("date_first_launch",date_first_launch);
        }

        if(launch_count > LAUNCH_UNTIL_PROMPT)
        {
            if(System.currentTimeMillis() > date_first_launch + (DAYS_UNTIL_PROMPT*24*60*60*1000))
            {
                showRateDialog(context,editor);
            }

        }
        editor.commit();
    }

    private static void showRateDialog(final Context context,final SharedPreferences.Editor editor) {

        Dialog dialog = new Dialog(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        String message = "If you loved the Greymans work, please take a moment to rate your friendly Neighbourhood Greyman. Thank you for your Support.";

        builder.setTitle("Verve 17");
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setCancelable(false);

        builder.setPositiveButton("Rate Now",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.putBoolean("dontshowagain",true);
                editor.commit();

                try {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id="+APP_PACKAGE_NAME)));
                }
                catch (ActivityNotFoundException e){
                    Toast.makeText(context,"Thank you for support !",Toast.LENGTH_SHORT);
                }
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Later",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"Sure ! Thank you.",Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No, Thanks",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(editor != null)
                {
                    editor.putBoolean("dontshowagain",true);
                    editor.commit();
                }
                Toast.makeText(context,"No Problem !",Toast.LENGTH_SHORT);
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.show();
    }


}
