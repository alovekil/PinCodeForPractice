package com.example.pin_codeforthepractice

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null
    var sharedPreferenceManager: SharedPreferance? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}