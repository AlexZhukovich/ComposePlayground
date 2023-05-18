package com.alexzh.composeplayground.ui.demo.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Demo_defaultButton() {
    Box(
        modifier = Modifier.size(height = 75.dp, width = 150.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { }) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "Share",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Share")
        }
    }
}

@Preview
@Composable
fun Demo_defaultOutlineButton() {
    Box(
        modifier = Modifier.size(height = 75.dp, width = 150.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton(onClick = { }) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "Share",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Share")
        }
    }
}

@Preview
@Composable
fun Demo_defaultTextButton() {
    Box(
        modifier = Modifier.size(height = 75.dp, width = 150.dp),
        contentAlignment = Alignment.Center
    ) {
        TextButton(onClick = { }) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "Share",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Share")
        }
    }
}

@Preview
@Composable
fun Demo_material3FilledTonalButton() {
    Box(
        modifier = Modifier.size(height = 75.dp, width = 150.dp),
        contentAlignment = Alignment.Center
    ) {

        androidx.compose.material3.FilledTonalButton(onClick = { }) {
            Icon(
                Icons.Filled.Share,
                contentDescription = "Share",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Share")
        }
    }
}

@Preview
@Composable
fun Demo_material3ButtonVsOutlineButtonVsFilledTonalButton() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.Button(onClick = { }) {
            Text(text = "Button")
        }

        androidx.compose.material3.OutlinedButton(onClick = { }) {
            Text(text = "OutlinedButton")
        }

        androidx.compose.material3.FilledTonalButton(onClick = { }) {
            Text(text = "FilledTonalButton")
        }
    }
}