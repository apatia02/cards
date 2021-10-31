class Album(val name: String, var albumReleaseYear: Int) {
    val listDecks = mutableListOf<Deck>()

    fun transportCards() {
        println("Enter name of initial deck")
        val initialDeck = readLine().toString()
        println("Enter name of finish deck")
        val finishDeck = readLine().toString()
        println("Enter name of card")
        val nameCard = readLine()
        listDecks.forEach { it ->
            if (it.name == initialDeck) {
                for (i in 0 until it.listCards.size) {
                    if (it.listCards[i].name == nameCard) {
                        it.listCards[i].deckName = finishDeck
                        listDecks.forEach {
                            if (it.name == finishDeck) it.listCards.add(it.listCards[i])
                        }
                        it.listCards.remove(it.listCards[i])
                    }
                }
            }
        }
    }

    fun deleteDeck() {
        println("Enter name of deck which you want delete")
        var count = 0
        val nameDeck = readLine().toString()
        for (i in 0..listDecks.size) {
            if (listDecks[i].name == nameDeck) {
                listDecks.remove(listDecks[i])
                count = 1
            }
        }
        if (count == 1) println("The deck was successfully deleted")
        else println("A deck with this name does not exist")
    }

    fun addDeck(nameAlbum: String) {
        var count = 0
        println("Enter name of deck")
        val deck = Deck(
            name = readLine().toString(),
            albumName = nameAlbum
        )
        listDecks.forEach { if (it.name == deck.name) count = 1 }
        if (count == 1) println("A deck with this name already exists")
        else {
            listDecks.add(deck)
        }
    }
}