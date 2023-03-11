import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    private final WebDriver driver = new ChromeDriver();
    public void setProperty() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @Test
    public void testHello() {
        setProperty();

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Алексиос");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Алексиос!";
        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }
    @Test
    public void testFieldNameIsNull() {
        setProperty();

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }
}
