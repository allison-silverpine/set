package com.example.set

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var card1 : TextView
    private lateinit var card2 : TextView
    private lateinit var card3 : TextView
    private lateinit var yesButton : Button
    private lateinit var noButton : Button
    private val styles = listOf(R.color.colorBlueBlack, R.color.colorSunflower, R.color.colorGreenery)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBoard()
    }

    private fun initializeBoard()
    {
        val random = Random()
        val first = random.nextInt(styles.size-1) + 1
        val second = random.nextInt(styles.size-1) + 1
        val third = random.nextInt(styles.size-1) + 1
        card1 = findViewById(R.id.card1)
        card1.setBackgroundResource(styles[first])
        card1.tag = styles[first].toString()
        card2= findViewById(R.id.card2)
        card2.setBackgroundResource(styles[second])
        card2.tag = styles[second].toString()
        card3 = findViewById(R.id.card3)
        card3.setBackgroundResource(styles[third])
        card3.tag = styles[third].toString()
        yesButton = findViewById(R.id.set_button)
        yesButton.setOnClickListener{ yesButton() }
        noButton = findViewById(R.id.not_set_button)
        noButton.setOnClickListener{ noButton() }
    }

    private fun yesButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(isSet())
        {
            resultText.text = "Correct!"
        }
        else resultText.text = "Nope, is not a set"

    }

    private fun noButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(isSet())
        {
            resultText.text = "It's actually a set"
        }
        else resultText.text = "Correct -- not a set"

    }

    private fun isSet() : Boolean
    {
        return card1.tag.toString() == card2.tag.toString() && card2.tag.toString() == card3.tag.toString()
    }


}
