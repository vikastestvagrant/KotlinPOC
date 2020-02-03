package webPage

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


public class SelectFlightPage(private val driver: WebDriver) {

    @FindBy(xpath = ".//*[@data-sort='airline']")
    var airlineTag: By? = null


    @FindBy(xpath = "(//*[@id=\"BaggageBundlingTemplate\"])[1]")
    var firstTicketPriceElement: WebElement? = null

//    @FindBy(xpath = "(.//*[contains(text(),'Work travel? Sign up to unlock')])[2]")
//    var pageFullyLoadCheckElement: WebElement? = null

    @FindBy(xpath = "(.//button[contains(text(),'Book')])[3]")
    var bookFlightElement: WebElement? = null


    init {
        PageFactory.initElements(driver, this)
    }


//    fun waitForFlightsToLoad() {
//
//        WebDriverWait(driver, 10)
//            .until(ExpectedConditions.textToBePresentInElement(pageFullyLoadCheckElement, "Work travel"))
//
//    }

    fun isTheTopMostPriceLowest(): Boolean {

        println("Lowest price as per Cleartrip " + firstTicketPriceElement?.text)

        var ticketPriceList = driver.findElements(By.xpath("(//*[@id=\"BaggageBundlingTemplate\"])"))

        var numOfTickets = (ticketPriceList.size)

        val listOfTickets: MutableList<String> = mutableListOf()

        println("-----------------------------------")
        println("Here goes all ticket prices")
        println("-----------------------------------")

        for (i in 0 until numOfTickets) {

            println()
            println(ticketPriceList.get(i).text)

            listOfTickets.add(ticketPriceList.get(i).text)
        }

        var lowestPriceInSortedList = listOfTickets.min()
        println("-----------------------------------")
        print("Lowest price in above list $lowestPriceInSortedList")

        return firstTicketPriceElement?.text.equals(lowestPriceInSortedList)


    }

    fun navigateToItineraryPageByChoosingFirstFlight() {
        bookFlightElement?.click()


    }


}