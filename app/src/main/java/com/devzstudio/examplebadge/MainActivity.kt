package com.devzstudio.examplebadge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.devzstudio.superbadge.SuperBadge

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val badge = findViewById<SuperBadge>(R.id.badge);
        badge.setOnBageClickListener {
            Toast.makeText(this@MainActivity,"Badge Clicked",Toast.LENGTH_LONG);
        }
    }
}
