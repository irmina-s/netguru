import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MainPage;

public class LogInTest extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getWrongPasswords()
    {
        return new Object[][]{
                {"123456"},
                //poprawne hasło dla test@irmina.com to testirmina
        };
    }

    @Test (dataProvider = "getWrongPasswords")
    public void incorrectLogInTest(String wrongPassword)
    {
        new MainPage(driver)
                .goToLogInForm();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
        LogInPage loginPage = new LogInPage(driver);

        loginPage
                .assertFormTitleIsShown()
                .typeEmail();

        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordForgot));

        loginPage
                .typePassword(wrongPassword)
                .clickToLogin();

        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordError));

        loginPage
                .assertPasswordErrorMessageIsShown()
                .assertPasswordFormFieldIsRed();
    }
}
