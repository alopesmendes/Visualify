package com.compose.visualify.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.visualify.ui.theme.models.NavRoutes // Import for NavRoutes and its objects
import com.compose.visualify.ui.theme.models.Routes // Import for the Routes type if needed by NavigationHost

@Composable
fun MainScaffold() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRouteString = navBackStackEntry?.destination?.route

    // Determine the initial start destination for NavHost.
    // It should be one of the NavRoutes objects.
    val startDestinationForNavHost: Routes = NavRoutes.destinations.firstOrNull() ?: NavRoutes.Creations

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            NavRoutes.destinations.forEach { screenRoute ->
                // The route string used by `composable<T>` is the KClass qualified name.
                val routeStringToCompare = screenRoute::class.qualifiedName
                item(
                    selected = currentRouteString == routeStringToCompare,
                    onClick = {
                        // Avoid redundant navigation if already selected
                        if (currentRouteString != routeStringToCompare) {
                            navController.navigate(screenRoute) { // Navigate with the NavRoutes object
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(imageVector = screenRoute.icon, contentDescription = stringResource(id = screenRoute.label)) },
                    label = { Text(text = stringResource(id = screenRoute.label)) }
                )
            }
        }
    ) {
        Scaffold { innerPadding ->
            NavigationHost(
                navController = navController,
                startDestination = startDestinationForNavHost,
                modifier = Modifier.padding(innerPadding)
            )
        }

    }
}
