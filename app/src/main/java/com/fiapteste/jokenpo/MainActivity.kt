package com.fiapteste.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btNewGame.setOnClickListener {
            val intent = Intent(this@MainActivity, ChooseActivity::class.java)
            startActivity(intent)
        }
    }
}
