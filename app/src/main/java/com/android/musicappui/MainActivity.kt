package com.android.musicappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.android.musicappui.ui.theme.MusicAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicAppUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicAppUI()
                }
            }
        }
    }
}

@Composable
fun MusicAppUI() {
    val navController = rememberNavController()
    MainView(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicAppUITheme {
        MusicAppUI()
    }
}