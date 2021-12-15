package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import utils.Utilities;
import java.util.List;


public class CommonPages extends Utilities {

    public CommonPages()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[Class*='elementor-button-text']")
    public List<WebElement> shopButton;
    public void homePageAssert(String homePageExpected)
    {
        for (WebElement homePageButtonCheck:shopButton) {
            Assert.assertEquals(homePageExpected,homePageButtonCheck.getText());
            return;
        }
    }
}
