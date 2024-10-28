package com.ebc.diceroller.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ebc.diceroller.enumerators.ViewIDs
import com.ebc.diceroller.model.Dice
import com.ebc.diceroller.view.*

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ViewIDs.SPLASH.name) {
        composable(ViewIDs.SPLASH.name) { SplashScreen(navController) }
        composable(ViewIDs.ONBOARDING.name) { OnboardingScreen(navController) }
        composable(ViewIDs.HOME.name) { HomeScreen(navController) }
        composable(ViewIDs.GALLERY.name){ DiceGallery(navController) }
        composable(ViewIDs.FINISH.name){ FinishScreen(navController) }
    }
}
