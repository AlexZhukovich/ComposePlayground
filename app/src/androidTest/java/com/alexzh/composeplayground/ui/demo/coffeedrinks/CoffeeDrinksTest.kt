package com.alexzh.composeplayground.ui.demo.coffeedrinks

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

@ExperimentalFoundationApi
class CoffeeDrinksTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    /**
     * Example of test case which demonstrates how to interact with items based on index.
     */
    @Test
    fun verifyPriceForTwoAmericanoAndOneEspressoByCoffeeDrinkIndex() {
        composeTestRule.apply {
            setContent { CoffeeDrinksWithBasket(drinks = coffeeDrinks) }

            onAllNodesWithText("＋")[0]
                .performClick()
                .performClick()

            onAllNodes(hasText("＋"))[2]
                .performClick()

            onNode(hasText("Pay (€ 18.0)"))
                .assertIsDisplayed()
        }
    }

    /**
     * Example of test case which demonstrates how to interact with items based on custom matchers.
     */
    @Test
    fun verifyPriceForTwoAmericanoAndOneEspressoByCoffeeDrinkName() {
        composeTestRule.apply {
            setContent { CoffeeDrinksWithBasket(drinks = coffeeDrinks) }

            onNodeWithIncrementForCoffeeDrink("Americano")
                .performClick()
                .performClick()

            onNodeWithIncrementForCoffeeDrink("Espresso")
                .performClick()

            onNode(hasText("Pay (€ 18.0)"))
                .assertIsDisplayed()
        }
    }
}

fun withIncrementForCoffeeDrink(text: String): SemanticsMatcher {
    return hasText("＋")
        .and(hasAnyAncestor(hasAnyChild(hasText(text))))
}

fun SemanticsNodeInteractionsProvider.onNodeWithIncrementForCoffeeDrink(text: String) =
    onNode(withIncrementForCoffeeDrink(text))