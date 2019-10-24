import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;

public class SignUpTest extends SeleniumBaseTest {

    @Test
    public void incorrectSignUpEmailInUseTest()
    {
        new MainPage(driver)
                .typeEmail()
                .submitEmail();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .assertFormTitleIsShown()
                .typeName()
                .typePassword()
                .clickToRegister();

        wait.until(ExpectedConditions.visibilityOf(signUpPage.errorMessage));

        signUpPage
                .assertEmailErrorIsShown();
    }
}
