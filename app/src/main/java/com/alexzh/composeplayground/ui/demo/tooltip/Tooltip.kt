package com.alexzh.composeplayground.ui.demo.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.Text
import androidx.compose.material3.rememberPlainTooltipState
import androidx.compose.material3.rememberRichTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Preview
@Composable
fun Demo_PlainTooltipBox() {
    val tooltipState = rememberPlainTooltipState()
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PlainTooltipBox(
            tooltip = { Text("Test note") },
            tooltipState = tooltipState
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
        Spacer(Modifier.requiredHeight(30.dp))
        OutlinedButton(
            onClick = { scope.launch { tooltipState.show() } },
        ) {
            Text("Display tooltip")
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun Demo_RichTooltipBox() {
    val tooltipState = rememberRichTooltipState(isPersistent = false)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(
            onClick = { }
        ) {
            Text("Button 1")
        }

        OutlinedButton(
            onClick = { }
        ) {
            Text("Button 2")
        }

        RichTooltipBox(
            text = { Text("Show tooltip message on the screen") },
            tooltipState = tooltipState
        ) {
            OutlinedButton(
                onClick = { scope.launch { tooltipState.show() } },
            ) {
                Text("Display tooltip")
            }
        }
    }
}