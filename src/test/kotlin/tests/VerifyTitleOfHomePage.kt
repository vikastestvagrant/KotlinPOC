package tests
import org.testng.Assert
import org.testng.annotations.Test
import webPage.LaunchHomePage
import java.io.FileInputStream
import java.util.*


class VerifyTitleOfHomePage : TestBase() {

    @Test
    fun verifyTitleOfHomePageTest() {

        var expectedTitleOfHomePage = "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities."

        var actualTitleOfHomePage = LaunchHomePage(driver).getTitleOfHomePage()


        Assert.assertEquals(
            actualTitleOfHomePage,
            expectedTitleOfHomePage,
            "Title is not as expected"
        )
    }
}