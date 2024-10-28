package com.ebc.diceroller.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NameInput() {
    var name by remember { mutableStateOf("") } // Estado para almacenar el nombre

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Ingresa tu nombre") },
        modifier = Modifier.fillMaxWidth()
    )
}
