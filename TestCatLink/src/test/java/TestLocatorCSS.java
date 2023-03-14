import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLocatorCSS {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLocatorCSS() throws InterruptedException {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        Thread.sleep(2000);

        String name = "Иван";
        String email = "test@test.com";
        String text = "Спасибо за работу";
        var nameLocator = By.cssSelector(".data.text");
        var emailLocator = By.cssSelector(".data.field");
        var textLocator = By.cssSelector(".field.text");
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");

        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(textLocator).sendKeys(text);
        Thread.sleep(2000);
        driver.findElement(buttonLocator).click();
        Thread.sleep(2000);

        Assert.assertTrue("Текст \"Спасибо за регистрацию\" не отображается", driver.findElement(messageLocator).isDisplayed());
    }

}
