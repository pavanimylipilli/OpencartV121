package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement msgHeading;
    
    @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")  //added in step 6
    WebElement linkLogout;

    public boolean isMyAccountPageExists()
    {
        try
        {
            return (msgHeading.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }
    } //these are three pages home page , login page and my account page to automate the login page 


        public void clickLogout()
        {
	        linkLogout.click();
        }
}
    