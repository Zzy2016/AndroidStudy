package com.example.abouttest;

import android.content.Intent;

import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.internal.IShadow;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * @author: Administrator
 * @date: 2020/11/4
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void onCreate() {

    }

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.login).performClick();
//        Intent intent=new Intent(activity,LoginActivity.class);
//        assertThat().isEqualTo(intent);
//        assertThat(shadowOf(activity).getNextStartedActivity()).isE;
//
//        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
//        assertEquals(intent.getComponent(), actual.getComponent());
    }


}