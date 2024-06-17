package com.mtt.material3ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ToggleableInfo(val isChecked: Boolean, val text: String)

@Composable
fun CheckBoxes() {
    val checkboxes = remember {
        mutableStateListOf(
            ToggleableInfo(isChecked = false, text = "Photos"),
            ToggleableInfo(isChecked = false, text = "Videos"),
            ToggleableInfo(isChecked = false, text = "Audio")
        )
    }
    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }
    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkboxes.indices.forEach { index ->
            checkboxes[index] = checkboxes[index].copy(
                isChecked = triState == ToggleableState.On
            )
        }
    }
    Column(
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    toggleTriState()
                }
                .padding(end = 16.dp)
        ) {
            TriStateCheckbox(state = triState, onClick = toggleTriState)
            Text(text = "File Types")
        }

        checkboxes.forEachIndexed { index, info ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .clickable {
                        checkboxes[index] = info.copy(
                            isChecked = !info.isChecked
                        )

                    }
                    .padding(end = 16.dp)
            ) {
                Checkbox(checked = info.isChecked, onCheckedChange = { isChecked ->
                    checkboxes[index] = info.copy(
                        isChecked = isChecked
                    )

                })
                Text(text = info.text)
            }
        }
    }
}

@Composable
fun Switches() {
    var switch by remember {
        mutableStateOf(
            ToggleableInfo(
                isChecked = false,
                text = "Dark Mode"
            )
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = switch.text, fontSize = 14.sp)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switch.isChecked,
            onCheckedChange = { isChecked ->
                switch = switch.copy(isChecked = isChecked)
            },
            thumbContent = {
                Icon(
                    imageVector = if (switch.isChecked) {
                        Icons.Default.Check
                    } else {
                        Icons.Default.Close
                    }, contentDescription = ""
                )
            }
        )
    }
}

@Composable
fun RadioButtons() {
    val radioButtons = remember {
        mutableStateListOf(
            ToggleableInfo(isChecked = true, text = "Photos"),
            ToggleableInfo(isChecked = false, text = "Videos"),
            ToggleableInfo(isChecked = false, text = "Audio")
        )
    }

    Column(
        modifier = Modifier
    ) {

        radioButtons.forEachIndexed { index, info ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 32.dp)
                    .clickable {
                        radioButtons.replaceAll { it ->
                            it.copy(
                                isChecked = it.text == info.text
                            )
                        }

                    }
                    .padding(end = 16.dp)
            ) {
                RadioButton(selected = info.isChecked, onClick = {
                    radioButtons.replaceAll { it ->
                        it.copy(
                            isChecked = it.text == info.text
                        )
                    }
                })

                Text(text = info.text)
            }
        }
    }
}

@Composable
fun MaterialSelectors(topPadding: Dp) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = topPadding)
        ) {
            CheckBoxes()
            Spacer(modifier = Modifier.height(16.dp))
            Switches()
            Spacer(modifier = Modifier.height(16.dp))
            RadioButtons()
        }
    }
}