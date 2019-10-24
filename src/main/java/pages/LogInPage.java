package pages;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LogInPage {

    protected WebDriver driver;
    private Config config = new Config();

    public LogInPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h1")
    public WebElement logInFormTitle;

    @FindBy(id = "user")
    private WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id ="login")
    private WebElement logInButton;

    @FindBy(css = "#error .error-message")
    public WebElement passwordError;

    @FindBy(css = "a[href='/forgot']")
    public WebElement passwordForgot;


    public LogInPage typeEmail()
    {
        emailInput.clear();
        emailInput.sendKeys(config.getApplicationEmail());

        return this;
    }

    public LogInPage typePassword(String password)
    {
        passwordInput.clear();
        passwordInput.sendKeys(password);

        return this;
    }

    public LogInPage clickToLogin()
    {
        logInButton.click();

        return new LogInPage(driver);
    }

    public LogInPage assertFormTitleIsShown()
    {
        Assert.assertEquals( logInFormTitle.getText(), "Zaloguj do Trello");

        return this;
    }

    public LogInPage assertPasswordErrorMessageIsShown()
    {
        boolean isEqual = passwordError.getText().equals("Nieprawidłowe hasło")
                || passwordError.getText().equals("To nie jest konto dla tego e-maila");
        Assert.assertTrue(isEqual);

        return this;
    }

    public LogInPage assertPasswordFormFieldIsRed()
    {
        Assert.assertTrue(passwordInput.getAttribute("class").contains("error"));

        return this;
    }

}
