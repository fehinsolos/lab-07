package com.example.lab_7

import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // Walkthrough: Upcoming Races
    @Test
    fun navigate_to_races_add_race_and_return_home() {

        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    // Participation Exercise: Drivers
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {

        // Navigate to Drivers
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // Verify Drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // Enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        // Add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver appears
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // Clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify driver was removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // Return to Home
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // Verify Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
