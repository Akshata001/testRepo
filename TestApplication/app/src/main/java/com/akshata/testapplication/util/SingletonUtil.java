package com.akshata.testapplication.util;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MR JOSHI on 14-Mar-16.
 */
public class SingletonUtil {
    private static SingletonUtil singletonUtil;

    private String TAG = "SingletonUtil";

    private SingletonUtil() {
    }

    public static SingletonUtil getSingletonConfigInstance() {
        if (singletonUtil == null)
            singletonUtil = new SingletonUtil();
        return singletonUtil;
    }


    /**
     * display message in snackbar
     *
     * @param message Message to show in snackbar
     * @param view    View in which Snackbar is to be shown
     */
    public Snackbar showSnackBar(String message, View view) {

        Snackbar snackbar = null;
        if (view != null) {

            snackbar = Snackbar
                    .make(view, message, Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    });
            // Changing message text color
            snackbar.setActionTextColor(Color.WHITE);
            // Changing action button text color
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        }
        return snackbar;
    }


    /**
     * check if net connection available or not
     *
     * @param mContext
     * @return
     */
    public boolean isConnectedToInternet(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected() == true) {
            return true;
        }
        return false;
    }

    public String setDateTimeFormat(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int selectedDate = 0;
        int selectedYear = 0;
        String month = "";
        Date startDate = null;
        try {
            startDate = df.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            selectedDate = cal.get(Calendar.DAY_OF_MONTH);
            selectedYear = cal.get(Calendar.YEAR);
            month = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat time = new SimpleDateFormat("hh:mm a");
        String dateTime = month + " " + selectedDate + "," + selectedYear + " " + time.format(startDate);
        return dateTime;
    }

}

