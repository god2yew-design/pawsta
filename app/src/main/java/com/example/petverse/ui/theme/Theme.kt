package com.example.petverse.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PetVerseColors.Purple80,
    onPrimary = PetVerseColors.Purple20,
    primaryContainer = PetVerseColors.Purple30,
    onPrimaryContainer = PetVerseColors.Purple90,
    inversePrimary = PetVerseColors.Purple40,
    secondary = PetVerseColors.Orange80,
    onSecondary = PetVerseColors.Orange20,
    secondaryContainer = PetVerseColors.Orange30,
    onSecondaryContainer = PetVerseColors.Orange90,
    tertiary = PetVerseColors.Blue80,
    onTertiary = PetVerseColors.Blue20,
    tertiaryContainer = PetVerseColors.Blue30,
    onTertiaryContainer = PetVerseColors.Blue90,
    error = PetVerseColors.Red80,
    onError = PetVerseColors.Red20,
    errorContainer = PetVerseColors.Red30,
    onErrorContainer = PetVerseColors.Red90,
    background = PetVerseColors.Grey10,
    onBackground = PetVerseColors.Grey90,
    surface = PetVerseColors.Grey10,
    onSurface = PetVerseColors.Grey90,
    surfaceVariant = PetVerseColors.Grey30,
    onSurfaceVariant = PetVerseColors.Grey80,
    surfaceTint = PetVerseColors.Purple80,
    inverseSurface = PetVerseColors.Grey90,
    inverseOnSurface = PetVerseColors.Grey20,
    outline = PetVerseColors.Grey60
)

private val LightColorScheme = lightColorScheme(
    primary = PetVerseColors.Purple40,
    onPrimary = PetVerseColors.White,
    primaryContainer = PetVerseColors.Purple90,
    onPrimaryContainer = PetVerseColors.Purple10,
    inversePrimary = PetVerseColors.Purple80,
    secondary = PetVerseColors.Orange40,
    onSecondary = PetVerseColors.White,
    secondaryContainer = PetVerseColors.Orange90,
    onSecondaryContainer = PetVerseColors.Orange10,
    tertiary = PetVerseColors.Blue40,
    onTertiary = PetVerseColors.White,
    tertiaryContainer = PetVerseColors.Blue90,
    onTertiaryContainer = PetVerseColors.Blue10,
    error = PetVerseColors.Red40,
    onError = PetVerseColors.White,
    errorContainer = PetVerseColors.Red90,
    onErrorContainer = PetVerseColors.Red10,
    background = PetVerseColors.Grey99,
    onBackground = PetVerseColors.Grey10,
    surface = PetVerseColors.Grey99,
    onSurface = PetVerseColors.Grey10,
    surfaceVariant = PetVerseColors.Grey90,
    onSurfaceVariant = PetVerseColors.Grey30,
    surfaceTint = PetVerseColors.Purple40,
    inverseSurface = PetVerseColors.Grey20,
    inverseOnSurface = PetVerseColors.Grey95,
    outline = PetVerseColors.Grey50
)

@Composable
fun PetVerseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = PetVerseTypography,
        content = content
    )
}