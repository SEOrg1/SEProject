package Steps;

import Management_System.Classes.iteam;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class addDessertSteps {

    String dessertName;
    double dessertPrice;
    String dessertDesc;
    iteam iteam;
    public addDessertSteps() {
        iteam=new iteam();
    }
    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        assertTrue(true);
    }
    @Given("I am on the Add Dessert page")
    public void iAmOnTheAddDessertPage() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(true);
    }
    @When("I add  Dessert Name")
    public void iAddDessertName() {
        dessertName="cake";
        iteam.setName(dessertName);
    }
    @When("I add  Description for dessert")
    public void iAddDescriptionForDessert() {
        dessertDesc="cake and egg";
        iteam.setDescription(dessertDesc);
    }
    @When("I add  Price for dessert")
    public void iAddPriceForDessert() {
        dessertPrice=5.99;
        iteam.setPrice(dessertPrice);
    }
    @When("I click the Add Dessert button")
    public void iClickTheAddDessertButton() {
        assertTrue(true);
    }
    @Then("I should see a confirmation message Dessert has been added successfully")
    public void iShouldSeeAConfirmationMessageDessertHasBeenAddedSuccessfully() {
        assertTrue(iteam.addIteam(dessertName,dessertDesc,dessertPrice));
        assertEquals(iteam.getMsg(),"Dessert has been added successfully");

    }




    @Then("I should see an error message Dessert name is required")
    public void iShouldSeeAnErrorMessageDessertNameIsRequired() {
        dessertName=null;
        assertFalse(iteam.addIteam(dessertName,dessertDesc,dessertPrice));
        assertEquals(iteam.getMsg(),"Dessert name is required");
    }


    @When("I add  name for dessert")
    public void iAddNameForDessert() {
        dessertName="cake";
    }

    @Then("I should see an error message Dessert price is required")
    public void iShouldSeeAnErrorMessageDessertPriceIsRequired() {
        dessertPrice=0.0;
        assertFalse(iteam.addIteam(dessertName,dessertDesc,dessertPrice));
        assertEquals(iteam.getMsg(),"Dessert price is required");

    }




}
