package fr.afaucogney.mobile.android.uitestwsevenmockapp


//@LargeTest
//@RunWith(MockitoJUnitRunner::class)
//class MainActivityTestWithMockito {
//
//    @Rule
//    @JvmField
//    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
//
//
//    //    @Mock
////    lateinit
//    val mDataManager = Mockito.mock(DataManager::class.java)
////    val mEvenBus = Mockito.mock(EventBus::class.java)
//
//
//    @Before
//    fun setup() {
//        MockitoAnnotations.initMocks(this)
////        mDataManager =
//
//    }
//
//    @Test
//    fun mainActivityTest() {
//
//        Mockito
//            .`when`(mDataManager.requestWebService())
//            .thenAnswer {
//                mActivityTestRule.activity.onEventMainThread(
//                    RequestResponseEvent("bonjour")
//                )
//            }
//
//
//        val textView = onView(
//            allOf(
//                withId(R.id.tv), withText("Hello World!"),
//                childAtPosition(
//                    childAtPosition(
//                        withId(R.id.cl),
//                        1
//                    ),
//                    0
//                ),
//                isDisplayed()
//            )
//        )
//        textView.check(matches(withText("Hello World!")))
//
//        val floatingActionButton = onView(
//            allOf(
//                withId(R.id.fab),
//                childAtPosition(
//                    allOf(
//                        withId(R.id.cl),
//                        childAtPosition(
//                            withId(android.R.id.content),
//                            0
//                        )
//                    ),
//                    2
//                ),
//                isDisplayed()
//            )
//        )
//        floatingActionButton.perform(click())
//
//        val textView2 = onView(
//            allOf(
//                withId(R.id.tv), withText("bonjour"),
//                childAtPosition(
//                    childAtPosition(
//                        withId(R.id.cl),
//                        1
//                    ),
//                    0
//                ),
//                isDisplayed()
//            )
//        )
//        textView2.check(matches(withText("bonjour")))
//    }
//
//    private fun childAtPosition(
//        parentMatcher: Matcher<View>, position: Int
//    ): Matcher<View> {
//
//        return object : TypeSafeMatcher<View>() {
//            override fun describeTo(description: Description) {
//                description.appendText("Child at position $position in parent ")
//                parentMatcher.describeTo(description)
//            }
//
//            public override fun matchesSafely(view: View): Boolean {
//                val parent = view.parent
//                return parent is ViewGroup && parentMatcher.matches(parent)
//                        && view == parent.getChildAt(position)
//            }
//        }
//    }
//}
