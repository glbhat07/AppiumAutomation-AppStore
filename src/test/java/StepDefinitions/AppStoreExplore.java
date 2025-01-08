package StepDefinitions;

import Helper.AppStoreHelper;
import Utils.AppTest;
import Utils.UtilHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;

public class AppStoreExplore {

    @Given("User is in the home page of app store")
    public void userIsInTheHomePageOfAppStore() throws IOException, InterruptedException {
        AppTest.moveToHomeScreen();
    }

    @And("User can able to see the games and apps tab")
    public void userCanAbleToSeeTheGamesAndAppsTab() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.GAMESTABHOMESCREEN));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.APPSTABHOMESCREEN));
    }

    @And("^User can able to see the different app sections (.*)$")
    public void userCanAbleToSeeTheDifferentAppSectionsSection(String section) {
        String text1="Use Your AppCoins";
        UtilHelper.poll(3000);
        String locator = UtilHelper.customElementLocator(AppStoreHelper.APPSECTIONSHOMESCREEN, section);
        System.out.println("locator: "+locator);
//        UtilHelper.scrollIntoView(locator);

        UtilHelper.swipeDown(text1 , section);
        System.out.println(UtilHelper.findElements(locator).size());
        for(int i=0; i<UtilHelper.findElements(locator).size(); i++){
            System.out.println(UtilHelper.findElements(locator).get(i).getText());
        }
    }

    @And("User can able to see the navigation bar at the bottom of the page")
    public void userCanAbleToSeeTheNavigationBarAtTheBottomOfThePage() {
        UtilHelper.poll(1500);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.HOMESCREENNAVIGATIONTAB));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.EDITORIALSCREENNAVIGATIONTAB));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.SEARCHSCREENNAVIGATIONTAB));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.STORESSCREENNAVIGATIONTAB));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.APPNAVIGATIONTAB));
    }


    @Then("User can able to see the apps listed")
    public void userCanAbleToSeeTheAppsListed() {
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.APPLISTHOMESCREEN));
    }

    @When("User clicks on the games")
    public void userClicksOnTheGames() {
        UtilHelper.clickElement(AppStoreHelper.GAMESTABHOMESCREEN);
    }

    @Then("User should navigate to the games section")
    public void userShouldNavigateToTheGamesSection() {
        UtilHelper.poll(7000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.TOPGAMESHEADER));
    }

    @And("User should see the games listed")
    public void userShouldSeeTheGamesListed() {
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LISTOFAPPSINGAMESANDAPPS));
    }

    @When("User clicks on the apps")
    public void userClicksOnTheApps() {
        UtilHelper.clickElement(AppStoreHelper.APPSTABHOMESCREEN);
    }

    @Then("User should navigate to the apps section")
    public void userShouldNavigateToTheAppsSection() {
        UtilHelper.poll(5000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.TOPAPPSHEADER));
    }

    @And("User should see the apps listed")
    public void userShouldSeeTheAppsListed() {
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.LISTOFAPPSINGAMESANDAPPS));
    }

    @When("User deselects the apps")
    public void userDeselectsTheApps() {
        UtilHelper.clickElement(AppStoreHelper.APPSTABHOMESCREEN);
    }

    @Then("User should navigate back to the home page")
    public void userShouldNavigateBackToTheHomePage() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.HOMESCREENTEXT));
    }

    @When("User clicks on more on trending")
    public void userClicksOnMoreOnTrending() {
        UtilHelper.poll(3000);
        UtilHelper.clickElement(AppStoreHelper.MORETRENDINGAPPSBUTTON);
    }

    @Then("User should able to see trending apps and games section")
    public void userShouldAbleToSeeTrendingAppsAndGamesSection() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.TRENDINGAPPSECTION));
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.TRENDINGGAMESECTION));
    }

    @When("User clicks on trending games section")
    public void userClicksOnTrendingGamesSection() {
        UtilHelper.poll(3000);
        UtilHelper.findElements(AppStoreHelper.MOREBUTTONINTRENDINGPAGE).get(0).click();
    }

    @Then("User should able to see the list of top trending games")
    public void userShouldAbleToSeeTheListOfTopTrendingGames() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.GAMESANDAPPSSECTIONINTREDING));
    }


    @And("^User should able to see the list of (.*) in trending games$")
    public void userShouldAbleToSeeTheListOfGameSectionsInTrendingGames(String types) {
        String[] sections =  types.split(",");
        for(String section: sections){
           Assert.assertTrue(UtilHelper.checkListOfElementsContainsMatch(AppStoreHelper.GAMESANDAPPSSECTIONINTREDING, section));
        }
    }

    @When("User selects board game section")
    public void userSelectsBoardGameSection() {
        UtilHelper.poll(3000);
        UtilHelper.clickElement(AppStoreHelper.BOARDGAMESSECTIONINTREDING);
    }

    @Then("^User should able to see the list of board games (.*)$")
    public void userShouldAbleToSeeTheListOfBoardGamesBoardGames(String types) {
        UtilHelper.poll(3000);
        String[] sections =  types.split(",");
        for(String section: sections){
            Assert.assertTrue(UtilHelper.checkListOfElementsContainsMatch(AppStoreHelper.LISTOFBOARDGAMES, section));
        }
    }

    @When("User clicks on trending apps section")
    public void userClicksOnTrendingAppsSection() {
        UtilHelper.poll(3000);
        UtilHelper.findElements(AppStoreHelper.MOREBUTTONINTRENDINGPAGE).get(1).click();
    }

    @Then("User should able to see the list of top trending apps")
    public void userShouldAbleToSeeTheListOfTopTrendingApps() {
        UtilHelper.poll(3000);
        Assert.assertTrue(UtilHelper.isElementPresents(AppStoreHelper.GAMESANDAPPSSECTIONINTREDING));
    }

    @And("^User should able to see the list of (.*) in trending apps$")
    public void userShouldAbleToSeeTheListOfAppSectionsInTrendingApps(String types) {
        UtilHelper.poll(3000);
        String[] sections =  types.split(",");
        for(String section: sections){
            Assert.assertTrue(UtilHelper.checkListOfElementsContainsMatch(AppStoreHelper.GAMESANDAPPSSECTIONINTREDING, section), "Section not found: "+section);
        }
    }

    @When("User selects medical app section")
    public void userSelectsFitnessAppSection() {
        UtilHelper.poll(2000);
        UtilHelper.clickElement(AppStoreHelper.MEDICALINTRENDING);
    }

    @Then("^User should able to see the list of fitness related apps (.*)$")
    public void userShouldAbleToSeeTheListOfFitnessRelatedAppsFitnessApps(String types) {
        UtilHelper.poll(3000);
        String[] sections =  types.split(",");
        for(String section: sections){
            Assert.assertTrue(UtilHelper.checkListOfElementsContainsMatch(AppStoreHelper.LISTOFFITNESSAPPS, section));
        }
    }


}
