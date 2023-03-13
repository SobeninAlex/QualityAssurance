import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestShoesShop {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckSizeShoes() {
        driver.findElement(By.tagName("input")).sendKeys("42");
        driver.findElement(By.id("check-size-button")).click();

        var expectedResult = "В нашем магазине есть обувь вашего размера";
        var actualResult = driver.findElement(By.tagName("label")).getText();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckSizeShoesNegative() {
        driver.findElement(By.id("size")).sendKeys("33");
        driver.findElement(By.tagName("button")).click();

        var expectedResult = "В нашем магазине нет обуви вашего размера";
        var actualResult = driver.findElement(By.id("size-error")).getText();

        Assert.assertEquals("Неверный текст сообщения об ошибке", expectedResult, actualResult);
    }
}
