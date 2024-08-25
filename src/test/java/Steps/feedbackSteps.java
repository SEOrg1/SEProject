package Steps;
import management_system.classes.iteam;
import management_system.classes.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static management_system.classes.iteam.iteams;
import static org.junit.Assert.*;
public class feedbackSteps {
    iteam iteam1,iteam2,iteam3;

    Order order;
    String feedback;
public feedbackSteps() {
    order = new Order();
}
    @Given("i am on order page")
    public void iAmOnOrderPage() {
        assertTrue(true);
    }
    @When("i finsh order")
    public void iFinshOrder() {
        iteam1=new iteam("cake",10);
        iteam2=new iteam("cake",10);
        iteam3=new iteam("cake",10);
        iteams.add(iteam1);
        iteams.add(iteam2);
        iteams.add(iteam3);
    }
    @Then("i add my feedback")
    public void iAddMyFeedback() {
       feedback="good price";
    }
    @Then("i should see confirm message your feedback added successfully")
    public void iShouldSeeConfirmMessageYourFeedbackAddedSuccessfully() {
        assertTrue(order.addOrderFeedback(feedback));
        assertEquals("your feedback added successfully",order.getMsg());
    }

    @Then("i miss to add my feedback")
    public void iMissToAddMyFeedback() {
        feedback=null;
    }
    @Then("i should see error message your feedback did not added successfully")
    public void iShouldSeeErrorMessageYourFeedbackDidNotAddedSuccessfully() {
        assertFalse(order.addOrderFeedback(feedback));
        assertEquals("your feedback did not added successfully",order.getMsg());
    }




}
