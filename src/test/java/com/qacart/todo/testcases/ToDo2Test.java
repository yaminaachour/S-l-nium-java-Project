package com.qacart.todo.testcases;
import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Pages.NewPage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class ToDo2Test extends BaseTest {
 
      @Story("Add Todo")
      @Test (description = "Should be able to add a new todo correctly")
      public void shouldBeAbleToAddNewTodooo2() { 
         RegisterApi registerApi = new RegisterApi(); 
         registerApi.register();
         NewPage newPage  = new NewPage(getDriver());
        newPage.load(); //load 9bel inject
         injectCookiesToBrowser(registerApi.getCookies());
         String actuelResult =
             
                 newPage.load()
                         .addNewTask("bonjour yamina")
                         .getToDoItemText();
         Assert.assertEquals(actuelResult, "bonjour yamina");
     }

     @Story("Delete Todo") 
      @Test (description = "Should be able to delete a todo correctly")
public void shouldBeAbleToDeleteNewTodooo(){
    RegisterApi registerApi = new RegisterApi();
    registerApi.register();

    TasksApi tasksApi = new TasksApi();
    tasksApi.addTask(registerApi.getToken());
   TodoPage todoPage=new TodoPage(getDriver());
    todoPage.load();
    injectCookiesToBrowser(registerApi.getCookies());

    boolean isNoMessageDisplyed= todoPage
            .load()
           .clickDeleteItem()   
            .isNoToDosMessageDisplayed();

    Assert.assertTrue(isNoMessageDisplyed);


}
}
