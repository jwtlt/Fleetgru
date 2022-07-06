package fleetgru.pages;

import fleetgru.utilities.ConfigurationReader;
import fleetgru.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input[name='_username']")
    public WebElement usernameBox;

    @FindBy(css = "input[name='_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public WebElement rememberMeText;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotPasswordText;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidText;

    @FindBy(className = "oro-subtitle")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"remember_me\"]")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/a")
    public WebElement employeeName;

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void loginAs(String jobTitle){

        if(jobTitle.equalsIgnoreCase("Driver")){
            usernameBox.sendKeys(ConfigurationReader.getProperty("driver_username"));
            passwordBox.sendKeys(ConfigurationReader.getProperty("driver_password"));
            loginButton.click();
        }

        else if(jobTitle.equalsIgnoreCase("sales manager")){
            usernameBox.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
            passwordBox.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
            loginButton.click();
        }

        else if(jobTitle.equalsIgnoreCase("store manager")){
            usernameBox.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
            passwordBox.sendKeys(ConfigurationReader.getProperty("store_manager_password"));
            loginButton.click();
        }

    }

    /* *
     public void waitUntilNameIsClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 8);
            wait.until(ExpectedConditions.elementToBeClickable(employeeName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

}
