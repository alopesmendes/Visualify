package com.compose.visualify.ui.theme.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.compose.visualify.R
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes

@Serializable
sealed class NavRoutes(
    @Contextual
    val icon: ImageVector,
    @StringRes val label: Int
) : Routes {
    @Serializable
    data object Creations : NavRoutes(
        icon = Icons.Filled.PhotoLibrary,
        label = R.string.creations
    )
    @Serializable
    data object Visuals : NavRoutes(
        icon = Icons.Filled.PhotoCamera,
        label = R.string.visuals
    )
    @Serializable
    data object Settings : NavRoutes(
        icon = Icons.Filled.Settings,
        label = R.string.settings
    )

    companion object {
        val destinations = listOf<NavRoutes>(Visuals, Creations, Settings)
    }
}
