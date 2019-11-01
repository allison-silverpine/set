package com.example.set

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var card1 : ImageView
    private lateinit var card2 : ImageView
    private lateinit var card3 : ImageView
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
        val first = random.nextInt(styles.size)
        val second = random.nextInt(styles.size)
        val third = random.nextInt(styles.size)
        card1 = findViewById(R.id.card1)
        card1.setImageResource(R.drawable.six_hollow_orange_rectangle)
        card1.tag = "six_hollow_orange_rectangle"
        //card1.setBackgroundResource(styles[first])
        //card1.tag = styles[first].toString()
        card2= findViewById(R.id.card2)
        card2.setImageResource(R.drawable.one_solid_green_diamond)
        card2.tag = "one_solid_green_diamond"
        //card2.setBackgroundResource(styles[second])
        //card2.tag = styles[second].toString()
        card3 = findViewById(R.id.card3)
        card3.setImageResource(R.drawable.three_striped_blue_circle)
        card3.tag = "three_striped_blue_circle"
        //card3.setBackgroundResource(styles[third])
        //card3.tag = styles[third].toString()

        yesButton = findViewById(R.id.set_button)
        yesButton.setOnClickListener{ yesButton() }
        noButton = findViewById(R.id.not_set_button)
        noButton.setOnClickListener{ noButton() }
    }

    private fun yesButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(isSet(card1.tag.toString(), card2.tag.toString(), card3.tag.toString()))
        {
            resultText.text = "Correct!"
        }
        else resultText.text = "Nope, is not a set"

    }

    private fun noButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(isSet(card1.tag.toString(), card2.tag.toString(), card3.tag.toString()))
        {
            resultText.text = "It's actually a set"
        }
        else resultText.text = "Correct -- not a set"

    }

    private fun isSet(card1: String, card2: String, card3: String) : Boolean
    {
        val card1Attrs = card1.split('_')
        val card2Attrs = card2.split('_')
        val card3Attrs = card3.split('_')
        return validSet(card1Attrs[0], card2Attrs[0], card3Attrs[0]) &&
                validSet(card1Attrs[1], card2Attrs[1], card3Attrs[1]) &&
                validSet(card1Attrs[2], card2Attrs[2], card3Attrs[2]) &&
                validSet(card1Attrs[3], card2Attrs[3], card3Attrs[3])
    }

    private fun validSet(attr1: String, attr2: String, attr3: String) : Boolean
    {
        return (attr1 == attr2 && attr2 == attr3) ||
                (attr1 != attr2 && attr2 != attr3 && attr1 != attr3)
    }


}
