package Steps;

import management_system.classes.user;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_system.classes.signUp;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class signUpSteps {
    signUp signUp;
    List<user> users;
    String userName;
    String password;
    String email;
    String role;
    boolean creatAcc;

    public signUpSteps() {
        users = new ArrayList<user>();
        signUp=new signUp(users);
    }



    @Given("the user is on the SignUp page")
    public void theUserIsOnTheSignUpPage() {
        assertTrue(true);
    }
    @When("the user provides username")
    public void theUserProvidesUsername() {
        userName="andulhamid";
    }
    @When("the user provides valid email")
    public void theUserProvidesValidEmail() {
        email="abdulhamid@gmail.com";
    }
    @When("the user provides strong password")
    public void theUserProvidesStrongPassword() {
        password="123456789";
    }
    @When("hit the register button")
    public void hitTheRegisterButton() {
        creatAcc=signUp.register(userName,email,password,role);
    }
    @Then("the user account is created successfully")
    public void theUserAccountIsCreatedSuccessfully() {

        assertTrue(creatAcc);
    }





    @When("the user submits the SignUp form with missing email")
    public void theUserSubmitsTheSignUpFormWithMissingEmail() {
        userName="abdulhamid";
        email=null;
        password="123456789";
    }

    @Then("the system displays error messages for the missing fields")
    public void theSystemDisplaysErrorMessagesForTheMissingFields() {
        creatAcc=signUp.register(userName,email,password,role);
        assertEquals("Some Missing Fields",signUp.getMsg());
    }





    @Given("an existing user with email")
    public void anExistingUserWithEmail() {
        userName="abdulhamid";
        email="abdulhamid@gmail.com";
        password="123456789";
        role="user";
        user u1=new user(userName,email,password,role);
        users.add(u1);
    }
    @When("the user provides a contact email that is already registered")
    public void theUserProvidesAContactEmailThatIsAlreadyRegistered() {
        creatAcc=signUp.register(userName,email,password,role);
    }
    @Then("the system displays an existing contact email error message")
    public void theSystemDisplaysAnExistingContactEmailErrorMessage() {
        assertEquals("Email Already Exists",signUp.getMsg());
    }






    @When("the user submits the SignUp form with missing username")
    public void theUserSubmitsTheSignUpFormWithMissingUsername() {
        userName=null;
        email="abdulhamid@gmail.com";
        password="123456789";
    }






    @When("the user submits the SignUp form with missing password")
    public void theUserSubmitsTheSignUpFormWithMissingPassword() {
        userName="abdulhamid";
        password=null;
        email="abdulhamid@gmail.com";
        assertFalse(signUp.register(userName,email,password,role));
    }




    @When("the user provides a password that is too short")
    public void theUserProvidesAPasswordThatIsTooShort() {
        password="123";
    }
    @Then("the system displays a weak password error message says")
    public void theSystemDisplaysAWeakPasswordErrorMessageSays() {
        creatAcc=signUp.register(userName,email,password,role);
        assertEquals(signUp.getMsg(),"your password is too weak");
    }




}
