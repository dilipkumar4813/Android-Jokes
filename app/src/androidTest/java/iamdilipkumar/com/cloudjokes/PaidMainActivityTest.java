package iamdilipkumar.com.cloudjokes;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PaidMainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void paidMainActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(iamdilipkumar.com.cloudjokes.R.id.btn_joke), withText("Joke me"), isDisplayed()));
        appCompatButton.perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(withId(iamdilipkumar.com.jokedisplayer.R.id.title))
                        .check(ViewAssertions.matches(withText("")));

        ViewInteraction appCompatMenuView = onView(
                allOf(withId(iamdilipkumar.com.jokedisplayer.R.id.title),
                        withText("Share"), isDisplayed()));
        appCompatMenuView.perform(click());
    }

}
