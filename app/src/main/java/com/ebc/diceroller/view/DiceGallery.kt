package com.ebc.diceroller.view
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ebc.diceroller.R
import com.ebc.diceroller.enumerators.ViewIDs

@Composable
fun DiceGallery(navController: NavController) {
    // Lista de imágenes de dados
    val diceImages = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3
    )

    // Diseño de la galería
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp), // Cuadrícula adaptable
        modifier = Modifier.padding(16.dp)
    ) {
        items(diceImages) { imageRes ->
            DiceImageItem(imageRes)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        // Botón para ir a Home
        Button(
            onClick = { navController.navigate("home") }, // Cambia "home" al nombre correcto de tu ruta
            modifier = Modifier.weight(1f) // Ocupa el 50% del ancho
        ) {
            Text(text = "Home")
        }

        Spacer(modifier = Modifier.width(16.dp)) // Espacio entre los botones

        // Botón para ir a Galería
        Button(
            onClick = { navController.navigate(ViewIDs.FINISH.name) }, // Cambia "gallery" al nombre correcto de tu ruta
            modifier = Modifier.weight(1f) // Ocupa el 50% del ancho
        ) {
            Text(text = "Exit")
        }
    }
}



@Composable
fun DiceImageItem(imageRes: Int) {
    // Caja que contiene la imagen
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp) // Tamaño de las imágenes
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Dice Image",
            modifier = Modifier.fillMaxSize()
        )
    }

}

