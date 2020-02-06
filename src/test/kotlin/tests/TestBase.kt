package tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.FileInputStream
import java.util.*
import java.util.concurrent.TimeUnit


abstract class TestBase {

     public lateinit var driver: WebDriver
     public lateinit var options: ChromeOptions

    @BeforeTest
    open fun testSetUp() {


        val fis = FileInputStream("src/main/resources/config.properties")

        val prop = Properties()
        prop.load(fis)
        var baseURL = prop.getProperty("pageURL")

        options = ChromeOptions()
        options!!.addArguments("--disable-notifications")

        driver = ChromeDriver(options)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get(baseURL)

    }

    @AfterTest
    fun driverClose() {

        driver?.close()

    }


}