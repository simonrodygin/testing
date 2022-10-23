import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

@Suppress("DEPRECATION")
class GoogleMainPage(private val driver: WebDriver) {

    fun start() {
        driver.get("https://google.com")
    }

    fun checkPage() {
        val element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"))
        assert(element.isDisplayed)
    }

    fun startInput(): GoogleMainPage {
        driver.findElement(By.name("q")).click()
        return this
    }

    fun typeSearch(text: String): GoogleMainPage {
        driver.findElement(By.name("q")).sendKeys(text)
        return this
    }

    fun imLucky(): GoogleMainPage {
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input[type=submit]:nth-child(2)")).click()
        return this
    }

    fun tapSearchButton(): GoogleMainPage {
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).click()
        return this
    }

}