package steps;

import io.cucumber.java.en.Given;
import pages.Scenario3;

public class Scenario3Steps {


    Scenario3 scenario3 = new Scenario3();


    @Given("Click shop")
    public void goToShop()
    {
        scenario3.clickShop();
    }

    @Given("Open dropdown")
    public void dropDownProducts()
    {
        scenario3.productDropDown();
    }

    @Given("Click three products")
    public void clickThreeProducts()
    {
        scenario3.clickCarts();
    }

    @Given("Change send keys product number")
    public void updateBasketPrice()
    {
        scenario3.productPrice();
    }

    @Given("Open billing page")
    public void openBillingPage()
    {
        scenario3.billingDetail();
    }

    @Given("Fill billing page")
    public void fillBillingPage() throws InterruptedException {
        scenario3.fillBillingDetail();
    }


    @Given("Open basket")
    public void openBasketPage()  {
        scenario3.clickBasket();
    }

    @Given("Remove products")
    public void removeProduct() throws InterruptedException {
        scenario3.productRemove();
    }





}
