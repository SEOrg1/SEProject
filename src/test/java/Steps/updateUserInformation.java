package Steps;
import Management_System.Classes.user;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import static Management_System.Classes.user.users;
import static org.junit.Assert.*;
public class updateUserInformation {

    user u1=new user();
    String oldUsername;
    user user;
    user user2;
    String newUsername;
    String newPassword;
    String newEmailAddress;
    String newRole;
    public updateUserInformation() {
        u1=new user("noor","noor@gmail.com","12345","user");
        users.add(u1);
        user=new user();
    }

    @Given("I on update user page")
    public void iOnUpdateUserPage() {
       assertTrue(true);
    }
    @When("I search about specific user to update")
    public void iSearchAboutSpecificUserToUpdate() {
        oldUsername="noor";
    }
    @When("click the search button")
    public void clickTheSearchButton() {
       assertTrue(true);
    }
    @Then("check if this user exist")
    public void checkIfThisUserExist() {
        assertTrue(user.checkUser(oldUsername));
    }
    @Then("enter the new value for all attributs")
    public void enterTheNewValueForAllAttributs() {
        newUsername="aliii";
        newPassword="12345";
        newRole="supplier";
        newEmailAddress="aasdas@gmail.com";
        assertTrue(user.updateUser(oldUsername, newUsername, newPassword, newRole, newEmailAddress));
    }
    @Then("I should see a confirmation message user information has been updated successfully")
    public void iShouldSeeAConfirmationMessageUserInformationHasBeenUpdatedSuccessfully() {
        assertEquals("user information has been updated successfully",user.getMsg());
    }



    @When("I search about non existent user to update")
    public void iSearchAboutNonExistentUserToUpdate() {
        oldUsername="ahmad";
    }

    @Then("I should see an error message cant update because missing name or non existent user")
    public void iShouldSeeAnErrorMessageCantUpdateBecauseMissingNameOrNonExistentUser() {
        assertFalse(user.checkUser(oldUsername));
        assertEquals("cant update because missing name or non existent user",user.getMsg());
    }


    @When("I search about missind user name to update")
    public void iSearchAboutMissindUserNameToUpdate() {
        oldUsername=null;
    }


}
