package RoyalCaribbeanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@class='siteSearchBox__input']")
    WebElement siteSearchBoxInput;

    @FindBy(xpath = "//div[@class='siteSearchBox__glassIconContainer']/img")
    WebElement siteSearchBoxGlassIcon;

    @FindBy(xpath = "//a[normalize-space(text())='Rhapsody of the Seas | Cruise Ships | Royal Caribbean Cruises']")
    WebElement rhapsodyOfTheSeasLink;

    @FindBy(xpath = "//a[@id='promoHeroCTAButton']")
    WebElement clikcBookNow;


    public void searchRhapsody(String cruiseName)
    {
        siteSearchBoxInput.click();
        siteSearchBoxInput.sendKeys(cruiseName);
        siteSearchBoxGlassIcon.click();
        rhapsodyOfTheSeasLink.click();
    }
    public void clickBookNow()
    {
        clikcBookNow.click();
    }

}
