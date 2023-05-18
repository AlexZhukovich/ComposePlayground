package com.alexzh.composeplayground.ui.demo.switch

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.R
import com.alexzh.composeplayground.ui.model.SelectableItem

/**
 * Jetpack Compose: Switch.
 * Example of creating a list of switch items.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-switch/
 */
@Preview
@Composable
fun Preview_SwitchWithLabel() {
    @Composable
    fun SelectableListWithMultiSelectionAndSummary(
        items: List<SelectableItem>,
        itemRole: Role,
        itemContent: @Composable RowScope.(SelectableItem) -> Unit
    ) {
        val selectedItems = remember { mutableStateOf(items) }
        val changeItemState: (String, Boolean) -> Unit = { item, isSelected ->
            selectedItems.value = selectedItems.value.toMutableList().apply {
                val index = selectedItems.value.indexOfFirst { it.text == item }
                this[index] = this[index].copy(isSelected = isSelected)
            }
        }
        val selectedValuesOrNone: () -> String = {
            selectedItems.value
                .filter { it.isSelected }
                .joinToString { it.text }
                .ifEmpty { "NONE" }
        }

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Selected value: ${selectedValuesOrNone()}",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            selectedItems.value.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = item.isSelected,
                            onClick = { changeItemState(item.text, !item.isSelected) },
                            role = itemRole
                        )
                ) {
                    itemContent(item)
                }
            }
        }
    }

    val items = listOf(
        SelectableItem("Item 1"),
        SelectableItem("Item 2"),
        SelectableItem("Item 3"),
        SelectableItem("Item 4"),
        SelectableItem("Item 5"),
        SelectableItem("Item 6"),
        SelectableItem("Item 7")

    )
    SelectableListWithMultiSelectionAndSummary(
        items = items,
        itemRole = Role.Switch,
        itemContent = { item ->
            Text(
                text = item.text,
                modifier = Modifier.weight(1.0f)
            )
            Switch(
                checked = item.isSelected,
                onCheckedChange = null,
            )
        }
    )
}

/**
 * Jetpack Compose: Switch.
 * Example of customization track, thumb and border colors.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-switch/#customizing-the-switch-component
 */
@Preview
@Composable
fun Demo_SwitchComponent() {
    val switchCheckedState by remember { mutableStateOf(true) }
    val switchUncheckedState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // TRACK AND THUMB COLORS
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Switch(
                    checked = true,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )

                Switch(
                    checked = true,
                    onCheckedChange = {  },
                    enabled = false,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Switch(
                    checked = false,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )

                Switch(
                    checked = false,
                    onCheckedChange = {  },
                    enabled = false,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )
            }
        }

        Divider()

        // THUMB ICON COLOR
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Switch(
                    checked = switchCheckedState,
                    onCheckedChange = {  },
                    thumbContent = {
                        Icon(
                            imageVector = if (switchCheckedState) Icons.Filled.Check else Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    },

                    //imageVector = if (switchCheckedState) Icons.Filled.Check else Icons.Filled,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )

                Switch(
                    checked = switchCheckedState,
                    onCheckedChange = {  },
                    enabled = false,
                    thumbContent = {
                        Icon(
                            imageVector = if (switchCheckedState) Icons.Filled.Check else Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                    )
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Switch(
                    checked = switchUncheckedState,
                    onCheckedChange = {  },
                    thumbContent = {
                        Icon(
                            imageVector = if (switchUncheckedState) Icons.Filled.Check else Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )

                Switch(
                    checked = switchUncheckedState,
                    onCheckedChange = {  },
                    enabled = false,
                    thumbContent = {
                        Icon(
                            imageVector = if (switchUncheckedState) Icons.Filled.Check else Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled)
                    )
                )
            }
        }

        Divider()

        // BORDER COLOR
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Switch(
                    checked = switchCheckedState,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedBorderColor = Color.Green,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedBorderColor = Color.Red,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedBorderColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedBorderColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                    )
                )

                Switch(
                    checked = switchCheckedState,
                    onCheckedChange = {  },
                    enabled = false,
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedBorderColor = Color.Green,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedBorderColor = Color.Red,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedBorderColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedBorderColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                    )
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Switch(
                    checked = switchUncheckedState,
                    onCheckedChange = {  },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedBorderColor = Color.Green,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedBorderColor = Color.Red,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedBorderColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedBorderColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                    )
                )

                Switch(
                    checked = switchUncheckedState,
                    onCheckedChange = {  },
                    enabled = false,
                    /*
                    The "checkedIconColor" and "uncheckedIconColor" excluded from this list
                    because you need to set an icon first, use the "thumbContent" parameter.
                    You can find an example in the next section.
                     */
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Green,
                        checkedTrackColor = Color.LightGray,
                        checkedBorderColor = Color.Green,
                        checkedIconColor = Color.DarkGray,
                        uncheckedThumbColor = Color.Red,
                        uncheckedTrackColor = Color.LightGray,
                        uncheckedBorderColor = Color.Red,
                        uncheckedIconColor = Color.LightGray,
                        disabledCheckedThumbColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledCheckedBorderColor = Color.Green.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedThumbColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedTrackColor = Color.LightGray.copy(alpha = ContentAlpha.disabled),
                        disabledUncheckedBorderColor = Color.Red.copy(alpha = ContentAlpha.disabled),
                    )
                )
            }
        }
    }
}

/**
 * Jetpack Compose: Switch.
 * Example of creating "SettingsScreen" which includes "SettingSwitchItem" components.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-switch/#creating-a-setting-switch-item
 */
@ExperimentalMaterial3Api
@Preview
@Composable
fun SettingsScreen() {
    @Composable fun SettingSwitchItem(
        modifier: Modifier = Modifier,
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        @StringRes title: Int,
        @StringRes description: Int,
        enabled: Boolean = true,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .toggleable(
                    value = checked,
                    enabled = enabled,
                    role = Role.Switch,
                    onValueChange = onCheckedChange
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1.0f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val contentAlpha = if (enabled) ContentAlpha.high else ContentAlpha.disabled

                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    modifier = Modifier.alpha(contentAlpha)
                )
                Text(
                    text = stringResource(id = description),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.alpha(contentAlpha)
                )
            }

            Switch(
                checked = checked,
                onCheckedChange = null,
                enabled = enabled
            )
        }
    }

    var item1EnabledState by remember { mutableStateOf(false) }
    var item1SubItem1EnabledState by remember { mutableStateOf(false) }
    var item1SubItem2EnabledState by remember { mutableStateOf(false) }
    var item2EnabledState by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title =  { Text(text = "Settings") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            SettingSwitchItem(
                title = R.string.demoSwitchSettings_super_important_item_title,
                description = R.string.demoSwitchSettings_super_important_item_description,
                checked = item1EnabledState,
                onCheckedChange = { newState ->
                    item1SubItem1EnabledState = false
                    item1SubItem2EnabledState = false
                    item1EnabledState = newState
                }
            )

            SettingSwitchItem(
                title = R.string.demoSwitchSettings_super_important_subitem1_title,
                description = R.string.demoSwitchSettings_super_important_subitem1_description,
                checked = item1SubItem1EnabledState,
                onCheckedChange = { item1SubItem1EnabledState = it },
                enabled = item1EnabledState,
                modifier = Modifier.padding(start = 8.dp)
            )

            SettingSwitchItem(
                title = R.string.demoSwitchSettings_super_important_subitem2_title,
                description = R.string.demoSwitchSettings_super_important_subitem2_description,
                checked = item1SubItem2EnabledState,
                onCheckedChange = { item1SubItem2EnabledState = it },
                enabled = item1EnabledState,
                modifier = Modifier.padding(start = 8.dp)
            )

            Divider()

            SettingSwitchItem(
                title = R.string.demoSwitchSettings_important_item_title,
                description = R.string.demoSwitchSettings_important_item_description,
                checked = item2EnabledState,
                onCheckedChange = { item2EnabledState = it },
            )
        }
    }
}