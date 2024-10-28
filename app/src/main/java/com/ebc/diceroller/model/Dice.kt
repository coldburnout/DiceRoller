package com.ebc.diceroller.model

import kotlin.random.Random

data class Dice(val sides: Int = 6) {
    fun roll(): Int {
        return Random.nextInt(1, sides + 1)
    }
}

