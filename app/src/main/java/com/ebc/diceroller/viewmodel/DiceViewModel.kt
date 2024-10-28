package com.ebc.diceroller.viewmodel

import android.view.WindowInsets.Side
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ebc.diceroller.model.Dice

class DiceViewModel : ViewModel() {
    private val dice = Dice(sides = 6)
    private var diceChange =Dice(sides = 6)
    var diceRolls = mutableStateOf(1)

    fun rollDice(sides: Int) {
        diceRolls.value = dice.roll()
    }
    fun rollDiceChange(sides: Int) {
        diceChange = Dice(sides)
        diceRolls.value = diceChange.roll()
    }

}
