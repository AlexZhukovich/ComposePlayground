package com.alexzh.composeplayground.ui.demo.subscription

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SubscriptionContainer(
    placeholderText: String = "Enter your email",
    subscribeText: String = "SUBSCRIBE",
    undoText: String = "UNDO",
    successfulSubscriptionMessage: String = "You successfully subscribed"
) {
    val text = remember { mutableStateOf("") }
    val isSubscribed = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(72.dp)
                .padding(vertical = 8.dp)
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(30.dp))
                .clip(RoundedCornerShape(30.dp))

        ) {
            TextField(
                value = text.value,
                onValueChange = { text.value = it },
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1.0f)
                    .testTag("subscribe_email"),
                placeholder = { Text(placeholderText) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                maxLines = 1,
                shape = RoundedCornerShape(0.dp)
            )
            Button(
                onClick = { isSubscribed.value = true },
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = subscribeText,
                )
            }
        }
        if (isSubscribed.value) {
            Snackbar(
                action = {
                    Text(
                        undoText,
                        color = Color.Yellow,
                        modifier = Modifier.padding(top = 8.dp )
                            .clickable { isSubscribed.value = !isSubscribed.value }
                    )
                }
            ) { Text(successfulSubscriptionMessage) }
        }
    }
}

@Preview
@Composable
fun Preview_SubscriptionContainer() {
    SubscriptionContainer()
}