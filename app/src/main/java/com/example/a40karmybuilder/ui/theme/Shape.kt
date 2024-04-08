package com.example.a40karmybuilder.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = CutCornerShape(50.dp),                                  //Circle
    medium = CutCornerShape(bottomEnd = 12.dp, topStart = 12.dp),   //Corner-cut medium
    large = CutCornerShape(bottomEnd = 18.dp, topStart = 18.dp)
)