package com.example.pokedex_android_compose.ui.common

import androidx.compose.ui.graphics.Color

data class PokemonColor(
    val type: String,
    val primary: Color,
    val light: Color,
)

class PokemonColorPicker() {

    val colors = listOf(
        PokemonColor(PokemonType.Bug, COLORS.BUG, COLORS.BUG_LIGHT),
        PokemonColor(PokemonType.Fire, COLORS.FIRE, COLORS.FIRE_LIGHT),
        PokemonColor(PokemonType.Water, COLORS.WATER, COLORS.WATER_LIGHT),
        PokemonColor(PokemonType.Grass, COLORS.GRASS, COLORS.GRASS_LIGHT),
        PokemonColor(PokemonType.Electric, COLORS.ELECTRIC, COLORS.ELECTRIC_LIGHT),
        PokemonColor(PokemonType.Dark, COLORS.DARK, COLORS.DARK_LIGHT),
        PokemonColor(PokemonType.Rock, COLORS.ROCK, COLORS.ROCK_LIGHT),
        PokemonColor(PokemonType.Ground, COLORS.GROUND, COLORS.GROUND_LIGHT),
        PokemonColor(PokemonType.Poison, COLORS.POISON, COLORS.POISON_LIGHT),
        PokemonColor(PokemonType.Ghost, COLORS.GHOST, COLORS.GHOST_LIGHT),
        PokemonColor(PokemonType.Psychic, COLORS.PSYCHIC, COLORS.PSYCHIC_LIGHT),
        PokemonColor(PokemonType.Ice, COLORS.ICE, COLORS.ICE_LIGHT),
        PokemonColor(PokemonType.Steel, COLORS.STEEL, COLORS.STEEL_LIGHT),
        PokemonColor(PokemonType.Fighting, COLORS.FIGHTING, COLORS.FIGHTING_LIGHT),
        PokemonColor(PokemonType.Flying, COLORS.FLYING, COLORS.FLYING_LIGHT),
        PokemonColor(PokemonType.Dragon, COLORS.DRAGON, COLORS.DRAGON_LIGHT),
        PokemonColor(PokemonType.Fairy, COLORS.FAIRY, COLORS.FAIRY_LIGHT),
        PokemonColor(PokemonType.Normal, COLORS.NORMAL, COLORS.NORMAL_LIGHT),
        PokemonColor(PokemonType.Unknown, COLORS.UNKNOWN, COLORS.UNKOWN_LIGHT),
    )

    operator fun invoke(type: String?): PokemonColor {
        return colors.find { it.type == type } ?: PokemonColor(
            PokemonType.Unknown,
            COLORS.UNKNOWN,
            COLORS.UNKOWN_LIGHT
        )
    }
}

object COLORS {
    val FIRE = Color(0xffF76351)
    val FIRE_LIGHT = Color(0xffF3978C)
    val WATER = Color(0xff4A90E2)
    val WATER_LIGHT = Color(0xff6FA3E1)
    val GRASS = Color(0xff21D380)
    val GRASS_LIGHT = Color(0xff62E0A5)
    val ELECTRIC = Color(0xffF7CC1A)
    val ELECTRIC_LIGHT = Color(0xffF9D954)

    val DARK = Color(0xff333333)
    val DARK_LIGHT = Color(0xff555555)

    val ROCK = Color(0xff5E3023)
    val ROCK_LIGHT = Color(0xff7F5447)
    val GROUND = Color(0xffC08552)
    val GROUND_LIGHT = Color(0xffD8AC86)
    val POISON = Color(0xff9448BC)
    val POISON_LIGHT = Color(0xffA974C5)

    val GHOST = Color(0xff4B3F72)
    val GHOST_LIGHT = Color(0xff655698)
    val PSYCHIC = Color(0xffDA4167)
    val PSYCHIC_LIGHT = Color(0xffFF6F93)
    val ICE = Color(0xff90FCF9)
    val ICE_LIGHT = Color(0xffCFFFFE)

    val STEEL = Color(0xff717C89)
    val STEEL_LIGHT = Color(0xff909FB0)
    val FIGHTING = Color(0xff841C26)
    val FIGHTING_LIGHT = Color(0xff9C535A)
    val FLYING = Color(0xff8ACDEA)
    val FLYING_LIGHT = Color(0xffA2E1FC)

    val DRAGON = Color(0xff725AC1)
    val DRAGON_LIGHT = Color(0xff8D79D1)
    val FAIRY = Color(0xffFF579F)
    val FAIRY_LIGHT = Color(0xffFF7EB5)
    val NORMAL = Color(0xff878E99)
    val NORMAL_LIGHT = Color(0xffAFB6C1)
    val BUG = Color(0xffBAB700)
    val BUG_LIGHT = Color(0xffCECB12)

    val UNKNOWN = Color(0xff333333)
    val UNKOWN_LIGHT = Color(0xff555555)
}