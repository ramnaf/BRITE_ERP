package com.briteerp.pages;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends TestBase {


    static LoginPage obj=PageFactory.initElements(Driver.getDriver(), LoginPage.class);
    static credentials infos= new credentials();

    static	@FindBy(xpath = "html/body/div[1]/div/div[2]/a[2]")
    WebElement firstClick;

    static	    @FindBy(xpath = ".//*[@id='login']")
    WebElement email;

    static    @FindBy(xpath = ".//*[@id='password']")
    WebElement password;

    static    @FindBy(xpath = ".//*[@id='wrapwrap']/main/div/form/div[4]/button")
    WebElement singinButton;

    static	 @FindBy(xpath = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[13]/a/span")
    WebElement LucnModel;

    static  @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
    WebElement okButton;

    public  static void Managerlogin(WebDriver driver) throws InterruptedException {
        driver.get("http://52.39.162.23/web/login");

        firstClick.click();

        email.sendKeys(infos.getManagerEmail());
        password.sendKeys(infos.getManagerPassword());

        singinButton.click();

        Thread.sleep(6000);
        LucnModel.click();

        Actions actToOkButton = new Actions(Driver.getDriver());
        Thread.sleep(2000);

        actToOkButton.moveToElement(okButton).perform();   // in Actions, we have to do the perform  in order to execute

        Thread.sleep(2000);


        okButton.click();

    }
    public static void Userlogin(WebDriver driver) {
        driver.get("http://52.39.162.23/web/login");
        wait.until(ExpectedConditions.visibilityOf(firstClick));
        firstClick.click();

        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(infos.getUserEmail());

        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(infos.getUserPassword());

        wait.until(ExpectedConditions.visibilityOf(singinButton));
        singinButton.click();
    }


}
