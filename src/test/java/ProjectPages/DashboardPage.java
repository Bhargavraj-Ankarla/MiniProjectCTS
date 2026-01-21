package ProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class DashboardPage {
    WebDriver driver;
    Random random = new Random();
    int min = 0;

    public DashboardPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@id = 'FromSector_show']") WebElement fromClickElement;
    @FindBy(xpath="//div[@id='fromautoFill']/child::ul/li")
    List<WebElement> fromList;
    @FindBy(id="a_Editbox13_show") WebElement toClickElement;
    @FindBy(xpath="//div[@id='toautoFill']/child::ul/li")
    List<WebElement> toList;
    @FindBy(xpath="//div[@class='box']/div/following-sibling::div[@class='days']/ul/li")
    List<WebElement> firstMonth ;
    @FindBy(id="divRtnCal") WebElement returnclick;
    @FindBy(xpath="//div[@class='box1']/div/following-sibling::div[@class='days']/ul/li")
    List<WebElement> secondMonth;
    @FindBy(id="trvlr_colm") WebElement travellerSection;
    @FindBy(xpath="//div[@id='field1']/child::button[@id='add']") WebElement adultAdd;
    @FindBy(xpath="//div[@id='field2']/child::button[@id='add']") WebElement childAdd;
    @FindBy(xpath="//span[@id='spanBusiness']") WebElement ClassSelection;
    @FindBy(xpath="//div[@id='divSearchFlight']/input[@value='Search']") WebElement searchElement;

    public void clickFromElement()
    {
        fromClickElement.click();
    }

    public void fromLocation()
    {
        int fromListSize = fromList.size()-1;
        int fromRandomInt = random.nextInt((fromListSize - min)+1)+min;
        fromList.get(fromRandomInt).click();
    }

    public void toLocation()
    {
        toClickElement.click();
        int toListSize = toList.size()-1;
        int toRandomInt = random.nextInt((toListSize - min)+1)+min;
        toList.get(toRandomInt).click();
    }

    public void travelDate()
    {
        while(true){
            int firstMonthSize = firstMonth.size()-1;
            String currentDate = driver.findElement(By.xpath("//li[@class='active-date']")).getText();
            int firstMonthRandInt = random.nextInt((firstMonthSize - min)+1)+min;
            if(firstMonth.get(firstMonthRandInt).equals("") || !firstMonth.get(firstMonthRandInt).isEnabled()){
                continue;
            }
            if(!firstMonth.get(firstMonthRandInt).equals("") && Integer.parseInt(firstMonth.get(firstMonthRandInt).getText().split("₹")[0].trim()) > Integer.parseInt(currentDate.trim())) {
                firstMonth.get(firstMonthRandInt).click();
                break;
            }
        }
    }

    public void returnDate()
    {
        returnclick.click();
        while(true){
            int secondMonthSize = secondMonth.size()-1;
            int secondMonthRandInt = random.nextInt((secondMonthSize - min)+1)+min;
            if(!secondMonth.get(secondMonthRandInt).isEnabled()) {
                continue;
            }
            if(!secondMonth.get(secondMonthRandInt).equals("")) {
                secondMonth.get(secondMonthRandInt).click();
                break;
            }
        }
    }

    public void travellersCount()
    {
        travellerSection.click();
        adultAdd.click();
        childAdd.click();
        ClassSelection.click();
    }

    public void clickSearch()
    {
        searchElement.click();
    }



}
