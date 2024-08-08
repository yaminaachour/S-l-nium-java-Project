package com.qacart.todo.testcase2;
// htha  9BEL final
import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
//builder pattern

public class XTessstavantfinal extends BaseTest {

    @Test(enabled = false)
    public void shouldBeAbleToAddNewTodoo() {
        LoginPage loginPage = new LoginPage(getDriver());
        // loginPage.load();  //load ma trj3 chy pcar "void"  --> twli trj3 "this"( cad trj3 loginpage)
        // dans LoginPage:
        //public LoginPage load(){
        //    driver.get("https://todo.qacart.com");
        //    return this ;
        String actuelResult = loginPage.load()
               // .login("yamina.achour95@gmail.com", "essat123...")
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .clickAddNewToDo()
                .addNewTask("bonjour yamina")
                .getToDoItemText();
        Assert.assertEquals(actuelResult, "bonjour yamina");


        /* loginPage.login("yamina.achour95@gmail.com", "essat123...");*/

        // toDoPage.clickAddNewToDo();// click fel todopage w thzna lel newpage

       //// NewPage newDoPage = new NewPage(driver);
       //  newDoPage .addNewTask("bonjour yamina");
       // String actuelResult= toDoPage.getToDoItemText();

        //Assert.assertEquals(actuelResult, "bonjour yamina");

    }
    @Test(enabled = false) // pour désactiver un test
    public void shouldBeAbleToDeleteNewTodoo(){


        LoginPage loginPage = new LoginPage(getDriver());
        boolean isNoMessageDisplyed= loginPage
                .load()
                .login("yamina.achour95@gmail.com", "essat123...")
                .clickAddNewToDo()
                .addNewTask("bonjour yamina")
                .clickDeleteItem()
                .isNoToDosMessageDisplayed();

        Assert.assertTrue(isNoMessageDisplyed);
        // trj3 login
        //  TodoPage toDoPage = loginPage.login("yamina.achour95@gmail.com", "essat123...");// deja rutern to do page

        //NewPage newPage =toDoPage.clickAddNewToDo();// ckick fi todi w trj3na fel new oage wla tet7al new page
        //  newPage.addNewTask("bonjour yamina"); //deja felnew page


        // toDoPage.clickDeleteItem(); gthi trj3 void chy bch trj3 nb9ou mm page to to n3ml this trj3 to do

        //boolean isNoMessageDisplyed= toDoPage.isnoToDosMassegeDisplayed();


    }





}
