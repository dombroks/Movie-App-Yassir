package com.younes_belouche.movieappyassir.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.younes_belouche.movieappyassir.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}