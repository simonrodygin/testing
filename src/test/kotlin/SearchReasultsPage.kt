import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SearchReasultsPage(private val driver: WebDriver) {

    fun checkPage() {
        val element = driver.findElement(By.cssSelector("#result-stats"))
        assert(element.isDisplayed)
    }

}