package com.fiapteste.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        ivRock.setOnClickListener {
            callResult(OptionsEnum.ROCK)
        }

        ivPaper.setOnClickListener {
            callResult(OptionsEnum.PAPER)
        }

        ivScissors.setOnClickListener {
            callResult(OptionsEnum.SCISSORS)
        }
    }

    private fun callResult(option: OptionsEnum) {
        val intent = Intent(this@ChooseActivity, ResultActivity::class.java)
        intent.putExtra("choose", option)
        startActivity(intent)
    }
}
