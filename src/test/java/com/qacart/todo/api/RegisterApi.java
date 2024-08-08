package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
                                 // build register api
import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    // hthom defntion 7jet eli reponse 7jti bigom
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getToken() {
        return accessToken;
    }

    public List<Cookie> getCookies() {
        return restAssuredCookies;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public  void register(){
      //  User user = new User ("atef","ach","nourhoyda @gmail.com","esat32541"); //si ne  utlier pas faker lzem ntb3 order de object(User
       User user = UserUtils.generateRandomUser(); //faker
        Response response=
                 given()
                         .baseUri("https://todo.qacart.com")
                         .header("Content-Type","application/json")
                         .body(user)
                         .log().all()// bch y5rej tt request bch kna 8la nfi9
                .when()
                  // .post("/api/v1/users/register")
                         .post(EndPoint.API_REGISTER_ENDPOINT)


                .then()
                         .log().all()// bch y5rej tt reponse  bch kna 8la nfi9
                         .extract().response(); // n3ml extrat
        if(response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }

      // Cookies cookies = response.detailedCookies() ;// ey 7ja 3ndha 3l9a bel cookies trj3 cookes de rest assured
      // bm2na 3rfnha private Cookies restAssuredCookies; twli =
         //  restAssuredCookies = response.detailedCookies() ;
      restAssuredCookies = response.detailedCookies().asList();

         // String  accessToke, =response.path("accessToken"); hthom exemple mais mst7knhomchg
       accessToken = response.path("access_token");
        userId= response.path("userId");
         firstName=response.path("firstName");

    }



}
/*-----------------------------------
        |             UserUtils           |
        -----------------------------------
        | - generateRandomUser()          |  =  génère des données aléatoires d'utilisateur.
        |                                 |       (User) comme un nom, un email et un mot de passe.
        |                                 |
        -----------------------------------
                        |
                        |
                        v
        -----------------------------------
        |           RegisterApi           |
        -----------------------------------
        | - restAssuredCookies List<Cookie>| =utilise RestAssured (ou une bibliothèque similaire) pour envoyer
        | - accessToken   String          |  des données à l'API REST du Backend Server et récupère les résultats
        | - userId   String               |                      + getAccessToken(): String                             |
        | - firstName                     |
        -----------------------------------
                      |
             API Request/Response
                      |  (HTTP)
                      |
        -----------------------------------
        |            Backend              |
        |            Server               |
        -----------------------------------
                       |
                       |
                       v
        -----------------------------------
        |            Selenium             |
        -----------------------------------
        |  User Interface (Web Browser)   |
        -----------------------------------
*/