package com.alexzh.composeplayground.ui.demo.checkbox

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Demo_TriStateCheckbox() {
    var option1State by remember { mutableStateOf(false) }
    var option2State by remember { mutableStateOf(false) }

    val parentState = remember(option1State, option2State) {
        if (option1State && option2State) ToggleableState.On
        else if (!option1State && !option2State) ToggleableState.Off
        else ToggleableState.Indeterminate
    }

    Column {
        Spacer(modifier = Modifier.height(60.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    option1State = newState
                    option2State = newState
                }
            )
            Text(text = "Options")
        }

        // Checkbox + Text
        CheckboxItem(name = "Option 1", checked = option1State, onCheckedChange = {
            option1State = it
        })

        // Checkbox + Text
        CheckboxItem(name = "Option 2", checked = option2State, onCheckedChange = {
            option2State = it
        })
    }
}

@Composable
fun CheckboxItem(
    modifier: Modifier = Modifier,
    name: String,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    Row(
        modifier = modifier.padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text = name)
    }
}