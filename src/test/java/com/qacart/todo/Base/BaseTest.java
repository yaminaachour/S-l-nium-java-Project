package com.qacart.todo.Base;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;

import com.qacart.todo.factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class BaseTest {
    //private : Accessible uniquement à l'intérieur de la classe.
    //protected : Accessible à l'intérieur de la classe et dans ses sous-classes.

    //si bech n3ml run en // par methode nst3ml ThreadLocal w nbdel driver --> get driver just dans casde test b9i pas important
    //  protected WebDriver driver;
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public void setDriver(WebDriver driver) {this.driver.set(driver); }
    public WebDriver getDriver() {return this.driver.get();}

    @BeforeMethod

    public void setup(){
        // Initialisation du WebDriver avant chaque méthode de test (@Test).

        //  driver = new DriverFactory().initializeDriver();
        // et dans run en // PAR METHODE  nbdel  Initialisation du WebDriver
        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {// Fermeture du navigateur après chaque méthode de test (@Test).
        //  driver.quit();// run // PAR METHODE --> NZD GET
       //screenshots dynamique dans target bsem cas de test
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName+".png");
        takeScreenshot(destFile);

        getDriver().quit();

    }
    //injectCookiesToBrowse
    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie : seleniumCookies ) {
            // driver.manage().addCookie(cookie); // run // PAR METHODE --> NZD GET
            getDriver().manage().addCookie(cookie);
            // --> KIFECH NST3MLHA FEL  vas de test -->go to"todotest2"
        } }
    public void takeScreenshot(File destFile) {
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file , destFile);
            // attach image to allure reporting
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot",is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    }
