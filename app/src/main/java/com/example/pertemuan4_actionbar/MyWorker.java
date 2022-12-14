package com.example.pertemuan4_actionbar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull
            WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        displayNotification("NOTIFICATION", "YOUR BOOKING PAYMENT WAS ADDED");
        return Result.success();
    }
    public void displayNotification(String task, String desc) {
        NotificationManager manager =
                (NotificationManager)

                        getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new
                NotificationChannel("NOTIFICATION", "YOUR BOOKING PAYMENT WAS ADDED",
                NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new

                NotificationCompat.Builder(getApplicationContext(),
                "NOTIFICATION")
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        manager.notify(1, builder.build());
    }
}


