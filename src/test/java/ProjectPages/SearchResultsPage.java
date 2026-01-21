package ProjectPages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[contains(@id,'DivOUT')]")
    List<WebElement> resultsSmallCards;
    @FindBy(xpath="//div[@id='divInt300']")
    List<WebElement> resultsBigCards;

    public void resultedCards()
    {
        int smallCount = resultsSmallCards.size();
        int bigCount= resultsBigCards.size();
        System.out.println("Resulted cars are : "+smallCount+bigCount);
    }

    public void TakeScreenshot()
    {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File sourcefile=ts.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\"+ timestamp+".png");
        sourcefile.renameTo(targetfile);

    }


}
