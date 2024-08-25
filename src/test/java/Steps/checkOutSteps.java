package Steps;

import management_system.classes.CheckOut;
import management_system.classes.Item;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.*;

import static management_system.classes.Item.iteams;


public class checkOutSteps {


    CheckOut check;
    String addres;
    String phone;
    String username;
    String email;
    Double totalOrder;
    public checkOutSteps() {
        check = new CheckOut();
    }

    @Given("the user has added items to their cart")
    public void theUserHasAddedItemsToTheirCart() {
        Item iteam1=new Item("nutellaCakae",50);
        Item iteam2=new Item("clasicaCakae",30);
        Item iteam3=new Item("pistashioaCakae",40);
        Item iteam4=new Item("beantbuterCakae",70);
        iteams.add(iteam1);
        iteams.add(iteam2);
        iteams.add(iteam3);
        iteams.add(iteam4);
    }
    @When("they navigate to the checkout page")
    public void theyNavigateToTheCheckoutPage() {
        assertTrue(true);
    }
    @When("add his delivery information")
    public void addHisDeliveryInformation() {
        addres = "123";
         phone = "123";
         username = "abdulhamid";
         email = "abdulhamid@gmail.com";
         totalOrder = 150.0;
    }
    @Then("they should see all items in their cart including")
    public void theyShouldSeeAllItemsInTheirCartIncluding() {
        assertTrue(check.isValidCheckOut(iteams));
    }
    @Then("see his information")
    public void seeHisInformation() {
        check.printOrderDetail(iteams,username,email,addres,phone,totalOrder);
    }
    @Then("see confirm message")
    public void seeConfirmMessage() {
        assertEquals("complete check out",check.getMsg());
    }




    @Given("the user didn't add any items")
    public void theUserDidnTAddAnyItems() {
        iteams.clear();
        assertFalse(check.isValidCheckOut(iteams));
    }

    @Then("they should see error message")
    public void theyShouldSeeErrorMessage() {
        assertEquals("incomplete check out beacuse you didnt order anythings",check.getMsg());
    }



}
