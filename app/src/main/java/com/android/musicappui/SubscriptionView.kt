package com.android.musicappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubscriptionView() {
    Column(modifier = Modifier.height(200.dp).padding(end = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Manage Subscription")
        Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Musical")
                Row {
                    Text(text = "See All Plans")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "See All Plans")
                }
            }
            Divider()
            Row(modifier = Modifier.padding(16.dp)) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
                Text(text = "Get a Plan")
            }
        }
    }
}