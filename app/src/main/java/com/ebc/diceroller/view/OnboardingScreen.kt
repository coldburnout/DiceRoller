package com.ebc.diceroller.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ebc.diceroller.R
import com.ebc.diceroller.enumerators.ViewIDs
import kotlinx.coroutines.delay


@Composable
fun OnboardingScreen(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.welcome_animation))
    val progress by animateLottieCompositionAsState(composition)

    LaunchedEffect(Unit) {
        delay(3000L) // Delay for 3 seconds
        navController.navigate(ViewIDs.ONBOARDING.name) {
            popUpTo(ViewIDs.ONBOARDING.name) { inclusive = true } // Clears the back stack
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(200.dp)


        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome to the Dice Roller App!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate(ViewIDs.HOME.name) }) {
            Text(text = "Start Rolling")
        }
    }
}
