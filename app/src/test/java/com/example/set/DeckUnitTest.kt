package com.example.set

import com.example.set.models.Deck
import org.junit.Test

import org.junit.Assert.*

class DeckTests {

    @Test
    fun uniqueDeck_isCreated() {
        val d = Deck()
        val cardSet : Set<String> = d.cards.toSet()
        assertEquals(81, cardSet.size)
    }

    @Test
    fun firstThreeCards_areRemoved() {
        val deck = Deck()
        val d = deck.cards
        val card1 = d[80]
        val card2 = d[79]
        val card3 = d[78]
        val drawnCards = deck.drawCards()
        assertEquals(3, drawnCards.size)
        assertEquals(card1, drawnCards[0])
        assertEquals(card2, drawnCards[1])
        assertEquals(card3, drawnCards[2])
        assertEquals(78, d.size)
    }

    @Test
    fun lastThreeCards_areRemoved() {
        val deck = Deck()
        val d = deck.cards
        val card3 = d[2]
        val card2 = d[1]
        val card1 = d[0]
        for (i in 1..26){
            deck.drawCards()
        }
        val lastCards = deck.drawCards()
        assertEquals(3, lastCards.size)
        assertEquals(card3, lastCards[0])
        assertEquals(card2, lastCards[1])
        assertEquals(card1, lastCards[2])
        assertEquals(0, d.size)
    }

    @Test
    fun drawFromEmptyDeck_returnsEmpty() {
        val deck = Deck()
        val d = deck.cards
        for (i in 1..27){
            deck.drawCards()
        }
        val lastCards = deck.drawCards()
        assertEquals(0, lastCards.size)
        assertEquals(0, d.size)
    }
}
