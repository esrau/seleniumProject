package steps;
import io.cucumber.java.en.Given;
import pages.Scenario1;

public class Scenario1Steps {
    Scenario1 scenario1 = new Scenario1();



    @Given("Check homepage {}")
    public void homePageAssert(String homepageExpectedResult)
    {
        scenario1.homePageAssert(homepageExpectedResult);
    }



    @Given("Click SHOP NOW button from homepage {}")
    public void clickShopNow(String buttonNames)
    {
        scenario1.shopNowButton(buttonNames);
    }



    @Given("Check product page {}")
    public void checkProductPage(String productExpectedResult)
    {
        scenario1.productPageAssert(productExpectedResult);
    }



    @Given("Click add to cart")
    public void clickAddToCart()
    {
        scenario1.clickAddToCart();
    }

    @Given("Click Cart")
    public void clickCart()
    {

        scenario1.clickCart();
    }

    @Given("Check first product")
    public void firstProductNameAsserts()
    {
        scenario1.firstProductNameAssert();
    }


    @Given("Send keys quantity {}")
    public void quantitySendKey(String quantityNumber)
    {
        scenario1.quantitySendKeys(quantityNumber);
    }




    @Given("Update cart")
    public void updateCart()
    {
        scenario1.updateCarts();
    }




    @Given("Product price Assert")
    public void productPriceAssert()
    {
        scenario1.productPriceAssert();
    }



    @Given("Remove product")
    public void productRemoves()
    {
        scenario1.productRemove();
    }



    @Given("Check to remove product {}")
    public void productRemoveAssert(String productRemoveName)
    {

        scenario1.productRemoveAssert(productRemoveName);
    }

}

