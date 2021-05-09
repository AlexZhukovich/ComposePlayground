package com.alexzh.composeplayground.ui.demo.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.alexzh.composeplayground.R

/**
 * Jetpack Compose: Box layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-box
 */
@Preview(name = "Box layout")
@Composable
fun DemoBoxLayout_1() {
    Box(
        modifier = Modifier.size(height = 120.dp, width = 300.dp)
    ) {
        Text(text = "Very important text", fontSize = 20.sp)
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", fontSize = 20.sp)
    }
}

@Preview(name = "Box layout - align modifier")
@Composable
fun DemoBoxLayout_2() {
    Box(
        modifier = Modifier.size(height = 120.dp, width = 300.dp)
    ) {
        Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

/**
 * Jetpack Compose: Column layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-column
 */
@Preview(name = "Column layout")
@Composable
fun DemoColumnLayout_1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso"
        )
        Text(
            text = "Espresso",
            fontSize = 50.sp
        )
    }
}

@Preview(name = "Column layout - weight modifier")
@Composable
fun DemoColumnLayout_2() {
    Column(modifier = Modifier.height(200.dp)) {
        Text(
            text = "Very important text",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color.White)
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.LightGray)
        )
    }
}

/**
 * Jetpack Compose: Row layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-row
 */
@Preview(name = "Row layout")
@Composable
fun DemoRowLayout_1() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "Espresso",
            fontSize = 30.sp
        )
    }
}

@Preview(name = "Row layout - weight modifier")
@Composable
fun DemoRowLayout_2() {
    Row(modifier = Modifier.height(200.dp)) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .background(Color.White)
        )
        Text(
            text = "Very important text",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.LightGray)
        )
    }
}

/**
 * Jetpack Compose: Combination of Row and Column layouts
 */
@Preview(name = "Combination of Row and Column layouts - coffee drink card")
@Composable
fun DemoColumnAndRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso",
            modifier = Modifier.size(100.dp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = "Espresso",
                fontSize = 24.sp
            )
            Text(
                text = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
                style = TextStyle(textAlign = TextAlign.Justify)
            )
        }
    }
}

/**
 * Jetpack Compose: ConstraintLayout layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-constraint-layout
 */
@Preview(name = "ConstraintLayout - coffee drink card")
@Composable
fun DemoConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (logo, title, description) = createRefs()

        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.espresso_small),
            contentDescription = "Espresso",
            modifier = Modifier
                .size(100.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = "Espresso",
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                linkTo(start = logo.end, end = parent.end, startMargin = 8.dp, endMargin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )
        Text(
            text = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
            style = TextStyle(textAlign = TextAlign.Justify),
            modifier = Modifier.constrainAs(description) {
                top.linkTo(title.bottom)
                linkTo(start = title.start, end = title.end)
                width = Dimension.fillToConstraints
            }
        )
    }
}

/**
 * Jetpack Compose: Scaffold layout
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#layouts-scaffold
 */
@Preview(name = "Scaffold layout - topAppBar and content")
@Composable
fun DemoScaffoldLayout_1() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Title") })
        },
        content = {
            Text(
                text = "Content",
                fontSize = 40.sp
            )
        }
    )
}

@Preview(name = "Scaffold layout - topAppBar, bottomBar, floatingActionButton and content")
@Composable
fun DemoScaffoldLayout_2() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Title") }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Item 1",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Item 2",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Item 3",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
        },
        drawerContent = {
            Text(text = "Drawer")
        },
        content = {
            Text(
                text = "Content",
                fontSize = 40.sp
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Text(text = "＋")
            }
        }
    )
}