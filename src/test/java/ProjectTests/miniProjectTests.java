package ProjectTests;

import ProjectPages.DashboardPage;
import ProjectPages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class miniProjectTests {
    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.easemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test(priority = 1)
    void easyMyTripDashBoardTests()
    {
        DashboardPage dp=new DashboardPage(driver);
        dp.clickFromElement();
        dp.fromLocation();
        dp.toLocation();
        dp.travelDate();
        dp.returnDate();
        dp.travellersCount();
        dp.clickSearch();
    }
    @Test(priority = 2 ,dependsOnMethods = {"easyMyTripDashBoardTests"})
    void easyMyTripSearchResultsTests()
    {
        SearchResultsPage sr = new SearchResultsPage(driver);
        sr.resultedCards();
        sr.TakeScreenshot();
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}
