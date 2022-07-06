package fleetgru.step_definitions;

import fleetgru.pages.DriverPage;
import fleetgru.pages.LoginPage;
import fleetgru.pages.ManagerPage;
import fleetgru.utilities.BrowserUtilities;
import fleetgru.utilities.ConfigurationReader;
import fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Map;

public class LoginStepDefinition {

    DriverPage driverPage = new DriverPage();
    ManagerPage managerPage = new ManagerPage();
    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user login as {string}")
    public void userLoginAs(String arg0) {
        loginPage.loginAs(arg0);
        BrowserUtilities.sleep(5);
    }

    @Then("user land on {string}")
    public void userLandOnExpectedPage(String arg0) {
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(arg0, actualTitle);
    }

// 2 ---------------------------------------------------------------------------------------------

    @When("user enter {string} or {string}")
    public void userEnterInvalidCredentials(String arg0, String arg1) {
        loginPage.usernameBox.sendKeys(arg0);
        loginPage.passwordBox.sendKeys(arg1);
        loginPage.loginButton.click();
    }

    @Then("user should see {string}")
    public void userShouldSeeInvalidMessage(String arg0) {
        if (Driver.getDriver().getTitle().equalsIgnoreCase("Login")) {
            Assert.assertEquals(arg0, loginPage.invalidText.getText());
        } else {
            Assert.fail();
        }
    }

    // 3 ---------------------------------------------------------------------------------------------

    @When("User enter {string} or {string}")
    public void userEnterEmptyCredentials(String arg0, String arg1) {
        loginPage.usernameBox.sendKeys(arg0);
        loginPage.passwordBox.sendKeys(arg1);
        loginPage.loginButton.click();
    }

    @Then("User should see the {string} for {string} or {string}")
    public void userShouldSeeTheForOr(String arg0, String arg1, String arg2) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        if (arg1.length() == 0) {
            Assert.assertEquals(arg0, js.executeScript("return arguments[0].validationMessage;", loginPage.usernameBox));
            System.out.println("validationMessage = " + js.executeScript("return arguments[0].validationMessage;", loginPage.usernameBox));
        } else {
            Assert.assertEquals(arg0, js.executeScript("return arguments[0].validationMessage;", loginPage.passwordBox));
            System.out.println("validationMessage = " + js.executeScript("return arguments[0].validationMessage;", loginPage.passwordBox));
        }

    }

    // 4 ---------------------------------------------------------------------------------------------

    @When("User click the Forgot your password? link")
    public void userClickTheForgotYourPasswordLink() {
        loginPage.forgotPasswordText.click();
    }

    @Then("User land on the ‘Forgot Password’ page")
    public void userLandOnTheForgotPasswordPage() {
        Assert.assertEquals("Forgot Password", Driver.getDriver().getTitle());
    }

    // 5 ---------------------------------------------------------------------------------------------

    @When("User see {string} link")
    public void userSeeRememberMeLink(String arg0) {
        Assert.assertEquals(arg0,loginPage.rememberMeText.getText());
    }

    @And("User click the link")
    public void userClickTheRememberMeLink() {
        loginPage.rememberMeText.click();
    }

    @Then("User see the linkBox is marked")
    public void userSeeTheLinkBoxIsMarked() {
        Assert.assertTrue(loginPage.rememberMeButton.isSelected());
    }

    // 6 ---------------------------------------------------------------------------------------------

    @When("User enter password {string}")
    public void userEnterPassword(String arg0) {
        loginPage.passwordBox.sendKeys(arg0);
    }

    @Then("User see the password in bullet signs")
    public void userSeeThePasswordInBulletSigns() {
        System.out.println("User see the password in bullet signs");
    }

    // 7 ---------------------------------------------------------------------------------------------

    @When("User enter valid credentials")
    public void userEnterValidCredentials(Map<String, String> credentials) {
        loginPage.usernameBox.sendKeys(credentials.get("username"));
        loginPage.passwordBox.sendKeys(credentials.get("password"));
    }

    @And("User hit the {string} key of the keyboard")
    public void userHitTheEnterKeyOfTheKeyboard(String arg0) {
        loginPage.usernameBox.sendKeys(Keys.ENTER);
        BrowserUtilities.sleep(5);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }

    @Then("User land on the Quick Launchpad page")
    public void userLandOnTheQuickLaunchpadPage() {
        Assert.assertEquals("Quick Launchpad", loginPage.getPageTitle());
    }

    // 8 ---------------------------------------------------------------------------------------------

    @Then("user see their {string} in the profile menu")
    public void userSeeTheirInTheProfileMenu(String arg0) {
        Assert.assertEquals(arg0, loginPage.employeeName.getText());
    }

}

