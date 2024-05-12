package com.example.diceroller

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity()
{
    private lateinit var binding: ActivityMainBinding
    private var randomInt = 0
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            diceImage = diceImg
            rollBtn.text = "roll Dice"
            rollBtn.setOnClickListener{
                rollDice()
            }
        }
    }

    private fun rollDice() {
        // we add + 1 to avoid falling in number 0
        randomInt = Random.nextInt(6) + 1
        val imageResource = when(randomInt)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imageResource)
    }
}

