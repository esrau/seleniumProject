package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utilities;

import java.util.ArrayList;
import java.util.List;




public class Scenario3 extends Utilities {


    String productName1;
    String productName2;
    String productName3;


    public Scenario3()
    {
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "[id='primary-menu'] li:nth-child(4)")
    public WebElement goToShop;
    public void clickShop()
    {
        goToShop.click();
    }


    @FindBy(css = "[Name='orderby']")
    public WebElement dropDownMenu;
    public void productDropDown()
    {
        Select dropDown = new Select(dropDownMenu);
        dropDown.selectByIndex(2);
    }

    @FindBy(css = "[Class='products columns-3'] li:nth-child(1) a:nth-child(1) h2")
    public WebElement ProductNames1;

    @FindBy(css = "[Class='products columns-3'] li:nth-child(2) a:nth-child(1) h2")
    public WebElement ProductNames2;

    @FindBy(css = "[Class='products columns-3'] li:nth-child(3) a:nth-child(1) h2")
    public WebElement ProductNames3;


    public void clickCarts(){
        By product1 = By.cssSelector("[Class='products columns-3'] li:nth-child(1) a:nth-child(2)");
        By product2 = By.cssSelector("[Class='products columns-3'] li:nth-child(2) a:nth-child(2)");
        By product3 = By.cssSelector("[Class='products columns-3'] li:nth-child(3) a:nth-child(2)");
        By viewCart = By.cssSelector("[Class='products columns-3'] li:nth-child(3) a:nth-child(3)");

        productName1 =ProductNames1.getText();
        productName2 =ProductNames2.getText();
        productName3 =ProductNames3.getText();

        driver.findElement(product1).click();
        driver.findElement(product2).click();
        driver.findElement(product3).click();

        driver.findElement(viewCart).click();

        By assertProduct1 = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(1) td:nth-child(3)");
        By assertProduct2 = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(2) td:nth-child(3)");
        By assertProduct3 = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(3) td:nth-child(3)");

        String assert1 =driver.findElement(assertProduct1).getText();
        String assert2 =driver.findElement(assertProduct2).getText();
        String assert3 =driver.findElement(assertProduct3).getText();

        Assert.assertEquals(productName1,assert1);
        Assert.assertEquals(productName2,assert2);
        Assert.assertEquals(productName3,assert3);

        }


    @FindBy(css = "[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(1) td:nth-child(5) input")
    public WebElement quantity1;

    @FindBy(css = "[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(2) td:nth-child(5) input")
    public WebElement quantity2;

    @FindBy(css = "[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(3) td:nth-child(5) input")
    public WebElement quantity3;


        public void productPrice ()
        {


            By price1 = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(1) td:nth-child(4) bdi");
            By price2 = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(2) td:nth-child(4) bdi");
            By price3 = By.cssSelector("[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(3) td:nth-child(4) bdi");


            String firstProductPrice=driver.findElement(price1).getText();
            String forConvertProductPrice1 = firstProductPrice.substring(2).replaceAll(",","");


            String secondProductPrice=driver.findElement(price2).getText();
            String forConvertProductPrice2 = secondProductPrice.substring(2).replaceAll(",","");

            String thirdProductPrice=driver.findElement(price3).getText();
            String forConvertProductPrice3 = thirdProductPrice.substring(2).replaceAll(",","").replace(".","");


            int intProductPrice1 =Integer.parseInt(forConvertProductPrice1);
            int intProductPrice2 =Integer.parseInt(forConvertProductPrice2);
            int intProductPrice3 =Integer.parseInt(forConvertProductPrice3);


            System.out.println(intProductPrice1);
            System.out.println(intProductPrice2);
            System.out.println(intProductPrice3);


            if((intProductPrice1>intProductPrice2) && (intProductPrice1>intProductPrice3)){
                quantity1.clear();
                quantity1.sendKeys("2");



            }
            else if ((intProductPrice2>intProductPrice1) && (intProductPrice2>intProductPrice3)){
                quantity2.clear();
                quantity2.sendKeys("2"); }

            else if ((intProductPrice3>intProductPrice1) && (intProductPrice3>intProductPrice2)){
                quantity3.clear();
                quantity3.sendKeys("2");
                 }

            if((intProductPrice1<intProductPrice2) && (intProductPrice1<intProductPrice3) ){
                quantity1.clear();
                quantity1.sendKeys("4"); }
            else if ((intProductPrice2<intProductPrice1) && (intProductPrice2<intProductPrice3) ){
                quantity2.clear();
                quantity2.sendKeys("4"); }

            else if ((intProductPrice3<intProductPrice1) && (intProductPrice3<intProductPrice2) ){
                quantity3.clear();
                quantity3.sendKeys("4");
            }
        }
    @FindBy(css = "[Class='wc-proceed-to-checkout'] a")
    public WebElement billing;
    public void billingDetail ()
    {

        billing.click();

    }
    @FindBy(css = "[Name='billing_first_name']")
    public WebElement name;
    @FindBy(css = "[Name='billing_last_name']")
    public WebElement lastName;
    @FindBy(css = "[Name='billing_address_1']")
    public WebElement address1;

    @FindBy(css = "[Name='billing_address_2']")
    public WebElement address2;


    @FindBy(css = "[Name='billing_postcode']")
    public WebElement postCode;

    @FindBy(css = "[Name='billing_city']")
    public WebElement city;

    @FindBy(css = "[Name='billing_phone']")
    public WebElement phone;

    @FindBy(css = "[Name='billing_email']")
    public WebElement email;

    @FindBy(css = "[Name='order_comments']")
    public WebElement comments;

    @FindBy(css = "[id='mailpoet_woocommerce_checkout_optin']")
    public WebElement checkbox;



    public void fillBillingDetail () throws InterruptedException {

        name.clear();
        name.sendKeys("Talha");

        lastName.clear();
        lastName.sendKeys("Begendi");

        address1.clear();
        address1.sendKeys("Istanbul");

        address2.clear();
        address2.sendKeys("Ankara");

        postCode.clear();
        postCode.sendKeys("34000");

        postCode.clear();
        postCode.sendKeys("34000");

        city.clear();
        city.sendKeys("Izmir");

        phone.clear();
        phone.sendKeys("5321456985");

        email.clear();
        email.sendKeys("asd@gmail.com");

        comments.clear();
        comments.sendKeys("Test");

        Thread.sleep(3500);
        checkbox.click();
    }
    @FindBy(css = "[id='primary-menu'] li:nth-child(8)")
    public WebElement goToCart;
    public void clickBasket()
    {
        goToCart.click();

    }
    @FindBy(css = "[Class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] tbody tr:nth-child(1) [Class='remove']")
    public WebElement productsRemove1;
    public void productRemove () throws InterruptedException
    {
        productsRemove1.click();
        Thread.sleep(5000);
        productsRemove1.click();
        Thread.sleep(5000);
        productsRemove1.click();
    }
    }















