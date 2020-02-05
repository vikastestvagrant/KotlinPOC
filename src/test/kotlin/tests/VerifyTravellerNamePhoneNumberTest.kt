package tests

import entities.Email
import entities.TravellerDetails
import entities.TravellerTitleNameMobile
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import webPage.ItineraryPage
import webPage.SelectFlightPage
import webPage.TicketsBookingPage
import webPages.EmailPage
import webPages.TravelNameMobileDetailsPage

public class VerifyTravellerNamePhoneNumberTest: TestBase() {


     lateinit var emailPage : EmailPage
     lateinit var ticketsBookingPage: TicketsBookingPage
     lateinit var selectFlightPage: SelectFlightPage
     lateinit var itineraryPage: ItineraryPage
     lateinit var travelNameMobileDetailsPage : TravelNameMobileDetailsPage

    @BeforeMethod
    fun setUp() {

        emailPage = EmailPage(driver)
        ticketsBookingPage = TicketsBookingPage(driver)
        selectFlightPage = SelectFlightPage(driver)
        itineraryPage = ItineraryPage(driver)
        travelNameMobileDetailsPage = TravelNameMobileDetailsPage(driver)

    }
    @Test
    fun verifyTravellerDetailsTest(){


        val travel = TravellerDetails("Bangalore", "Lucknow", "14/02/2020")
        val email = Email("vikas543@gmail.com")
        val travellerInfo = TravellerTitleNameMobile("Mr","ABC", "XYS", "0123456789")

        ticketsBookingPage.searchFlight(travel)

        selectFlightPage.navigateToItineraryPageByChoosingFirstFlight()

        itineraryPage.clickContinueBookingBtn()

        emailPage.enterEmailAddress(email)

        travelNameMobileDetailsPage.enterFirstNameLastNameMobileNum(travellerInfo)

        var getTravelNameMobileTitleCheck = travelNameMobileDetailsPage.isTravellerInfoCorrect(travellerInfo)



        Assert.assertEquals(getTravelNameMobileTitleCheck, true, "Passenger details are not saved correctly")

    }

}