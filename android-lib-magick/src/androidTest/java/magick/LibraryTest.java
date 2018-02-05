package magick;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import test.R;
import test.TestActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class LibraryTest {

    private String textTovalidate;

    @Before
    public void initValidString() {
        textTovalidate = "OK";
    }

    @Rule
    public ActivityTestRule<TestActivity> mActivityRule = new ActivityTestRule<TestActivity>(TestActivity.class);

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.txtStatus)).check(matches(withText(textTovalidate)));
    }
}
