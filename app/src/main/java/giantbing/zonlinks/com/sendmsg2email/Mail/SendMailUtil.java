package giantbing.zonlinks.com.sendmsg2email.Mail;

/**
 * Created by P on 2017/11/20.
 */

import android.support.annotation.NonNull;

import java.io.File;

/**
 * Created by Administrator on 2017/4/10.
 */

public class SendMailUtil {
    //qq
    private static final String HOST = "smtp.qq.com";
    private static final String PORT = "587";
    private static final String FROM_ADD = "**"; //发送方邮箱
    private static final String FROM_PSW = "**";//发送方邮箱授权码
    private static final String TO_ADD = "**";
//    //163
//    private static final String HOST = "smtp.163.com";
//    private static final String PORT = "465"; //或者465  994
//    private static final String FROM_ADD = "teprinciple@163.com";
//    private static final String FROM_PSW = "teprinciple163";
////    private static final String TO_ADD = "2584770373@qq.com";

    public static void send(final File file, String title,String content) {
        final MailInfo mailInfo = creatMail(title,content);
        final MailSender sms = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendFileMail(mailInfo, file);
            }
        }).start();
    }

    public static void send(String title,String content) {
        final MailInfo mailInfo = creatMail(title,content);
        final MailSender sms = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendTextMail(mailInfo);
            }
        }).start();
    }

    @NonNull
    private static MailInfo creatMail(String title,String content) {
        final MailInfo mailInfo = new MailInfo();
        mailInfo.setMailServerHost(HOST);
        mailInfo.setMailServerPort(PORT);
        mailInfo.setValidate(true);
        mailInfo.setUserName(FROM_ADD); // 你的邮箱地址
        mailInfo.setPassword(FROM_PSW);// 您的邮箱密码
        mailInfo.setFromAddress(FROM_ADD); // 发送的邮箱
        mailInfo.setToAddress(TO_ADD); // 发到哪个邮件去
        mailInfo.setSubject(title); // 邮件主题
        mailInfo.setContent(content); // 邮件文本
        return mailInfo;
    }
}

