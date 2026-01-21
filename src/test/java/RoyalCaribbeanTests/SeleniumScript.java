package RoyalCaribbeanTests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeleniumScript {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.manage().window().maximize();
        driver.get("https://www.royalcaribbean.com/alaska-cruises");

        driver.findElement(By.xpath("//div[@class='notification-banner__section-close']")).click();

        driver.findElement(By.xpath("//li[@id='global-nav-search-button']")).click();

        driver.findElement(By.xpath("//input[@class='siteSearchBox__input']")).click();

        driver.findElement(By.xpath("//input[@class='siteSearchBox__input']")).sendKeys("Rhapsody of the Seas");

        driver.findElement(By.xpath("//div[@class='siteSearchBox__glassIconContainer']/img")).click();

        driver.findElement(By.xpath("//a[normalize-space(text())='Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises']")).click();

        driver.findElement(By.xpath("//a[@id='promoHeroCTAButton']")).click();

        driver.findElement(By.xpath("//button[@data-testid='date-filter-button']")).click();
        List<WebElement> monthButtons = driver.findElements(By.xpath("//div[text()='2026']//following-sibling::div/button"));
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int n = random.nextInt(monthButtons.size());
            monthButtons.get(n).click();
            monthButtons.remove(n);
        }
        driver.findElement(By.xpath("//div[@class='Footer_root__p496ei0']/span[@class='Footer_buttonsContainer__p496ei4']/button[2]")).click();


        driver.findElement(By.xpath("//button[@data-testid='departure-port-filter-button']")).click();
        List<WebElement> allDeparturePortButtons = driver.findElements(By.xpath("//button[starts-with(@data-testid,'departurePort-pill-button')]"));
        List<WebElement> enabledDeparturePortButtons = new ArrayList<>();
        for (WebElement button : allDeparturePortButtons) {
            if (button.isEnabled()) {
                enabledDeparturePortButtons.add(button);
            }
        }
        int n = new Random().nextInt(enabledDeparturePortButtons.size());
        WebElement SelectDeparturePort = enabledDeparturePortButtons.get(n);
        SelectDeparturePort.click();
        driver.findElement(By.xpath("//div[@class='Footer_root__p496ei0']/span[@class='Footer_buttonsContainer__p496ei4']/button[2]")).click();



        driver.findElement(By.xpath("//button[@data-testid='destination-filter-button']")).click();
        List<WebElement> allDestinations = driver.findElements(By.xpath("//div[contains(@class,'FilterOptions_root')][.//span[normalize-space()='All destinations']]"));
        List<WebElement> enabledDestinationButtons = new ArrayList<>();
        for (WebElement button : allDestinations) {
            if (button.isEnabled()) {
                enabledDestinationButtons.add(button);
            }
        }
        int m = new Random().nextInt(enabledDestinationButtons.size());
        WebElement SelectDestination = enabledDestinationButtons.get(m);
        SelectDestination.click();
        driver.findElement(By.xpath("//div[@class='Footer_root__p496ei0']/span[@class='Footer_buttonsContainer__p496ei4']/button[2]")).click();



        driver.findElement(By.xpath("//button[@data-testid='number-of-nights-filter-button']")).click();
        List<WebElement> AvailableListOfTimes =  driver.findElements(By.xpath("//button[starts-with(@data-testid,'nights-pill-button')]"));
        List<WebElement> enabledNightsButtons = new ArrayList<>();
        for (WebElement button : AvailableListOfTimes) {
            if (button.isEnabled()) {
                enabledNightsButtons.add(button);
            }
        }
        int o = new Random().nextInt(enabledNightsButtons.size());
        WebElement SelectNoOfNights = enabledNightsButtons.get(o);
        SelectNoOfNights.click();
        driver.findElement(By.xpath("//div[@class='Footer_root__p496ei0']/span[@class='Footer_buttonsContainer__p496ei4']/button[2]")).click();



        driver.findElement(By.xpath("//div[@class='styles__DropdownContainer-sc-5d55c2e3-1 lSAjz']/button")).click();
        driver.findElement(By.xpath("//div[@class='styles__ModalDropdown-sc-5d55c2e3-4 etnqHC']/ul/li[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        TakesScreenshot ts=(TakesScreenshot)driver;
        File sourcefile=ts.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\"+ timestamp+".png");
        sourcefile.renameTo(targetfile);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bannerCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='number-results-label']//span/span")));
        String resultsCount = driver.findElement(By.xpath("//div[@data-testid='number-results-label']//span/span")).getText();
        System.out.println("The number of Cruise Search Results are : "+resultsCount);

        driver.quit();
    }


}

