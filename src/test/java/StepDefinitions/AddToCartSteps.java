package StepDefinitions;

import SelenidePageObjects.AddToCartPage;
import Utilities.CommonAttribute;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.awt.*;


public class AddToCartSteps {

    private final AddToCartPage addToCartPage;

    public AddToCartSteps(){

        addToCartPage=new AddToCartPage(CommonAttribute.driver);
    }

    @Given("^I click on Shop link on Home Page$")
     public void iClickOnShopLinkOnHomePage() {
        addToCartPage.clickOnShopLink();
    }

    @And("^I verify the cart count as (.+)$")
    public void iVerifyTheCartCountAsOldCartCount(int count) {
        addToCartPage.verifyCartCount(count);
    }

    @And("^I verify the new cart count as (.+)$")
    public void iVerifyTheNewCartCountAsOldCartCount(int count) {
        addToCartPage.verifyNewCartCount(count);
    }

    @And("^I added (.+) to cart$")
    public void iAddedProductToCart(String product) throws AWTException {
        addToCartPage.addProductToCart(product);
    }
}
