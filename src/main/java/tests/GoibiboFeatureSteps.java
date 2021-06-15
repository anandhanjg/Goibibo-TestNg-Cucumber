package tests;

import controller.goibibo.Goibibo;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.InvalidDateException;

public class GoibiboFeatureSteps extends GoibiboTestRunner {


    @BeforeStep
    public void beforeStep(){
        System.out.println("Before Step");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("After Step");
    }

    @Test(groups = "Search Flight")
    @Given("Search Flight")
    public void searchFlight() throws InvalidDateException {
       Goibibo.getInstance().searchPage();
    }

    @Test(groups = "Select Flight")
    @Then("Select Flight")
    public void selectFlight(){
        Goibibo.getInstance().selectFlightPage();
    }


    @Test(groups = "Give Passenger Details")
    @Then("Give Passenger Details")
    public void givePassengerDetail(){
        Goibibo.getInstance().memberFillAndDiscountPage();
    }


}
