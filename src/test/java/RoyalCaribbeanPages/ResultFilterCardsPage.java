package RoyalCaribbeanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultFilterCardsPage {
    WebDriver driver;
    Random random = new Random();


    public ResultFilterCardsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy( xpath="//div[text()='2026']//following-sibling::div/button")
    List<WebElement> monthButtons;

    @FindBy( xpath="//div[contains(@class,'FilterOptions_root')][.//span[normalize-space()='All destinations']]")
    List<WebElement> allDestinations;

    @FindBy( xpath="//button[starts-with(@data-testid,'departurePort-pill-button')]")
    List<WebElement> allDeparturePortButtons;

    @FindBy( xpath="//button[starts-with(@data-testid,'nights-pill-button')]")
    List<WebElement> AvailableListOfTimes;


    @FindBy(xpath = "//div[@id='filters-wrapper']/div/div/div/button")
    WebElement dateFilterButton;

    @FindBy(xpath = "//div[@class='Footer_root__p496ei0']/span[@class='Footer_buttonsContainer__p496ei4']/button[2]")
    WebElement footerApplyButton;

    @FindBy(xpath = "//div[@id='filters-wrapper']/div/div/div/button[2]")
    WebElement departurePortFilterButton;

    @FindBy(xpath = "//div[@id='filters-wrapper']/div/div/div/button[3]")
    WebElement destinationFilterButton;

    @FindBy(xpath = "//div[@id='filters-wrapper']/div/div/div/button[4]")
    WebElement numberOfNightsFilterButton;

    @FindBy(xpath = "//div[@class='styles__DropdownContainer-sc-5d55c2e3-1 lSAjz']/button")
    WebElement dropdownContainerButton;

    @FindBy(xpath = "//div[@class='styles__ModalDropdown-sc-5d55c2e3-4 etnqHC']/ul/li[2]")
    WebElement modalDropdownSecondOption;

    @FindBy(xpath = "//div[@data-testid='number-results-label']//span/span")
    WebElement numberResultsLabel;


    public void CruiseDates()
    {
        dateFilterButton.click();
        for (int i = 0; i < 4; i++) {
            int n = random.nextInt(monthButtons.size());
            monthButtons.get(n).click();
            monthButtons.remove(n);
        }
        footerApplyButton.click();
    }
    public void DeparturePort()
    {
        departurePortFilterButton.click();
        List<WebElement> enabledDeparturePortButtons = new ArrayList<>();
        for (WebElement button : allDeparturePortButtons) {
            if (button.isEnabled()) {
                enabledDeparturePortButtons.add(button);
            }
        }
        int n = new Random().nextInt(enabledDeparturePortButtons.size());
        WebElement SelectDeparturePort = enabledDeparturePortButtons.get(n);
        SelectDeparturePort.click();
        footerApplyButton.click();
    }
    public void DestinationPort()
    {
        destinationFilterButton.click();
        List<WebElement> enabledDestinationButtons = new ArrayList<>();
        for (WebElement button : allDestinations) {
            if (button.isEnabled()) {
                enabledDestinationButtons.add(button);
            }
        }
        int m = new Random().nextInt(enabledDestinationButtons.size());
        WebElement SelectDestination = enabledDestinationButtons.get(m);
        SelectDestination.click();
        footerApplyButton.click();
    }
    public void NumberOfNights()
    {
        numberOfNightsFilterButton.click();
        List<WebElement> enabledNightsButtons = new ArrayList<>();
        for (WebElement button : AvailableListOfTimes) {
            if (button.isEnabled()) {
                enabledNightsButtons.add(button);
            }
        }
        int o = new Random().nextInt(enabledNightsButtons.size());
        WebElement SelectNoOfNights = enabledNightsButtons.get(o);
        SelectNoOfNights.click();
        footerApplyButton.click();
    }
    public void lowToHighSort(){
        dropdownContainerButton.click();
        modalDropdownSecondOption.click();
    }
    public void getNumberOfResults(){
        String res = numberResultsLabel.getText();
        System.out.println("The number of Cruise Search Results are : "+res);
    }
}
