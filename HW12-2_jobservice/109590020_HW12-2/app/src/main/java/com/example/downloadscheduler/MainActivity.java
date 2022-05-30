package com.example.downloadscheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();



        final Button downloadButton = findViewById(R.id.download_b);
        downloadButton.setOnClickListener(view -> {
            DownloadJob();
            sendNotification();
        });
    }

    private void createNotificationChannel() {
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("channel", getResources().getString(R.string.channel_name), NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Downloading task running notification");
            manager.createNotificationChannel(notificationChannel);
        }
    }

    public void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel")
                .setContentTitle("Performing Work")
                .setContentText("Downloading in progress")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_adb)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);
        manager.notify(0, builder.build());
    }

    public void DownloadJob() {
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), DownloadJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(0, componentName);
        builder.setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setPeriodic(TimeUnit.DAYS.toMillis(1));
        if (Build.VERSION.SDK_INT > 23) {
            builder.setPeriodic(TimeUnit.DAYS.toMillis(1), TimeUnit.MINUTES.toMillis(0));
        }
        JobInfo jobInfo = builder.build();
        if (scheduler != null) {
            scheduler.schedule(jobInfo);
        }
    }

    public class DownloadJobService extends JobService {
        @Override
        public boolean onStartJob(JobParameters params) {
            sendNotification();
            return true;
        }

        @Override
        public boolean onStopJob(JobParameters params) {
            return false;
        }
    }
}