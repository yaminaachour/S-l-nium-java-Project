package com.qacart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    // Cette méthode convertit une liste de cookies RestAssured en une liste de cookies Selenium
    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies) {
                                                                                                             //test9bel cookies men ie> restAssuredCookies)
        // Création d'une nouvelle liste vide "ArrayList"pour stocker les cookies Selenium
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();//إنشاء قائمة جديدة و فارغة باش نحطو فيها الـ cookies اللي باش نحولوهم لـ Selenium.
        // Boucle sur chaque cookie dans la liste de cookies RestAssured
        for(io.restassured.http.Cookie cookie : restAssuredCookies ) {//نعملو loop باش تعدّي على كلّ cookie في القائمة اللي جات من RestAssured.
            // Conversion du cookie RestAssured en cookie Selenium
            // Crée un nouveau cookie Selenium en utilisant le nom et la valeur du cookie RestAssured.
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            // Ajout du cookie Selenium à la liste
            seleniumCookies.add(seleniumCookie);// nthifhom fel seleniumCookie
        }
        // Retourne la liste des cookies Selenium

        return seleniumCookies;// methode trj3seleniumCookies
    }
    }


// UTILITE; cette fichier dans etape 2
       // +------------------------+      +-----------------------+      +---------------------+
    //    |                        |      |                       |      |                     |
    //    |  RestAssured (resgapi)        |      CookieUtils      |      |      Selenium       |
   //     | (Effectuer un appel API)|      | (Conversion des       |      | (Tests de l'UI      |
    //    |     et obtenir des     | ---> |  cookies RestAssured  | ---> |  avec les cookies)  |
   //     |      cookies)          |      |   en cookies Selenium)|      |                     |
    //    |                        |      |                       |      |                     |
   //     +------------------------+      +-----------------------+      +---------------------+
// injecte cookies dans browser??? BASE TEST
