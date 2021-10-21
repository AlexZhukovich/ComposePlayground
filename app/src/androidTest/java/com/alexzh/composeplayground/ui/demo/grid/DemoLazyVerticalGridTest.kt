package com.alexzh.composeplayground.ui.demo.grid

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class DemoLazyVerticalGridTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldShowSnackbarWithSelectedItem_whenGridItemClicked() {
        composeTestRule.apply {
            setContent {
                DemoEmojiGallery()
            }

            onNodeWithText("☕️")
                .performClick()

            onNodeWithText("☕️ was selected")
                .assertIsDisplayed()
        }
    }
}