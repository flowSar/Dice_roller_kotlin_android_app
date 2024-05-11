package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.random.Random

class MainActivity : ComponentActivity()
{
    private var randomInt = 0
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById<ImageView>(R.id.dice_img)
        val roll_button: Button = findViewById<Button>(R.id.roll_btn)
        roll_button.text = "roll Dice"
        roll_button.setOnClickListener {
            rollDice()
            Toast.makeText(this, "${randomInt}", Toast.LENGTH_SHORT).show()
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

