fun main() {
    val library = Library()
    work(library)
}

fun work(library: Library) {
    var count = 1
    while (count == 1) {
        println("""Select a function:
        |get information about all cards, decks, and albums - 1
        |add card - 2
        |delete card - 3
        |change card - 4
        |sort cards by attribute - 5
        |add deck - 6
        |delete deck - 7
        |move card - 8
        |add album - 9
        |delete album with content - 10
        |delete album without content - 11
        |move deck - 12
        |show card attributes - 13
        |change album year of release - 14
        |exit - 0
    """.trimMargin())
        when (readLine()?.toIntOrNull() ?: return) {
            1 -> {
                library.listSortAlbums.forEach {
                    println("Name of album: ${it.name}")
                    it.listDecks.forEach { it1 ->
                        println("Name of deck: ${it1.name}")
                        println("Еhe names of the cards in this deck")
                        it1.listCards.forEach { it2 -> println(it2.name) }
                    }
                }
            }
            2 -> addCard(library)
            3 -> deleteCard(library)
            4 -> changeCard(library)
            5 -> sortCards(library)
            6 -> addDeck(library)
            7 -> deleteDeck(library)
            8 -> moveCards(library)
            9 -> library.addAlbum()
            10 -> library.deleteAlbum()
            11 -> library.deleteAlbumWithoutContent()
            12 -> library.transportDecks()
            13 -> showCard(library)
            14 -> library.changeAlbum()
            0 -> count = 0
        }
    }
}

fun addCard(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    println("Which deck?")
    val nameDeck = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum)
            it.listDecks.forEach { it1 ->
                if (it1.name == nameDeck)
                    it1.addCard(nameDeck)
            }
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun deleteCard(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    println("Which deck?")
    val nameDeck = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum)
            it.listDecks.forEach { it1 ->
                if (it1.name == nameDeck)
                    it1.deleteCard()
            }
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun changeCard(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    println("Which deck?")
    val nameDeck = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum)
            it.listDecks.forEach { it1 ->
                if (it1.name == nameDeck)
                    it1.changeCard()
            }
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun sortCards(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    println("Which deck?")
    val nameDeck = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum)
            it.listDecks.forEach { it1 ->
                if (it1.name == nameDeck)
                    it1.sortCards()
            }
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun addDeck(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum) it.addDeck(nameAlbum)
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun deleteDeck(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum) it.deleteDeck()
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun moveCards(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum) it.transportCards()
    }
    library.listSortAlbums = library.listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
}

fun showCard(library: Library) {
    println("In which album?")
    val nameAlbum = readLine().toString()
    println("Which deck?")
    val nameDeck = readLine().toString()
    println("Name of card?")
    val nameCard = readLine().toString()
    library.listAlbums.forEach {
        if (it.name == nameAlbum)
            it.listDecks.forEach { it1 ->
                if (it1.name == nameDeck)
                    it1.listCards.forEach { it2 ->
                        if (it2.name == nameCard) {
                            println("""Name: ${it2.name}
                        |Human: ${it2.human}
                        |AttackPower ${it2.attackPower}
                        |ProtectionPower: ${it2.protectionPower}
                        |HealthPoints: ${it2.healthPoints}
                    """.trimMargin())
                        }
                    }
            }
    }
}