package giantbing.zonlinks.com.sendmsg2email;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SendEmailService extends Service {

    public SendEmailService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
