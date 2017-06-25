package com.example.android.teatimer3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by maksk on 5/28/2017.
 */

public class Tab3 extends Fragment {

    TimePicker alarmPicker;
    AlarmManager alarmManager;
    PendingIntent pending_alarm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);
        alarmPicker = (TimePicker) view.findViewById(R.id.timePicker);
        Switch  alarmSwitch = (Switch) view.findViewById(R.id.switch1);
        alarmSwitch.setOnCheckedChangeListener(new MyListener());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
    }



    Calendar calendar = Calendar.getInstance();

    private class MyListener implements Switch.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                Log.e("alarmCheck", "Alarm On");
               calendar.set(Calendar.HOUR_OF_DAY, alarmPicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmPicker.getCurrentMinute());
                getActivity().sendBroadcast(new Intent("alarm"));
                Intent alarm_intent = new Intent(getActivity(), AlarmReceiver.class);
                pending_alarm = PendingIntent.getBroadcast(getActivity(), 0, alarm_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_alarm);
            } else {
                Log.d("alarmCheck", "Alarm Off");
                alarmManager.cancel(pending_alarm);
            }
        }
    }
}





