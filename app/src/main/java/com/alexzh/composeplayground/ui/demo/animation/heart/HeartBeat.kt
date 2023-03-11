package com.alexzh.composeplayground.ui.demo.animation.heart

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexzh.composeplayground.R

enum class HeartAnimationState {
    Hidden,
    Shown
}

@Composable
fun AnimatedCoffeeDrink(
    animationState: MutableState<HeartAnimationState>
) {
    val transition = updateTransition(
        targetState = animationState.value,
        label = "Heart Transition"
    )
    val heartSize by transition.animateDp(
        label = "Size Animation",
        transitionSpec = {
            if (HeartAnimationState.Shown isTransitioningTo HeartAnimationState.Hidden) {
                tween(durationMillis = 300)
            } else {
                keyframes {
                    durationMillis = 1600
                    0.0.dp at 0 with FastOutSlowInEasing
                    160.dp at 400 with FastOutSlowInEasing
                    160.dp at 550 with FastOutSlowInEasing
                    100.dp at 900
                    130.dp at 1000 with FastOutSlowInEasing
                    100.dp at 1300 with FastOutSlowInEasing
                }
            }
        }
    ) { state ->
        when (state) {
            HeartAnimationState.Hidden -> 0.dp
            HeartAnimationState.Shown -> 100.dp
        }
    }
    if (transition.currentState == transition.targetState) {
        animationState.value = HeartAnimationState.Hidden
    }
    Image(
        painter = painterResource(id = R.drawable.cappuccino_small),
        contentDescription = "Heart Animation",
        modifier = Modifier.size(heartSize)
    )
}

@Preview
@Composable
fun Preview_AnimatedCoffeeDrink() {
    val state = remember { mutableStateOf(HeartAnimationState.Hidden) }
    LaunchedEffect("LaunchAnimation") {
        state.value = HeartAnimationState.Shown
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(300.dp)
    ) {
        AnimatedCoffeeDrink(state)
    }
}