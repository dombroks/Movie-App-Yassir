package com.younes_belouche.movieappyassir

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MoviesApp : MultiDexApplication() {
}