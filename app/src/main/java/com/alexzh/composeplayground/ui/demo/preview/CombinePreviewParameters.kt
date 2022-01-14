package com.alexzh.composeplayground.ui.demo.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

open class TripleCombinedPreviewParameter<T1, T2, T3>(
    private val provider: Triple<PreviewParameterProvider<T1>, PreviewParameterProvider<T2>, PreviewParameterProvider<T3>>
) : PreviewParameterProvider<Triple<T1, T2, T3>> {
    override val values: Sequence<Triple<T1, T2, T3>>
        get() = provider.first.values.flatMap { first ->
            provider.second.values.flatMap { second ->
                provider.third.values.map { third ->
                    Triple(first, second, third)
                }
            }
        }
}

open class PairCombinedPreviewParameter<T1, T2>(
    private val provider: Pair<PreviewParameterProvider<T1>, PreviewParameterProvider<T2>>
) : PreviewParameterProvider<Pair<T1, T2>> {
    override val values: Sequence<Pair<T1, T2>>
        get() = provider.first.values.flatMap { first ->
            provider.second.values.map { second ->
                first to second
            }
        }
}