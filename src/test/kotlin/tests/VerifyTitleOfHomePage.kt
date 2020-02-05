package tests
import org.testng.Assert
import org.testng.annotations.Test
import webPage.LaunchHomePage


class VerifyTitleOfHomePage : TestBase() {

    @Test(priority = 1)
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