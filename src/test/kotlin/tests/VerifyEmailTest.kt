package tests

import entities.Email
import entities.TravelDetails
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import webPage.ItineraryPage
import webPage.SelectFlightPage
import webPage.TicketsBookingPage
import webPages.EmailPage

class VerifyEmailTest : TestBase() {

    private lateinit var emailPage: EmailPage
    private lateinit var ticketsBookingPage: TicketsBookingPage
    private lateinit var selectFlightPage: SelectFlightPage
    private lateinit var itineraryPage: ItineraryPage


    @BeforeMethod
    fun setUp() {

        emailPage = EmailPage(driver)
        ticketsBookingPage = TicketsBookingPage(driver)
        selectFlightPage = SelectFlightPage(driver)
        itineraryPage = ItineraryPage(driver)

    }

    @Test
    fun verifyEmailTest() {

        val travel = TravelDetails("Bangalore", "Lucknow", "14/02/2020")
        val email = Email("vikas543@gmail.com")

        ticketsBookingPage.searchFlight(travel)

        selectFlightPage.navigateToItineraryPageByChoosingFirstFlight()

        itineraryPage.clickContinueBookingBtn()

        emailPage.enterEmailAddress(email)
        var getEmailCheckFromItineraryPage = emailPage.isEmailEnteredCorrectly(email)


        Assert.assertEquals(getEmailCheckFromItineraryPage, true, "Email is not saved correctly")

    }
}