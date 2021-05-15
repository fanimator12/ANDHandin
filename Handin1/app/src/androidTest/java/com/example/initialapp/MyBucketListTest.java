package com.example.initialapp;

import android.content.Context;
import android.view.Gravity;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.initialapp.View.Activities.DrawerActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MyBucketListTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.initialapp", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<DrawerActivity> activityTestRule = new ActivityTestRule<>(DrawerActivity.class);

    @Test
    public void testHomeScreen(){

    }

    @Test
    public void testAllGalleryScreen() {


    }

    @Test
    public void testCreateScreen() {


    }
    @Test
    public void testWishlistScreen() {


    }

    @Test
    public void testCompletedScreen() {


    }

    @Test
    public void testDescriptionScreen() {


    }

    @Test
    public void testAddingGoalsToWishlist() {


    }

    @Test
    public void testMarkingGoalsAsCompleted() {


    }

    @Test
    public void testSignIn() {


    }

    @Test
    public void testSignOut() {


    }

}