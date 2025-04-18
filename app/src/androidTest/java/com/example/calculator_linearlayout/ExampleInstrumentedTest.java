package com.example.calculator_linearlayout;

import android.content.Context;
import android.util.Log;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.filters.SmallTest;
import androidx.test.core.app.ActivityScenario;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.calculator_linearlayout", appContext.getPackageName());
    }

    // Wait for the UI to update (use Thread.sleep or more sophisticated method if required)
    public void waitForUI() {
        try {
            Thread.sleep(500);  // Wait for 500 milliseconds (adjust if needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddFunctionality() {
        // Launch the activity
        ActivityScenario.launch(MainActivity.class);

        // Simulate user input for 5 + 3
        Espresso.onView(withId(R.id.btn5)).perform(click());
        Espresso.onView(withId(R.id.btnAdd)).perform(click());
        Espresso.onView(withId(R.id.btn3)).perform(click());
        Espresso.onView(withId(R.id.btnCal)).perform(click());

        // Wait for the result to be updated
        waitForUI();

        // Check if the result is correct (8)
        Espresso.onView(withId(R.id.txtCal))
                .check(matches(ViewMatchers.withText("8")));
    }

    @Test
    public void testSubFunctionality() {
        // Launch the activity
        ActivityScenario.launch(MainActivity.class);

        // Simulate user input for 9 - 4
        Espresso.onView(withId(R.id.btn9)).perform(click());
        Espresso.onView(withId(R.id.btnSub)).perform(click());
        Espresso.onView(withId(R.id.btn4)).perform(click());
        Espresso.onView(withId(R.id.btnCal)).perform(click());

        // Wait for the result to be updated
        waitForUI();

        // Check if the result is correct (5)
        Espresso.onView(withId(R.id.txtCal))
                .check(matches(ViewMatchers.withText("5")));
    }

    @Test
    public void testMulFunctionality() {
        // Launch the activity
        ActivityScenario.launch(MainActivity.class);

        // Simulate user input for 4 * 6
        Espresso.onView(withId(R.id.btn4)).perform(click());
        Espresso.onView(withId(R.id.btnMul)).perform(click());
        Espresso.onView(withId(R.id.btn6)).perform(click());
        Espresso.onView(withId(R.id.btnCal)).perform(click());

        // Wait for the result to be updated
        waitForUI();

        // Check if the result is correct (24)
        Espresso.onView(withId(R.id.txtCal))
                .check(matches(ViewMatchers.withText("24")));
    }

    @Test
    public void testDivFunctionality() {
        // Launch the activity
        ActivityScenario.launch(MainActivity.class);

        // Simulate user input for 8 / 2
        Espresso.onView(withId(R.id.btn8)).perform(click());
        Espresso.onView(withId(R.id.btnDiv)).perform(click());
        Espresso.onView(withId(R.id.btn2)).perform(click());
        Espresso.onView(withId(R.id.btnCal)).perform(click());

        // Wait for the result to be updated
        waitForUI();

        // Check if the result is correct (4)
        Espresso.onView(withId(R.id.txtCal))
                .check(matches(ViewMatchers.withText("4")));
    }

    @Test
    public void testClearFunctionality() {
        // Launch the activity
        ActivityScenario.launch(MainActivity.class);

        // Simulate user input for 5 + 3 and clear the text
        Espresso.onView(withId(R.id.btn5)).perform(click());
        Espresso.onView(withId(R.id.btnAdd)).perform(click());
        Espresso.onView(withId(R.id.btn3)).perform(click());
        Espresso.onView(withId(R.id.btnClear)).perform(click());

        // Check if the text is cleared
        Espresso.onView(withId(R.id.txtCal))
                .check(matches(ViewMatchers.withText("")));
    }
}
