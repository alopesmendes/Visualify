package com.compose.visualify.ui.theme.models

import androidx.compose.runtime.Immutable

@Immutable
data class MainScaffoldState(
    val currentRoute: Routes = NavRoutes.Visuals,
)
