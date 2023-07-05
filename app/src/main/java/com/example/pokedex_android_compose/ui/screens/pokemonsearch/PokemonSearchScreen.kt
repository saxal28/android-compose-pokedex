package com.example.pokedex_android_compose.ui.screens.pokemonsearch

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.util.Locale

@Composable
fun PokemonSearchScreen(
    navigateToPokemonDetails: (String) -> Unit = {},
    viewModel: PokemonSearchViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    Screen(viewModel.viewState, navigateToPokemonDetails)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun Screen(
    viewState: PokemonSearchViewState,
    navigateToPokemonDetails: (String) -> Unit = {},
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "What Pokemon\nare you looking for?",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Black,
                fontSize = 26.sp,
                lineHeight = 34.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = viewState.searchText,
                onValueChange = viewState::onChange,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xffF6F6F6),
                    unfocusedBorderColor = Color(0xffF6F6F6)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xffF6F6F6)),
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "")
                },
                trailingIcon = {
                    AnimatedVisibility(visible = viewState.searchText.isNotEmpty()) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "",
                            modifier = Modifier.clickable { viewState.clear() })

                    }

                },
                shape = RoundedCornerShape(30.dp),
                placeholder = {
                    Text(text = "Search pokemon name")
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn() {
                items(viewState.autocomplete, key = { it.id }) { pokemon ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .animateItemPlacement()
                            .clickable { navigateToPokemonDetails(pokemon.id) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(pokemon.image)
                                .crossfade(true)
                                .build(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = pokemon.capitalizedName,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PokemonSearchScreen__Preview() {
    Screen(viewState = PokemonSearchViewState())
}