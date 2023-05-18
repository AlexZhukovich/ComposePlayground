@file:OptIn(ExperimentalMaterial3Api::class)

package com.alexzh.composeplayground.ui.demo.switch

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.alexzh.composeplayground.R
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalFoundationApi
class SwitchTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun shouldSubItemsBeDisabled_whenParentItemIsUnchecked() {
        composeTestRule.apply {
            setContent { SettingsScreen() }

            onSettingSwitchItem(
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_item_title),
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_item_description),
            ).assertIsOff()

            onSettingSwitchItem(
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem1_title),
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem1_description),
            ).assertIsNotEnabled()

            onSettingSwitchItem(
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem2_title),
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem2_description),
            ).assertIsNotEnabled()
        }
    }

    @Test
    fun shouldSubItemsBeEnabled_whenParentItemIsChecked() {
        composeTestRule.apply {
            setContent { SettingsScreen() }

            onSettingSwitchItem(
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_item_title),
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_item_description),
            ).performClick()

            onSettingSwitchItem(
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem1_title),
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem1_description),
            ).assertIsEnabled()

            onSettingSwitchItem(
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem2_title),
                composeTestRule.activity.getString(R.string.demoSwitchSettings_super_important_subitem2_description),
            ).assertIsEnabled()
        }
    }
}

private fun SemanticsNodeInteractionsProvider.onSettingSwitchItem(
    title: String,
    description: String
) = onNode(
    SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Switch)
        .and(hasText(title, substring = true))
        .and(hasText(description, substring = true))
)