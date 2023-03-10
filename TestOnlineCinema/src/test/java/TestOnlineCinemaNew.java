import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class TestOnlineCinemaNew {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCorrectFieldOnePage() {
        setUp();
        String films = "Брат, Брат-2";
        String serials = "Игра престолов, Бестыжие, Шерлок";

        driver.findElement(By.id("films")).sendKeys(films);
        driver.findElement(By.id("serials")).sendKeys(serials);
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("ok")).click();

        var actualFilms = driver.findElement(By.id("best_films")).getText();

        var actualSerials = driver.findElement(By.id("best_serials")).getText();

        Assert.assertEquals(films, actualFilms);
        Assert.assertEquals(serials, actualSerials);
    }

    @Test
    public void testCorrectFieldTwoPage() {
        driver.findElement(By.id("two")).click();
        driver.findElement(By.xpath("//*[@id=\"page_2\"]/div[1]/div[2]/div[2]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"page_2\"]/div[1]/div[2]/div[4]/label")).click();
        driver.findElement(By.cssSelector("#page_2 > div:nth-child(2) > div.module__inputs > div:nth-child(3) > label > span")).click();
        driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ok\"]")).click();

        List<WebElement> list = driver.findElements(By.className("result__content"));
        var expectedSize = 4;
        var actualSeize = list.size();

        String expectedAge = "26-30";
        String actualAge = list.get(3).findElement(By.id("age")).getText();

        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedSize, actualSeize);
    }

    @Test
    public void testAllFieldsIsNull() {
        driver.findElement(By.xpath("//*[@id=\"two\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ok\"]")).click();

        List<WebElement> list = driver.findElements(By.className("result__content"));
        String actualTextFavoriteFilms = list.get(0).findElement(By.id("best_films")).getText();
        String expectedTestFavoriteFilms = "";

        Assert.assertEquals(expectedTestFavoriteFilms, actualTextFavoriteFilms);
    }

}
