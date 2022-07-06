package fleetgru.step_definitions;

import fleetgru.pages.DriverPage;
import fleetgru.pages.LoginPage;
import fleetgru.pages.ManagerPage;
import fleetgru.utilities.ConfigurationReader;
import fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class LogoutStepDefinition {

    LoginPage loginPage = new LoginPage();
    DriverPage driverPage = new DriverPage();
    ManagerPage managerPage = new ManagerPage();

    @When("user click the log out button")
    public void userClickTheLogOutButton() {
        if(loginPage.pageTitle.getText().equalsIgnoreCase("Quick Launchpad")){
            driverPage.driverLogOut();
        }
        else{
            managerPage.managerLogOut();
        }
        Assert.assertEquals("Login",Driver.getDriver().getTitle());
    }

    // 2 ------------------------------------------------------------------------

    @And("user click the step back button after logging out")
    public void userClickTheStepBackButtonAfterLoggingOut() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should not be on the homepage")
    public void userShouldNotBeOnTheHomepage() {
        Assert.assertEquals("Login",Driver.getDriver().getTitle());
    }

    // 3 -------------------------------------------------------------------------

    @When("user close all open tabs")
    public void userCloseAllOpenTabs() {
        Driver.closeBrowser();
    }

    @Then("user logged out")
    public void userLoggedOut() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Assert.assertEquals("Login",Driver.getDriver().getTitle());
    }
}
