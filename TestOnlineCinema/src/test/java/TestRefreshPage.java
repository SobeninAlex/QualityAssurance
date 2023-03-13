import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class TestRefreshPage {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
    }

    @Before
    public void sleep() throws InterruptedException {
        Thread.sleep(2500);
    }

    @After
    public void tearDown() {
        driver.navigate().refresh();
    }

    @AfterClass
    public static void exit() {
        driver.quit();
    }

    @Test
    public void testCorrectFieldOnePage() throws InterruptedException {
        String films = "Брат, Брат-2";
        String serials = "Игра престолов, Бестыжие, Шерлок";

        driver.findElement(By.id("films")).sendKeys(films);
        Thread.sleep(1500);
        driver.findElement(By.id("serials")).sendKeys(serials);
        Thread.sleep(1500);
        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        Thread.sleep(1500);
        driver.findElement(By.className("section__button")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("ok")).click();


        var actualFilms = driver.findElement(By.id("best_films")).getText();
        var actualSerials = driver.findElement(By.id("best_serials")).getText();

        Assert.assertEquals(films, actualFilms);
        Assert.assertEquals(serials, actualSerials);
        Thread.sleep(1500);
    }

    @Test
    public void testCorrectFieldTwoPage() throws InterruptedException {
        driver.findElement(By.id("two")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"page_2\"]/div[1]/div[2]/div[2]/label")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"page_2\"]/div[1]/div[2]/div[4]/label")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#page_2 > div:nth-child(2) > div.module__inputs > div:nth-child(3) > label > span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"ok\"]")).click();

        List<WebElement> list = driver.findElements(By.className("result__content"));
        var expectedSize = 4;
        var actualSeize = list.size();

        String expectedAge = "26-30";
        String actualAge = list.get(3).findElement(By.id("age")).getText();

        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedSize, actualSeize);
        Thread.sleep(1500);
    }

    @Test
    public void testAllFieldsIsNull() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"two\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"ok\"]")).click();

        List<WebElement> list = driver.findElements(By.className("result__content"));
        String actualTextFavoriteFilms = list.get(0).findElement(By.id("best_films")).getText();
        String expectedTestFavoriteFilms = "";

        Assert.assertEquals(expectedTestFavoriteFilms, actualTextFavoriteFilms);
        Thread.sleep(1500);
    }
}
