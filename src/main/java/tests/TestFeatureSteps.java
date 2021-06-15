package tests;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFeatureSteps extends GoibiboTestRunner {
    @Given("Hi")
    public void hi(){
        System.out.println("Hi From The Test Step");
    }

    @Then("Hello")
    public void hello(){
        System.out.println("Hello From The Test Step");
    }

    @Then("Bye")
    public void bye(){
        System.out.println("Bye From The Test Step");
        Assert.assertEquals(1,1);
    }
}
