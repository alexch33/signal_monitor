package com.i3po.video.signalmonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.telephony.TelephonyManager
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSignalStrength = findViewById<TextView>(R.id.tvSignalStrength)

        val handler = android.os.Handler(Looper.getMainLooper())
        val runnable: Runnable = object : Runnable {
            override fun run() {
                val tm = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
                tvSignalStrength.text = "${tm.signalStrength}"
                handler.postDelayed(this, 200)
            }
        }
        runnable.run()
    }
}