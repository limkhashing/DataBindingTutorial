package com.kslimweb.databindingtutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Random

object FakeRepository {

    private val fruitNames: List<String> = listOf(
        "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig",
        "Pear", "Strawberry", "Gooseberry", "Raspberry"
    )

    // try don't expose MutableLiveData, only expose LiveData
    // if 2-way data binding. This will make the code much safer
    private val randomFruitName = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = randomFruitName

    init {
        randomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        randomFruitName.value = getRandomFruitName()
    }
}
