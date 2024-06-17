package com.mtt.material3ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MaterialTextFields() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var filledText by remember {
            mutableStateOf("")
        }
        val outLinedText by remember {
            mutableStateOf("")
        }
        Text(text = "Text Fields", textAlign = TextAlign.Center, fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(bottom = 50.dp))
        TextField(
            value = filledText, onValueChange = { it: String -> filledText = it },
            label = ({ Text(text = "Enter Your Weight") }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.MonitorWeight,
                    contentDescription = "Weight"
                )
            }, suffix = {
                Text(text = "Kg")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))

        OutlinedTextField(
            value = outLinedText, onValueChange = { it: String -> filledText = it },
            label = ({ Text(text = "Enter Your Height") }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Height,
                    contentDescription = "Height"
                )
            }, suffix = {
                Text(text = "Cms")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
    }
}

@Composable
@Preview
fun MaterialTextFieldsPreview() {
    MaterialTextFields()
}
