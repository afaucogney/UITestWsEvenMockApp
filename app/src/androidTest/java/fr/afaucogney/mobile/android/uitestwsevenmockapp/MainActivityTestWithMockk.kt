package fr.afaucogney.mobile.android.uitestwsevenmockapp


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import de.greenrobot.event.EventBus
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTestWithMockk {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    //    @Mock
//    lateinit


    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks
    }


    @Test
    fun mainActivityTest() {
        val mDataManager = mockk<DataManager>()
//        val mEventBus = mockk<EventBus>()

        every { mDataManager.requestWebService() } answers {
            mActivityTestRule.runOnUiThread {
                mActivityTestRule.activity.onEventMainThread(
                    RequestResponseEvent("bonjour")
                )
            }
        }


        val textView = onView(
            allOf(
                withId(R.id.tv), withText("Hello World!"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cl),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Hello World!")))

        val floatingActionButton = onView(
            allOf(
                withId(R.id.fab),
                childAtPosition(
                    allOf(
                        withId(R.id.cl),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())



        val textView2 = onView(
            allOf(
                withId(R.id.tv), withText("bonjour"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cl),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("bonjour")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
