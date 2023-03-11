package com.alexzh.composeplayground.ui.demo.text

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.google.accompanist.pager.ExperimentalPagerApi
import org.junit.Rule
import org.junit.Test

@ExperimentalPagerApi
@ExperimentalFoundationApi
class TextTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test() {
        composeTestRule.apply {
            setContent {
                val content = listOf(
                    listOf(
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida massa laoreet ultrices porttitor.",
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

            onRoot().printToLog("MERGED")

            onNodeWithText("Chapter 1")
                .assertIsDisplayed()

            onNode(hasHorizontalScroll())
                .performTouchInput { swipeLeft() }

            onNodeWithText("Chapter 2")
                .assertIsDisplayed()

            onNode(hasHorizontalScroll())
                .performTouchInput { swipeLeft() }

            onNodeWithText("Chapter 3")
                .assertIsDisplayed()
        }
    }

    fun hasHorizontalScroll() =
        SemanticsMatcher.keyIsDefined(SemanticsProperties.HorizontalScrollAxisRange)
}