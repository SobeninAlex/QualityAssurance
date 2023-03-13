import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestOnlineCinema {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
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

        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
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
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();

        var expectedResult = "Введите имя";
        var actualResult = driver.findElement(By.className("form-errors")).getText();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindElements() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");

        var emailElement = driver.findElement(By.id("email"));
        var passwordElement = driver.findElement(By.name("password"));
        var confirmPasswordElement = driver.findElement(By.id("confirm_password"));
        var buttonElement = driver.findElement(By.tagName("button"));
        var headerResultElement = driver.findElement(By.tagName("h3"));
        var email = "test@mail.com";
        var password = "123";

        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(password);
        buttonElement.click();

        var emailResultElement = driver.findElement(By.linkText(email));
//        var emailResultElement1 = driver.findElement(By.partialLinkText(email));

        Assert.assertEquals("Неверный текст при успешной регистрации", "Спасибо за регистрацию!", headerResultElement.getText());
        Assert.assertEquals("Неверный email при успешной регистрации", email, emailResultElement.getText());
    }


}