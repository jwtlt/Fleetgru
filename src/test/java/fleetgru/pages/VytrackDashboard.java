package fleetgru.pages;

import fleetgru.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class VytrackDashboard {
    public VytrackDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(linkText = "Logout")
    public WebElement logOut;

    public void logOut(){
        fullName.click();
        logOut.click();
    }

}
