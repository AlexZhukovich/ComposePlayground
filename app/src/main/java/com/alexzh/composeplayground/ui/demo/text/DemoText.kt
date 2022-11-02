package com.alexzh.composeplayground.ui.demo.text

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

/**
 * Jetpack Compose: Text
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-style-text/
 */
@Preview(name = "Text: basic example")
@Composable
fun DemoText_basic() {
    Text(
        text = "Jetpack Compose: Text",
        color = Color.Green,
        fontSize = 24.sp,
        fontFamily = FontFamily.Monospace,
        letterSpacing = 4.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(300.dp)
    )
}

/**
 * Text: shadow property
 */
@Preview(name = "Text: shadow property")
@Composable
fun DemoText_shadow() {
    Text(
        text = "Jetpack Compose: Text",
        style = TextStyle(
            color = Color.Green,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(8f, 8f),
                blurRadius = 4f
            )
        ),
        modifier = Modifier.width(300.dp)
    )
}

/**
 * Text: combine textDecorations
 */
@Preview(name = "Text: combine textDecorations")
@Composable
fun DemoText_combineTextDecorations() {
    Text(
        text = "Jetpack Compose: Text",
        textDecoration = TextDecoration.combine(
            listOf(
                TextDecoration.Underline,
                TextDecoration.LineThrough
            )
        ),
        fontSize = 24.sp,
        modifier = Modifier.padding(8.dp)
    )
}

/**
 * Text: overflow property
 */
@Preview(name = "Text: overflow property")
@Composable
fun DemoText_overflow() {
    val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida massa laoreet ultrices porttitor."

    Column(
        Modifier.padding(8.dp)
    ) {
        Text(text = "Clip", fontSize = 24.sp)
        Text(
            text = text,
            overflow = TextOverflow.Clip,
            maxLines = 2,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Ellipsis", fontSize = 24.sp)
        Text(
            text = text,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Visible", fontSize = 24.sp)
        Text(
            text = text,
            overflow = TextOverflow.Visible,
            maxLines = 2,
            fontSize = 18.sp
        )
    }
}

/**
 * Text: style property
 */
@Preview(name = "Text: style property")
@Composable
fun DemoText_style_property() {
    Text(
        text = "Jetpack Compose",
        style = TextStyle(
            color = Color.Green,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(8f, 8f),
                blurRadius = 4f
            ),
            textGeometricTransform = TextGeometricTransform(
                scaleX = 2.5f,
                skewX = 1f
            )
        ),
        modifier = Modifier.width(300.dp)
    )
}

/**
 * Text: create AnnotatedString
 */
@Preview(name = "Text: create AnnotatedString")
@Composable
fun DemoText_createAnnotatedString() {
    Column {
        Text(
            text = AnnotatedString(
                text = "Red",
                spanStyle = SpanStyle(Color.Red)
            ).plus(
                AnnotatedString(
                    text = "Green",
                    spanStyle = SpanStyle(Color.Green)
                )
            ).plus(
                AnnotatedString(
                    text = "Blue",
                    spanStyle = SpanStyle(Color.Blue)
                )
            )
        )

        Text(
            text = buildAnnotatedString {
                append(
                    AnnotatedString("Red", spanStyle = SpanStyle(Color.Red))
                )
                append(
                    AnnotatedString("Green", spanStyle = SpanStyle(Color.Green))
                )
                append(
                    AnnotatedString("Blue", spanStyle = SpanStyle(Color.Blue))
                )
            }
        )
    }
}

/**
 * AnnotatedString: append methods
 */
@Preview(name = "AnnotatedString: append methods")
@Composable
fun DemoText_append() {
    Text(
        text = buildAnnotatedString {
            append(
                AnnotatedString("AnnotatedString", spanStyle = SpanStyle(Color.Red))
            )
            append('≠')
            append("String")
        },
        fontSize = 24.sp,
        modifier = Modifier.padding(8.dp)
    )
}

/**
 * AnnotatedString: addStyle method
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-layouts/#arrangement
 */
@Preview(name = "AnnotatedString: addStyle method")
@Composable
fun DemoText_2_addStyle() {
    Text(
        text = buildAnnotatedString {
            append("Jetpack Compose")
            addStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                ),
                start = 0,
                end = 3
            )
            addStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.End
                ),
                start = 8,
                end = 15
            )
            addStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline
                ),
                start = 8,
                end = 15
            )
        },
        fontSize = 24.sp,
        modifier = Modifier.width(300.dp)
            .padding(8.dp)
    )
}

/**
 * AnnotatedString: addStringAnnotation method
 */
@Preview(name = "AnnotatedString: addStringAnnotation method")
@Composable
fun DemoText_addStringAnnotation() {
    val uriTag = "URI"

    val annotatedString = buildAnnotatedString {
        append("Jetpack Compose")
        addStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline
            ),
            start = 8,
            end = 15
        )
        addStringAnnotation(
            tag = uriTag,
            annotation = "https://developer.android.com/jetpack/compose",
            start = 8,
            end = 15
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = annotatedString,
        onClick = { position ->
            val annotations = annotatedString.getStringAnnotations(uriTag, start = position, end = position)
            annotations.firstOrNull()?.let {
                uriHandler.openUri(it.item)
            }
        },
        style = TextStyle(
            fontSize = 24.sp
        ),
        modifier = Modifier.padding(8.dp)
    )
}

/**
 * AnnotatedString: pushStyle and pop methods
 */
@Preview(name = "AnnotatedString: pushStyle and pop methods")
@Composable
fun DemoText_2_pushStyle_pop() {
    Text(
        text = buildAnnotatedString {
            append("Hello, ")

            pushStyle(style = SpanStyle(color = Color.Green))
            append("this ")
            append("is ")
            append("example ")
            append("of ")
            append("pushStyle ")
            pop()

            pushStyle(style = SpanStyle(color = Color.Red))
            append("and ")
            append("pop ")
            pop()

            append("methods")
        },
        fontSize = 24.sp,
        modifier = Modifier.padding(8.dp)
    )
}

/**
 * AnnotatedString: textIndent property
 */
@Preview(name = "AnnotatedString: textIndent property")
@Composable
fun DemoText_textIndent_property() {
    val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida massa laoreet ultrices porttitor."

    Text(
        text = buildAnnotatedString {
            append(
                AnnotatedString(
                    text = text,
                    paragraphStyle = ParagraphStyle(
                        textIndent = TextIndent(
                            firstLine = 20.sp,
                            restLine = 40.sp
                        )
                    )
                )
            )
            append("Test")
        },
        fontSize = 24.sp,
        modifier = Modifier.padding(8.dp)
    )
}

/**
 * AnnotatedString: spanStyle property
 */
@Preview(name = "AnnotatedString: spanStyle property")
@Composable
fun DemoText_AnnotatedString_spanStyle_property() {
    Text(
        text = buildAnnotatedString {
            append("Jetpack Compose: ")
            append(
                AnnotatedString(
                    text = "Text",
                    spanStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                )
            )
        },
        color = Color.Red,
        fontSize = 24.sp,
        fontFamily = FontFamily.Monospace,
        letterSpacing = 4.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(300.dp)
    )
}

/**
 * AnnotatedString: textAlign property
 *
 * The [TextAlign.Start] and [TextAlign.End] respect [LayoutDirection].
 * The [TextAlign.Left] and [TextAlign.Right] do NOT respect [LayoutDirection].
 *
 * Read more and check samples:
 */
@Preview(name = "AnnotatedString: textAlign property")
@Composable
fun DemoText_AnnotatedString_textAlign_property() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Text(
            text = buildAnnotatedString {
                append("Jetpack Compose")
                append(
                    AnnotatedString(
                        text = "Text (Start)",
                        spanStyle = SpanStyle(fontSize = 16.sp),
                        paragraphStyle = ParagraphStyle(textAlign = TextAlign.Start)
                    )
                )
                append(
                    AnnotatedString(
                        text = "Text (Left)",
                        spanStyle = SpanStyle(fontSize = 16.sp),
                        paragraphStyle = ParagraphStyle(textAlign = TextAlign.Left)
                    )
                )
                append(
                    AnnotatedString(
                        text = "Text (Center)",
                        spanStyle = SpanStyle(fontSize = 16.sp),
                        paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
                    )
                )
                append(
                    AnnotatedString(
                        text = "Text (End)",
                        spanStyle = SpanStyle(fontSize = 16.sp),
                        paragraphStyle = ParagraphStyle(textAlign = TextAlign.End)
                    )
                )
                append(
                    AnnotatedString(
                        text = "Text (Right)",
                        spanStyle = SpanStyle(fontSize = 16.sp),
                        paragraphStyle = ParagraphStyle(textAlign = TextAlign.Right)
                    )
                )
            },
            color = Color.Blue,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 4.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(300.dp)
                .padding(8.dp)
        )
    }
}

/**
 * Example: Style substrings
 *
 * Let's imagine that we have an application with a list of coffee drinks and detailed information about each coffee.
 * The CoffeeDrinkDetailsScreen has name and description parameters.
 *
 * So, let's apply a style to the description based on the following requirements:
 *  - The substring with the first appearance of a specific coffee drink in the description should be bold.
 *  - All "coffee" substrings in the description should be underlined.
 *
 *  Read more and check samples: https://alexzh.com/jetpack-compose-style-text/#example-style-substrings
 */
@Preview(name = "Example: Style substrings")
@Composable
fun DemoText_style_substrings() {
    val name = "Espresso"
    val italicSubstring = "coffee"
    val description = "Espresso is coffee of Italian origin, brewed by forcing a small amount of " +
         "nearly boiling water under pressure (expressing) through finely-ground coffee beans."

    fun getSubstrings(substring: String, text: String): List<IntRange> {
        return substring.toRegex()
            .findAll(text)
            .map { it.range }
            .toList()
    }

    val substrings = getSubstrings(italicSubstring, description)
    val nameIndex = description.indexOf(name)

    Text(
        text = buildAnnotatedString {
            append(description)
            addStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                ),
                start = nameIndex,
                end = nameIndex + name.length
            )

            for (substringRange in substrings) {
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = substringRange.first,
                    end = substringRange.last + 1
                )
            }
        },
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

/**
 * Example: Capitalize the first letter of a book chapter
 *
 * Let's try to build the main screen of the application for reading books with multiple chapters.
 * We can move between chapters by swiping to the left and right. The first letter of every chapter
 * should have a font size of 52 sp (scale-independent pixels), and the color should be Red.
 *
 * Read more and check samples: https://alexzh.com/jetpack-compose-style-text/#example-the-first-letter-of-a-book-chapter
 */
@ExperimentalPagerApi
@Preview(name = "Example: Capitalize the first letter of a book chapter")
@Composable
fun DemoText_capitalize_the_first_letter_of_a_book_chapter() {
    val testData = "important test data"

    val content = listOf(
        listOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida massa laoreet ultrices porttitor.",
            testData,
            "Suspendisse nec dignissim leo. Aenean fringilla sapien non risus eleifend, ac dictum erat consequat. Donec sed velit interdum, ullamcorper dolor at, dapibus est. Vivamus semper hendrerit tortor a ultrices. Maecenas nec urna a est condimentum porta sed nec quam. Curabitur at rutrum ipsum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus vitae ante ex. Aliquam augue massa, consectetur vel rutrum id, luctus nec ipsum. Nulla ut elementum tellus. Aliquam non viverra neque. Ut consequat a magna et dictum.",
            "Nulla imperdiet pellentesque nisi nec mollis. Praesent convallis neque lectus. In maximus turpis nec luctus porttitor. Vivamus vel mi pulvinar neque malesuada mattis. Nulla tincidunt mauris eget ultrices porttitor. Integer ornare tellus lorem, eu viverra nisl scelerisque faucibus. Sed turpis massa, placerat nec ante at, maximus volutpat sem. Nunc finibus enim vel erat interdum ornare. Proin dapibus justo lectus, quis feugiat leo aliquet non. Nam tortor arcu, iaculis a placerat id, facilisis ac metus. Maecenas at elit iaculis, tempor massa id, consequat mauris."
        ),
        listOf(
            "Maecenas gravida ipsum ac rhoncus feugiat. Proin at risus non lectus sagittis congue. Morbi mollis, ligula nec vestibulum sodales, arcu justo euismod ligula, eget tincidunt mauris nibh sit amet elit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi auctor tincidunt consectetur. Nunc est justo, facilisis ut facilisis quis, sollicitudin nec mauris. Nam condimentum, ligula mattis fringilla maximus, lacus magna gravida sem, ac dictum lacus augue ac dui. Aenean posuere tortor orci, at accumsan dui sodales quis. Suspendisse nec risus consequat, semper ex vel, ullamcorper ante. Curabitur nunc ligula, tincidunt quis ullamcorper vitae, elementum vel nulla. Proin sit amet rutrum nisi, vel aliquet purus. Nullam maximus ut felis ut venenatis. Nunc accumsan aliquet dolor et lacinia. Nullam aliquam dolor eu nisi pharetra tempor.",
            "Vestibulum a finibus erat. Donec ut ullamcorper erat. Cras sodales, eros vitae tempus mattis, dolor velit gravida nisi, eget aliquam elit neque ac mi. Etiam vulputate, ex dictum dictum finibus, dolor nulla viverra diam, eu pellentesque odio magna ut sem. Integer lorem dolor, iaculis a arcu id, eleifend vulputate est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer sed feugiat erat, non pretium arcu. Aliquam accumsan quis sapien a tempor. Pellentesque vel malesuada ante.",
            "Sed ac mauris ac justo consectetur venenatis nec sit amet felis. Nulla facilisi. Nulla a faucibus neque, sed hendrerit sem. Etiam non nulla at nisl ullamcorper accumsan. Duis fermentum convallis semper. Maecenas purus dolor, euismod eu nisl non, venenatis ultrices lectus. Suspendisse eget imperdiet magna. Cras ipsum sem, maximus et volutpat ac, malesuada pretium nisl. Integer ut dapibus nisl."
        ),
        listOf(
            "Fusce at magna odio. Integer suscipit a purus ut efficitur. Aenean facilisis nisi nec ligula mattis, at ullamcorper ex cursus. Nulla enim arcu, volutpat a facilisis nec, congue ut turpis. Cras commodo eros velit, non fringilla risus ullamcorper suscipit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec laoreet sed libero sit amet viverra. Praesent a venenatis nisi. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.",
            "Fusce gravida gravida neque vitae venenatis. Curabitur vel leo auctor, rutrum erat nec, sagittis massa. Quisque quis auctor magna. Sed molestie hendrerit laoreet. Morbi sapien justo, cursus at sem ut, dictum cursus nunc. Pellentesque vehicula efficitur sem. Vivamus eget odio quam. Pellentesque a felis ligula. Aenean convallis auctor quam vitae pellentesque. Integer tincidunt, est quis iaculis fringilla, justo arcu feugiat erat, interdum tristique ipsum libero at sapien. Proin sagittis luctus tempus. Pellentesque in dapibus dui, id pretium odio.",
            "Cras eu enim tortor. Suspendisse volutpat consectetur sapien, a facilisis nunc malesuada nec. Phasellus volutpat, turpis vel ornare eleifend, sem eros placerat risus, ac varius magna tortor at nibh. Duis dapibus id nulla at finibus. Mauris non tincidunt leo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec sed ex velit. Duis faucibus ac tortor eu dictum. Donec lacinia eget turpis eu cursus. Sed volutpat nunc enim, vitae porta elit tempor in. Fusce sem nulla, rutrum id quam non, maximus hendrerit eros. Integer pretium ex augue. Proin lobortis ac lorem eu gravida. Morbi leo magna, consectetur in laoreet eu, ullamcorper id turpis.",
            "Nulla non ante at turpis tincidunt dictum. Phasellus magna turpis, egestas sit amet eleifend id, placerat non leo. Duis aliquam congue sapien vel porta. Sed vel elementum velit. Phasellus sollicitudin et erat quis volutpat. Quisque egestas est sed sodales rutrum. Donec tincidunt pharetra eleifend. Vestibulum ut mi sit amet nibh dictum hendrerit. Sed tempor nulla et ipsum ullamcorper, id ultricies ante condimentum. Curabitur mi tortor, auctor eget faucibus nec, commodo et neque. Suspendisse sagittis dolor non enim tempor accumsan id sed mauris. Sed facilisis magna sed porta fermentum."
        )
    )

    capitalize_the_first_letter_of_a_book_chapter(content)
}

@ExperimentalPagerApi
@Composable
fun capitalize_the_first_letter_of_a_book_chapter(
    content: List<List<String>>,
    testData: String = ""
) {
    val pagerState = rememberPagerState(initialPage = 0)
    HorizontalPager(
        count = content.size,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        LazyColumn {
            val pageText = content[page]

            item {
                Text(
                    text = "Chapter ${page + 1}",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 52.sp,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                )

                for (index in pageText.indices) {
                    Text(
                        text = buildAnnotatedString {
                            append(pageText[index])
                            if (index == 0) {
                                addStyle(
                                    style = SpanStyle(
                                        color = Color.Red,
                                        fontSize = 52.sp,
                                        fontFamily = FontFamily.Cursive
                                    ),
                                    start = 0,
                                    end = 1
                                )
                            }
                            if (pageText[index] == testData) {
                                addStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        textDecoration = TextDecoration.LineThrough
                                    ),
                                    start = 0,
                                    end = testData.length
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        fontSize = 24.sp,
                        style = TextStyle(
                            textAlign = TextAlign.Justify
                        )
                    )
                }
            }
        }
    }
}