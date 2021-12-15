package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import utils.Utilities;
import java.util.List;

public class Scenario1 extends Utilities {

    String productName;
    String productNumber;

    public Scenario1()
    {
        PageFactory.initElements(driver,this);
    }


    public void homePageAssert(String homePageExpected)
    {
        for (WebElement homePageButtonCheck:shopButton) {
            Assert.assertEquals(homePageExpected,homePageButtonCheck.getText());
            return;
        }
    }


   @FindBy(css = "[Class*='elementor-button-text']")
   public List<WebElement> shopButton;
    public void shopNowButton(String buttonName){
        for (WebElement button:shopButton) {
             if (button.getText().equalsIgnoreCase(buttonName)){
                 button.click();
            return;
         }
          }
         Assert.fail("There is no button for shop now");
    }




    @FindBy(css = "[Class='tg-page-header__title']")
    public WebElement productPage;
    public void productPageAssert(String productPageText)
    {
            Assert.assertEquals(productPageText,productPage.getText());
    }




//[Name='orderby']
    @FindBy(css = "[Class='products columns-3'] li:nth-child(1) a:nth-child(2)")
    public WebElement addToCart;
    public void clickAddToCart()
    {
        productName =firstProductName.getText();
        addToCart.click();
    }



    @FindBy(css = "[id='primary-menu'] li:nth-child(8)")
    public List<WebElement> goToCart;
    public void clickCart()
    {
        By viewCardSelector = By.cssSelector("[Class='added_to_cart wc-forward']");
        for (WebElement cart:goToCart) {
            if (driver.findElement(viewCardSelector).isDisplayed()){
                cart.click();
                return;
            }
    }
    }


    @FindBy(css = "[Class='products columns-3'] li:nth-child(1) a:nth-child(1) h2")
    public WebElement firstProductName;
    public void firstProductNameAssert()
    {
    System.out.println(productName);
    By firstProductFromCartSelector = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(1) td:nth-child(3)");
    String firstProductNameFromCart = driver.findElement(firstProductFromCartSelector).getText();
        System.out.println(firstProductNameFromCart);
        Assert.assertEquals(productName,firstProductNameFromCart);

    }




    @FindBy(css = "[type='number']")
    public WebElement quantity;
    public void quantitySendKeys(String productNumberFeature)
    {
        quantity.clear();
        quantity.sendKeys(productNumberFeature);
        productNumber=productNumberFeature;
    }

    @FindBy(css = "[name='update_cart']")
    public WebElement updateCart;
    public void updateCarts()
    {
        updateCart.click();
    }


    public void productPriceAssert()
    {

        By productPriceTotal = By.cssSelector("[data-title='Total'] [Class='woocommerce-Price-amount amount'] bdi");
        By updateButtonVisible = By.cssSelector("[aria-disabled='true']");
        By productPrice = By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']/td[4]/span/bdi");

            if (driver.findElement(updateButtonVisible).isDisplayed()){

                String firstProductPrice=driver.findElement(productPrice).getText();
                String forConvertProductPrice = firstProductPrice.substring(2).replaceAll(",","");

                String totalProductPrice=driver.findElement(productPriceTotal).getText();
                String forConvertTotalProductPrice = totalProductPrice.substring(2).replaceAll(",","").replace(".","");

               System.out.println(forConvertTotalProductPrice);

                int intProductPrice =Integer.parseInt(forConvertProductPrice);
                int intProductNumber =Integer.parseInt(productNumber);

                String newProductPrice=String.valueOf(intProductPrice*intProductNumber);
                System.out.println(newProductPrice);

                Assert.assertEquals(forConvertTotalProductPrice,newProductPrice);
                return;
        }
        Assert.fail("Update button is true");
    }


    @FindBy(css = "[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(1) [Class='remove']")
    public WebElement productsRemove;
    public void productRemove()
    {
        productsRemove.click();

    }
    @FindBy(css = "[Class='cart-empty woocommerce-info']")
    public WebElement productRemoveCheck;
    public void productRemoveAssert(String productRemoveText)
    {
        String productRemoveName = productRemoveCheck.getText();
        System.out.println(productRemoveName);
        Assert.assertEquals(productRemoveText,productRemoveCheck.getText());
    }
    }

