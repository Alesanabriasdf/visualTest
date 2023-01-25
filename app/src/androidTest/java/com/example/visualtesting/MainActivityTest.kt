package com.example.visualtesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.hamcrest.core.Is.`is`
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityMain = ActivityTestRule(MainActivity::class.java)

    companion object{
        @JvmStatic
        @BeforeClass
        fun setup(){
            Intents.init()
        }
    }

    @Test
    fun testToast(){

        onView(withId(R.id.btn_continue)).perform(click())

        onView(withText("asd")).inRoot(withDecorView(Matchers
            .not(`is`(activityMain.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun faltaContrasenia(){

        onView(withId(R.id.et_nombre)).perform(typeText("alejandro"))

        onView(withId(R.id.et_contraseña)).perform(typeText(""))

        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btn_continue)).perform(click())

        onView(withText("complete los datos")).inRoot(withDecorView(Matchers
            .not(`is`(activityMain.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun faltanNombre(){

        onView(withId(R.id.et_nombre)).perform(typeText(""))

        onView(withId(R.id.et_contraseña)).perform(typeText("1234156"))

        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btn_continue)).perform(click())

        onView(withText("complete los datos")).inRoot(withDecorView(Matchers
            .not(`is`(activityMain.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun faltanTodosLosDatos(){

        onView(withId(R.id.et_nombre)).perform(typeText(""))

        onView(withId(R.id.et_contraseña)).perform(typeText(""))

        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btn_continue)).perform(click())

        onView(withText("complete los datos")).inRoot(withDecorView(Matchers
            .not(`is`(activityMain.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun estanTodosLosDatos(){

        onView(withId(R.id.et_nombre)).perform(typeText("alejandro"))

        onView(withId(R.id.et_contraseña)).perform(typeText("12345889"))

        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())

        //onView(withId(R.id.btn_continue)).perform(click())

        onView(withText("usted ingreso")).inRoot(withDecorView(Matchers
            .not(`is`(activityMain.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun estanTodosLosDatosYNavega(){

        onView(withId(R.id.et_nombre)).perform(typeText("alejandro"))

        onView(withId(R.id.et_contraseña)).perform(typeText("12345889"))

        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btn_continue)).perform(click())

        intended(hasComponent(MainActivity2::class.java.name))

    }

}