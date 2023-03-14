import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TestCats {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        driver.navigate().refresh();
    }

    @AfterClass
    public static void exit() {
        driver.quit();
    }

    private final By emailLocator = By.className("email");
    private final By buttonLocator = By.id("write-to-me");
    private final By resultTextLocator = By.className("result-text");
    private final By resultEmailLocator = By.className("result-email");

    @Test
    public void testEmailIsFilled() throws InterruptedException {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        String email = "test@test.com";

        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonLocator).click();
        Thread.sleep(2000);
        boolean isDisplayed = driver.findElement(resultTextLocator).isDisplayed();
        String emailText = driver.findElement(resultEmailLocator).getText();

        Assert.assertEquals("Email указанный при регистрации не совпадает", email, emailText);
        Assert.assertTrue("Текст с подтвержденинем email не отображается", isDisplayed);
    }

    @Test
    public void testEmailIsNull() throws InterruptedException {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        Thread.sleep(2000);
        driver.findElement(buttonLocator).click();
        Thread.sleep(2000);
        boolean isDisplayed = driver.findElement(resultTextLocator).isDisplayed();
        String emailText = driver.findElement(resultEmailLocator).getText();

        Assert.assertEquals("Email указанный при регистрации не совпадает", "", emailText);
        Assert.assertTrue("Текст с подтвержденинем email не отображается", isDisplayed);
    }

    private final By radioButtonLocator = By.name("puppyGender");
    private final By locatorFieldEmail = By.name("email");
    private final By locatorButton = By.id("sendMe");
    private final By anotherEmailLocator = By.id("anotherEmail");
    private final By locatorResultEmail = By.tagName("pre");
    private final By locatorTextResult = By.className("result-text");
    String email = "test@test.com";

    @Test
    public void testGenderIsGirl() throws InterruptedException {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(radioButtonLocator);
        elements.get(1).click();
        driver.findElement(locatorFieldEmail).sendKeys(email);
        driver.findElement(locatorButton).click();
        Thread.sleep(2000);
        boolean isDisplayed = driver.findElement(anotherEmailLocator).isDisplayed();
        String resultEmail = driver.findElement(locatorResultEmail).getText();
        String resultText = driver.findElement(locatorTextResult).getText();
        String[] arr = resultText.split("\\s+");
        String resultGender = arr[6];
        String expectedGender = "девочки";

        Assert.assertEquals("Пол щенка не совпадает с выбранным", expectedGender, resultGender);
        Assert.assertEquals("Указанный email не совпадает с результатом", email, resultEmail);
        Assert.assertTrue("Ссылка на возможность указать другой email не отображается", isDisplayed);
    }

    @Test
    public void testGenderIsBoy() throws InterruptedException {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(radioButtonLocator);
        elements.get(0).click();
        driver.findElement(locatorButton).click();
        Thread.sleep(2000);
        String resultText = driver.findElement(locatorTextResult).getText();
        String[] arr = resultText.split("\\s+");
        String resultGender = arr[6];
        String expectedGender = "мальчика";

        Assert.assertEquals("Пол щенкка не совпадает с выбранным", expectedGender, resultGender);
    }

}
