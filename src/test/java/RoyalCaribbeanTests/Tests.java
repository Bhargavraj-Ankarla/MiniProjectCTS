package RoyalCaribbeanTests;
import RoyalCaribbeanPages.HomePage;
import RoyalCaribbeanPages.ResultFilterCardsPage;
import RoyalCaribbeanPages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    WebDriver driver;

    @BeforeClass
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.royalcaribbean.com/alaska-cruises");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test(priority = 1)
    void HomepageTests()
    {
        HomePage hp =new HomePage(driver);
        hp.navigateSearch();
    }

    @Test(priority = 10)
    void SearchPageTests()
    {
        SearchPage sp = new SearchPage(driver);
            sp.searchRhapsody("Rhapsody of the Seas");
            sp.clickBookNow();
    }
    @Test(priority = 20)
    void FilteredResultsTests()
    {
        ResultFilterCardsPage rfp = new ResultFilterCardsPage(driver);
        rfp.CruiseDates();
        rfp.DeparturePort();
        rfp.DestinationPort();
        rfp.NumberOfNights();
        rfp.lowToHighSort();
        rfp.getNumberOfResults();
    }

    @AfterClass
    void tearDown()
    {
        driver.quit();
    }
}
