package ru.tpu.dataprotection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.tpu.dataprotection.encoder.EncoderFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}