package com.qacart.todo.Pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//the Page Object Model (POM) pattern, making the test code more maintainable and readable
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
   ///* private WebDriver driver;

  // public LoginPage (WebDriver driver){
     ////  this.driver=driver;
      // PageFactory.initElements(driver,this);
   //}*///
//@FindBy est idéal pour une structure maintenable avec POM, tandis que driver.findElement offre plus de flexibilité dynamique.
//pom ;Réduire la Duplication de Code :Maintenance Facil,Lisibilité
    @FindBy(css = "[data-testid='email']")
    private WebElement emailInput;

    @FindBy(css = "[data-testid='password']")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid='submit']")
    private WebElement submit;



    //methode
   /* public void login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();*/

        // LORSQUE FAIT CLIQUE YHZNA AY PAGE ?;2 toto page donc n3ml laissions  bch n9es men hthi LoginPage loginPage = new LoginPage(driver);
      //  alors twli :
      // void mtrj3 chy  donc rturn trj3 object men todopage  ()page2 --> todopage
        @Step

        public TodoPage login(String email, String password){
        emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
           submit.click();
           return  new TodoPage(driver) ;  // w bch n3rf page lzem nb3th driver donc  TodoPage toDoPage =new TodoPage(driver);nl8ha

        }


//public  void load(){
       //  driver.get("https://todo.qacart.com");

//}
// si utliser builserpatttern : void twli trj3 login oage
@Step("Load the login page")

public LoginPage load(){
  //  1-driver.get("https://todo.qacart.com");
   //2 Properties props= PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local/production.properties"); // adress haki mwjouda fel "prodction prprites "
   // driver.get(props.getProperty("baseUrl")); // men class PropertiesUtils a9ra loadProperties w 7puta fel pros b1 sur yrj3 Properties ; w jbli men pros  base url
     driver.get(ConfigUtils.getInstance().getBaseUrl());// jbli men ConfigUtils ; getInstance().getBaseUrl() ;

    return this ;



}


}
