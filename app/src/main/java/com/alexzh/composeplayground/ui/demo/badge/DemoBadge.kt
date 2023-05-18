package com.alexzh.composeplayground.ui.demo.badge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Preview
@Composable
fun Demo_IconWithBadge() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = { Text(text = "123") }
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                imageVector = Icons.Filled.Email,
                contentDescription = "Messages"
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = { Text(text = "42") }
                )
            }
        ) {
            Text(text = "Test message")
        }

        BadgedBox(
            badge = {
                Badge(
                    modifier = Modifier.size(20.dp).padding(0.dp),
                    content = {
                        Icon(Icons.Filled.Notifications, contentDescription = "notifications")
                    },
                    containerColor = Color.Blue
                )
            }
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                imageVector = Icons.Filled.Email,
                contentDescription = "Messages"
            )
        }
    }
}