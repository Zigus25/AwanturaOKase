package data.model

import androidx.compose.ui.graphics.Color

data class Team(
    val color: Color,
    val fontColor: Color,
    val id: Int,
    var amount: Int,
    var bid: Int
)
