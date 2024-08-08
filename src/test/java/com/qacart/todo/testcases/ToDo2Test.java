package com.qacart.todo.testcases;
    // dernier corriger
import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Pages.NewPage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")// الميزة التي يتم اختبارها= fonctionnalités des tâches.  = 7jet 5sa bel doto
 /// e5tisar login page d5lna direct to do page  "" 3mlna  login bel api pas par ui (
public class ToDo2Test extends BaseTest {
  /* // @Story("X")
//@Test(enabled = false)// hthi bch nfhm etape test2
//public void shouldBeAbleToAddNewTodooo() { // 5dmna bel cookies
   // RegisterApi registerApi = new RegisterApi(); // call  RegisterApi
  ///  registerApi.register(); // eli fha reponse et request
   // injectCookiesToBrowser(registerApi.getCookies()); // get all cokokies ww thifha 3la browser nt3na w hthi dima 9nel load


    //LoginPage loginPage = new LoginPage(driver); // nl8ha 5ter bech nbda fel men  to page
//TodoPage todoPage= new  TodoPage(driver);
  //  todoPage.load(); //load 9bel inject
 //   injectCookiesToBrowser(registerApi.getCookies());

 //   String actuelResult =// loginPage.load()
    // .login("yamina.achour95@gmail.com", "essat123...") // k,a 3na cookies zyed "" ""login""
        //    .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())

       ///     todoPage.load()//https://todo.qacart.com/todo
        //    .clickAddNewToDo()
       //     .getToDoItemText();
    //Assert.assertEquals(actuelResult, "bonjour yamina");

//}*/
      @Story("Add Todo")
      @Test (description = "Should be able to add a new todo correctly")
      public void shouldBeAbleToAddNewTodooo2() { // hthi ki nbda men new page direct bch nl8i .clickAddNewToDo()()
         RegisterApi registerApi = new RegisterApi(); // call  RegisterApi
         registerApi.register();
         NewPage newPage  = new NewPage(getDriver());
        newPage.load(); //load 9bel inject
         injectCookiesToBrowser(registerApi.getCookies());
         String actuelResult =
                // todoPage.load()//
                       //  .clickAddNewToDo() // cette button fha mchkl ma thznich new page alors direct nbda mem âge new page w n3ml load fel new page

                 newPage.load()
                         .addNewTask("bonjour yamina")
                         .getToDoItemText();
         Assert.assertEquals(actuelResult, "bonjour yamina");
     }

     @Story("Delete Todo") //la fonctionnalité(detailler) principale décrite par @Feature
      @Test (description = "Should be able to delete a todo correctly")
public void shouldBeAbleToDeleteNewTodooo(){
    RegisterApi registerApi = new RegisterApi();
    registerApi.register();

    TasksApi tasksApi = new TasksApi();
    tasksApi.addTask(registerApi.getToken());
  // LoginPage loginPage = new LoginPage(driver);
   TodoPage todoPage=new TodoPage(getDriver());
    todoPage.load();
    injectCookiesToBrowser(registerApi.getCookies());

    boolean isNoMessageDisplyed= todoPage
            .load()
            //ANHOU ITEM ? NJEB ALORS API TASK

           // .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
           // .clickAddNewToDo() //HTHI M3CH NST3MHA
          //  . addNewTask("bonjour yamina") BCH NST3ML API
            //ANHOU ITEM ? NJEB ALORS API TASK

            // njem 4 ligne fo9nin nl8ihom  ( ma n3dmed 3la to do page"--> n7eb ro7i fi new page bch nfs5 direct w testi = api+ load new to do
         // w la fma mochkel si "clickAddNewToDo(" ne fonctiner ma thznich 3 eme page
            .clickDeleteItem()   /// fel to to page nmchi direct load fel to do
            .isNoToDosMessageDisplayed();

    Assert.assertTrue(isNoMessageDisplyed);


}
}