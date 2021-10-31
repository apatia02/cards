import kotlin.random.Random

class Deck(val name: String, var albumName: String) {
    var listCards = mutableListOf<Card>()


    fun sortCards() {
        println(
            """On what attribute to sort:
                |human
                |attackPower
                |protectionPower
                |healthPoints
            """.trimMargin())
        val attribute = readLine().toString()
        println("Ascending or descending?(true/false)")
        val direction = readLine().toBoolean()
        when (attribute) {
            "human" -> sortHuman(direction)
            "attackPower" -> sortAttackPower(direction)
            "protectionPower" -> sortProtectionPower(direction)
            "healthPoints" -> sortHealthPoints(direction)
        }
    }

    private fun sortHuman(direction: Boolean) {
        val list = mutableListOf<Card>()
        if (direction) {
            listCards.forEach { if (it.human) list.add(it) }
            listCards.forEach { if (!it.human) list.add(it) }
            list.forEach { println("Name of card:${it.name} Human: ${it.human}") }
        } else {
            listCards.forEach { if (!it.human) list.add(it) }
            listCards.forEach { if (it.human) list.add(it) }
            list.forEach { println("Name of card:${it.name} Human: ${it.human}") }
        }
    }

    private fun sortAttackPower(direction: Boolean) {
        val list = mutableListOf<Int>()
        listCards.forEach { list.add(it.attackPower) }
        if (direction) {
            val set = list.toSet().sorted()
            set.forEach {
                for (i in 0 until listCards.size) {
                    if (it == listCards[i].attackPower)
                        println("Name of card:${listCards[i].name} AttackPower: ${listCards[i].attackPower}")
                }
            }
        } else {
            val set = list.toSet().sorted().reversed()
            set.forEach {
                for (i in 0 until listCards.size) {
                    if (it == listCards[i].attackPower)
                        println("Name of card:${listCards[i].name} AttackPower: ${listCards[i].attackPower}")
                }
            }
        }
    }

    private fun sortProtectionPower(direction: Boolean) {
        val list = mutableListOf<Int>()
        listCards.forEach { list.add(it.protectionPower) }
        if (direction) {
            val set = list.toSet().sorted()
            set.forEach {
                for (i in 0 until listCards.size) {
                    if (it == listCards[i].protectionPower)
                        println("Name of card:${listCards[i].name} AttackPower: ${listCards[i].protectionPower}")
                }
            }
        } else {
            val set = list.toSet().sorted().reversed()
            set.forEach {
                for (i in 0 until listCards.size) {
                    if (it == listCards[i].protectionPower)
                        println("Name of card:${listCards[i].name} AttackPower: ${listCards[i].protectionPower}")
                }
            }
        }
    }

    private fun sortHealthPoints(direction: Boolean) {
        val list = mutableListOf<Int>()
        listCards.forEach { list.add(it.healthPoints) }
        if (direction) {
            val set = list.toSet().sorted()
            set.forEach {
                for (i in 0 until listCards.size) {
                    if (it == listCards[i].healthPoints)
                        println("Name of card:${listCards[i].name} AttackPower: ${listCards[i].healthPoints}")
                }
            }
        } else {
            val set = list.toSet().sorted().reversed()
            set.forEach {
                for (i in 0 until listCards.size) {
                    if (it == listCards[i].healthPoints)
                        println("Name of card:${listCards[i].name} AttackPower: ${listCards[i].healthPoints}")
                }
            }
        }
    }

    fun deleteCard() {
        println("Enter name of card which you want delete")
        var count = 0
        val name = readLine().toString()
        for (i in 0..listCards.size) {
            if (listCards[i].name == name) {
                listCards.remove(listCards[i])
                count = 1
            }
            if (count == 1) println("The card was successfully deleted")
            else println("A card with this name does not exist")
        }
    }

    fun changeCard() {
        println("Enter name of card which you want change")
        var count = 0
        val name = readLine().toString()
        var card = Card(
            name = "",
            human = true,
            attackPower = Random.nextInt(1, 10),
            protectionPower = Random.nextInt(1, 10),
            healthPoints = Random.nextInt(1, 10),
            deckName = ""
        )
        listCards.forEach {
            if (it.name == name) {
                card = it
                count = 1
            }
        }
        return if (count == 0) println("A card with this name does not exist")
        else {
            println(
                """Write which attribute you want to change:
                |human
                |attackPower
                |protectionPower
                |healthPoints
            """.trimMargin()
            )

            val attribute = readLine().toString()
            println("Write a new attribute value")
            val attributeValue = readLine().toString()
            when (attribute) {
                "human" -> card.human = attributeValue.toBoolean()
                "attackPower" -> card.attackPower = attributeValue.toInt()
                "protectionPower" -> card.protectionPower = attributeValue.toInt()
                "healthPoints" -> card.healthPoints = attributeValue.toInt()
            }
            for (i in 0 until listCards.size)
                if (listCards[i].name == card.name) listCards[i] = card


        }
    }

    fun addCard(deckName: String) {
        var count = 0
        println("Enter name of card")
        val card = Card(
            name = readLine().toString(),
            human = Random.nextBoolean(),
            attackPower = Random.nextInt(1, 10),
            protectionPower = Random.nextInt(1, 10),
            healthPoints = Random.nextInt(1, 10),
            deckName = deckName
        )
        listCards.forEach { if (it.name == card.name) count = 1 }
        if (count == 1) println("A card with this name already exists")
        else {
            listCards.add(card)
        }
    }
}