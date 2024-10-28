package com.ebc.diceroller.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ebc.diceroller.R
import com.ebc.diceroller.viewmodel.DiceViewModel
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(navController: NavController) {
    val diceViewModel: DiceViewModel = remember { DiceViewModel() }
    val rollResult = diceViewModel.diceRolls.value

    var showResult by remember { mutableStateOf(false) }
    var isFixedButtonEnabled by remember { mutableStateOf(true) } // Estado para habilitar/deshabilitar el botón fijo
    var isSliderEnabled by remember{ mutableStateOf(true)} // Estado para habilitar/deshabilitar el slider

    // Configuracion de animación Lottie
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.dice_roll_animation))
    val progress by animateLottieCompositionAsState(
        composition,
        isPlaying = showResult, // Inicia la animación cuando showResult es true
        restartOnPlay = true,   // Reinicia la animación cada vez que se juega
        speed = 1.5f,           // Velocidad de la animación
        iterations = 1          // Ejecuta la animación solo una vez
    )

    var sides by remember { mutableStateOf(6) } // Estado para almacenar el número de lados del dado, inicialmente 6


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(150.dp)
        )
        if (progress == 1f && showResult) {
            Text(
                text = "Valor del dado: $rollResult",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            LaunchedEffect(Unit) {
                delay(2000)//Espera 2 segundos antes de reiniciar el estado para la animacion
                showResult = false
                sides = 6
                isSliderEnabled =true
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Selecciona los lados del dado: $sides")
        Slider(
            value = sides.toFloat(),
            onValueChange = {
                sides = it.toInt()
                isFixedButtonEnabled = false
                            },
            valueRange = 6f..20f,
            steps = 15, // Crear pasos (ej. 4, 6, 8, ..., 20)
            modifier = Modifier.fillMaxWidth(),
            enabled = isSliderEnabled
        )

        Button(
            onClick = {
                showResult = true
                diceViewModel.rollDice(6)
                isFixedButtonEnabled = true
                isSliderEnabled = false
                      },
            enabled = isFixedButtonEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = "Throw Regular Dice")
        }

        Button(
            onClick = {
                showResult = true
                diceViewModel.rollDiceChange(sides)
                isFixedButtonEnabled = true
                isSliderEnabled = false
                      },
            enabled = !showResult,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(text = "Throw $sides sides custom Dice")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
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
                onClick = { navController.navigate("gallery") }, // Cambia "gallery" al nombre correcto de tu ruta
                modifier = Modifier.weight(1f) // Ocupa el 50% del ancho
            ) {
                Text(text = "Gallery")
            }
        }

    }
}


/*
@Composable
fun HomeScreen(diceViewModel: DiceViewModel, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Existing UI elements...

        // Button to navigate to Roll History
        Button(onClick = { navController.navigate("rollHistory") }) {
            Text("View Roll History")
        }
    }
}

*/