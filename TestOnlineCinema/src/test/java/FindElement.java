import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class FindElement {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://qajava.skillbox.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();

//        driver.navigate().refresh();

    }

    @Test
    public void findElement() {
        driver.findElement(By.linkText("Обратная связь"));
        driver.findElement(By.linkText("Предзаказы"));
        driver.findElement(By.className("book-add")).click();
        var count = driver.findElement(By.id("cart_count"));
        driver.findElement(By.id("genres"));
        driver.findElement(By.id("search-input")).sendKeys("Мастер и Маргарита");

        List<WebElement> list = driver.findElements(By.className("book-add"));
        list.get(2).click();
        list.stream().map(WebElement::getText).forEach(System.out::println);
    }

    @Test
    public void findBookInfo() {
        List<WebElement> elements = driver.findElements(By.className("book-info"));
        elements.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

        var expectedResult = 15;
        var actualResult = elements.size();

        Assert.assertEquals(expectedResult, actualResult);
    }

}
