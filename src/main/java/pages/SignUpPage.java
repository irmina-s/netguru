package pages;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SignUpPage {

    protected WebDriver driver;
    private Config config = new Config();

    public SignUpPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "h1")
    private WebElement formTitleText;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "signup")
    private WebElement signUpButton;

    @FindBy(css = "#error .error-message")
    public WebElement errorMessage;

    public SignUpPage typeName()
    {
        nameInput.clear();
        nameInput.sendKeys(config.getApplicationUser());

        return this;
    }

    public SignUpPage typePassword()
    {
        passwordInput.clear();
        passwordInput.sendKeys(config.getApplicationIncorrectPassword());

        return this;
    }

    public SignUpPage clickToRegister()
    {
        signUpButton.click();

        return this;
    }

    public SignUpPage assertFormTitleIsShown()
    {
        Assert.assertEquals(formTitleText.getText(), "Stwórz konto Trello");

        return this;
    }

    public SignUpPage assertEmailErrorIsShown()
    {
        Assert.assertTrue(errorMessage.getText().contains("E-mail jest już w użyciu przez niepotwierdzone konto."));

        return this;
    }
}
