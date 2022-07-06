package fleetgru.pages;

import fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverPage extends LoginPage{

    public DriverPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"user-menu\"]/a")
    WebElement driverMenu;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[4]/a")
    WebElement driverLogOutButton;

    public void driverLogOut(){
        driverMenu.click();
        driverLogOutButton.click();
    }

}
