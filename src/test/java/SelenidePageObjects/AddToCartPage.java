package SelenidePageObjects;

import Base.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.Collections;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class AddToCartPage {


    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "Xpath")
    private WebElement element;

    private final By linkShop = By.xpath("//a[text()='Shop']");
    private final By cartCount = By.xpath("//a[@class='cart-page-link']/span");
    private final By buttonAddToCart = By.xpath("//button[@name='add-to-cart']");
    private final By iconShoppingCart = By.xpath("//i[@class='tg-icon tg-icon-shopping-cart']");
    private final By removeCartItem= By.xpath("//a[@class='remove']");

     public void clickOnShopLink(){
        String productPageTitle;
        $(linkShop)
                .should(exist)
                .shouldBe(visible).click();

        productPageTitle= title();
        assertEquals("Title of shop page does not matched", Constants.TITLE_SHOP, productPageTitle);
    }

    public void verifyCartCount(int count){
        int cartcount;
        cartcount = Integer.parseInt($(cartCount)
                .should(exist)
                .shouldBe(visible).getText());

        if(cartcount !=0){
            $(iconShoppingCart)
                    .should(exist)
                    .shouldBe(visible).click();
            $$(removeCartItem)
                    .removeAll(Collections.emptyList());
        }
        sleep(3000);
        cartcount = Integer.parseInt($(cartCount)
                .should(exist)
                .shouldBe(visible).getText());
        System.out.println(cartcount);
//        assertEquals("cart count does not matched...", count, cartcount);
    }

    public void verifyNewCartCount(int count){
        int cartcount;
        cartcount = Integer.parseInt($(cartCount)
                .should(exist)
                .shouldBe(visible).getText());
        assertEquals("cart count does not matched...", count, cartcount);
    }

    public AddToCartPage addProductToCart(String product) throws AWTException {
        $(By.xpath("//h2[text()='"+product+"']"))
                .should(exist)
                .shouldBe(visible).click();

        $(buttonAddToCart)
                .should(exist)
                .shouldBe(visible).click();
        return this;
    }


}
