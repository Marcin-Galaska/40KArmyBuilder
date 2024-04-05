package com.example.a40karmybuilder.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a40karmybuilder.R

val Anton = FontFamily(
    Font(R.font.anton_regular)
)

val SpaceMarine = FontFamily(
    Font(R.font.space_marine_regular)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Anton,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Anton,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Anton,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = SpaceMarine,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)