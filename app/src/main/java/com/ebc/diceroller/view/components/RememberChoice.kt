// File: com/ebc/diceroller/view/components/RememberChoice.kt
package com.ebc.diceroller.view.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

@Composable
fun RememberChoice() {
    var checkedState by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it }
        )
        Text("Recuerda mi elección")
    }
}
