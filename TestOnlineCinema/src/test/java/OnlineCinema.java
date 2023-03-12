import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OnlineCinema {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAllFieldFilled() {
        String name = "Иван";
        String email = "skillbox@test.ru";
        String password = "qwerty!123";

        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("form-submit")).click();

        var expectedResult = "Вам на почту " + email + " отправлено письмо";
        var actualResult = driver.findElement(By.className("form-result")).getText();

        Assert.assertEquals("Неверный текст об успешной регистрации", expectedResult, actualResult);
    }

    @Test
    public void testAllFieldNull() {
        driver.findElement(By.className("form-submit")).click();

        var expectedResult = "Введите имя";
        var actualResult = driver.findElement(By.className("form-errors")).getText();

        Assert.assertEquals(expectedResult, actualResult);
    }
}