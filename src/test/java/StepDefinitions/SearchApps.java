package StepDefinitions;

import Helper.AppStoreHelper;
import Utils.UtilHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class SearchApps {

    @And("Navigated to search app section")
    public void navigatedToSearchAppSection() {
        UtilHelper.poll(3000);
        UtilHelper.clickElement(AppStoreHelper.SEARCHSCREENNAVIGATIONTAB);
    }

    @When("^User enters app (.*)in the search box$")
    public void userEntersAppAppNameInTheSearchBox(String appName) {
        UtilHelper.poll(3000);
        UtilHelper.findElement(AppStoreHelper.SEARCHAPPINPUTBOX).sendKeys(appName);
        UtilHelper.keyboardActions(Keys.ENTER);
    }

    @Then("^User should see the app (.*) in the search results$")
    public void userShouldSeeTheAppAppNameInTheSearchResults(String appName) {
        UtilHelper.poll(3000);
        UtilHelper.isElementPresents(AppStoreHelper.SEARCHSELECTEDAPPS);
    }

    @When("User selects the first app from the search list")
    public void userSelectsTheFirstAppFromTheSearchList() {
        UtilHelper.clickElement(AppStoreHelper.SEARCHSELECTEDAPPS);
    }

    @Then("User should see the app description")
    public void userShouldSeeTheAppDescription() {
        UtilHelper.poll(3000);
        UtilHelper.isElementPresents(AppStoreHelper.APPDESCRIPTION);
    }

    @And("User should see the app rating")
    public void userShouldSeeTheAppRating() {
        UtilHelper.isElementPresents(AppStoreHelper.APPRATING);
    }

    @And("User should see the app screenshots")
    public void userShouldSeeTheAppScreenshots() {
        UtilHelper.isElementPresents(AppStoreHelper.APPIMAGES);
    }


    @And("User should see app install button")
    public void userShouldSeeAppInstallButton() {
        UtilHelper.isElementPresents(AppStoreHelper.APPINSTALLBUTTON);
    }

    @And("User should see the app version")
    public void userShouldSeeTheAppVersion() {
        UtilHelper.isElementPresents(AppStoreHelper.APPVERSION);
    }

    @And("User should see the app size")
    public void userShouldSeeTheAppSize() {
        UtilHelper.isElementPresents(AppStoreHelper.APPDOWNLOADS);
    }

    @And("User should see the app share button")
    public void userShouldSeeTheAppShareButton() {
        UtilHelper.isElementPresents(AppStoreHelper.APPSHAREBUTTON);
    }

    @When("user clicks on the share button")
    public void userClicksOnTheShareButton() {
        UtilHelper.clickElement(AppStoreHelper.APPSHAREBUTTON);
    }

    @Then("User should see the share options")
    public void userShouldSeeTheShareOptions() {
        UtilHelper.poll(3000);
        UtilHelper.isElementPresents(AppStoreHelper.APPSHAREOPTIONS);
    }
}
