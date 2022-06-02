package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main1.*


class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        nextOne.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // broadcaste receiver battery low
        val intentFilter1 = IntentFilter("android.intent.action.BATTERY_LOW");
        val myReceiver1 = MyBroadcasteReceiver();
        registerReceiver(myReceiver1, intentFilter1);


        // broadcaste receiver charger connected
        val intentFilter2 = IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        val myReceiver2 = MyBroadcasteReceiver2();
        registerReceiver(myReceiver2, intentFilter2);


        // broadcaste receiver charger disconnected
        val intentFilter3 = IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        val myReceiver3 = MyBroadcasteReceiver3();
        registerReceiver(myReceiver3, intentFilter3);
    }

}