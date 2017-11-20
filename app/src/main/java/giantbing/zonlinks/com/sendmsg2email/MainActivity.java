package giantbing.zonlinks.com.sendmsg2email;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

import giantbing.zonlinks.com.sendmsg2email.Mail.SendMailUtil;
import giantbing.zonlinks.com.sendmsg2email.Util.Permission.PermissionReq;
import giantbing.zonlinks.com.sendmsg2email.Util.Permission.PermissionResult;
import giantbing.zonlinks.com.sendmsg2email.Util.Permission.Permissions;

public class MainActivity extends AppCompatActivity {
    private TextView sendtxt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionReq.with(MainActivity.this).permissions(Permissions.SMS).result(new PermissionResult() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied() {
                System.exit(0);
            }
        }).request();
        sendtxt = (TextView)findViewById(R.id.sendtxt);
        sendtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
