import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Experiment {
    @Test
    public void testAllFields() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\QualityAssurance\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://ya.ru/");
        driver.findElement(By.name("text")).sendKeys("Джек воробей");
        driver.findElement(By.className("search3__button")).click();

        driver.quit();

    }
}
