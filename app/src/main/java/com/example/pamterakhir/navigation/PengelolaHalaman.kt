package com.example.pamterakhir.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {


    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(
            DestinasiHome.route
        ) {
            HomeScreen(navigateToItemEntry = {
                navController.navigate(DestinasiEntry.route)
            },
                onDetailClick = { itemId ->
                    navController.navigate("${DetailDestination.route}/$itemId")
                    println("itemId: $itemId")
                })
        }
        composable(DestinasiEntry.route) {
            AddScreen(navigateBack = {
                navController.popBackStack()
            })

        }

        composable(
            route = DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.kontakId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val kontakId = backStackEntry.arguments?.getString(DetailDestination.kontakId)
            kontakId?.let {
                DetailScreen(
                    navigateBack = { navController.popBackStack() },
                    navigateToEditItem = {
                        navController.navigate("${EditDestination.route}/$kontakId")
                        println("kontakId: $kontakId")
                    }
                )
            }
        }

        composable(
            route = EditDestination.routeWithArgs,
            arguments = listOf(navArgument(EditDestination.kontakId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val kontakId = backStackEntry.arguments?.getString(EditDestination.kontakId)
            kontakId?.let {
                EditScreen(
                    navigateBack = { navController.popBackStack() },
                    onNavigateUp = { navController.navigateUp() }
                )
            }
        }
    }
}