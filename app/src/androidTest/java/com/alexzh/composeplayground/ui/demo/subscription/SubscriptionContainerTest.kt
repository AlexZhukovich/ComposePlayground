package com.alexzh.composeplayground.ui.demo.subscription

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class SubscriptionContainerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldDisplaySnackbar_whenEmailIsEnteredAndSubscribeButtonClicked() {
        composeTestRule.apply {
            setContent { SubscriptionContainer() }

            onNode(hasTestTag("subscribe_email"))
                .performTextInput("test@test.com")

            onNode(hasText("SUBSCRIBE"))
                .performClick()

            onNode(hasText("You successfully subscribed"))
                .assertIsDisplayed()
        }
    }
}