package com.mtt.material3ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MaterialButtons() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { }
        ) {
            Text(text = "Subscribe")
        }
        ElevatedButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Elevated Button",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Add To Cart")
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Open In Browser")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Login Here")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Learn More")
        }
    }
}

@Preview
@Composable
fun MaterialButtonsPreview() {
    MaterialButtons()
}