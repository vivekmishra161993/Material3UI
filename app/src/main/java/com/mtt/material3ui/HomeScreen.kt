package com.mtt.material3ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mtt.material3ui.components.BottomSheets
import com.mtt.material3ui.components.MaterialButtons
import com.mtt.material3ui.components.MaterialSelectors
import com.mtt.material3ui.components.MaterialTextFields
import com.mtt.material3ui.ui.Screens
import kotlinx.coroutines.launch


@Composable
fun Home(calculateTopPadding: Dp) {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route,
    ) {
        composable(Screens.ButtonScreen.route) {
            MaterialButtons()
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(topPadding = calculateTopPadding, navController)
        }
        composable(Screens.SelectorScreen.route) {
            MaterialSelectors(topPadding = calculateTopPadding)
        }
        composable(Screens.TextFieldScreen.route) {
            MaterialTextFields()
        }


    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(topPadding: Dp, navController: NavController) {
    val components = mutableListOf<String>(
        "Buttons",
        "TextFields",
        "Selectors",
        "Bottom Sheets",
    )
    val scope = rememberCoroutineScope()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    Column(modifier = Modifier.padding(top = topPadding)) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.Center
        ) {
            items(components.size) {
                ElevatedButton(
                    onClick = {
                        if (components[it] == Screens.BottomSheetScreen.route) {

                            scope.launch {
                                isBottomSheetVisible = true
                                sheetState.expand()
                            }
                        } else {
                            navController.navigate(components[it])
                        }
                    },
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
                ) {
                    Text(text = components[it])
                }
            }
        }
        BottomSheets(
            isBottomSheetVisible = isBottomSheetVisible,
            sheetState = sheetState,
            onDismiss = {
                scope.launch { sheetState.hide() }
                    .invokeOnCompletion { isBottomSheetVisible = false }
            }
        )
    }


}