package com.ariuil.lab.needsleep.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ariuil.lab.needsleep.ui.navigation.data.NavItem
import com.ariuil.lab.needsleep.ui.navigation.data.navItems
import com.ariuil.lab.needsleep.ui.theme.NileRiverAdventureTheme
import com.ariuil.lab.needsleep.ui.theme.SelectedButtonColor
import com.ariuil.lab.needsleep.ui.theme.UnselectedButtonColor

@Composable
fun NavBar(
    navController: NavController,
    items: List<NavItem>,
    modifierOfNavBar: Modifier = Modifier,
    colorsOfNavBarItems: NavigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = SelectedButtonColor,
        unselectedIconColor = UnselectedButtonColor,
        selectedTextColor = SelectedButtonColor,
        unselectedTextColor = UnselectedButtonColor,
        indicatorColor = Color.Transparent
    )
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        modifier = modifierOfNavBar
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.contentDescription
                    )
                },
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                selected = currentRoute == item.route,
                colors = colorsOfNavBarItems
            )
        }
    }
}

@Preview
@Composable
fun ButtonNavBarPreview() {
    val mockNavController = rememberNavController()
    NileRiverAdventureTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavBar(
                navController = mockNavController,
                items = navItems,
                modifierOfNavBar = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )
        }
    }
}