package com.example.pokedex_android_compose.ui.screens.pokemondetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex_android_compose.R
import com.example.pokedex_android_compose.network.model.PokemonDetail
import com.example.pokedex_android_compose.ui.common.COLORS

@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onBack: () -> Unit
) {
    Screen(viewState = viewModel.viewState, onBack = onBack)
}

@Composable
private fun Screen(viewState: PokemonDetailViewState, onBack: () -> Unit = {}) {

    viewState.pokemonDetail?.let { pokemonDetail ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // pokemon detail section

            Box(
                modifier = Modifier.background(pokemonDetail.colors.primary)
            ) {

                Box(modifier = Modifier.fillMaxWidth()){
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(color = pokemonDetail.colors.primary, blendMode = BlendMode.Modulate)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .clip(
                            RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                        )
                        .background(Color.White)
                        .align(Alignment.BottomCenter)
                ) {}

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        IconButton(onClick = onBack) {
                            Icon(
                                tint = Color.White,
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "back")
                        }



                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                tint = Color.White,
                                imageVector = Icons.Default.FavoriteBorder, //Icons.Filled.Favorite
                                contentDescription = "back")
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1F)) {
                            Text(
                                text = pokemonDetail.capitalizedName,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black,
                                fontSize = 30.sp,
                                lineHeight = 34.sp,
                                color = Color.White,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {
                                pokemonDetail.types.forEach { type ->
                                    Text(
                                        text = type,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Black,
                                        color = Color.White,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(pokemonDetail.colors.light)
                                            .padding(vertical = 6.dp, horizontal = 12.dp)
                                    )

                                    Spacer(modifier = Modifier.width(5.dp))

                                }
                            }
                        }

                        Text(text = pokemonDetail.idDisplay,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(pokemonDetail.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        fallback = painterResource(id = R.drawable.pokemonplaceholder),
                        modifier = Modifier.fillMaxWidth(.6F)
                    )
                }
            }


            // pokemon tab section
            val titles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text")

            Column(modifier = Modifier.height(600.dp).background(Color.Red)) {
                TabRow(selectedTabIndex = viewState.selectedTabIndex, contentColor = pokemonDetail.colors.light) {
                    viewState.tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = viewState.selectedTabIndex == index,
                            onClick = { viewState.selectTab(index) },
                            text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) },
                            selectedContentColor = pokemonDetail.colors.primary
                        )
                    }
                }
                Text(
                    modifier = Modifier.fillMaxSize(),
                    text = "Text tab ${state + 1} selected",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview() {
    Screen(viewState =
    PokemonDetailViewState().apply {
        pokemonDetail = PokemonDetail(
            name = "Charizard",
            types = listOf("water", "flying"),
            id = "1",
            image = ""
        )
    }
    )
}