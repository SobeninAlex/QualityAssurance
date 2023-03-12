import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTests {
    private WebDriver driver;

    @Before
    public void setUp() {
//        TODO: пердаем путь к веб-драйверу;
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

//        TODO: так как после обновления хрома все сломалось теперь делаем так;
//        TODO: создаем переменную класса ChromeOption и добавляем аргумент;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

//        TODO: передаем переменную options в параметры переменной driver класса ChromeDriver;
        driver = new ChromeDriver(options);

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testHello() {
        driver.findElement(By.name("name")).sendKeys("Алексиос");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Алексиос!";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFieldNameIsNull() {
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";

        Assert.assertEquals(expectedResult, actualResult);
    }
}
