package com.qacart.todo.Pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

                                   // PAGE3
public class NewPage extends BasePage  {

    public NewPage (WebDriver driver) {
            super(driver);
        }

        @FindBy(css="[data-testid='new-todo']")
        private WebElement newToDoInput;

    @FindBy(css="[data-testid='submit-newTask']")
    private WebElement submitNewTaskButton;
     @Step
      //si utliser  api (voir to dotest2  :
      public NewPage load() {
       // driver.get(ConfigUtils.getInstance().getBaseUrl() + "/todo/new"); // 3bra dans cette page w mnst7ech login :https://todo.qacart.com/todo/new
          driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.NEW_TODO_END_POINT);

          return this;}


     @Step
    // Method to enter a new to-do
    public TodoPage addNewTask (String item) {
        newToDoInput.sendKeys(item); //driver.findElement(By.cssSelector("[data-testid='new-todo']")).sendKeys("bonjour yamina");
        submitNewTaskButton.click();
        // driver.findElement(By.cssSelector("[data-testid='submit-newTask']")).click();
        return new TodoPage (driver);
    }

}
