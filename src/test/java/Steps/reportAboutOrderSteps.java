package Steps;
import Management_System.Classes.iteam;
import Management_System.Classes.order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Management_System.Classes.iteam.iteams;
import static Management_System.Classes.order.orders;
import static org.junit.Assert.*;
public class reportAboutOrderSteps {
    iteam iteam1;
    iteam iteam2;
    iteam iteam3;
    String userName;
    order order;

    public reportAboutOrderSteps() {
        iteam1 = new iteam("cake1",5.1);
        iteam2 = new iteam("cake2",5.1);
        iteam3 = new iteam("cake3",5.1);
        iteams.add(iteam1);
        iteams.add(iteam2);
        iteams.add(iteam3);
        order=new order();
    }
    @Given("I am on the Report page")
    public void iAmOnTheReportPage() {
        assertTrue(true);
    }
    @Given("there is order")
    public void thereIsOrder() {
        userName="abdulhamid";
        order.addOrder(iteams,userName);
    }
    @When("I click to generate order")
    public void iClickToGenerateOrder() {
        assertTrue(true);
    }
    @Then("I should see deteails about every order")
    public void iShouldSeeDeteailsAboutEveryOrder() {
        order.printReportOrder(orders);
    }



    @Given("there is no order")
    public void thereIsNoOrder() {
        orders.clear();
        assertTrue(orders.isEmpty());
    }

    @Then("I should see error message cannot generate report because there is no order")
    public void iShouldSeeErrorMessageCannotGenerateReportBecauseThereIsNoOrder() {
        assertFalse(order.printReportOrder(orders));
        assertEquals(order.getMsg(),"cannot generate report because there is no order");
    }



}
