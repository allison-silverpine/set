package com.example.set

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.set.models.Deck
import com.example.set.models.Mapper

class MainActivity : AppCompatActivity() {

    private val deck : Deck = Deck()
    private val mapper : Mapper = Mapper()
    private var selectedCards : MutableList<String> = mutableListOf()
    private lateinit var card1 : ImageView
    private lateinit var card2 : ImageView
    private lateinit var card3 : ImageView
    private lateinit var yesButton : Button
    private lateinit var noButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBoard()
    }

    private fun initializeBoard()
    {
        card1 = findViewById(R.id.card1)
        card1.setOnClickListener(cardSelected())
        card2 = findViewById(R.id.card2)
        card2.setOnClickListener(cardSelected())
        card3 = findViewById(R.id.card3)
        card3.setOnClickListener(cardSelected())
        noButton = findViewById(R.id.not_set_button)
        noButton.setOnClickListener{ noButton() }
        refillCards()
    }

    private fun refillCards()
    {
        val tags = deck.drawCards()
        if (tags.isEmpty()){
            val resultText : TextView = findViewById(R.id.set_result)
            resultText.text = "No more cards left!"
        }
        else{
            card1 = findViewById(R.id.card1)
            card1.setImageResource(mapper.tagToResource.getValue(tags[0]))
            card1.tag = tags[0]

            card2= findViewById(R.id.card2)
            card2.setImageResource(mapper.tagToResource.getValue(tags[1]))
            card2.tag = tags[1]

            card3 = findViewById(R.id.card3)
            card3.setImageResource(mapper.tagToResource.getValue(tags[2]))
            card3.tag = tags[2]
        }

    }

    private fun cardSelected() : View.OnClickListener
    {
        //TODO: handle de-selecting when board size increased
        val clickListener = View.OnClickListener {view ->
            selectedCards.add(view.tag.toString())
            if(selectedCards.size == 3){
                validateCards()
            }
        }
        return clickListener
    }

    private fun validateCards()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(isSet(selectedCards[0], selectedCards[1], selectedCards[2]))
        {
            resultText.text = "Correct!"
            refillCards()
        }
        else resultText.text = "Nope, is not a set"
        selectedCards = mutableListOf()
    }

    private fun noButton()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(!isSet(card1.tag.toString(), card2.tag.toString(), card3.tag.toString()))
        {
            resultText.text = "Correct -- not a set"
            refillCards()
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



}
