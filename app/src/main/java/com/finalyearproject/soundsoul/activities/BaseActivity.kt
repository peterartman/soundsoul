package com.finalyearproject.soundsoul.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.finalyearproject.soundsoul.SpotifyPlaygroundApplication
import com.finalyearproject.soundsoul.data.Model

abstract class BaseActivity : AppCompatActivity() {
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = (application as SpotifyPlaygroundApplication).model
    }
}
