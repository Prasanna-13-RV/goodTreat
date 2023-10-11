package com.example.recipe.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.recipe.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isActivityInView() {
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

//    @Test
//    fun test_is_title_button() {
//        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun test_is_text_displayed() {
//        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
//    }
//
//    @Test
//    fun test_navController() {
//        onView(withId(R.id.button_next_activity)).perform(ViewActions.click())
//    }
//
//    @Test
//    fun test_back_press() {
//        onView(withId(R.id.button_next_activity)).perform(ViewActions.click())
//        Espresso.pressBack()
//        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
//    }


}