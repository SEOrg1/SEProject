package Steps;
import management_system.classes.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import static management_system.classes.User.users;
import static org.junit.Assert.*;
public class deleteUserSteps {

    String username;
    User user;
    User user1;
    public deleteUserSteps() {
         user1=new User("ali","ali@gmail.com","123456","user");
        users.add(user1);
        user =new User();
    }
    @Given("I am logged in as an administrator")
    public void iAmLoggedInAsAnAdministrator() {
        assertTrue(true);
    }
    @When("I search about specific username")
    public void iSearchAboutSpecificUsername() {
        username="ali";
    }
    @When("click the Delete button")
    public void clickTheDeleteButton() {
        assertTrue(true);
    }
    @Then("I should see a confirmation message User old_user has been successfully deleted")
    public void iShouldSeeAConfirmationMessageUserOldUserHasBeenSuccessfullyDeleted() {
        assertTrue(user.deleteUser(username));
        assertEquals("old_user has been successfully deleted",user.getMsg());
    }


    @When("I search about non-existent username")
    public void iSearchAboutNonExistentUsername() {
        username="masdas";
    }
    @When("I click the Delete button")
    public void iClickTheDeleteButton() {
       assertTrue(true);
    }
    @Then("I should see an error message cant delete because missing name or non-existent user")
    public void iShouldSeeAnErrorMessageCantDeleteBecauseMissingNameOrNonExistentUser() {
       assertFalse(user.deleteUser(username));
       assertEquals("cant delete because missing name or non-existent user",user.getMsg());

    }



    @When("I serach about missing username")
    public void iSerachAboutMissingUsername() {
        username=null;
    }


}
