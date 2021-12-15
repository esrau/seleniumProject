import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario2 {
    private WebDriver driver;

    @Test
    public void scenario2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Actions actions = new Actions(driver);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Home - Sample Shop";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
           System.out.println("You're in homepage");
        else
           System.out.println("You're not in homepage");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //Sayfanın en altına scroll etme
        Thread.sleep(1000);

        boolean isDisplayed = driver.findElement(By.className("widget-title")).isDisplayed(); //Contact Info kontrolü
        if (isDisplayed){
            System.out.println("Contact Info field exists");
        }
        else{
            System.out.println("Contact Info field does not exist");
        }

        WebElement arrowIcon = driver.findElement(By.xpath("//*[@id=\"tg-scroll-to-top\"]/i"));
        actions.moveToElement(arrowIcon).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tg-scroll-to-top\"]/i"))); //Giriş yap butonu üzerinde bekletmek için
        arrowIcon.click(); //Sayfanın üstüne git butonunu tıklama
        Thread.sleep(1000);

        boolean isDisplayedPageTop = driver.findElement(By.className("tg-site-header-top")).isDisplayed(); //Sayfa bası kontrolü
        if (isDisplayedPageTop){
            System.out.println("You are top of the home page");
        }
        else{
            System.out.println("You are not top of the home page");
        }

    }

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup(); //hangi tarayıcıda test edilecekse onun driver'ı setup edilir
        driver = new ChromeDriver(); //en başta tanımlanan driver hangi tarayıcıda test edilecekse ona eşitlenir
        driver.get("https://training.qastorming.com/"); //test edilecek sitenin URL bilgisi yazılır
        driver.manage().window().maximize(); // site açılırken tam pencere açılması için
    }

    @AfterTest
    public void afterTest(){
        driver.quit(); //Test bittikten sonra tarayıcıyı kapatmak için
    }
}



