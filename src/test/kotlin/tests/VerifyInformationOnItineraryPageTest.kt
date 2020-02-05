package tests

import entities.TravellerDetails
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import webPage.ItineraryPage
import webPage.SelectFlightPage
import webPage.TicketsBookingPage


class VerifyInformationOnItineraryPageTest : TestBase() {

    private lateinit var ticketsBookingPage: TicketsBookingPage
    private lateinit var selectFlightPage: SelectFlightPage
    private lateinit var itineraryPage: ItineraryPage


    @BeforeMethod
    fun testSetup(){

        ticketsBookingPage = TicketsBookingPage(driver)
        selectFlightPage = SelectFlightPage(driver)
        itineraryPage = ItineraryPage(driver)

    }

    @Test()
    fun verifyItineraryPageDetails() {

        val travel = TravellerDetails("Bangalore", "Lucknow", "14/02/2020")

        ticketsBookingPage.searchFlight(travel)

        selectFlightPage.navigateToItineraryPageByChoosingFirstFlight()

        var getItineraryDetailCheck = itineraryPage.isItineraryDetailCorrect(travel)

        Assert.assertEquals(getItineraryDetailCheck, true, "Flight info is not displayed correctly on itinerary page")

        var getDateMonthYearCheckFromItineraryPage = itineraryPage.isTravelDateCorrect(travel.travelDate)

        Assert.assertEquals(getDateMonthYearCheckFromItineraryPage, true,
            "Date is not displayed correctly on itinerary page"
        )

    }

}