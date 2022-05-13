package com.digitalspaceguru.restaurant;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    @Rule // @Rule tells our device which activity to launch before each test.
    public ActivityScenarioRule<MainActivity> activityRule = //Here, we're instructing the instrumentation tests to launch the MainActivity before each test.
            new ActivityScenarioRule<> (MainActivity.class); //ActivityScenarioRule launches a given activity before the test starts and closes after the test.



}