import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTests_1 {

    private WebDriver driver;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenPage() {
        var actualResult = driver.findElement(By.className("start-screen__text")).getText();
        var expectedResult = "Введите свои данные";

        Assert.assertEquals("Страница не загрузилась", expectedResult, actualResult);
    }

    @Test
    public void testCorrectAllData() {
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan.ivanov@yandex.ru");
        driver.findElement(By.name("phone")).sendKeys("+79995554433");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan.ivanov@yandex.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79995554433.";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDataNoPhone() {
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan.ivanov@yandex.ru");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan.ivanov@yandex.ru) отправлено письмо.\n";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDataNoEmail() {
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("phone")).sendKeys("+79995554433");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79995554433.";

        Assert.assertEquals("Неверный текст приветствия", expectedResult, actualResult);
    }

    @Test
    public void testDataNoEmailNoPhone() {
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoData() {
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Пожалуйста, введите свои данные";

        Assert.assertEquals(expectedResult, actualResult);
    }

}
