package StepDefinitions;

import Helper.AppStoreHelper;
import Utils.UtilHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AppStoreNavigation {

    @When("User click on the system installed app section")
    public void userClickOnTheSystemInstalledAppSection() {
        UtilHelper.clickElement(AppStoreHelper.APPNAVIGATIONTAB);
    }

    @Then("User should see the system installed app section page")
    public void userShouldSeeTheSystemInstalledAppSectionPage() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.elementText(AppStoreHelper.SYSTEMINSTALLEDAPPHEADER).equalsIgnoreCase("Installed"));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.SYSTEMINSTALLEDAPPS));
    }

    @And("User should able to see the appName and version of the installed apps")
    public void userShouldAbleToSeeTheAppNameAndVersionOfTheInstalledApps() {
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.SYSTEMINSTALLEDAPPSNAME));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.SYSTEMINSTALLEDAPPSVERSION));
    }

    @When("User click on the editorial section")
    public void userClickOnTheEditorialSection() {
        UtilHelper.clickElement(AppStoreHelper.EDITORIALSCREENNAVIGATIONTAB);
    }

    @Then("User should see the editorial app section page")
    public void userShouldSeeTheEditorialAppSectionPage() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.EDITORIALAPPS));
    }

    @When("User click on the Store section")
    public void userClickOnTheStoreSection() {
        UtilHelper.clickElement(AppStoreHelper.STORESSCREENNAVIGATIONTAB);
    }

    @Then("User should see the Store section page")
    public void userShouldSeeTheStoreSectionPage() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.FOLLOWEDSTOREHEADER));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.RECOMMENDEDSTORESHEADER));
    }

    @And("User should see the login option")
    public void userShouldSeeTheLoginOption() {
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LOGINBUTTON));
    }

    @When("User clicks on login option")
    public void userClicksOnLoginOption() {
        UtilHelper.clickElement(AppStoreHelper.LOGINBUTTON);
    }

    @Then("^User should see the login page and different login options (.*)$")
    public void userShouldSeeTheLoginPageAndDifferentLoginOptionsLoginOptions(String loginOption) {
        UtilHelper.poll(3000);
        if(loginOption.equalsIgnoreCase("Facebook"))
            Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LOGINWITHFACEBOOK));
        else if(loginOption.equalsIgnoreCase("Google"))
            Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LOGINWITHGOOGLE));
        else if(loginOption.equalsIgnoreCase("Email"))
            Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LOGINWITHEMAIL));

    }

    @And("User should see the Terms and conditions and privacy policy")
    public void userShouldSeeTheTermsAndConditionsAndPrivacyPolicy() {
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.TNCCHECKBOX));
    }

    @When("User clicks on connect with email option")
    public void userClicksOnConnectWithEmailOption() {
        UtilHelper.clickElement(AppStoreHelper.LOGINWITHEMAIL);
    }

    @Then("user should see the error message for not accepting the tnC")
    public void userShouldSeeTheErrorMessageForNotAcceptingTheTnC() {
        UtilHelper.poll(1000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LOGINERRORSNACKBAR));
    }

    @When("User accepts the tnC")
    public void userAcceptsTheTnC() {
        UtilHelper.clickElement(AppStoreHelper.TNCCHECKBOX);
    }

    @Then("User should see the email login page")
    public void userShouldSeeTheEmailLoginPage() {
        UtilHelper.poll(2000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.EMAILENTRYBOX));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.SENDMAGICLINKBUTTONFORLOGIN));
    }
}
