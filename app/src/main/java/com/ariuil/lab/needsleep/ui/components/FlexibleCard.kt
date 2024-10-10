package com.ariuil.lab.needsleep.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.ui.screens.sounds.data.soundItems
import com.ariuil.lab.needsleep.ui.theme.Blue
import com.ariuil.lab.needsleep.ui.theme.NileRiverAdventureTheme
import com.ariuil.lab.needsleep.ui.theme.Rad
import com.ariuil.lab.needsleep.utils.BackgroundElementColors

@Composable
fun FlexibleCard(
    name: String? = null,
    iconRes: Int? = null,
    cardColorBack: BackgroundElementColors = BackgroundElementColors.ColorBackground(Color.Gray),
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable {
                    onClick()
                }
        ) {
            Box(
                modifier = Modifier
                    .let {
                        when (cardColorBack) {
                            is BackgroundElementColors.ColorBackground -> it.background(
                                cardColorBack.color
                            )

                            is BackgroundElementColors.BrushBackground -> it.background(
                                cardColorBack.brush
                            )
                        }
                    }
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                if (iconRes != null) {
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (name != null) {
            Text(
                text = name,
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun CardPreview() {
    NileRiverAdventureTheme {
        FlexibleCard(
            name = soundItems[0].name,
            iconRes = soundItems[0].iconRes,
            cardColorBack = BackgroundElementColors.BrushBackground(
                Brush.linearGradient(
                    colors = listOf(Rad, Blue),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
        )
    }
}