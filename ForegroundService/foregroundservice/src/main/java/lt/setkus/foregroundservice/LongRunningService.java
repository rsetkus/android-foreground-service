package lt.setkus.foregroundservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class LongRunningService extends Service {

    private static final int LONG_RUNNING_SERVICE_ID = 1;

    public static String NOTIFICATION = "notification_icon";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notification notification = intent.getExtras().getParcelable(NOTIFICATION);
        startForeground(LONG_RUNNING_SERVICE_ID, notification);
        return START_STICKY;
    }
}
