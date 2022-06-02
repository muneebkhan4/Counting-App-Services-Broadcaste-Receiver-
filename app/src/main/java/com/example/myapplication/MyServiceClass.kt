package com.example.myapplication

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyServiceClass: Service() {

    private var player: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //getting systems default ringtone
        player = MediaPlayer.create(applicationContext, R.raw.gta)
        //setting loop play to true, this will make the ringtone continuously playing
        player!!.isLooping = true
        //staring the player
        player!!.start()
        //Some options for service, start sticky means service will be explicitly started and stopped
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player!!.stop()
    }

}