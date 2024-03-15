package com.android.musicappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountView() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 16.dp)) {
        Column(modifier = Modifier
            .padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(modifier = Modifier.weight(1f)) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterVertically) // Center Icon vertically
                    )
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text(text = "ABC")
                        Text(text = "DEF")
                    }
                }
                Spacer(modifier = Modifier.width(16.dp)) // Add space between the two rows
                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                    }
                }
            }
        }
    }
}
