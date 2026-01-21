package RoyalCaribbeanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='notification-banner__section-close']")
    WebElement bannerCloseButton;

    @FindBy(xpath = "//li[@id='global-nav-search-button']")
    WebElement SearchButton;


    public void navigateSearch()
    {
        bannerCloseButton.click();
        SearchButton.click();
    }
}
