package tests

import entities.TravellerDetails
import org.testng.Assert
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import webPage.SelectFlightPage
import webPage.TicketsBookingPage


class VerifyLowestFlightPriceTestTest : TestBaseTest() {

    private lateinit var ticketsBookingPage: TicketsBookingPage
    private lateinit var selectFlightPage: SelectFlightPage

    @BeforeTest
    fun testSetup() {

        ticketsBookingPage = TicketsBookingPage(driver)
        selectFlightPage = SelectFlightPage(driver)

    }


    @Test
    fun verifyLowestFlightPriceIsOnTheTop() {


        val travel = TravellerDetails("Bangalore", "Lucknow", "14/02/2020")

        ticketsBookingPage.searchFlight(travel)

        val isLowestPrice = selectFlightPage.isTheTopMostPriceLowest()

        Assert.assertEquals(isLowestPrice, true, "Lowest price is not displayed correctly")


    }


}