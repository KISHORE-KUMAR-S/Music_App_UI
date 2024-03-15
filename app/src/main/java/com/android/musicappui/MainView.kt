package com.android.musicappui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedScreen = remember { mutableStateOf(Destinations.HOME) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                val drawerItems = listOf(
                    DrawerItem("Home", R.drawable.ic_home),
                    DrawerItem("Account", R.drawable.ic_account),
                    DrawerItem("Subscription", R.drawable.ic_subscribe_music),
                )

                drawerItems.forEachIndexed { index, drawerItem ->
                    NavigationDrawerItem(
                        label = { Text(text = drawerItem.name) },
                        icon = {
                            Icon(painter = painterResource(id = drawerItem.icon), contentDescription = null)
                        },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }

                            selectedScreen.value = drawerItem.name

                            when (index) {
                                0 -> navController.navigate(Destinations.HOME)
                                1 -> navController.navigate(Destinations.ACCOUNT)
                                2 -> navController.navigate(Destinations.SUBSCRIBE)
                            }
                        }
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = selectedScreen.value) },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                // TODO:
                            }
                        }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                        }
                    }
                )
            },
        ) {
            values ->

            Box(modifier = Modifier
                .padding(values)
                .padding(start = 16.dp)) {
                NavHost(navController = navController, startDestination = Destinations.HOME) {
                    composable(Destinations.HOME) { HomeView() }
                    composable(Destinations.ACCOUNT) { AccountView() }
                    composable(Destinations.SUBSCRIBE) { SubscriptionView() }
                }
            }
        }
    }
}





