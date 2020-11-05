package com.example.databindtest;

import android.app.Application;
import android.content.Intent;
import android.os.Build;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * @author: Administrator
 * @date: 2020/11/4
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class MainActivityTest {

    @Before
    public void setUp() throws Exception {
        Application application=RuntimeEnvironment.application;

    }

    @After
    public void tearDown() throws Exception {
    }
//
    @Test
    public void onCreate() {

    }



    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.btn).performClick();
        Intent intent = new Intent(activity, SecondActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(intent.getComponent(), actual.getComponent());
    }
}