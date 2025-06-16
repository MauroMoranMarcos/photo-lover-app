package com.example.photo_lover_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.photo_lover_app.ui.home.HomeDestination
import com.example.photo_lover_app.ui.home.HomeScreen
import com.example.photo_lover_app.ui.reminder.AddReminderDestination
import com.example.photo_lover_app.ui.reminder.AddReminderScreen

object Routes {
    const val HOME = "home"
    const val ADD_REMINDER = "add_reminder"
}

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit) {
    NavHost(navController = navController, startDestination = Routes.HOME, modifier = modifier) {
        composable(route = HomeDestination.route) {
            HomeScreen(navigateToReminder = { navController.navigateUp() },
                navigateToAddReminder = {
                    navController.navigate("${AddReminderDestination.route}/${it}")
                },
                onMenuClick = onMenuClick)
        }
        composable(Routes.ADD_REMINDER) {
            AddReminderScreen()
        }
    }
}
