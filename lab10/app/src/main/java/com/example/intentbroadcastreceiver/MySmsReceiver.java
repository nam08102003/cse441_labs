package com.example.intentbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        processReceive(context,intent);
    }

    public void processReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String message=""; String body =""; String address=""; if (extras != null)
        {
            Object[] smsEtra = (Object[])extras.get("pdus");
            for (int i =0;i<smsEtra.length;i++)
            {
                SmsMessage sms = SmsMessage.createFromPdu((byte[])smsEtra[i]); body = sms.getMessageBody();

                address = sms.getOriginatingAddress();
                message +="Có 1 tin nhắn từ "+address+"\n"+body+" vừa gởi đến";

            }
            Toast.makeText(context,message,Toast.LENGTH_LONG).show();
        }
    }

}