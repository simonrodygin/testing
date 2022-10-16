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
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]")).click()
        return this
    }

    fun tapSearchButton(): GoogleMainPage {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click()
        return this
    }

}