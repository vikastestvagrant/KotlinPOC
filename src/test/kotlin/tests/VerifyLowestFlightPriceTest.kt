package tests

import entities.TravelDetails
import org.testng.Assert
import org.testng.annotations.Test
import webPage.SelectFlightPage
import webPage.TicketsBookingPage


class VerifyLowestFlightPriceTest : TestBase() {

    private lateinit var ticketsBookingPage: TicketsBookingPage
    private lateinit var selectFlightPage: SelectFlightPage


    fun testSetup() {

        ticketsBookingPage = TicketsBookingPage(driver)
        selectFlightPage = SelectFlightPage(driver)

    }


    @Test(priority = 2)
    fun verifyLowestFlightPriceIsOnTheTop() {

        testSetup()
        val travel = TravelDetails("Bangalore", "Lucknow", "14/02/2020")

        ticketsBookingPage.searchFlight(travel)

        val isLowestPrice = selectFlightPage.isTheTopMostPriceLowest()

        Assert.assertEquals(isLowestPrice, true, "Lowest price is not displayed correctly")


    }


}