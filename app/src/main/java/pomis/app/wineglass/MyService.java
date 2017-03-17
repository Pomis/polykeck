package pomis.app.wineglass;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4500);
                    startActivity(new Intent(getApplicationContext(), MatchActivity.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }
}
