import kotlin.random.Random

class Library {
    var listAlbums = mutableListOf<Album>()
    var listSortAlbums = mutableListOf<Album>()
    fun transportDecks() {
        println("Enter name of initial album")
        val initialAlbum = readLine().toString()
        println("Enter name of finish album")
        val finishAlbum = readLine().toString()
        println("Enter name of deck")
        val nameDeck = readLine()
        listAlbums.forEach { it ->
            if (it.name == initialAlbum) {
                for (i in 0 until it.listDecks.size) {
                    if (it.listDecks[i].name == nameDeck) {
                        it.listDecks[i].albumName = finishAlbum
                        listAlbums.forEach {
                            if (it.name == finishAlbum) it.listDecks.add(it.listDecks[i])
                        }
                        it.listDecks.remove(it.listDecks[i])
                    }
                }
            }
        }
        listSortAlbums = listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
    }

    fun changeAlbum() {
        var count = 0
        println("Enter name of album which you want change")
        val albumName = readLine().toString()
        println("Write a new year of release")
        listAlbums.forEach {
            if (it.name == albumName) {
                it.albumReleaseYear = readLine()?.toIntOrNull() ?: return
                count = 1

            }
        }
        if (count == 1) println("The album was successfully deleted")
        else println("A album with this name does not exist")
        listSortAlbums = listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
    }

    fun deleteAlbumWithoutContent() {
        println("Enter name of album which you want delete")
        var count = 0
        val name = readLine().toString()
        for (i in 0..listAlbums.size) {
            if (listSortAlbums[i].name == name) {
                listSortAlbums[i - 1].listDecks.addAll(listSortAlbums[i].listDecks)
                listSortAlbums.remove(listAlbums[i])
                listAlbums = listSortAlbums
                count = 1
            }
        }
        if (count == 1) println("The album was successfully deleted")
        else println("A album with this name does not exist")
    }

    fun deleteAlbum() {
        println("Enter name of album which you want delete")
        var count = 0
        val name = readLine().toString()
        for (i in 0..listAlbums.size) {
            if (listAlbums[i].name == name) {
                listAlbums.remove(listAlbums[i])
                listSortAlbums = listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
                count = 1
            }

        }
        if (count == 1) println("The album was successfully deleted")
        else println("A album with this name does not exist")
    }

    fun addAlbum() {
        var count = 0
        println("Enter name of album")
        val album = Album(
            name = readLine().toString(),
            albumReleaseYear = Random.nextInt(1950, 2022)
        )
        listAlbums.forEach { if (it.name == album.name) count = 1 }
        if (count == 1) println("A album with this name already exists")
        else {
            listAlbums.add(album)
            listSortAlbums = listAlbums.sortedBy { it.albumReleaseYear }.toMutableList()
        }
    }
}