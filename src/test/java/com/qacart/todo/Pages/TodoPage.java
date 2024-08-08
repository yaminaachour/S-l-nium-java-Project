package com.qacart.todo.Pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

                                              //page 2 +
public class TodoPage extends BasePage {
    public TodoPage (WebDriver driver) {
        super(driver);
    }

  @FindBy(css = "[data-testid=\"welcome\"]")
  private WebElement welcomeMessage;


    @FindBy (css=".MuiButtonBase-root.MuiIconButton-root")
    private WebElement addNewToDo;

    @FindBy (css="[data-testid='todo-item']")
    private WebElement toDoItem;

  @FindBy (css="[data-testid='delete']")
    private WebElement deleteItem;//  driver.findElement(By.cssSelector("[data-testid='delete']")).click();

    @FindBy (css = "[data-testid='no-todos']")
     private WebElement noToDosMassege;
      @Step
     //si utliser  api (voir to dotest2  :
     public TodoPage load() {
      //   driver.get(ConfigUtils.getInstance().getBaseUrl() + "/todo"); // 3bra dans cette page w mnst7ech login ://todo.qacart.com/todo
         driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_PAGE_ENDPOINT);

         return this;
     }





    //METHODES
    @Step
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();// return kna vrai trj3 true ...


   // boolean iswelcomedisplay= driver.findElement(By.cssSelector("[data-testid='welcome']")).isDisplayed();
}


        //si clique new item y7el page3 (p2-->3)
    //public void clickAddNewToDo() {
      //  addNewToDo.click();}  devient =
   @Step
  public NewPage clickAddNewToDo() {
        addNewToDo.click();
        return  new NewPage(driver);
  }

// Method to get the text of a to-do item
@Step
public String getToDoItemText() {
  return  toDoItem.getText();  // return trj3na text
}
   /* RETURN EXEMPLE .: getAttribute(String name), getCssValue(String propertyName)
                      getSize(Dimension), is displyed( boolean)
                     getLocation():Point
                     isEnabled(): Vérifie si l'élément est activé.(boolean)
                   isSelected()( boolean)*/
   @Step
    public TodoPage clickDeleteItem() {
       deleteItem.click();
     return this;             // apres builder pattern knet void

}

    // Method to check if to-do text is displayed
    @Step
public boolean isNoToDosMessageDisplayed() {

    return  noToDosMassege.isDisplayed();
    }

                                                  }





