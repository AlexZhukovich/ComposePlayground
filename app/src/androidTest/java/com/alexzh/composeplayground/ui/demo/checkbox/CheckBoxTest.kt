package com.alexzh.composeplayground.ui.demo.checkbox

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.*
import androidx.compose.ui.test.SemanticsMatcher.Companion.expectValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.ui.model.SelectableItem
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class CheckBoxTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun noItemsSelectedByDefault_whenFirstAndThirdAndFourthItemsAreSelected_thenAllSelectedValuesDisplayedOnTheScreen() {
        composeTestRule.apply {
            setContent {
                val items = listOf(
                    SelectableItem("Item 1"),
                    SelectableItem("Item 2"),
                    SelectableItem("Item 3"),
                    SelectableItem("Item 4"),
                    SelectableItem("Item 5")
                )
                val selectedItems = remember { mutableStateOf(items) }

                val isItemSelected: (SelectableItem) -> Boolean = { item ->
                    selectedItems.value.first { it.text == item.text }.isSelected
                }
                val changeItemState: (String, Boolean) -> Unit = { item, isSelected ->
                    val index = selectedItems.value.indexOfFirst { it.text == item }
                    selectedItems.value = selectedItems.value.toMutableList().apply {
                        this[index] = this[index].copy(isSelected = isSelected)
                    }
                }

                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = "Selected value: ${selectedItems.value.filter { it.isSelected }. joinToString { it.text }}"
                    )
                    items.forEach { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.selectable(
                                selected = isItemSelected(item),
                                onClick = { changeItemState(item.text, !item.isSelected) },
                                role = Role.Checkbox
                            )
                        ) {
                            Checkbox(
                                checked = isItemSelected(item),
                                onCheckedChange = null,
                            )
                            Text(text = item.text)
                        }
                    }
                }
            }

            onNodeWithRoleAndText(Role.Checkbox, "Item 1")
                .performClick()

            onNodeWithRoleAndText(Role.Checkbox, "Item 3")
                .performClick()

            onNodeWithRoleAndText(Role.Checkbox, "Item 4")
                .performClick()

            onNodeWithText("Selected value: Item 1, Item 3, Item 4")
                .assertIsDisplayed()
        }
    }

    private fun SemanticsNodeInteractionsProvider.onNodeWithRoleAndText(
        role: Role,
        text: String
    ) = onNode(
        expectValue(SemanticsProperties.Role, role)
            .and(isSelectable())
            .and(isEnabled())
            .and(hasText(text))
    )
}