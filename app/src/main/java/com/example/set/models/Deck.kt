package com.example.set.models

import java.util.*


class Deck(seed: Long?){
    lateinit var cards : MutableList<String>
        private set

    init{ createDeck(seed) }

    private fun createDeck(seed: Long?) {
        cards = mutableListOf()
        val numbers = listOf("one", "three", "six")
        val patterns = listOf("solid", "hollow", "striped")
        val colors = listOf("orange", "blue", "green")
        val shapes = listOf("circle", "diamond", "rectangle")

        for (number in numbers){
            for (pattern in patterns){
                for (color in colors){
                    for (shape in shapes){
                        cards.add(listOf(number, pattern, color, shape).joinToString("_"))
                    }
                }
            }
        }
        shuffleDeck(seed)
    }

    fun shuffleDeck(seed: Long?)
    {
        val r = if (seed == null) Random() else Random(seed)
        for (i in cards.size-1 downTo 0){
            val j = r.nextInt(i+1)
            val tempCard = cards[i]
            cards[i] = cards[j]
            cards[j] = tempCard
        }
    }

    fun drawCards() : List<String>{
        if ( cards.size == 0) return listOf()
        val card1 = cards.removeAt(cards.size-1)
        val card2 = cards.removeAt(cards.size-1)
        val card3 = cards.removeAt(cards.size-1)
        return listOf(card1, card2, card3)
    }
}