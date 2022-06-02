package com.example.myapplication

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmField
        var flag: Boolean = true;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nextActivityButton.setOnClickListener{
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }



        // music start click listener
        start.setOnClickListener {
            if (flag)
            {
                flag =false;
                startService(Intent(this, MyServiceClass::class.java))
                showToast("Background Service Started...")
            }
            else{
                showToast("Background Service Already Started...")
            }
        }
        // music stop click listener
        stop.setOnClickListener {
            flag =true;
            stopService(Intent(this, MyServiceClass::class.java))
            showToast("Background Service Stopped...")
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

