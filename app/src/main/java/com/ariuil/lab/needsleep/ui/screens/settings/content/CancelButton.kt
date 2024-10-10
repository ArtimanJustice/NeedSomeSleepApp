package com.ariuil.lab.needsleep.ui.screens.settings.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ariuil.lab.needsleep.R

@Composable
fun CancelButton(
    onCancel: () -> Unit
) {
    Button(
        onClick = onCancel,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(top = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cancel_button),
            contentDescription = "Cancel Image",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp))
        )
    }
}