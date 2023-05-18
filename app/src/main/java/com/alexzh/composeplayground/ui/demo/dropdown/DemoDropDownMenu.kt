package com.alexzh.composeplayground.ui.demo.dropdown

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.saket.cascade.CascadeDropdownMenu

/**
 * Jetpack Compose: DropDown menu.
 * Example of creating a DropDownMenu in Jetpack Compose.
 *
 * Note: The preview shows pop-up in a wrong place. Please use a device or emulator for verification.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-dropdownmenu/
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_DropDownMenu() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.height(200.dp),
        topBar = {
            TopAppBar(
                title = { },
                actions = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More menu"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE3E3E3)),
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFE3E3E3))
                .wrapContentSize(Alignment.TopEnd)
        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(
                    text = { Text("Load") },
                    onClick = { Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show() },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Image,
                            contentDescription = "More menu"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "More menu"
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text("Save") },
                    onClick = { Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show() }
                )
            }
        }
    }
}

/**
 * Jetpack Compose: DropDown menu.
 * Example of creating a ExposedDropdownMenuBox in Jetpack Compose.
 *
 * Note: The preview didn't work properly. Please use a device or emulator for verification.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-dropdownmenu/#creating-an-exposeddropdownmenubox
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_ExposedDropdownMenuBox() {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color(0xFFE3E3E3))
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

/**
 * Jetpack Compose: DropDown menu.
 * Example of creating an ExposedDropdownMenuBox and styling selected item in a list in Jetpack Compose.
 *
 * Note: The preview didn't work properly. Please use a device or emulator for verification.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-dropdownmenu/#changing-style-of-selected-menu-item
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_ExposedDropdownMenuBox_SelectionStyling() {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    var expanded by remember { mutableStateOf(false) }
    var selectedItemIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color(0xFFE3E3E3))
            .padding(32.dp)
    ) {

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.padding(16.dp),
        ) {
            TextField(
                value = coffeeDrinks[selectedItemIndex],
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = item,
                            fontWeight = if (index == selectedItemIndex) FontWeight.Bold else null
                            )
                        },
                        onClick = {
                            selectedItemIndex = index
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }

    }
}

/**
 * Jetpack Compose: DropDown menu.
 * Example of creating a CascadeDropdownMenu in Jetpack Compose.
 *
 * Note: The preview didn't work properly. Please use a device or emulator for verification.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-dropdownmenu/#creating-a-cascadedropdownmenu
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_CascadeDropdownMenu() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.height(300.dp),
        topBar = {
            TopAppBar(
                title = { },
                actions = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More menu"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE3E3E3)),
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE3E3E3))
                .padding(paddingValues)
                .wrapContentSize(Alignment.TopEnd)
                .padding(end = 8.dp)
        ) {
            CascadeDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "1. Item") },
                    childrenHeader = {},
                    children = {
                        DropdownMenuItem(
                            text = { Text(text = "1.1. Sub-Item") },
                            onClick = {
                                expanded = false
                                Toast.makeText(context, "1.1. Sub-Item", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "2. Item") },
                    children = {
                        DropdownMenuItem(
                            text = { Text(text = "2.1. Sub-Item") },
                            onClick = {
                                expanded = false
                                Toast.makeText(context, "2.1. Sub-Item", Toast.LENGTH_SHORT).show()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "2.2. Sub-Item") },
                            children = {
                                DropdownMenuItem(
                                    text = { Text(text = "2.2.1. Sub-Sub-Item") },
                                    onClick = {
                                        expanded = false
                                        Toast.makeText(
                                            context,
                                            "2.2.1. Sub-Sub-Item",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                )
                            }
                        )
                    }
                )
            }
        }
    }
}

/**
 * Jetpack Compose: DropDown menu.
 * Example of creating a searchable ExposedDropdownMenuBox in Jetpack Compose.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-dropdownmenu/#creating-a-searchable-dropdown-menu
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_SearchableExposedDropdownMenuBox() {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color(0xFFE3E3E3))
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                label = { Text(text = "Start typing the name of the coffee") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            val filteredOptions =
                coffeeDrinks.filter { it.contains(selectedText, ignoreCase = true) }
            if (filteredOptions.isNotEmpty()) {
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        // We shouldn't hide the menu when the user enters/removes any character
                    }
                ) {
                    filteredOptions.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedText = item
                                expanded = false
                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Jetpack Compose: DropDown menu.
 * Example of creating a "Units" screen with different dropdown menu components.
 *
 * Note:
 * - This screen is created only for demonstrating testing approaches.
 * - The preview didn't work properly. Please use a device or emulator for verification.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Demo_UnitsScreen() {
    val context = LocalContext.current

    var nestedMenuExpanded by remember { mutableStateOf(false) }
    var moreMenuExpanded by remember { mutableStateOf(false) }

    val temperatureUnits = listOf("Celsius (°C)", "Fahrenheit (°F)")
    var temperatureUnitsExpanded by remember { mutableStateOf(false) }
    var selectedTemperatureItem by remember { mutableStateOf(temperatureUnits.first()) }

    val distanceUnits = listOf("Kilometers", "Miles")
    var distanceUnitsExpanded by remember { mutableStateOf(false) }
    var selectedDistanceItem by remember { mutableStateOf(distanceUnits.first()) }

    val speedUnits = listOf("Kilometer/Hour", "Mile/Hour", "Meter/Second", "Kilometer/Second")
    var speedUnitsExpanded by remember { mutableStateOf(false) }
    var selectedSpeedItem by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Units") },
                actions = {
                    IconButton(onClick = { nestedMenuExpanded = !nestedMenuExpanded }) {
                        Icon(
                            imageVector = Icons.Outlined.Warning,
                            contentDescription = "Nested menu"
                        )
                    }
                    IconButton(onClick = { moreMenuExpanded = !moreMenuExpanded }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More menu"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .background(Color.Red)
                .wrapContentSize(Alignment.TopEnd)
        ) {
            DropdownMenu(
                expanded = moreMenuExpanded,
                onDismissRequest = { moreMenuExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Load") },
                    onClick = {
                        moreMenuExpanded = false
                        Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                    },
                    enabled = false
                )
                DropdownMenuItem(
                    text = { Text("Save") },
                    onClick = {
                        moreMenuExpanded = false
                        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                    }
                )
                Divider()
                DropdownMenuItem(
                    text = { Text("Reset") },
                    onClick = {
                        moreMenuExpanded = false
                        Toast.makeText(context, "Reset", Toast.LENGTH_SHORT).show()
                    }
                )
            }

            CascadeDropdownMenu(
                expanded = nestedMenuExpanded,
                onDismissRequest = { nestedMenuExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "1. Item") },
                    children = {
                        DropdownMenuItem(
                            text = { Text(text = "1.1. Sub-Item") },
                            onClick = {
                                nestedMenuExpanded = false
                                Toast.makeText(context, "1.1. Sub-Item", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                )
                DropdownMenuItem(
                    text = { Text(text = "2. Item") },
                    children = {
                        DropdownMenuItem(
                            text = { Text(text = "2.1. Sub-Item") },
                            onClick = {
                                nestedMenuExpanded = false
                                Toast.makeText(context, "2.1. Sub-Item", Toast.LENGTH_SHORT).show()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "2.2. Sub-Item") },
                            children = {
                                DropdownMenuItem(
                                    text = { Text(text = "2.2.1. Sub-Sub-Item") },
                                    onClick = {
                                        nestedMenuExpanded = false
                                        Toast.makeText(context, "2.2.1. Sub-Sub-Item", Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        )
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // Temperature
            ExposedDropdownMenuBox(
                expanded = temperatureUnitsExpanded,
                onExpandedChange = {
                    temperatureUnitsExpanded = !temperatureUnitsExpanded
                }
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    value = selectedTemperatureItem,
                    label = { Text(text = "Temperature") },
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = temperatureUnitsExpanded)
                    }
                )

                ExposedDropdownMenu(
                    expanded = temperatureUnitsExpanded,
                    onDismissRequest = { temperatureUnitsExpanded = false }
                ) {
                    temperatureUnits.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedTemperatureItem = item
                                temperatureUnitsExpanded = false
                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }

            // Distance
            ExposedDropdownMenuBox(
                expanded = distanceUnitsExpanded,
                onExpandedChange = {
                    distanceUnitsExpanded = !distanceUnitsExpanded
                }
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    value = selectedDistanceItem,
                    label = { Text(text = "Distance") },
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = distanceUnitsExpanded)
                    }
                )

                ExposedDropdownMenu(
                    expanded = distanceUnitsExpanded,
                    onDismissRequest = { distanceUnitsExpanded = false }
                ) {
                    distanceUnits.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedDistanceItem = item
                                distanceUnitsExpanded = false
                                Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }

            // Speed
            ExposedDropdownMenuBox(
                expanded = speedUnitsExpanded,
                onExpandedChange = { speedUnitsExpanded = !speedUnitsExpanded }
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    value = selectedSpeedItem,
                    label = { Text(text = "Speed") },
                    onValueChange = { selectedSpeedItem = it },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = speedUnitsExpanded)
                    }
                )

                val filteredOptions = speedUnits.filter { it.contains(selectedSpeedItem, ignoreCase = true) }
                if (filteredOptions.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = speedUnitsExpanded,
                        onDismissRequest = { }
                    ) {
                        filteredOptions.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(text = item) },
                                onClick = {
                                    selectedSpeedItem = item
                                    speedUnitsExpanded = false
                                    Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}