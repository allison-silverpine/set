package com.example.set

import android.graphics.Color
import com.daimajia.androidanimations.library.YoYo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.*
import com.daimajia.androidanimations.library.Techniques
import com.example.set.models.Game
import com.example.set.models.Mapper

class MainActivity : AppCompatActivity() {

    private val tempSeed : Long? = 123457
    private var game = Game(tempSeed)
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
    private lateinit var card13 : ImageView
    private lateinit var card14 : ImageView
    private lateinit var card15 : ImageView
    private lateinit var newGameButton : Button
    private lateinit var hintButton : Button
    private lateinit var chronometer : Chronometer
    private var images= arrayListOf<ImageView>()
    private var cardIds = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seedValue : TextView = findViewById(R.id.seed)
        seedValue.text = if (tempSeed == null) "" else getString(R.string.seed_value, tempSeed)
        newGameButton = findViewById(R.id.new_button)
        newGameButton.setOnClickListener { createNewGame() }
        hintButton = findViewById(R.id.hint_button)
        hintButton.setOnClickListener { showHint() }
        initializeBoard()
    }

    private fun initializeBoard()
    {
        cardIds= arrayListOf(R.id.card1, R.id.card2, R.id.card3, R.id.card4, R.id.card5, R.id.card6, R.id.card7, R.id.card8, R.id.card9, R.id.card10, R.id.card11, R.id.card12, R.id.card13, R.id.card14, R.id.card15)
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
        card13 = findViewById(cardIds[12])
        card14 = findViewById(cardIds[13])
        card15 = findViewById(cardIds[14])
        images= arrayListOf(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15)

        for (i in 0 until images.size){
            images[i].setOnClickListener{
                if (!game.gameWon && images[i].tag.toString() != "empty") {
                    if (selectedCards.size < 3) {
                        if (selectedCards.contains(it.tag.toString())) {
                            selectedCards.remove(it.tag.toString())
                            images[i].setColorFilter(Color.argb(0, 0, 0, 0))
                        } else {
                            images[i].setColorFilter(Color.argb(50,0,0,0))
                            selectedCards.add(it.tag.toString())
                            if (selectedCards.size == 3) {
                                Handler().postDelayed({validateCards()},700)
                            }
                        }
                    }
                }
            }
        }
        setCardImages()
        setCardCount()
        chronometer = findViewById(R.id.chronometer)
        chronometer.start()
    }


    private fun setCardImages() {
        val boardSize = game.board.size
        var i = 0
        var j = 0
        while (i < images.size){
            val card : ImageView = findViewById(cardIds[i])
            card.setColorFilter(Color.argb(0,0,0,0))
            if (j < boardSize){
                card.setImageResource(mapper.tagToResource.getValue(game.board[i]))
                card.visibility = View.VISIBLE
                card.tag = game.board[i]
                j += 1
            }
            else{
                card.setImageResource(mapper.tagToResource.getValue("empty"))
                card.visibility = View.GONE
                card.tag = "empty"
            }
            images[i] = card
            i += 1
        }
    }

    private fun setCardCount()
    {
        val cardsRemaining : TextView = findViewById(R.id.cards_remaining)
        val cardCount = game.deck.cards.size + game.board.size
        cardsRemaining.text = getString(R.string.card_count, cardCount)
    }

    private fun validateCards()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        if(game.makeGuess(selectedCards[0], selectedCards[1], selectedCards[2]))
        {
            setCardCount()
            if(game.gameWon) {
                resultText.text = getString(R.string.win_text)
                chronometer.stop()
            }
        }
        else{
            Toast.makeText(this, "Nope, not a set", Toast.LENGTH_SHORT).show()
        }

        selectedCards = mutableListOf()
        setCardImages()
    }

    private fun createNewGame()
    {
        val resultText : TextView = findViewById(R.id.set_result)
        resultText.text = ""
        game = Game(tempSeed)
        setCardImages()
        setCardCount()
        chronometer.stop()
        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.start()
    }

    private fun showHint(){
        val set = game.findSet()
        if (set.isEmpty())
            Toast.makeText(this, "There is no set present!", Toast.LENGTH_SHORT).show()
        else{
            images.forEach {
                if (it.tag.toString() == set[0] || it.tag.toString() == set[1]){
                    YoYo.with(Techniques.Shake).duration(500).playOn(it)
                }
            }
        }
    }
}
