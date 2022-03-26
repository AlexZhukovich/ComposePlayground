package com.alexzh.composeplayground.ui.demo.radiobutton

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.R
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class RadioButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun firstItemSelectedByDefaultUseRadioButtons_whenThirdItemIsSelected_thenSelectedValueDisplayedCorrectly() {
        composeTestRule.apply {
            setContent {
                val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
                val selectedValue = remember { mutableStateOf(items.first()) }

                val isItemSelected: (String) -> Boolean = { selectedValue.value == it }

                Column(Modifier.padding(8.dp)) {
                    Text(text = "Selected value: ${selectedValue.value}")
                    items.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.selectable(
                                selected = isItemSelected(item),
                                onClick = { selectedValue.value = item },
                                role = Role.RadioButton
                            )
                        ) {
                            RadioButton(
                                selected = isItemSelected(item),
                                onClick = null,
                            )
                            Text(text = item)
                        }
                    }
                }
            }

            onNodeWithRoleAndText(Role.RadioButton, "Item 1")
                .assertIsSelected()

            onNodeWithText("Item 3")
                .performClick()

            onNodeWithRoleAndText(Role.RadioButton, "Item 3")
                .assertIsSelected()

            onNodeWithText("Selected value: Item 3")
                .assertIsDisplayed()
        }
    }

    @Test
    fun firstItemSelectedByDefaultUseIconToggleButton_whenThirdItemIsSelected_thenSelectedValueDisplayedCorrectly() {
        composeTestRule.apply {
            setContent {
                val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
                val selectedValue = remember { mutableStateOf(items.first()) }

                val isItemSelected: (String) -> Boolean = { selectedValue.value == it }

                Column(Modifier.padding(8.dp)) {
                    Text(text = "Selected value: ${selectedValue.value}")
                    items.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.selectable(
                                selected = isItemSelected(item),
                                onClick = { selectedValue.value = item },
                                role = Role.RadioButton
                            )
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
                            Text(text = item)
                        }
                    }
                }
            }

            onNodeWithRoleAndText(Role.RadioButton, "Item 1")
                .assertIsSelected()

            onNodeWithText("Item 3")
                .performClick()

            onNodeWithRoleAndText(Role.RadioButton, "Item 3")
                .assertIsSelected()

            onNodeWithText("Selected value: Item 3")
                .assertIsDisplayed()
        }
    }

    private fun withRole(role: Role): SemanticsMatcher {
        return SemanticsMatcher("${SemanticsProperties.Role.name} contains '$role'") {
            it.config.getOrNull(SemanticsProperties.Role) == role
        }
    }

    private fun SemanticsNodeInteractionsProvider.onNodeWithRoleAndText(
        role: Role,
        text: String
    ) = onNode(
        withRole(role)
            .and(isSelectable())
            .and(isEnabled())
            .and(hasText(text))
    )
}