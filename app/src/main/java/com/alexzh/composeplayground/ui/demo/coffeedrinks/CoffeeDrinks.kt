package com.alexzh.composeplayground.ui.demo.coffeedrinks

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexzh.composeplayground.R
import java.math.BigDecimal

@Preview
@Composable
fun Preview_CoffeeDrinksWithBasket() {
    CoffeeDrinksWithBasket(
        drinks = coffeeDrinks
    )
}

@Composable
fun CoffeeDrinksWithBasket(
    drinks: List<CoffeeDrink>
) {
    val total = remember { mutableStateOf(BigDecimal.ZERO) }
    val coffeeDrinks = remember { mutableStateOf(drinks) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CoffeeDrinks(
            drinks = coffeeDrinks.value,
            onProductIncreased = { drinkId ->
                val index = coffeeDrinks.value.indexOfFirst { it.id == drinkId }
                total.value += coffeeDrinks.value[index].price
                coffeeDrinks.value = coffeeDrinks.value.toMutableList().apply {
                    this[index] = this[index].copy(amount = this[index].amount + 1)
                }

            },
            onProductDecreased = { drinkId ->
                val index = coffeeDrinks.value.indexOfFirst { it.id == drinkId }
                if (coffeeDrinks.value[index].amount > 0) {
                    total.value -= coffeeDrinks.value[index].price
                    coffeeDrinks.value = coffeeDrinks.value.toMutableList().apply {
                        this[index] = this[index].copy(amount = this[index].amount - 1)
                    }
                }
            }
        )
        Basket(
            total = total.value
        )
    }
}

@Composable
fun CoffeeDrinks(
    drinks: List<CoffeeDrink>,
    onProductIncreased: (Long) -> Unit,
    onProductDecreased: (Long) -> Unit,
) {
    LazyColumn {
        items(drinks) { item ->
            Column {
                Row(
                    modifier = Modifier.padding(8.dp)
                        .semantics(mergeDescendants = false) {}
                ) {
                    Image(
                        painter = painterResource(item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .padding(start = 8.dp)
                    )
                    Column(
                        modifier = Modifier.weight(1.0f)
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = item.name,
                            fontSize = 18.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = item.description,
                            fontSize = 14.sp,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp)
                        )
                    }
                    ProductCounter(
                        coffeeDrink = item,
                        onProductIncreased = onProductIncreased,
                        onProductDecreased = onProductDecreased
                    )
                }
                Divider()
            }
        }
    }
}

@Composable
fun Basket(
    total: BigDecimal
) {
    Row(
        modifier = Modifier.background(Color.Blue)
    ) {
        Text(
            text = "Pay (€ $total)",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun ProductCounter(
    coffeeDrink: CoffeeDrink,
    onProductIncreased: (Long) -> Unit,
    onProductDecreased: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(size = 5.dp),
        border = BorderStroke(1.dp, Color.Gray),
        color = Color.Transparent,
        modifier = modifier.size(width = 40.dp, height = 85.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            // TODO: REPLACE IT TO BUTTON
            Text(
                text = "＋",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,

                modifier = Modifier.height(36.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        onProductIncreased(coffeeDrink.id)
                    }
            )
            Text(
                text = coffeeDrink.amount.toString(),
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            // TODO: REPLACE IT TO BUTTON
            Text(
                text = "—",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(36.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        onProductDecreased(coffeeDrink.id)
                    }
            )
        }
    }
}

val coffeeDrinks = listOf(
    CoffeeDrink(
        id = 1L,
        name = "Americano",
        image = R.drawable.americano_small,
        description = "Americano is a type of coffee drink prepared by diluting an espresso with hot water, giving it a similar strength to, but different flavour from, traditionally brewed coffee. ",
        size = "150 ml",
        price = BigDecimal(6.5)
    ),
    CoffeeDrink(
        id = 2L,
        name = "Cappuccino",
        image = R.drawable.cappuccino_small,
        description = "A cappuccino is an espresso-based coffee drink that originated in Italy, and is traditionally prepared with steamed milk foam.",
        size = "250 ml",
        price = BigDecimal(6.0)
    ),
    CoffeeDrink(
        id = 3L,
        name = "Espresso",
        image = R.drawable.espresso_small,
        description = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
        size = "200 ml",
        price = BigDecimal(5.0)
    )
)

data class CoffeeDrink(
    val id: Long,
    val name: String,
    @DrawableRes val image: Int,
    val description: String,
    val size: String,
    val price: BigDecimal,
    val amount: Int = 0
)