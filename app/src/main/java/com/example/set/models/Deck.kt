package com.example.set.models


class Deck{
    lateinit var deck : MutableList<String>
        private set

    init{ createDeck() }

    private fun createDeck() {
        deck = mutableListOf()
        val numbers = listOf("one", "three", "six")
        val patterns = listOf("solid", "hollow", "striped")
        val colors = listOf("orange", "blue", "green")
        val shapes = listOf("circle", "diamond", "rectangle")

        for (number in numbers){
            for (pattern in patterns){
                for (color in colors){
                    for (shape in shapes){
                        deck.add(listOf(number, pattern, color, shape).joinToString("_"))
                    }
                }
            }
        }
        deck.shuffle()
    }

    fun drawCards() : List<String>{
        if ( deck.size == 0) return listOf()
        val card1 = deck.removeAt(deck.size-1)
        val card2 = deck.removeAt(deck.size-1)
        val card3 = deck.removeAt(deck.size-1)
        return listOf(card1, card2, card3)
    }
}