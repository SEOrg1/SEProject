package Steps;

import management_system.classes.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_system.classes.Login;

import java.util.ArrayList;
import java.util.List;

import static management_system.classes.User.users;
import static org.junit.Assert.*;

public class signInSteps {

    public String username;
    public String password;
    Login login;
    public signInSteps() {

        User u1=new User("admin","admin@gmail.com","123","user");
        users.add(u1);
        login = new Login(users);
        username="";
        password="";
    }

    @Given("the user has a valid username  and password")
    public void theUserHasAValidUsernameAndPassword() {
        username="admin";
        password="123";
    }
    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        assertTrue(login.checkForLogIn(username, password));
    }
    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        assertEquals("Login Successful",login.getMsg());
    }




    @Given("the user has a valid username  and incorrect password")
    public void theUserHasAValidUsernameAndIncorrectPassword() {
       username="admin";
       password="321";
    }
    @When("the user logs in with invalid password")
    public void theUserLogsInWithInvalidPassword() {
        assertFalse(login.checkForLogIn(username, password));
    }
    @Then("the user should see an error message Login Failed")
    public void theUserShouldSeeAnErrorMessageLoginFailed() {
        assertEquals("Login Failed",login.getMsg());
    }




    @Given("the user has an invalid username  and valid password")
    public void theUserHasAnInvalidUsernameAndValidPassword() {
        username="aadmin";
        password="123";
    }
    @When("the user logs in with invalid username")
    public void theUserLogsInWithInvalidUsername() {
        assertFalse(login.checkForLogIn(username,password));
    }




    @Given("the user has an invalid username  and incorrect password")
    public void theUserHasAnInvalidUsernameAndIncorrectPassword() {
        username="aadmin";
        password="321";
    }
    @When("the user logs in with both invalid username and password")
    public void theUserLogsInWithBothInvalidUsernameAndPassword() {
        assertFalse(login.checkForLogIn(username,password));
    }




    @Given("the user has empty username and password")
    public void theUserHasEmptyUsernameAndPassword() {
       username="";
       password="";
    }
    @When("the user tries to log in with empty credentials")
    public void theUserTriesToLogInWithEmptyCredentials() {
        assertTrue(login.checkForLogIn(username,password));
    }





}
