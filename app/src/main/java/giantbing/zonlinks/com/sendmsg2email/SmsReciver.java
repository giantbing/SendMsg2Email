package giantbing.zonlinks.com.sendmsg2email;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import giantbing.zonlinks.com.sendmsg2email.Mail.SendMailUtil;

/**
 * Created by P on 2017/11/20.
 */

public class SmsReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage msg = null;
        if (null != bundle) {
            Object[] smsObj = (Object[]) bundle.get("pdus");
            for (Object object : smsObj) {
                msg = SmsMessage.createFromPdu((byte[]) object);
                Date date = new Date(msg.getTimestampMillis());//时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String receiveTime = format.format(date);


                SendMailUtil.send("noreply<短信服务>", "发件人：" + msg.getOriginatingAddress() + "\n"
                        + "时间：" + receiveTime + "\n" + "内容：" + msg.getDisplayMessageBody());
            }
        }

    }
}