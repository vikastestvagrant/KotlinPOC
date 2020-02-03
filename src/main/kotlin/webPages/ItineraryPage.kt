package webPage

import entities.TravellerDetails
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.text.DateFormatSymbols

public class ItineraryPage(private val driver: WebDriver) {


    @FindBy(xpath = "//*[@class=\"itinerary clearFix onwBlock\"]")
    var originToSourceFlightDetailElement: WebElement? = null

    @FindBy(xpath = "//*[@class=\"itinerary clearFix onwBlock\"]/h1/small[2]")
    var flightDateOnItineraryPage: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }


    fun getOriginToSourceFlightInfo(): String? {

        var originToSourceFlightInfo = originToSourceFlightDetailElement?.text
        return originToSourceFlightInfo

    }

    fun getFlightDateFromItineraryPage(): String? {


        return (flightDateOnItineraryPage?.text)

    }

    fun isItineraryDetailCorrect(travel: TravellerDetails): Boolean {

        val actual = getOriginToSourceFlightInfo()

        return (actual?.contains(travel.sourceCity)!!) && (actual?.contains(travel.destCity))


    }

    fun isTravelDateCorrect(travelDate: String): Boolean {

        val actualDate = getFlightDateFromItineraryPage()


        var parsingMonthNumberToName = (((travelDate.split("/"))[1]).toIntOrNull())?.minus(1)
        val parsedMonthName =(DateFormatSymbols.getInstance().months[parsingMonthNumberToName!!])

        var isDateMatching = ((travelDate.split("/"))[0]).equals(((actualDate?.split(" "))?.get(1)))

        var isMonthMatching = parsedMonthName.contains(((actualDate?.split(" "))?.get(2).toString()))

        var isYearMatching = ((travelDate.split("/"))[2]).equals(((actualDate?.split(" "))?.get(3)))

        return(isDateMatching && isMonthMatching && isYearMatching)


    }


}