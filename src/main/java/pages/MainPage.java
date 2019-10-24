package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    protected WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "quick-signup-email")
    private WebElement emailInput;

    @FindBy(css = "button[type=submit]")
    private WebElement signUpButton;

    @FindBy(css = "a[href='/login']")
    private WebElement logInLink;

    public MainPage typeEmail()
    {
        emailInput.clear();
        emailInput.sendKeys("test@irmina.com");

        return this;
    }

    public SignUpPage submitEmail()
    {
        signUpButton.click();

        return new SignUpPage(driver);
    }

    public LogInPage goToLogInForm()
    {
        logInLink.click();

        return new LogInPage(driver);
    }




}
