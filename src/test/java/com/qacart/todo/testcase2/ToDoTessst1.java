package com.qacart.todo.testcase2;

import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.NewPage;
import com.qacart.todo.Pages.TodoPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTessst1 extends BaseTest {

 @Test(enabled = false)
public void shouldBeAbleToAddNewTodo() {
                // WebDriver driver = new DriverFactory().initializeDriver();    base test
                /*  WebDriverManager.chromedriver().setup();                    d fact
                WebDriver driver = new ChromeDriver();
                   driver.manage().window().maximize();
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
     LoginPage loginPage = new LoginPage(getDriver());
     loginPage.load(); // Chargez la page de login driver.get("https://todo.qacart.com")
     loginPage.login("yamina.achour95@gmail.com", "essat123...");
             /* driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys("yamina.achour95@gmail.com");
                     driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys("essat123...");
                       driver.findElement(By.cssSelector("[data-testid='submit']")).click();*/
      TodoPage toDoPage =new TodoPage(getDriver());
      toDoPage.clickAddNewToDo();  // nchpuf emplacement nt3ha wen bch n7tha fi anhi page
                                    // driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root")).click();

                                    // new to do page 3

      NewPage newDoPage = new   NewPage(getDriver());// Initialize the NewPage object
      newDoPage .addNewTask("bonjour yamina");
        //driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("bonjour yamina");
        // driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();

                                       // dans todopage


        String actuelResult= toDoPage.getToDoItemText();
    //String actuelResult = driver.findElement(By.cssSelector("[data-testid='todo-item']")).getText();
        Assert.assertEquals(actuelResult, "bonjour yamina");
    /*driver.quit();*/
}
@Test(enabled = false)
public void shouldBeAbleToDeleteNewTodo(){
  /* WebDriver driver = new DriverFactory().initializeDriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/


    LoginPage loginPage = new LoginPage(getDriver());
    loginPage.load();     // Chargez la page de login driver.get("https://todo.qacart.com")
      // loginPage.login("yamina.achour95@gmail.com", "essat123...");
        /*driver.findElement(By.cssSelector("[data-testid='email']")).sendKeys("yamina.achour95@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='password']")).sendKeys("essat123...");
        driver.findElement(By.cssSelector("[data-testid='submit']")).click();*/

    TodoPage toDoPage = loginPage.login("yamina.achour95@gmail.com", "essat123...");
    /* TodoPage toDoPage =new TodoPage(driver);   SUPPRIMER new TodoPage(driver); < ntl3ha 9blha */
   // toDoPage.clickAddNewToDo();   //==> hthi wen thez pg 2 vers3  ++++++
   NewPage newPage =toDoPage.clickAddNewToDo(); //driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiIconButton-root")).click();

    //NewPage  newPage = new NewPage(driver); // dans page3
      newPage.addNewTask("bonjour yamina"); //say hzet , w bech thez 2 ++++++

        //driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("bonjour yamina");
       // driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();

    //TodoPage todoPage=new TodoPage(driver); // page 2
    toDoPage.clickDeleteItem();   // driver.findElement(By.cssSelector("[data-testid='delete']")).click();

    
    boolean isNoMessageDisplyed= toDoPage.isNoToDosMessageDisplayed(); //  to do page

   // boolean  isNoMessageDisplyed = driver.findElement(By.cssSelector("[data-testid='no-todos']")).isDisplayed();
    Assert.assertTrue(isNoMessageDisplyed);


   /*  driver.quit();*/
}

}

