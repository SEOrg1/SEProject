package Steps;
import Management_System.Classes.supplierProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static Management_System.Classes.supplierProduct.supplierProducts;
import static org.junit.Assert.*;
public class deleteSupplierProduct {

    String productName;
    supplierProduct product;
    supplierProduct product1;
    public deleteSupplierProduct() {
        product = new supplierProduct();
        product1 = new supplierProduct("ahmad","nuts",15.1);
        supplierProducts.add(product1);
    }

    @Given("I am logged in as an admin to delete a product")
    public void iAmLoggedInAsAnAdminToDeleteAProduct() {
        assertTrue(true);
    }
    @When("I serach by exist product Name")
    public void iSerachByExistProductName() {
        productName="nuts";
    }
    @When("I click on the delete button")
    public void iClickOnTheDeleteButton() {
        assertTrue(true);
    }
    @Then("I should see a confirmation message product has been deleted successfully")
    public void iShouldSeeAConfirmationMessageProductHasBeenDeletedSuccessfully() {
        assertTrue(product.deleteSupplierProduct(productName));
        assertEquals("product has been deleted successfully",product.getMsg());
    }



    @When("I serach by miss product Name")
    public void iSerachByMissProductName() {
        productName=null;
    }

    @Then("I should see an error message cant delete because missing name or non exist product Name")
    public void iShouldSeeAnErrorMessageCantDeleteBecauseMissingNameOrNonExistProductName() {
        assertFalse(product.deleteSupplierProduct(productName));
        assertEquals("cant delete because missing name or non exist product Name",product.getMsg());
    }



    @When("I serach by non exist product Name")
    public void iSerachByNonExistProductName() {
        productName="cocount";
    }

}
