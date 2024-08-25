package Steps;

import management_system.classes.Item;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import static management_system.classes.Item.iteams;

public class deleteDessertSteps {

    Item iteam;
    String dessertName;
    public deleteDessertSteps() {
        iteam = new Item();
        Item iteam1 =new Item("cake",10.99);
        iteams.add(iteam1);
    }

    @Given("I am logged in as an admin to delete a dessert")
    public void iAmLoggedInAsAnAdminToDeleteADessert() {
       assertTrue(true);
    }
    @When("I serach by exist Dessert Name")
    public void iSerachByExistDessertName() {
       dessertName="cake";
    }
    @When("I click the delete Dessert button")
    public void iClickTheDeleteDessertButton() {
        assertTrue(true);
    }
    @Then("I should see a confirmation message Dessert has been deleted successfully")
    public void iShouldSeeAConfirmationMessageDessertHasBeenDeletedSuccessfully() {
        assertTrue(iteam.removeItam(dessertName));
        assertEquals("Dessert has been deleted successfully",iteam.getMsg());
    }



    @When("I serach by miss Dessert Name")
    public void iSerachByMissDessertName() {
        dessertName=null;
    }

    @Then("I should see an error message cant delete because missing name or not exist Dessert Name")
    public void iShouldSeeAnErrorMessageCantDeleteBecauseMissingNameOrNotExistDessertName() {
        assertFalse(iteam.removeItam(dessertName));
        assertEquals("cant delete because missing name or not exist Dessert Name",iteam.getMsg());
    }



    @When("I serach by not exist Dessert Name")
    public void iSerachByNotExistDessertName() {
        dessertName="hiiii";
    }


}
