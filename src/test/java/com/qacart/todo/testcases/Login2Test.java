package com.qacart.todo.testcases;
import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Authentication Feature")// auth hya sing et inscrption....
public class Login2Test extends BaseTest {
    @Story("Successful Login with Email and Password")
    @Description("It will login by filling the email and the password and navigate to the todo page")
    @Test(description = "Test the login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {
        // Add extra code
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                         .isWelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);

    }
}