package com.mtt.material3ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mtt.material3ui.models.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets(
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit
) {

    val drawerItems = listOf(
        NavigationItem(
            title = "Recent", selectedIcon = Icons.Filled.Schedule,
            unSelectedIcon = Icons.Outlined.Schedule,
        ),
        NavigationItem(
            title = "Sent", selectedIcon = Icons.AutoMirrored.Filled.Send,
            unSelectedIcon = Icons.AutoMirrored.Outlined.Send,
            badgeCount = 10
        ),
        NavigationItem(
            title = "Bin", selectedIcon = Icons.Filled.Delete,
            unSelectedIcon = Icons.Outlined.DeleteOutline,
        ),
        NavigationItem(
            title = "Settings", selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings

        )
    )
    if (isBottomSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState
        ) {
            LazyColumn(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 24.dp)
            ) {
                items(drawerItems.size) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable(onClick = onDismiss)
                    ) {
                        Icon(
                            imageVector = drawerItems[index].selectedIcon,
                            contentDescription = "", modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            text = drawerItems[index].title,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }
    }


}