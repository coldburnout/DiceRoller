package com.ebc.diceroller.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.ebc.diceroller.R
import com.ebc.diceroller.enumerators.ViewIDs
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_animation))
    val progress by animateLottieCompositionAsState(composition)

   LaunchedEffect(Unit) {
        delay(3000L) // Delay for 3 seconds
        navController.navigate(ViewIDs.ONBOARDING.name) {
            popUpTo(ViewIDs.SPLASH.name) { inclusive = true } // Clears the back stack
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(200.dp)


        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Proyecto Final", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Jose Daniel Garcia Sepulveda", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Desarrollo de Aplicaciones Moviles", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))


        /*Button(onClick = { navController.navigate(ViewIDs.ONBOARDING.name) }) {
            Text(text = "Iniciar")
        }*/
    }
}
