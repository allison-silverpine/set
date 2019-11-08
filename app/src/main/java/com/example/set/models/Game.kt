package com.example.set.models

class Game{
    var deck = Deck()
        private set
    var board: MutableList<String>
        private set
    var gameWon = false

    init {
        board = mutableListOf()
        for (i in 0 until 4){
            board.addAll(deck.drawCards())
        }
        while (!boardContainsSet()){
            deck.cards.addAll(board)
            deck.cards.shuffle()
            board.clear()
            for (i in 0 until 4){
                board.addAll(deck.drawCards())
            }
        }
    }

    fun boardContainsSet() : Boolean {
        for (i in 0 until board.size-2){
            for (j in i+1 until board.size-1){
                for (k in j+1 until board.size){
                    if (isSet(board[i], board[j], board[k]))
                        return true
                }
            }
        }
        return false
    }

    fun isSet(card1: String, card2: String, card3: String) : Boolean
    {
        if (!boardContainsCards(card1, card2, card3)) return false

        val card1Attrs = card1.split('_')
        val card2Attrs = card2.split('_')
        val card3Attrs = card3.split('_')
        return validSet(card1Attrs[0], card2Attrs[0], card3Attrs[0]) &&
                validSet(card1Attrs[1], card2Attrs[1], card3Attrs[1]) &&
                validSet(card1Attrs[2], card2Attrs[2], card3Attrs[2]) &&
                validSet(card1Attrs[3], card2Attrs[3], card3Attrs[3])
    }

    private fun boardContainsCards(card1: String, card2: String, card3: String) : Boolean {
        return board.contains(card1) && board.contains(card2) && board.contains(card3)
    }

    private fun validSet(attr1: String, attr2: String, attr3: String) : Boolean
    {
        return (attr1 == attr2 && attr2 == attr3) ||
                (attr1 != attr2 && attr2 != attr3 && attr1 != attr3)
    }

    fun makeGuess(card1: String, card2: String, card3: String) : Boolean {
        if (gameWon || !isSet(card1, card2, card3)) return false

        val cards = listOf( card1, card2, card3)
        if(deck.cards.isEmpty()){
            cards.forEach { board.remove(it) }
            if (!boardContainsSet())
                gameWon = true
        }
        else{
            updateBoard(cards)
        }
        return true
    }

    private fun updateBoard(cards: List<String>){
        //TODO
    }

}