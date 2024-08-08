package com.qacart.todo.testcase2;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Authentication Feature")

public class LoginTessst1 {
    @Story("Successful Login with Email and Password")

    @Test(enabled = false)
    public void shouldBeAbleToLoginWithEmailAndPassword(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://todo.qacart.com");
        // dans login page  le 3 meme methode pour lo
       driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys("yamina.achour95@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys("essat123...");
        driver.findElement(By.cssSelector("[data-testid='submit']")).click();
      // Verify if the welcome message is displayed

    // mwjouda dans todopage hthi si utliser autre cas :
      //  TodoPage todoPage =new TodoPage (driver); // driver jya men obase
      //  boolean iswelcomedisplay= todoPage.isWelcomeMessageDisplayed();

       boolean iswelcomedisplay= driver.findElement(By.cssSelector("[data-testid='welcome']")).isDisplayed();
        // Assert that the welcome message is displayed
//Cette ligne utilise la bibliothèque TestNG pour vérifier que la valeur de iswelcomedisplay est vraie (c'est-à-dire que l'élément est bien visible). Si ce n'est pas le cas, le test échouera.
        Assert.assertTrue(iswelcomedisplay);
      // driver.quit();

    }

}
