package com.example.set

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.set.models.Board
import com.example.set.models.Deck
import com.example.set.models.Mapper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   // private val deck = Deck()
    private val board = Board()
    private val mapper = Mapper()
    private var selectedCards : MutableList<String> = mutableListOf()
    private lateinit var card1 : ImageView
    private lateinit var card2 : ImageView
    private lateinit var card3 : ImageView
    private lateinit var card4 : ImageView
    private lateinit var card5 : ImageView
    private lateinit var card6 : ImageView
    private lateinit var card7 : ImageView
    private lateinit var card8 : ImageView
    private lateinit var card9 : ImageView
    private lateinit var card10 : ImageView
    private lateinit var card11 : ImageView
    private lateinit var card12 : ImageView
    private var images= arrayListOf<ImageView>()
    private var cardIds = arrayListOf<Int>()
    private lateinit var noButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeBoard()
    }

    private fun initializeBoard()
    {
        cardIds= arrayListOf(R.id.card1, R.id.card2, R.id.card3, R.id.card4, R.id.card5, R.id.card6, R.id.card7, R.id.card8, R.id.card9, R.id.card10, R.id.card11, R.id.card12)
        card1 = findViewById(cardIds[0])
        card2 = findViewById(cardIds[1])
        card3 = findViewById(cardIds[2])
        card4 = findViewById(cardIds[3])
        card5 = findViewById(cardIds[4])
        card6 = findViewById(cardIds[5])
        card7 = findViewById(cardIds[6])
        card8 = findViewById(cardIds[7])
        card9 = findViewById(cardIds[8])
        card10 = findViewById(cardIds[9])
        card11 = findViewById(cardIds[10])
        card12 = findViewById(cardIds[11])
        images= arrayListOf(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12)

        for (i in 0 until images.size){
            images[i].setOnClickListener(cardSelected())
        }
        noButton = findViewById(R.id.not_set_button)
        noButton.setOnClickListener{ noButton() }
        fillBoard()
    }

    private fun fillBoard()
    {
        if (board.deck.cards.isEmpty()){
            val resultText : TextView = findViewById(R.id.set_result)
            resultText.text = "No more cards left!"
        }
        else{
            val tags = board.board
            for (i in 0 until tags.size){
                 images[i] = setCardImages(cardIds[i], tags[i])
            }
        }
    }

    private fun setCardImages(cardId : Int, cardTag: String) : ImageView {
        val card : ImageView = findViewById(cardId)
        card.setImageResource(mapper.tagToResource.getValue(cardTag))
        card.tag = cardTag
        return card
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
            //refillCards()
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
            //refillCards()
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
