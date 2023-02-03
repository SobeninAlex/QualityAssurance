import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests_1 {
    private final WebDriver driver = new ChromeDriver();

    public void openPage() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
    }

    @Test
    public void testOpenPage() {
        openPage();

        var actualResult = driver.findElement(By.className("start-screen__text")).getText();
        var expectedResult = "Введите свои данные";

        try {Assert.assertEquals(expectedResult, actualResult);}
        finally {driver.quit();}
    }

    @Test
    public  void testCorrectAllData() {
        openPage();

        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan.ivanov@yandex.ru");
        driver.findElement(By.name("phone")).sendKeys("+79995554433");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan.ivanov@yandex.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79995554433.";

        try {Assert.assertEquals(expectedResult, actualResult);}
        finally {driver.quit();}
    }

    @Test
    public void testDataNoPhone() {
        openPage();

        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan.ivanov@yandex.ru");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan.ivanov@yandex.ru) отправлено письмо.\n";

        try {Assert.assertEquals(expectedResult, actualResult);}
        finally {driver.quit();}
    }

    @Test
    public void testDataNoEmail() {
        openPage();

        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("phone")).sendKeys("+79995554433");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79995554433.";

        try {Assert.assertEquals(expectedResult, actualResult);}
        finally {driver.quit();}
    }

    @Test
    public void testDataNoEmailNoPhone() {
        openPage();

        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.";

        try {Assert.assertEquals(expectedResult, actualResult);}
        finally {driver.quit();}
    }

    @Test
    public void testNoData() {
        openPage();

        driver.findElement(By.className("custom-form__button")).click();

        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Пожалуйста, введите свои данные";

        try {Assert.assertEquals(expectedResult, actualResult);}
        finally {driver.quit();}
    }

}
