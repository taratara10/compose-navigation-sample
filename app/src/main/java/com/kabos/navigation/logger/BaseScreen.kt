package com.kabos.navigation.logger

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen(
    title: String,
    buttonTitle: String = "",
    onClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onClick) {
                Text(text = buttonTitle)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Screen(
        title = "sample",
        buttonTitle = "button",
        onClick = {}
    )
}
