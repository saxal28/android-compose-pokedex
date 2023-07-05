package com.example.pokedex_android_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex_android_compose.network.AppService
import com.example.pokedex_android_compose.ui.screens.pokemondetail.PokemonDetailScreen
import com.example.pokedex_android_compose.ui.screens.pokemonsearch.PokemonSearchScreen
import com.example.pokedex_android_compose.ui.theme.Pokedex_android_composeTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Pokedex_android_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "profile") {
                        composable("profile") {
                            PokemonSearchScreen(
                                navigateToPokemonDetails = { id -> navController.navigate("details/${id}") }
                            )
                        }
                        composable(
                            "details/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.StringType })
                        ) { PokemonDetailScreen(
                            onBack = { navController.popBackStack() }
                        ) }
                    }
                }
            }
        }
    }
}