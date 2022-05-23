package com.digitalspaceguru.restaurant;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    @Rule // @Rule tells our device which activity to launch before each test.
    public ActivityScenarioRule<MainActivity> activityRule = //Here, we're instructing the instrumentation tests to launch the MainActivity before each test.
            new ActivityScenarioRule<>(MainActivity.class); //ActivityScenarioRule launches a given activity before the test starts and closes after the test.

    @Test
    public void validateEditText() {
        onView(withId(R.id.locationEditText))//onView() specifies that we want to interact with a view -withId() is a ViewMatcher method that allows us to find specific views by I
                .perform(typeText("Nairobi"))  //typeText() is a ViewAction method that allows us to type the specified text into our EditText
                .check(matches(withText("Nairobi")));  // matches() is a ViewAssertion method that validates the specific properties of the given view
    }

    @Test
    public void locationIsSentToRestaurantActivity(){
        String location = "Nairobi";
        onView(withId(R.id.locationEditText))
                .perform(typeText(location))
                .perform(closeSoftKeyboard());
        try{ //  // the sleep method requires to be checked and handled so we use try block
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.findRestaurantsButton)).perform(click());
        onView(withId(R.id.locationTextView))
                .check(matches(withText("Here are the restaurants near the place: " + location)));
    }


}