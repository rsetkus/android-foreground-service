package lt.setkus.foregroundservice;

import android.app.Notification;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String NOTIFICATION_CHANNEL_ID = "long_running_service_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LongRunningService.class);
        intent.putExtra(LongRunningService.NOTIFICATION, buildNotification());
        startService(intent);
    }

    private Notification buildNotification() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificationBuilder
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.foreground_service_title))
            .setContentText(getString(R.string.foreground_service_message))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return notificationBuilder.build();
    }
}
