package com.qacart.todo.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

   protected WebDriver driver;

    // Constructor
    public BasePage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
}

    }