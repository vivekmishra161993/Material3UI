package com.mtt.material3ui.ui

sealed class Screens(val route: String) {
    data object HomeScreen : Screens("home")
    data object ButtonScreen : Screens("Buttons")
    data object TextFieldScreen : Screens("TextFields")
    data object SelectorScreen : Screens("Selectors")
    data object BottomSheetScreen : Screens("Bottom Sheets")

}