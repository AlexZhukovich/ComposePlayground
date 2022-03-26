package com.alexzh.composeplayground.ui.demo.radiobutton

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.R

@Preview
@Composable
fun Preview_SingleRadioButton() {
    val selectedValue = remember { mutableStateOf("") }
    val label = "Item"
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedValue.value == label,
            onClick = { selectedValue.value = label }
        )
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun Preview_MultipleRadioButtons() {
    val selectedValue = remember { mutableStateOf("") }

    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    Column(Modifier.padding(8.dp)) {
        Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.selectable(
                    selected = isSelectedItem(item),
                    onClick = { onChangeState(item) },
                    role = Role.RadioButton
                ).padding(8.dp)
            ) {
                RadioButton(
                    selected = isSelectedItem(item),
                    onClick = null
                )
                Text(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview_MultipleRadioButtonsWithCustomColors() {
    val selectedValue = remember { mutableStateOf("") }
    val textToEnableList = listOf(
        "Item 1" to true,
        "Item 2" to true,
        "Item 3" to true,
        "Item 4" to false,
        "Item 5" to true
    )

    val isSelectedItem: (String) -> Boolean = { selectedValue.value == it }
    val onChangeState: (String) -> Unit = { selectedValue.value = it }

    Column(Modifier.padding(8.dp)) {
        Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
        textToEnableList.forEach { textToEnableState ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.selectable(
                    selected = isSelectedItem(textToEnableState.first),
                    enabled = textToEnableState.second,
                    onClick = { onChangeState(textToEnableState.first) }
                ).padding(8.dp)
            ) {
                RadioButton(
                    selected = isSelectedItem(textToEnableState.first),
                    onClick = null,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Red,
                        disabledColor = Color.LightGray
                    ),
                    enabled = textToEnableState.second
                )
                Text(
                    text = textToEnableState.first,
                    color = when {
                        isSelectedItem(textToEnableState.first) -> Color.Green
                        !textToEnableState.second -> Color.LightGray
                        else -> Color.Red
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview_CustomRadioButtonIndicator_WithIconToggleButton() {
    MaterialTheme {
        val selectedValue = remember { mutableStateOf("") }
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        Column(Modifier.padding(8.dp)) {
            Text(text = "Selected value: ${selectedValue.value.ifEmpty { "NONE" }}")
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.selectable(
                        selected = (selectedValue.value == item),
                        onClick = { selectedValue.value = item },
                        role = Role.RadioButton
                    ).padding(8.dp)
                ) {
                    IconToggleButton(
                        checked = selectedValue.value == item,
                        onCheckedChange = { selectedValue.value = item },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                if (selectedValue.value == item) {
                                    R.drawable.ic_circle_checked
                                } else {
                                    R.drawable.ic_circle_outline
                                }
                            ),
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary
                        )
                    }
                    Text(
                        text = item,
                        modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}