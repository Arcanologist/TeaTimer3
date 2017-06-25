package com.example.android.teatimer3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by maksk on 6/10/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("in reciever","success");
        Toast.makeText(context,"It's tea time",Toast.LENGTH_LONG).show();
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(context, notification);
        r.play();


        //Intent service_intent = new Intent(context, RingtonePlayingService.class);

        //context.startService(service_intent);
    }
}
