package com.fiapteste.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val choose = intent.extras?.get("choose") as OptionsEnum
        val chooseImage = when (choose) {
            OptionsEnum.ROCK -> R.drawable.pedra
            OptionsEnum.PAPER -> R.drawable.papel
            OptionsEnum.SCISSORS -> R.drawable.tesoura
        }
        ivYou.setImageResource(chooseImage)

        val machineResult = OptionsEnum.values().random()

        val machineImage = when (machineResult) {
            OptionsEnum.ROCK -> R.drawable.pedra
            OptionsEnum.PAPER -> R.drawable.papel
            OptionsEnum.SCISSORS -> R.drawable.tesoura
        }
        ivMachine.setImageResource(machineImage)

        val result = calculateResult(choose, machineResult)

        tvResult.text = when (result) {
            ResultEnum.LOSE -> getString(R.string.text_lose)
            ResultEnum.DRAW -> getString(R.string.text_draw)
            ResultEnum.VICTORY -> getString(R.string.text_victory)
        }

        btPlayAgain.setOnClickListener {
            finish()
        }
    }



    private fun calculateResult(you: OptionsEnum, machine: OptionsEnum) : ResultEnum {

        if (you == machine) {
            return ResultEnum.DRAW
        }

        when (you) {
            OptionsEnum.ROCK -> {
                return if (machine == OptionsEnum.PAPER) {
                    ResultEnum.LOSE
                } else {
                    ResultEnum.VICTORY
                }
            }
            OptionsEnum.PAPER -> {
                return if (machine == OptionsEnum.SCISSORS) {
                    ResultEnum.LOSE
                } else {
                    ResultEnum.VICTORY
                }
            }
            OptionsEnum.SCISSORS -> {
                return if (machine == OptionsEnum.ROCK) {
                    ResultEnum.LOSE
                } else {
                    ResultEnum.VICTORY
                }
            }
        }

    }

}
