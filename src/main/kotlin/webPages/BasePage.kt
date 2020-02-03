package webPage

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.text.DateFormatSymbols

open class BasePage(private val driver: WebDriver) {

    fun sendKeys(Element: WebElement?, Text: String) {

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(Element))
        Element?.click()
        Element?.sendKeys(Text)

    }

    fun click(Element: WebElement?){

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(Element))

        Element?.click()


    }

    fun waitForFlightsToLoad(Element: WebElement?) {

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.textToBePresentInElement(Element, "Work travel"))

    }

//    fun isDateCorrect(travelDate: String, dateOnItineraryPage: String?): Boolean {
//
//
//        var parsingMonthNumberToName = (((travelDate.split("/"))[1]).toIntOrNull())?.minus(1)
//        val parsedMonthName =(DateFormatSymbols.getInstance().months[parsingMonthNumberToName!!])
//
//        var isDateMatching = ((travelDate.split("/"))[0]).equals(((dateOnItineraryPage?.split(" "))?.get(1)))
//
//        var isMonthMatching = parsedMonthName.contains(((dateOnItineraryPage?.split(" "))?.get(2).toString()))
//
//        var isYearMatching = ((travelDate.split("/"))[2]).equals(((dateOnItineraryPage?.split(" "))?.get(3)))
//
//        return(isDateMatching && isMonthMatching && isYearMatching)
//
//
//    }



}