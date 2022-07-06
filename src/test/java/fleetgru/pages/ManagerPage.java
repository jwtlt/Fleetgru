package fleetgru.pages;

import fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage extends LoginPage{

    public ManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"user-menu\"]/a")
    WebElement managerMenu;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[4]/a")
    WebElement managerLogOutButton;

    public void managerLogOut(){
        managerMenu.click();
        managerLogOutButton.click();
    }

}
