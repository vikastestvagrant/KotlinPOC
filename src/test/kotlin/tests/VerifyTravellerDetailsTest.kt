package tests

import entities.Email
import entities.TravelDetails
import entities.Traveller
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import webPage.ItineraryPage
import webPage.SelectFlightPage
import webPage.TicketsBookingPage
import webPages.EmailPage
import webPages.TravellerDetailsPage

public class VerifyTravellerNamePhoneNumberTest: TestBase() {


     lateinit var emailPage : EmailPage
     lateinit var ticketsBookingPage: TicketsBookingPage
     lateinit var selectFlightPage: SelectFlightPage
     lateinit var itineraryPage: ItineraryPage
     lateinit var travellerDetailsPage : TravellerDetailsPage

    @BeforeMethod
    fun setUp() {

        emailPage = EmailPage(driver)
        ticketsBookingPage = TicketsBookingPage(driver)
        selectFlightPage = SelectFlightPage(driver)
        itineraryPage = ItineraryPage(driver)
        travellerDetailsPage = TravellerDetailsPage(driver)

    }
    @Test
    fun verifyTravellerDetailsTest(){


        val travel = TravelDetails("Bangalore", "Lucknow", "14/02/2020")
        val email = Email("vikas543@gmail.com")
        val travellerInfo = Traveller("Mr","ABC", "XYS", "0123456789")

        ticketsBookingPage.searchFlight(travel)

        selectFlightPage.navigateToItineraryPageByChoosingFirstFlight()

        itineraryPage.clickContinueBookingBtn()

        emailPage.enterEmailAddress(email)

        travellerDetailsPage.enterTravellerDetails(travellerInfo)

        var getTravelNameMobileTitleCheck = travellerDetailsPage.isTravellerInfoCorrect(travellerInfo)

        Assert.assertEquals(getTravelNameMobileTitleCheck, true, "Passenger details are not saved correctly")

    }

}