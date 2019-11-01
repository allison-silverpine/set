package com.example.set

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.set.models.Deck
import java.util.*

class MainActivity : AppCompatActivity() {

    private val deck : Deck = Deck()
    private lateinit var card1 : ImageView
    private lateinit var card2 : ImageView
    private lateinit var card3 : ImageView
    private lateinit var yesButton : Button
    private lateinit var noButton : Button
    private val cards = listOf(
        R.drawable.six_hollow_orange_rectangle,
        R.drawable.six_hollow_blue_circle,
        R.drawable.six_hollow_green_diamond,
        R.drawable.three_striped_orange_rectangle,
        R.drawable.three_striped_blue_circle,
        R.drawable.three_striped_green_diamond,
        R.drawable.one_solid_orange_rectangle,
        R.drawable.one_solid_blue_circle,
        R.drawable.one_solid_green_diamond)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBoard()
    }

    private fun initializeBoard()
    {
        val random = Random()
        val first = random.nextInt(cards.size)
        card1 = findViewById(R.id.card1)
        card1.setImageResource(cards[first])
        card1.tag = cardToTag(cards[first])

        val second = random.nextInt(cards.size)
        card2= findViewById(R.id.card2)
        card2.setImageResource(cards[second])
        card2.tag = cardToTag(cards[second])

        val third = random.nextInt(cards.size)
        card3 = findViewById(R.id.card3)
        card3.setImageResource(cards[third])
        card3.tag = cardToTag(cards[third])

        yesButton = findViewById(R.id.set_button)
        yesButton.setOnClickListener{ yesButton() }
        noButton = findViewById(R.id.not_set_button)
        noButton.setOnClickListener{ noButton() }

        val resultText : TextView = findViewById(R.id.set_result)
        val testDeck = deck.drawCards()
        if (testDeck.isNotEmpty()){
            resultText.text = testDeck.joinToString(";")
        }
        else{
            resultText.text = "No more cards left!"
        }
    }

    private fun yesButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(isSet(card1.tag.toString(), card2.tag.toString(), card3.tag.toString()))
        {
            resultText.text = "Correct!"
            initializeBoard()
        }
        else resultText.text = "Nope, is not a set"
    }

    private fun noButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(!isSet(card1.tag.toString(), card2.tag.toString(), card3.tag.toString()))
        {
            resultText.text = "Correct -- not a set"
            initializeBoard()
        }
        else resultText.text = "Actually, it's a set"
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

    private fun cardToTag(resource : Int) : String
    {
        when(resource){
            R.drawable.one_solid_orange_rectangle      -> return "one_solid_orange_rectangle"
            R.drawable.one_solid_blue_circle           -> return "one_solid_blue_circle"
            R.drawable.one_solid_green_diamond         -> return "one_solid_green_diamond"
            R.drawable.three_striped_orange_rectangle  -> return "three_striped_orange_rectangle"
            R.drawable.three_striped_blue_circle       -> return "three_striped_blue_circle"
            R.drawable.three_striped_green_diamond     -> return "three_striped_green_diamond"
            R.drawable.six_hollow_orange_rectangle     -> return "six_hollow_orange_rectangle"
            R.drawable.six_hollow_blue_circle          -> return "six_hollow_blue_circle"
            R.drawable.six_hollow_green_diamond        -> return "six_hollow_green_diamond"
        }
        return "empty_empty_empty_empty"
    }


}
