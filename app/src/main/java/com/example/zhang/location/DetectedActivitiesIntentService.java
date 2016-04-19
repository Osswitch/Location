package com.example.zhang.location;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.ArrayList;

/**
 * Created by zhang on 17/04/16.
 */
public class DetectedActivitiesIntentService extends IntentService {

    private static final String LOG_TAG = DetectedActivitiesIntentService.class.getSimpleName();

    public DetectedActivitiesIntentService() {
        // Use the tag to name the work thread.
        super(LOG_TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ActivityRecognitionResult activityRecognitionResult = ActivityRecognitionResult.extractResult(intent);

        // Get the list of the probable activities associated with the current state of the
        // device. Each activity is associated with a confidence level, which is an int between
        // 0 and 100.
        ArrayList<DetectedActivity> detectedActivities = (ArrayList) activityRecognitionResult.getProbableActivities();

        Intent localIntent = new Intent(Constants.BROADCAST_ACTION);
        localIntent.putExtra(Constants.ACTIVITY_EXTRA, detectedActivities);

        // Log each activity.
        Log.i(LOG_TAG, "activities detected");

        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    }
}
