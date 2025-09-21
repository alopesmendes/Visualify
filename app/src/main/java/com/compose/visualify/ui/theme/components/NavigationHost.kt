package com.compose.visualify.ui.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.visualify.ui.theme.models.MainScaffoldState
import com.compose.visualify.ui.theme.models.NavRoutes
import com.compose.visualify.ui.theme.models.Routes


@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Routes = NavRoutes.Visuals,
    mainScaffoldState: MainScaffoldState = MainScaffoldState(),
    onMainScaffoldStateChange: (MainScaffoldState) -> Unit = {},
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<NavRoutes.Visuals> {
            // TODO: Replace with your actual Creations screen composable.
            // You can use stringResource(NavRoutes.Creations.label) for the title.
            Text(text = "Visuals Screen")
        }
        composable<NavRoutes.Creations> {
            // TODO: Replace with your actual Visuals screen composable.
            // You can use stringResource(NavRoutes.Visuals.label) for the title.
            Text(text = "Creations Screen")
        }
        composable<NavRoutes.Settings> {
            // TODO: Replace with your actual Settings screen composable.
            // You can use stringResource(NavRoutes.Settings.label) for the title.
            Text(text = "Settings Screen")
        }
    }
}
