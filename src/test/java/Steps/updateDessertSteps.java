package Steps;
import Management_System.Classes.iteam;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import static Management_System.Classes.iteam.iteams;
public class updateDessertSteps {
    iteam iteam3;
    String dessertName;
    iteam iteam;
    String dessertDesc;
    Double dessertPrice;
    String newName;

    public updateDessertSteps(){
        iteam3=new iteam("nutellacake",50);
        iteams.add(iteam3);
        iteam=new iteam();

    }
    @Given("I on update page")
    public void iOnUpdatePage() {
        assertTrue(true);
    }
    @When("I search about specific dessert to update")
    public void iSearchAboutSpecificDessertToUpdate() {
        dessertName="nutellacake";
    }
    @When("click the serch button")
    public void clickTheSerchButton() {
        assertTrue(true);
    }

    @Then("check if this dessert exist")
    public void checkIfThisDessertExist() {
        assertTrue(iteam.cheakIteam(dessertName));
    }
    @Then("enter the new value for all the attributs")
    public void enterTheNewValueForAllTheAttributs() {
        newName="nutellacake11";
        dessertPrice=15.9;
        dessertDesc="asdasd";
        assertTrue(iteam.updateIteam(dessertName,newName,dessertDesc,dessertPrice));
    }
    @Then("I should see a confirmation message Dessert has been updated successfully")
    public void iShouldSeeAConfirmationMessageDessertHasBeenUpdatedSuccessfully() {
         assertEquals(iteam.getMsg(),"Dessert has been updated successfully");
    }




    @When("I search about non existent dessert to update")
    public void iSearchAboutNonExistentDessertToUpdate() {
        dessertName="asd";
    }

    @Then("I should see an error message cant update because missing name or non existent dessert")
    public void iShouldSeeAnErrorMessageCantUpdateBecauseMissingNameOrNonExistentDessert() {
        assertFalse(iteam.cheakIteam(dessertName));
        assertEquals(iteam.getMsg(),"cant found dessert because missing name or non existent dessert");
    }



    @When("I search about missind dessert name to update")
    public void iSearchAboutMissindDessertNameToUpdate() {
        dessertName=null;
    }


}
