
import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.*
import org.openqa.selenium.By

@Suppress("DEPRECATION")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestGoogleSearch {

    private val driver = WebDriverManager.chromedriver().create()


    @Test
    fun makeSearchFromEnter() {

        GoogleMainPage(driver).start()

        GoogleMainPage(driver).typeSearch("этот запрос совершен автоматически и введен клавишей Enter\n")

        SearchReasultsPage(driver).checkPage()
    }

    @Test
    fun makeSearchFromButton() {

        GoogleMainPage(driver).start()

        GoogleMainPage(driver).typeSearch("этот запрос совершен автоматически и введен кнопкой")

        GoogleMainPage(driver).tapSearchButton()

        SearchReasultsPage(driver).checkPage()
    }

    @Test
    fun accessDoodlePage() {

        GoogleMainPage(driver).start()

        GoogleMainPage(driver).imLucky()

        val element = driver.findElement(By.id("archive-link"))

        assert(element.isDisplayed)
    }

    @Test
    fun dumbSearch() {

        GoogleMainPage(driver).start()

        val dumbRequest = getRandomString(1000)

        GoogleMainPage(driver).typeSearch(dumbRequest)

        GoogleMainPage(driver).tapSearchButton()

        val element = driver.findElement(By.cssSelector("#topstuff > div > div > p:nth-child(2)"))

        assert(element.isDisplayed)
    }

    @Test
    fun wrongLayout() {

        GoogleMainPage(driver).start()

        GoogleMainPage(driver).typeSearch("z jib,cz c hfcrkflrjq\n")

        val element = driver.findElement(By.cssSelector("#oFNiHe > p > span"))

        assert(element.isDisplayed)
    }


    @AfterAll
    fun closeBrowser() {
        driver.close()
    }

}

fun getRandomString(length: Int) : String {
    val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    return List(length) { charset.random() }
        .joinToString("")
}