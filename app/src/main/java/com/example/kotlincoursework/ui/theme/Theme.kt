package com.example.kotlincoursework.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = SkyBlueDark,
    onPrimary = Night,
    secondary = Cloud,
    onSecondary = Night,
    tertiary = SunGlow,
    onTertiary = Night,
    background = Night,
    onBackground = Mist,
    surface = Storm,
    onSurface = Mist,
    surfaceVariant = DeepNavy,
    onSurfaceVariant = Cloud,
    error = ErrorRed
)

private val LightColorScheme = lightColorScheme(
    primary = SkyBlue,
    onPrimary = Mist,
    secondary = Horizon,
    onSecondary = Mist,
    tertiary = SunGlow,
    onTertiary = Night,
    background = Mist,
    onBackground = DeepNavy,
    surface = ColorWhite,
    onSurface = DeepNavy,
    surfaceVariant = Frost,
    onSurfaceVariant = Rain,
    error = ErrorRed
)

@Composable
fun KotlinCourseWorkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
